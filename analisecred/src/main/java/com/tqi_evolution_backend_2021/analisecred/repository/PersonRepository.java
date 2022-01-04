package com.tqi_evolution_backend_2021.analisecred.repository;

import com.tqi_evolution_backend_2021.analisecred.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
