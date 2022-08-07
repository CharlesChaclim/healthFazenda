package br.com.check.HealthFazenda.repository;

import br.com.check.HealthFazenda.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

    @Query(
            value = "select " +
                    "	e.id, " +
                    "	e.name, " +
                    "	e.sigla " +
                    "from " +
                    "	estado e,  " +
                    "	( " +
                    "	    select " +
                    "		    hd.estado_id, " +
                    "			count(*) as quantidade_indisponivel, " +
                    "			FIRST_VALUE(count(*)) OVER( ORDER BY count(*) desc ) quantidade_maxima_indisponivel " +
                    "		from " +
                    "		    historico_disponibilidade hd " +
                    "		where " +
                    "		        autorizacao = 'INDISPONIVEL' " +
                    "			or inutilizacao = 'INDISPONIVEL' " +
                    "			or status_servico = 'INDISPONIVEL' " +
                    "			or recepcao_evento = 'INDISPONIVEL' " +
                    "			or consulta_cadastro = 'INDISPONIVEL' " +
                    "			or consulta_protocolo = 'INDISPONIVEL' " +
                    "			or retorno_autorizacao = 'INDISPONIVEL' " +
                    "		group by " +
                    "		    hd.estado_id) hd " +
                    "where " +
                    "       e.id = hd.estado_id " +
                    "	and hd.quantidade_Indisponivel = hd.quantidade_maxima_indisponivel"

            ,
            nativeQuery = true
    )
    List<Estado> findMaisIndisponivel();

}