package com.jalves.ibura_bank_api.controller;

import com.jalves.ibura_bank_api.model.Agencia;
import com.jalves.ibura_bank_api.model.Conta;
import com.jalves.ibura_bank_api.repository.AgenciaRepository;
import com.jalves.ibura_bank_api.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @Autowired
    private AgenciaRepository agenciaRepository;

    @GetMapping
    public List<Conta> findAll() {
        return contaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Conta> findById(@PathVariable Long id) {
        return contaService.findById(id);
    }

    @GetMapping("/numero/{numero}")
    public Optional<Conta> findByNumero(@PathVariable String numero) {
        return contaService.findByNumero(numero);
    }

    @PostMapping
    public ResponseEntity<Conta> save(@RequestBody Conta conta) {
        Agencia agencia = agenciaRepository.findById(conta.getAgencia().getId())
                .orElseThrow(() -> new RuntimeException("Agência não encontrada"));
        conta.setAgencia(agencia);
        Conta savedConta = contaService.save(conta);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedConta);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        contaService.deleteById(id);
    }

}
