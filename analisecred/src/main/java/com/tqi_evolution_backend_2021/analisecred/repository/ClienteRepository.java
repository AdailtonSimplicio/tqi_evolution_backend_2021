package com.tqi_evolution_backend_2021.analisecred.repository;

import com.tqi_evolution_backend_2021.analisecred.model.ClienteModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ClienteRepository extends CrudRepository<ClienteModel, Long> {
}
