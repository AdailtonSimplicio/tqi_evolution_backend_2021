package com.tqi_evolution_backend_2021.analisecred.controller;

import com.tqi_evolution_backend_2021.analisecred.entity.Client;
import com.tqi_evolution_backend_2021.analisecred.entity.Loan;
import com.tqi_evolution_backend_2021.analisecred.exception.LoanNotFoundException;
import com.tqi_evolution_backend_2021.analisecred.services.LoanService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/emprestimo")
public class LoanController {
    @Autowired
    private LoanService loanService;
    @Autowired
    private ModelMapper modelMapper;


    //Metodo listar emprestimo
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Loan> listAllLoan(){
        return loanService.listAllLoan();
    }
    //Metodo buscar por ID
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Loan findLoanById(@PathVariable("id") Long id) throws LoanNotFoundException {

        return loanService.findLoanById(id);
    }
    //Metodo para salvar emprestimo
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Loan> CreateLoan(@RequestBody Loan NewLoan){
        return loanService.CreateLoan(NewLoan);
    }
    //Metodo deletar por id
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity deleteLoan(@PathVariable Long id) {
        return loanService.deleteLoan(id);
    }
    //metodo Put - Alterando um emprestimo
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity ChangeLoan(@PathVariable("id") Long id, @RequestBody Loan loan) {
        return loanService.ChangeLoan(id, loan);
    }

}
