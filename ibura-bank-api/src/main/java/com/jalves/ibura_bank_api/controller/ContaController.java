package com.jalves.ibura_bank_api.controller;

import com.jalves.ibura_bank_api.model.Conta;
import com.jalves.ibura_bank_api.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @GetMapping
    public List<Conta> findAll(){
        return contaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Conta> findById(@PathVariable Long id){
        return contaService.findById(id);
    }

    @PostMapping
    public Conta save(@RequestBody Conta conta){
        return contaService.save(conta);
    }

    @DeleteMapping("/{id}")
    public void delet(@PathVariable Long id){
        contaService.deleteById(id);
    }
}
