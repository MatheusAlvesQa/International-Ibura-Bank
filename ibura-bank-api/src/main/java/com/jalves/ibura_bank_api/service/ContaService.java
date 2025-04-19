package com.jalves.ibura_bank_api.service;

import com.jalves.ibura_bank_api.model.Conta;
import com.jalves.ibura_bank_api.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public List<Conta> findAll(){
        return contaRepository.findAll();
    }

    public Optional<Conta> findById(Long id){
        return contaRepository.findById(id);
    }

    public Optional<Conta> findByNumero(String numero){
        return contaRepository.findByNumero(numero);
    }

    @Transactional
    public Conta save(Conta conta) {
        conta.setId(null);
        return contaRepository.save(conta);
    }

    @Transactional
    public void deleteById(Long id) {
        if (contaRepository.existsById(id)) {
            contaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Conta não encontrada");
        }
    }

}
