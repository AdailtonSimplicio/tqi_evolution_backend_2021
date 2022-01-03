package com.tqi_evolution_backend_2021.analisecred.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEndereco;
    @Column(nullable = false)
    private String uf;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private String bairro;
    @Column(nullable = false)
    private String rua;
    @Column(nullable = false)
    private int numero;
    private String complemento;
}
