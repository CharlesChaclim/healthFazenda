package br.com.check.HealthFazenda.model;

import br.com.check.HealthFazenda.model.Enums.Autorizador;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "estado")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String sigla;

    public Estado() {
    }

    public Estado(Long id) {
        this.id = id;
    }

    public Estado(Autorizador estado) {
        this.id = estado.getId();
        this.sigla = estado.name();
        this.name = estado.getName();
    }

    public Estado(Autorizador.SVRS estado) {
        this.id = estado.getId();
        this.sigla = estado.name();
        this.name = estado.getName();
    }

    public Estado(Autorizador.SVAN estado) {
        this.id = estado.getId();
        this.sigla = estado.name();
        this.name = estado.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return Objects.equals(id, estado.id) && Objects.equals(name, estado.name) && Objects.equals(sigla, estado.sigla);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sigla);
    }

    @Override
    public String toString() {
        return "Estado{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sigla='" + sigla + '\'' +
                '}';
    }
}
