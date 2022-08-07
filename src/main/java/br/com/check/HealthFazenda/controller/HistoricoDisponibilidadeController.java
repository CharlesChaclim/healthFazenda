package br.com.check.HealthFazenda.controller;

import br.com.check.HealthFazenda.model.HistoricoDisponibilidade;
import br.com.check.HealthFazenda.service.HistoricoDisponibilidadeService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/historicoDisponibilidade")
public class HistoricoDisponibilidadeController {

    private final HistoricoDisponibilidadeService historicoDisponibilidadeService;


    public HistoricoDisponibilidadeController(HistoricoDisponibilidadeService historicoDisponibilidadeService) {
        this.historicoDisponibilidadeService = historicoDisponibilidadeService;
    }

    @GetMapping
    public ResponseEntity<List<HistoricoDisponibilidade>> findHistoricoDisponibilidade(@RequestParam(value = "estado_id", required = false) Long estadoId, @RequestParam(value = "data", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date) {
        return ResponseEntity.ok(historicoDisponibilidadeService.findHistoricoDisponibilidade(estadoId, date));
    }
}
