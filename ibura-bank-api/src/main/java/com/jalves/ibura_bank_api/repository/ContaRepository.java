package com.jalves.ibura_bank_api.repository;

import com.jalves.ibura_bank_api.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>{
    Optional<Conta> findByNumero(String numero);
}
