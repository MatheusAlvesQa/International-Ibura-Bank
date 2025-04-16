package com.jalves.ibura_bank_api.repository;

import com.jalves.ibura_bank_api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByCpf(String cpf);
}
