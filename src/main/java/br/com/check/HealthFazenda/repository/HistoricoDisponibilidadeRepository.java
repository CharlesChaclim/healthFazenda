package br.com.check.HealthFazenda.repository;

import br.com.check.HealthFazenda.model.Estado;
import br.com.check.HealthFazenda.model.HistoricoDisponibilidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface HistoricoDisponibilidadeRepository extends JpaRepository<HistoricoDisponibilidade, Long> {

    @Query(
            value = "select " +
                    "	id, " +
                    "	data, " +
                    "	estado_id, " +
                    "	autorizacao, " +
                    "	retorno_autorizacao, " +
                    "	inutilizacao, " +
                    "	consulta_protocolo, " +
                    "	status_servico, " +
                    "	consulta_cadastro, " +
                    "	recepcao_evento " +
                    "from " +
                    "   historico_disponibilidade hd " +
                    "where " +
                    "   hd.data between DATE_ADD(:data, INTERVAL -5 MINUTE) and :data",
            nativeQuery = true
    )
    List<HistoricoDisponibilidade> findHistoricoDisponibilidadeByData(@Param("data") Date data);

    @Query(
            value = "select " +
                    "	id, " +
                    "	data, " +
                    "	estado_id, " +
                    "	autorizacao, " +
                    "	retorno_autorizacao, " +
                    "	inutilizacao, " +
                    "	consulta_protocolo, " +
                    "	status_servico, " +
                    "	consulta_cadastro, " +
                    "	recepcao_evento " +
                    "from " +
                    "	historico_disponibilidade hd " +
                    "where " +
                    "       hd.estado_id = :estado_id " +
                    "	and hd.data between DATE_ADD(:data, INTERVAL -5 MINUTE) and :data",
            nativeQuery = true
    )
    List<HistoricoDisponibilidade> findHistoricoDisponibilidadeByEstadoAndData(Estado estado, Date data);
}