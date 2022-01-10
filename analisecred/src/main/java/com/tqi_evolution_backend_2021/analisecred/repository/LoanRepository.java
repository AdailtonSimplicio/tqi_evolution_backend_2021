package com.tqi_evolution_backend_2021.analisecred.repository;

import com.tqi_evolution_backend_2021.analisecred.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository

public interface LoanRepository extends JpaRepository<Loan, Long >{

}

