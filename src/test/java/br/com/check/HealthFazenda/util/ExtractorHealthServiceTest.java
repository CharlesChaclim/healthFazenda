package br.com.check.HealthFazenda.util;

import br.com.check.HealthFazenda.model.Enums.Disponibilidade;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExtractorHealthServiceTest {

    private Element nodeBlank;

    private Element nodeDisponivel;

    private Element nodeIndisponivel;

    @InjectMocks
    private ExtractorHealthService extractorHealthService;

    @BeforeEach
    void setUp() {
        setNode();
    }

    @Test
    void whenGetDisponibilidadeShouldReturnNull() {
        var retorno = extractorHealthService.getDisponibilidade(nodeBlank);

        Assertions.assertNull(retorno);
    }

    @Test
    void whenGetDisponibilidadeShouldReturnDisponivel() {
        var retorno = extractorHealthService.getDisponibilidade(nodeDisponivel);

        Assertions.assertEquals(Disponibilidade.DISPONIVEL, retorno);
    }

    @Test
    void whenGetDisponibilidadeShouldReturnIndisponivel() {
        var retorno = extractorHealthService.getDisponibilidade(nodeIndisponivel);

        Assertions.assertEquals(Disponibilidade.INDISPONIVEL, retorno);
    }

    @Test
    void whenGetHistoricoDisponibilidadeAtualShouldNotRetunNull() {
        var retorno = extractorHealthService.getHistoricoDisponibilidadeAtual();

        Assertions.assertNotNull(retorno);
    }

    void setNode() {
        nodeBlank = new Element("<td></td>");
        nodeBlank.appendChild(new Element("<span></span>"));

        nodeDisponivel = new Element("<td></td>");
        var nodeDisponivelAppend = new Element("<img>");
        nodeDisponivelAppend.attr("src", "imagens/bola_verde_P.png");
        nodeDisponivel.appendChild(nodeDisponivelAppend);


        nodeIndisponivel = new Element("<td></td>");
        var nodeIndisponivelAppend = new Element("<img>");
        nodeIndisponivelAppend.attr("src", "imagens/bola_vermelha_P.png");
        nodeIndisponivel.appendChild(nodeIndisponivelAppend);
    }
}