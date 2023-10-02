package com.example.desafiobackend.service;

import com.example.desafiobackend.model.ContainerModel;

import java.util.List;

public interface ContainerService {

    ContainerModel saveContainer(ContainerModel containerModel);

    List<ContainerModel> getAllContainers();

    boolean deletedContainer(Long id);
}
