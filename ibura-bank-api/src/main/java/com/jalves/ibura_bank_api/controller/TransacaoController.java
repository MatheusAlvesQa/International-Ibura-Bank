package com.jalves.ibura_bank_api.controller;

import com.jalves.ibura_bank_api.model.Transacao;
import com.jalves.ibura_bank_api.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @GetMapping
    public List<Transacao> findAll() {
        return transacaoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Transacao> findById(@PathVariable Long id) {
        return transacaoService.findById(id);
    }

    @PostMapping
    public Transacao save(@RequestBody Transacao transacao) {
        return transacaoService.save(transacao);
    }

    @PutMapping("/{id}")
    public Transacao update(@PathVariable Long id, @RequestBody Transacao transacaoAtualizada) {
        return transacaoService.update(id, transacaoAtualizada);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        transacaoService.deleteById(id);
    }
}