package com.jalves.ibura_bank_api.service;

import com.jalves.ibura_bank_api.model.Usuario;
import com.jalves.ibura_bank_api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Optional<Usuario> findById(Long id){
        return usuarioRepository.findById(id);
    }

    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public void deleteById(Long id){
        usuarioRepository.deleteById(id);
    }

}
