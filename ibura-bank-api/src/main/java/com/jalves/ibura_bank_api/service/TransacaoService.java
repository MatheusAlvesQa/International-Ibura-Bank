package com.jalves.ibura_bank_api.service;

import com.jalves.ibura_bank_api.model.Transacao;
import com.jalves.ibura_bank_api.repository.TransacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    public List<Transacao> findAll() {
        return transacaoRepository.findAll();
    }

    public Optional<Transacao> findById(Long id) {
        return transacaoRepository.findById(id);
    }

    @Transactional
    public Transacao save(Transacao transacao) {
        transacao.setId(null); // Garante novo registro
        return transacaoRepository.save(transacao);
    }

    @Transactional
    public Transacao update(Long id, Transacao dadosAtualizados) {
        Transacao transacaoExistente = transacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transação não encontrada"));

        transacaoExistente.setValor(dadosAtualizados.getValor());
        transacaoExistente.setTipo(dadosAtualizados.getTipo());
        transacaoExistente.setConta(dadosAtualizados.getConta());

        return transacaoRepository.save(transacaoExistente);
    }

    @Transactional
    public void deleteById(Long id) {
        transacaoRepository.deleteById(id);
    }
}