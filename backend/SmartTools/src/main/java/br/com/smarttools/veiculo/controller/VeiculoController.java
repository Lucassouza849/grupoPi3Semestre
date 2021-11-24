package br.com.smarttools.veiculo.controller;

import br.com.smarttools.cliente.model.Cliente;
import br.com.smarttools.veiculo.model.Veiculo;
import br.com.smarttools.veiculo.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @GetMapping
    public List<Veiculo> getVeiculos() {
        return veiculoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Veiculo getVeiculosById(@PathVariable Integer id){
        return veiculoRepository.findById(id).get();
    }

    @PostMapping
    public ResponseEntity<Veiculo> createVeiculo(@RequestBody Veiculo newVeiculo){
        veiculoRepository.save(newVeiculo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{veiculoId}")
    public ResponseEntity<Veiculo> atualizar(@PathVariable Integer veiculoId, @RequestBody Veiculo updateVeiculo){
        if (!veiculoRepository.existsById(veiculoId)){
            return ResponseEntity.notFound().build();
        }
        updateVeiculo.setIdVeiculo(veiculoId);
        veiculoRepository.save(updateVeiculo);
        return ResponseEntity.ok(updateVeiculo);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Veiculo> deleteVeiculo(@PathVariable Integer id){
        if (!veiculoRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        veiculoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}



