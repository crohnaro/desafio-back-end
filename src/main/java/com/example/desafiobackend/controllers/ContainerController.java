package com.example.desafiobackend.controllers;

import com.example.desafiobackend.model.ContainerModel;
import com.example.desafiobackend.service.ContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class ContainerController {

    @Autowired
    private ContainerService containerService;

    @PatchMapping("/containers/add")
    public ContainerModel saveContainer(@RequestBody ContainerModel containerModel){
        return containerService.saveContainer(containerModel);
    }

    @GetMapping("/containers/get")
    public List<ContainerModel> getAllContainers(){
        return containerService.getAllContainers();
    }

    @DeleteMapping("/containers/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteContainer(@PathVariable("id") Long id){
        boolean deleted = false;
        deleted = containerService.deletedContainer(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);
    }

}
