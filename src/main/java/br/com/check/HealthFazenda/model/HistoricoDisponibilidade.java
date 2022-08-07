package br.com.check.HealthFazenda.model;

import br.com.check.HealthFazenda.model.Enums.Disponibilidade;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "historico_disponibilidade")
public class HistoricoDisponibilidade implements Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date data;

    @OneToOne
    private Estado estado;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('DISPONIVEL','INDISPONIVEL')")
    private Disponibilidade autorizacao;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('DISPONIVEL','INDISPONIVEL')")
    private Disponibilidade retornoAutorizacao;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('DISPONIVEL','INDISPONIVEL')")
    private Disponibilidade inutilizacao;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('DISPONIVEL','INDISPONIVEL')")
    private Disponibilidade consultaProtocolo;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('DISPONIVEL','INDISPONIVEL')")
    private Disponibilidade statusServico;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('DISPONIVEL','INDISPONIVEL')")
    private Disponibilidade consultaCadastro;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('DISPONIVEL','INDISPONIVEL')")
    private Disponibilidade recepcaoEvento;

    public HistoricoDisponibilidade() {
    }

    public HistoricoDisponibilidade(Date data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Disponibilidade getAutorizacao() {
        return autorizacao;
    }

    public void setAutorizacao(Disponibilidade autorizacao) {
        this.autorizacao = autorizacao;
    }

    public Disponibilidade getRetornoAutorizacao() {
        return retornoAutorizacao;
    }

    public void setRetornoAutorizacao(Disponibilidade retornoAutorizacao) {
        this.retornoAutorizacao = retornoAutorizacao;
    }

    public Disponibilidade getInutilizacao() {
        return inutilizacao;
    }

    public void setInutilizacao(Disponibilidade inutilizacao) {
        this.inutilizacao = inutilizacao;
    }

    public Disponibilidade getConsultaProtocolo() {
        return consultaProtocolo;
    }

    public void setConsultaProtocolo(Disponibilidade consultaProtocolo) {
        this.consultaProtocolo = consultaProtocolo;
    }

    public Disponibilidade getStatusServico() {
        return statusServico;
    }

    public void setStatusServico(Disponibilidade statusServico) {
        this.statusServico = statusServico;
    }

    public Disponibilidade getConsultaCadastro() {
        return consultaCadastro;
    }

    public void setConsultaCadastro(Disponibilidade consultaCadastro) {
        this.consultaCadastro = consultaCadastro;
    }

    public Disponibilidade getRecepcaoEvento() {
        return recepcaoEvento;
    }

    public void setRecepcaoEvento(Disponibilidade recepcaoEvento) {
        this.recepcaoEvento = recepcaoEvento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoricoDisponibilidade that = (HistoricoDisponibilidade) o;
        return Objects.equals(id, that.id) && Objects.equals(data, that.data) && Objects.equals(estado, that.estado) && autorizacao == that.autorizacao && retornoAutorizacao == that.retornoAutorizacao && inutilizacao == that.inutilizacao && consultaProtocolo == that.consultaProtocolo && statusServico == that.statusServico && consultaCadastro == that.consultaCadastro && recepcaoEvento == that.recepcaoEvento;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data, estado, autorizacao, retornoAutorizacao, inutilizacao, consultaProtocolo, statusServico, consultaCadastro, recepcaoEvento);
    }

    @Override
    public String toString() {
        return "HistoricoDisponibilidade{" +
                "id=" + id +
                ", data=" + data +
                ", estado=" + estado +
                ", autorizacao=" + autorizacao +
                ", retornoAutorizacao=" + retornoAutorizacao +
                ", inutilizacao=" + inutilizacao +
                ", consultaProtocolo=" + consultaProtocolo +
                ", statusServico=" + statusServico +
                ", consultaCadastro=" + consultaCadastro +
                ", recepcaoEvento=" + recepcaoEvento +
                '}';
    }

    @Override
    public HistoricoDisponibilidade clone() {
        try {
            return (HistoricoDisponibilidade) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
