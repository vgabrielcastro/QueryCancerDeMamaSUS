package com.test.spring.controller;

import com.test.spring.entity.FaixaEtaria;
import com.test.spring.repository.FaixaEtariaRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FaixaEtariaController {

    private FaixaEtariaRepo frepository;

    public FaixaEtariaController(FaixaEtariaRepo frepository) {
        this.frepository = frepository;
    }

    public void FaixaEtariaController(FaixaEtariaRepo frepository) {
        this.frepository = frepository;
    }

    @GetMapping("/faixaetaria")
    public ResponseEntity<?> findAllFaixaEtaria(){
        try{List<FaixaEtaria> lista = frepository.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/faixaetaria/{id}")
    public ResponseEntity<FaixaEtaria> findByIdFaixaEtaria(@PathVariable Long id){
        try{
            Optional<FaixaEtaria> unidOptional = frepository.findById(id);
            if (unidOptional.isPresent()){
                FaixaEtaria faixaEtariaUnid = unidOptional.get();
                return new ResponseEntity<>(faixaEtariaUnid, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/faixaetaria/novo")
    public FaixaEtaria newFaixaEtaria(@RequestBody FaixaEtaria newFaixa){
        return frepository.save(newFaixa);
    }

    @DeleteMapping("/faixaetaria/remover/{id}")
    public void deleteFaixaEtaria(@PathVariable long id){
        frepository.deleteById(id);
    }
}
