package com.tqi_evolution_backend_2021.analisecred.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity

public class ClienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(nullable = false)
    public String nome;
    @Column(nullable = false)
    public String email;
    @Column(nullable = false)
    public String cpf;
    @Column(nullable = false)
    public String rg;
    @Column(nullable = false)
    public String endereco;
    @Column(nullable = false)
    public Float renda;
    @Column(nullable = false)
    public String senha;
}


