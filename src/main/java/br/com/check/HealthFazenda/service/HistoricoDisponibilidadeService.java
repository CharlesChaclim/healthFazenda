package br.com.check.HealthFazenda.service;

import br.com.check.HealthFazenda.model.Estado;
import br.com.check.HealthFazenda.model.HistoricoDisponibilidade;
import br.com.check.HealthFazenda.repository.HistoricoDisponibilidadeRepository;
import br.com.check.HealthFazenda.util.ExtractorHealthService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class HistoricoDisponibilidadeService {

    private final ExtractorHealthService extractorHealthService;

    private final HistoricoDisponibilidadeRepository historicoDisponibilidadeRepository;

    public HistoricoDisponibilidadeService(ExtractorHealthService extractorHealthService, HistoricoDisponibilidadeRepository historicoDisponibilidadeRepository) {
        this.extractorHealthService = extractorHealthService;
        this.historicoDisponibilidadeRepository = historicoDisponibilidadeRepository;
    }

    public void save(HistoricoDisponibilidade historicoDisponibilidade) {
        historicoDisponibilidadeRepository.save(historicoDisponibilidade);
    }

    public List<HistoricoDisponibilidade> findHistoricoDisponibilidade(Long estadoId, Date data) {

        if (Objects.nonNull(estadoId)) {
            var estado = new Estado(estadoId);

            if (Objects.nonNull(data)) {
                return historicoDisponibilidadeRepository.findHistoricoDisponibilidadeByEstadoAndData(estado, data);
            } else {
                var historicoDisponibilidadeList = extractorHealthService.getHistoricoDisponibilidadeAtual();

                return historicoDisponibilidadeList.stream().filter(historicoDisponibilidade -> estadoId.equals(historicoDisponibilidade.getEstado().getId())).collect(Collectors.toList());
            }
        } else if (Objects.nonNull(data)) {
            return historicoDisponibilidadeRepository.findHistoricoDisponibilidadeByData(data);
        } else {
            return extractorHealthService.getHistoricoDisponibilidadeAtual();
        }
    }
}
