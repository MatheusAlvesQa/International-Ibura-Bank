package com.jalves.ibura_bank_api.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.jalves.ibura_bank_api.enums.NumeroAgenciasEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "agencias")
public class Agencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id", unique = true)
    private Long id;

    @Column(name = "numero", nullable = false, unique = true, length = 10)
    private NumeroAgenciasEnum numero;

    @OneToMany(mappedBy = "agencia", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Conta> contas;
}
