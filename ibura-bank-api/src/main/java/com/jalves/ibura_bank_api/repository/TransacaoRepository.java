package com.jalves.ibura_bank_api.repository;

import com.jalves.ibura_bank_api.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao,Long> {
}
