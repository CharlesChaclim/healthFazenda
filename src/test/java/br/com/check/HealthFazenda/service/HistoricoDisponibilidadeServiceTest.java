package br.com.check.HealthFazenda.service;

import br.com.check.HealthFazenda.model.Enums.Disponibilidade;
import br.com.check.HealthFazenda.model.Estado;
import br.com.check.HealthFazenda.model.HistoricoDisponibilidade;
import br.com.check.HealthFazenda.repository.HistoricoDisponibilidadeRepository;
import br.com.check.HealthFazenda.util.ExtractorHealthService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class HistoricoDisponibilidadeServiceTest {


    private final ArrayList<HistoricoDisponibilidade> historicoDisponibilidadeList = new ArrayList<>();

    @InjectMocks
    private HistoricoDisponibilidadeService historicoDisponibilidadeService;

    @Mock
    private ExtractorHealthService extractorHealthService;

    @Mock
    private HistoricoDisponibilidadeRepository historicoDisponibilidadeRepository;


    @BeforeEach
    void setUp() {
        setHistoricoDisponibilidade();
    }

    @Test
    void whenFindHistoricoDisponibilidadeShouldReturnHistoricoDisponibilidade() {
        Mockito.when(extractorHealthService.getHistoricoDisponibilidadeAtual()).thenReturn(historicoDisponibilidadeList);

        var retorno = historicoDisponibilidadeService.findHistoricoDisponibilidade(null, null);

        Assertions.assertEquals(historicoDisponibilidadeList, retorno);
    }

    @Test
    void whenFindHistoricoDisponibilidadeByEstadoShouldReturnListEmpty() {
        Mockito.when(extractorHealthService.getHistoricoDisponibilidadeAtual()).thenReturn(historicoDisponibilidadeList);

        var retorno = historicoDisponibilidadeService.findHistoricoDisponibilidade(2L, null);

        Assertions.assertEquals(List.of(), retorno);
    }

    @Test
    void whenFindHistoricoDisponibilidadeByEstadoShouldReturnHistoricoDisponibilidade() {
        Mockito.when(extractorHealthService.getHistoricoDisponibilidadeAtual()).thenReturn(historicoDisponibilidadeList);

        var retorno = historicoDisponibilidadeService.findHistoricoDisponibilidade(1L, null);

        Assertions.assertEquals(historicoDisponibilidadeList, retorno);
    }

    @Test
    void whenFindHistoricoDisponibilidadeByDataShouldReturnHistoricoDisponibilidade() {
        Mockito.when(historicoDisponibilidadeRepository.findHistoricoDisponibilidadeByData(Mockito.any())).thenReturn(historicoDisponibilidadeList);

        var retorno = historicoDisponibilidadeService.findHistoricoDisponibilidade(null, new Date());

        Assertions.assertEquals(historicoDisponibilidadeList, retorno);
    }

    @Test
    void whenFindHistoricoDisponibilidadeByEstadoAndDataShouldReturnHistoricoDisponibilidade() {
        Mockito.when(historicoDisponibilidadeRepository.findHistoricoDisponibilidadeByEstadoAndData(Mockito.any(), Mockito.any())).thenReturn(historicoDisponibilidadeList);

        var retorno = historicoDisponibilidadeService.findHistoricoDisponibilidade(1L, new Date());

        Assertions.assertEquals(historicoDisponibilidadeList, retorno);
    }

    void setHistoricoDisponibilidade() {
        var historicoDisponibilidade = new HistoricoDisponibilidade(new Date(System.currentTimeMillis()));

        historicoDisponibilidade.setEstado(new Estado(1L));
        historicoDisponibilidade.setAutorizacao(Disponibilidade.DISPONIVEL);
        historicoDisponibilidade.setRetornoAutorizacao(Disponibilidade.DISPONIVEL);
        historicoDisponibilidade.setInutilizacao(Disponibilidade.DISPONIVEL);
        historicoDisponibilidade.setConsultaProtocolo(Disponibilidade.DISPONIVEL);
        historicoDisponibilidade.setStatusServico(Disponibilidade.DISPONIVEL);
        historicoDisponibilidade.setConsultaCadastro(Disponibilidade.DISPONIVEL);
        historicoDisponibilidade.setRecepcaoEvento(Disponibilidade.DISPONIVEL);

        historicoDisponibilidadeList.add(historicoDisponibilidade);
    }
}