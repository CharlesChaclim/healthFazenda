package br.com.check.HealthFazenda.controller;

import br.com.check.HealthFazenda.exception.ObjectNotFoundException;
import br.com.check.HealthFazenda.model.Estado;
import br.com.check.HealthFazenda.service.EstadoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    private final EstadoService estadoService;

    public EstadoController(EstadoService estadoService) {
        this.estadoService = estadoService;
    }


    @GetMapping("/{id}")
    public HttpEntity<?> findById(@PathVariable("id") Long id) {
        return estadoService.findById(id).map(ResponseEntity::ok).orElseThrow(() -> {
            throw new ObjectNotFoundException(String.format("Estado %s não encontrado", id));
        });
    }

    @GetMapping("/all")
    public ResponseEntity<Page<Estado>> findAll(Pageable pageable) {
        return ResponseEntity.ok(estadoService.findAll(pageable));
    }

    @GetMapping("/maisIndisponivel")
    public ResponseEntity<List<Estado>> findMaisIndisponivel() {
        return ResponseEntity.ok(estadoService.findMaisIndisponivel());
    }
}
