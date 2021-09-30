package br.com.smarttools.plano.controller;

import br.com.smarttools.plano.domain.Plano;
import br.com.smarttools.plano.repository.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/planos")
public class PlanoController{
    @Autowired
    private PlanoRepository planoRepository;

    @GetMapping("/{id}")
    public Plano getPlanosById(@PathVariable Integer id){
        return planoRepository.findById(id).get();
    }
}
