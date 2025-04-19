package com.jalves.ibura_bank_api.controller;

import com.jalves.ibura_bank_api.model.Agencia;
import com.jalves.ibura_bank_api.service.AgenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agencias")
public class AgenciaController {

    @Autowired
    private AgenciaService agenciaService;

    @GetMapping
    public List<Agencia> findAll() {
        return agenciaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Agencia> findById(@PathVariable Long id) {
        return agenciaService.findById(id);
    }

    @PostMapping
    public Agencia save(@RequestBody Agencia agencia) {
        return agenciaService.save(agencia);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        agenciaService.deleteById(id);
    }
}