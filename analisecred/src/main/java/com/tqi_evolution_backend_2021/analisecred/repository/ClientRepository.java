package com.tqi_evolution_backend_2021.analisecred.repository;

import com.tqi_evolution_backend_2021.analisecred.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query(value = "select c.* from cliente c WHERE c.email = :email AND c.senha = :senha ",nativeQuery = true)
    Optional<Client> GetLogin(String email, String senha);
}
