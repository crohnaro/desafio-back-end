package com.example.desafiobackend.service;

import com.example.desafiobackend.entity.ContainerEntity;
import com.example.desafiobackend.model.ContainerModel;
import com.example.desafiobackend.repository.ContainerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContainerServiceImplementation implements ContainerService {

    private ContainerRepository containerRepository;

    public ContainerServiceImplementation(ContainerRepository containerRepository) {
        this.containerRepository = containerRepository;
    }

    @Override
    public ContainerModel saveContainer(ContainerModel containerModel) {
        ContainerEntity containerEntity = new ContainerEntity();
        BeanUtils.copyProperties(containerModel, containerEntity);
        containerRepository.save(containerEntity);
        return containerModel;
    }

    @Override
    public List<ContainerModel> getAllContainers() {
        List<ContainerEntity> containerEntities = containerRepository.findAll();

        List<ContainerModel> containers = containerEntities
                .stream()
                .map(containerEntity ->
                        new ContainerModel(
                                containerEntity.getId(),
                                containerEntity.getCliente(),
                                containerEntity.getNumero(),
                                containerEntity.getTipo(),
                                containerEntity.getStatus(),
                                containerEntity.getCategoria()
                        )
                )
                .collect(Collectors.toList());

        return containers;
    }

    @Override
    public boolean deletedContainer(Long id) {
        ContainerEntity containerModel = containerRepository.findById(id).get();
        containerRepository.delete(containerModel);
        return true;
    }
}
