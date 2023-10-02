package com.example.desafiobackend.model;

import com.example.desafiobackend.entity.ContainerEntity;

import java.util.Date;

public class MovimentacaoModel {

    private Long id;

    private String tipoMovimentacao;
    private Date dataHoraInicio;
    private Date dataHoraFim;
    private ContainerEntity containerEntity;

    public MovimentacaoModel(Long id, String tipoMovimentacao, Date dataHoraInicio, Date dataHoraFim, ContainerEntity containerEntity) {
        this.id = id;
        this.tipoMovimentacao = tipoMovimentacao;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.containerEntity = containerEntity;
    }

    public MovimentacaoModel() {
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
