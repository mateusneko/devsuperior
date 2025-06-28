package com.devsuperior.desafio.entities;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "tb_bloco")
public class Bloco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant horarioInicio;
    private Instant horarioFim;

    @ManyToOne
    @JoinColumn(name = "atividade_id")
    private Atividade atividade;

    public Bloco() {}

    public Bloco(Long id, Instant horarioInicio, Instant horarioFim) {
        this.id = id;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }



    public Instant getHorarioInicio() { return horarioInicio; }
    public void setHorarioInicio(Instant horarioInicio) { this.horarioInicio = horarioInicio; }

    public Instant getHorarioFim() { return horarioFim; }
    public void setHorarioFim(Instant horarioFim) { this.horarioFim = horarioFim; }

    public Atividade getAtividade() { return atividade; }
    public void setAtividade(Atividade atividade) { this.atividade = atividade; }
}
