package com.example.desafiobackend.repository;

import com.example.desafiobackend.entity.ContainerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContainerRepository extends JpaRepository<ContainerEntity, Long> {
}
