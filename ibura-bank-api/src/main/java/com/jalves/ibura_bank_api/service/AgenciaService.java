package com.jalves.ibura_bank_api.service;

import com.jalves.ibura_bank_api.model.Agencia;
import com.jalves.ibura_bank_api.repository.AgenciaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgenciaService {

    @Autowired
    private AgenciaRepository agenciaRepository;

    public List<Agencia> findAll() {
        return agenciaRepository.findAll();
    }

    public Optional<Agencia> findById(Long id) {
        return agenciaRepository.findById(id);
    }

    @Transactional
    public Agencia save(Agencia agencia) {
        agencia.setId(null);
        return agenciaRepository.save(agencia);
    }

    @Transactional
    public void deleteById(Long id) {
        agenciaRepository.deleteById(id);
    }
}