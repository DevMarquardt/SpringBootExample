//Controller
//Recebe a requisição, Implementa regras relacionadas a requisição HTTP, Aciona a camada service.

package net.weg.api.controller;

import java.util.*;
import net.weg.api.model.Carro;
import net.weg.api.service.CarroService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carros")

public class CarroController {

    private CarroService carroService = new CarroService();

    @GetMapping("/{id}")
    public Carro buscarCarro(@PathVariable Integer id) {
        return carroService.buscarUm(id);
    }

    @GetMapping()
    public Collection<Carro> buscarTodos() {
        return carroService.buscarTodos();
    }

    @PutMapping()
    public void atualizar(@RequestBody Carro carro) {
        carroService.atualizar(carro);
    }

    @PostMapping()
    public void inserir(@RequestBody Carro carro) {
        carroService.inserir(carro);
    }

    @DeleteMapping()
    public void deletar(@RequestParam Integer id) {
        carroService.deletar(id);
    }
}