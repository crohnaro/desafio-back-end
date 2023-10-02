package com.example.desafiobackend.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "movimentacao")
public class MovimentacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoMovimentacao;
    private Date dataHoraInicio;
    private Date dataHoraFim;

    @ManyToOne
    @JoinColumn(name = "container_id")
    private ContainerEntity containerEntity;

    public MovimentacaoEntity() {
    }

    public MovimentacaoEntity(Long id, String tipoMovimentacao, Date dataHoraInicio, Date dataHoraFim, ContainerEntity containerEntity) {
        this.id = id;
        this.tipoMovimentacao = tipoMovimentacao;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.containerEntity = containerEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public Date getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(Date dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public Date getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(Date dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public ContainerEntity getContainerEntity() {
        return containerEntity;
    }

    public void setContainerEntity(ContainerEntity containerEntity) {
        this.containerEntity = containerEntity;
    }
}
