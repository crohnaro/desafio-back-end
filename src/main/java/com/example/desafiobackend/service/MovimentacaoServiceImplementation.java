package com.example.desafiobackend.service;

import com.example.desafiobackend.entity.ContainerEntity;
import com.example.desafiobackend.entity.MovimentacaoEntity;
import com.example.desafiobackend.model.MovimentacaoModel;
import com.example.desafiobackend.repository.ContainerRepository;
import com.example.desafiobackend.repository.MovimentacaoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimentacaoServiceImplementation implements MovimentacaoService {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Autowired
    private ContainerRepository containerRepository;

    public MovimentacaoServiceImplementation(MovimentacaoRepository movimentacaoRepository, ContainerRepository containerRepository) {
        this.movimentacaoRepository = movimentacaoRepository;
        this.containerRepository = containerRepository;
    }

    @Override
    public MovimentacaoModel saveMovimentacao(MovimentacaoModel movimentacaoModel) {
        MovimentacaoEntity movimentacaoEntity = new MovimentacaoEntity();

        BeanUtils.copyProperties(movimentacaoModel, movimentacaoEntity);

        if(movimentacaoModel.getContainerEntity() != null){
            ContainerEntity containerEntity = containerRepository.findById(movimentacaoModel.getContainerEntity().getId()).orElse(null);

            movimentacaoEntity.setContainerEntity(containerEntity);

            if(containerEntity != null){
                movimentacaoModel.getContainerEntity().setCliente(containerEntity.getCliente());
                movimentacaoModel.getContainerEntity().setNumero(containerEntity.getNumero());
                movimentacaoModel.getContainerEntity().setTipo(containerEntity.getTipo());
                movimentacaoModel.getContainerEntity().setStatus(containerEntity.getStatus());
                movimentacaoModel.getContainerEntity().setCategoria(containerEntity.getCategoria());
            }
        }

        movimentacaoRepository.save(movimentacaoEntity);

        return movimentacaoModel;
    }

    @Override
    public List<MovimentacaoModel> getAllMovimentacoes() {
        List<MovimentacaoEntity> movimentacaoEntities
                = movimentacaoRepository.findAll();

        List<MovimentacaoModel> movimentacoes = movimentacaoEntities
                .stream()
                .map(movimentacaoEntity -> new MovimentacaoModel(
                        movimentacaoEntity.getId(),
                        movimentacaoEntity.getTipoMovimentacao(),
                        movimentacaoEntity.getDataHoraInicio(),
                        movimentacaoEntity.getDataHoraFim(),
                        movimentacaoEntity.getContainerEntity()
                ))
                .toList();

                return movimentacoes;
    }

    @Override
    public boolean deletedMovimentacao(Long id) {
        MovimentacaoEntity movimentacaoModel = movimentacaoRepository.findById(id).get();
        movimentacaoRepository.delete(movimentacaoModel);
        return true;
    }
}
