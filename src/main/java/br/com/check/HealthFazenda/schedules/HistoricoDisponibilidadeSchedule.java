package br.com.check.HealthFazenda.schedules;

import br.com.check.HealthFazenda.service.HistoricoDisponibilidadeService;
import br.com.check.HealthFazenda.util.ExtractorHealthService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class HistoricoDisponibilidadeSchedule {

    private final ExtractorHealthService extractorHealthService;

    private final HistoricoDisponibilidadeService historicoDisponibilidadeService;

    public HistoricoDisponibilidadeSchedule(ExtractorHealthService extractorHealthService, HistoricoDisponibilidadeService historicoDisponibilidadeService) {
        this.extractorHealthService = extractorHealthService;
        this.historicoDisponibilidadeService = historicoDisponibilidadeService;
    }

    @Scheduled(cron = "0 */5 * * * *")
    public void updateHistoricoDisponibilidade() {
        var historicoDisponibilidadeList = extractorHealthService.getHistoricoDisponibilidadeAtual();

        historicoDisponibilidadeList.forEach(historicoDisponibilidadeService::save);
    }

}
