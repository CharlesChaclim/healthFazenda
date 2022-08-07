package br.com.check.HealthFazenda.service;

import br.com.check.HealthFazenda.model.Estado;
import br.com.check.HealthFazenda.repository.EstadoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

   private final EstadoRepository estadoRepository;

    public EstadoService(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    public Optional<Estado> findById(Long id){
       return estadoRepository.findById(id);
    }

    public Page<Estado> findAll(Pageable pageable){
        return estadoRepository.findAll(pageable);
    }

    public List<Estado> findMaisIndisponivel(){
        return estadoRepository.findMaisIndisponivel();
    }
}
