package com.example.desafiobackend.controllers;

import com.example.desafiobackend.model.MovimentacaoModel;
import com.example.desafiobackend.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoService movimentacaoService;

    @PatchMapping("/movimentacoes/add")
    public MovimentacaoModel saveMovimentacao(@RequestBody MovimentacaoModel movimentacaoModel){
        return movimentacaoService.saveMovimentacao(movimentacaoModel);
    }

    @GetMapping("/movimentacoes/get")
    public List<MovimentacaoModel> getAllMovimentacoes(){
        return movimentacaoService.getAllMovimentacoes();
    }

    @DeleteMapping("/movimentacoes/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteMovimentacao(@PathVariable("id")Long id){
        boolean deleted = false;
        deleted = movimentacaoService.deletedMovimentacao(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);
    }

}
