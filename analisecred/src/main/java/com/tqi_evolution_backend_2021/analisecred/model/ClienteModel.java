package com.tqi_evolution_backend_2021.analisecred.model;

import com.sun.istack.NotNull;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "cliente")
public class ClienteModel {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Id
    public Integer id;
    @NotNull
    public String nome;
    @NotNull
    public String email;
    @NotNull
    public String cpf;
    @NotNull
    public String rg;
    @NotNull
    public String endereco;
    @NotNull
    public Float renda;
    @NotNull
    public String senha;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Float getRenda() {
        return renda;
    }

    public void setRenda(Float renda) {
        this.renda = renda;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}


