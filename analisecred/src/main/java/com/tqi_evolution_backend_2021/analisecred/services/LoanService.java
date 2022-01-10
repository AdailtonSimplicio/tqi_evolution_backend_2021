package com.tqi_evolution_backend_2021.analisecred.services;

import com.tqi_evolution_backend_2021.analisecred.entity.Loan;
import com.tqi_evolution_backend_2021.analisecred.exception.LoanNotFoundException;
import com.tqi_evolution_backend_2021.analisecred.repository.LoanRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class LoanService {

    private LoanRepository loanRepository;

    public List<Loan> listAllLoan(){
        return loanRepository.findAll();
    }
    public Loan findLoanById(@PathVariable Long id) throws LoanNotFoundException {
        Optional<Loan> emprestimoOptional = loanRepository.findById(id);
        return emprestimoOptional.orElseThrow(() -> new LoanNotFoundException("Loan Not Found"));
    }
    public ResponseEntity<Loan> CreateLoan(@RequestBody Loan NewLoan){
        LocalDate dataPrimeiraParcela = NewLoan.getDataPrimeiraParcela();
        LocalDate data_tres_meses = LocalDate.now().plusMonths(3);

        if((NewLoan.getQuantidadeParcela() <= 60) && (dataPrimeiraParcela.compareTo(data_tres_meses) <= 0)){
            return new ResponseEntity<>(loanRepository.save(NewLoan), HttpStatus.OK);
        }else {
            System.out.println("Emprestimo excedeu o limite permitido!");
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    public ResponseEntity deleteLoan(@PathVariable Long id) {
        Optional<Loan> emprestimoOptional = loanRepository.findById(id);
        if(emprestimoOptional.isPresent()){
            loanRepository.deleteById(id);
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return  new ResponseEntity(new LoanNotFoundException("Emprestimo não foi encontrado!"),HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity ChangeLoan(@PathVariable Long id, @RequestBody Loan NewLoan) {
        Optional<Loan> emprestimoOld = loanRepository.findById(id);

        if (emprestimoOld.isPresent()) {
            Loan loan = emprestimoOld.get();
            loan.setValorEmprestimo(NewLoan.getValorEmprestimo());
            loan.setQuantidadeParcela(NewLoan.getQuantidadeParcela());
            loan.setDataPrimeiraParcela(NewLoan.getDataPrimeiraParcela());
            return new ResponseEntity<>(loan, HttpStatus.OK);
        } else {
            return new ResponseEntity(new LoanNotFoundException("Emprestimo não foi encontrado!"), HttpStatus.NOT_FOUND);
        }
    }
}