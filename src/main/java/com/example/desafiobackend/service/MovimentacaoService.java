package com.example.desafiobackend.service;

import com.example.desafiobackend.model.MovimentacaoModel;

import java.util.List;

public interface MovimentacaoService {

    MovimentacaoModel saveMovimentacao(MovimentacaoModel movimentacaoModel);

    List<MovimentacaoModel> getAllMovimentacoes();

    boolean deletedMovimentacao(Long id);
}
