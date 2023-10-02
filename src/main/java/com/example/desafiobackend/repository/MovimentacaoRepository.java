package com.example.desafiobackend.repository;

import com.example.desafiobackend.entity.MovimentacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoRepository extends JpaRepository<MovimentacaoEntity, Long> {
}
