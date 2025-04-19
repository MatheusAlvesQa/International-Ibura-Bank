package com.jalves.ibura_bank_api.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contas")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id", unique = true)
    private Long id;

    @Column(name = "nome", unique = true, nullable = false, length = 100)
    private String nome;

    @Column(name = "senha", nullable = false, length = 60)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String senha;

    @Column(name = "cpf", unique = true, nullable = false, length = 11)
    private String cpf;

    @Column(name = "email", nullable = true)
    private String email;

    @Column(name = "telefone", length = 11)
    private String telefone;

    @Column(name = "numero", nullable = false, unique = true)
    private String numero;

    @Column(name = "saldo")
    private BigDecimal saldo = BigDecimal.ZERO;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "agencia_id")
    @JsonManagedReference
    private Agencia agencia;


}
