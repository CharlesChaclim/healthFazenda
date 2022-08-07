package br.com.check.HealthFazenda.util;

import br.com.check.HealthFazenda.model.Enums.Autorizador;
import br.com.check.HealthFazenda.model.Enums.Disponibilidade;
import br.com.check.HealthFazenda.model.Estado;
import br.com.check.HealthFazenda.model.HistoricoDisponibilidade;
import liquibase.repackaged.org.apache.commons.lang3.EnumUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class ExtractorHealthService {
    public Disponibilidade getDisponibilidade(Node element) {
        String src = element.childNode(0).attr("src");

        if ("imagens/bola_verde_P.png".equals(src)) {
            return Disponibilidade.DISPONIVEL;
        } else if (!"".equals(element.childNode(0).attr("src"))) {
            return Disponibilidade.INDISPONIVEL;
        }

        return null;
    }

    public List<HistoricoDisponibilidade> getHistoricoDisponibilidadeAtual() {

        try {
            var historicoDisponibilidadeList = new ArrayList<HistoricoDisponibilidade>();

            var horarioAtual = new Date(System.currentTimeMillis());

            var doc = Jsoup.connect("https://www.nfe.fazenda.gov.br/portal/disponibilidade.aspx").get();

            var linhasTabela = doc.select(".tabelaListagemDados tbody tr:not(:first-child)");

            linhasTabela.forEach(linha -> {
                var colunas = linha.childNodes();
                var autorizador = new AtomicReference<>("");
                var historicoDisponibilidade = new HistoricoDisponibilidade(horarioAtual);

                colunas.forEach(coluna -> {
                    if (coluna.getClass().equals(Element.class)) {
                        switch (coluna.siblingIndex()) {
                            case 1 -> autorizador.set(((Element) coluna).text());
                            case 2 -> historicoDisponibilidade.setAutorizacao(getDisponibilidade(coluna));
                            case 3 -> historicoDisponibilidade.setRetornoAutorizacao(getDisponibilidade(coluna));
                            case 4 -> historicoDisponibilidade.setInutilizacao(getDisponibilidade(coluna));
                            case 5 -> historicoDisponibilidade.setConsultaProtocolo(getDisponibilidade(coluna));
                            case 6 -> historicoDisponibilidade.setStatusServico(getDisponibilidade(coluna));
                            case 8 -> historicoDisponibilidade.setConsultaCadastro(getDisponibilidade(coluna));
                            case 9 -> historicoDisponibilidade.setRecepcaoEvento(getDisponibilidade(coluna));
                        }
                    }
                });

                if ("SVRS".equals(autorizador.get())) {
                    Arrays.stream(Autorizador.SVRS.values()).forEach(estado -> {
                        var cloneHistoricoDisponibilidade = historicoDisponibilidade.clone();

                        cloneHistoricoDisponibilidade.setEstado(new Estado(estado));

                        if (!EnumUtils.isValidEnum(Autorizador.SVRSConsultaCadastro.class, estado.name())) {
                            cloneHistoricoDisponibilidade.setConsultaCadastro(null);
                        }

                        historicoDisponibilidadeList.add(cloneHistoricoDisponibilidade);
                    });
                } else if ("SVAN".equals(autorizador.get())) {
                    Arrays.stream(Autorizador.SVAN.values()).forEach(estado -> {
                        historicoDisponibilidade.setEstado(new Estado(estado));
                        historicoDisponibilidadeList.add(historicoDisponibilidade);
                    });
                } else if (EnumUtils.isValidEnum(Autorizador.class, autorizador.get())) {
                    historicoDisponibilidade.setEstado(new Estado(Autorizador.valueOf(autorizador.get())));
                    historicoDisponibilidadeList.add(historicoDisponibilidade);
                }
            });


            return historicoDisponibilidadeList;

        } catch (Exception exception) {
            return null;
        }
    }
}
