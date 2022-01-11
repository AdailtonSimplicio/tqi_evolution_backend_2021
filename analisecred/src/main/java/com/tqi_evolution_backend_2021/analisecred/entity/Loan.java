package com.tqi_evolution_backend_2021.analisecred.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
/*import com.tqi_evolution_backend_2021.analisecred.exception.ClientNotFoundException;*/
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Loan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double valorEmprestimo;
    @Column(nullable = false)
    private Integer quantidadeParcela;
    @Column(nullable = false)
    private LocalDate dataPrimeiraParcela;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cliente",referencedColumnName = "id")
    private Client client;

}

