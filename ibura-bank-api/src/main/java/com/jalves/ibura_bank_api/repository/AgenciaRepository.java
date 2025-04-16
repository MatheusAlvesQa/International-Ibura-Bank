package com.jalves.ibura_bank_api.repository;

import com.jalves.ibura_bank_api.model.Agencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenciaRepository extends JpaRepository<Agencia, Long> {
}
