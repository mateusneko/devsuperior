package com.devsuperior.desafio.entities;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "tb_atividade")
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private Double preco;

    @OneToMany(mappedBy = "atividade", cascade = CascadeType.ALL)
    private List<Bloco> blocos = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "atividade_participante",
            joinColumns = @JoinColumn(name = "atividade_id"),
            inverseJoinColumns = @JoinColumn(name = "participante_id"))
    private Set<Participante> participantes = new HashSet<>();

    public Atividade() {}

    public Atividade(Long id, String nome, String descricao, Double preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }

    public List<Bloco> getBlocos() { return blocos; }
    public void setBlocos(List<Bloco> blocos) { this.blocos = blocos; }

    public Set<Participante> getParticipantes() { return participantes; }
    public void setParticipantes(Set<Participante> participantes) { this.participantes = participantes; }
}
