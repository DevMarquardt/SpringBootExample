//Controller
//Recebe a requisição, Implementa regras relacionadas a requisição HTTP, Aciona a camada service.

package net.weg.api.controller;

import java.util.*;
import net.weg.api.model.Usuario;
import net.weg.api.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")

public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }
    @GetMapping("/{id}")
    public Usuario buscarUsuario(@PathVariable Integer id) {
        return usuarioService.buscarUm(id);
    }

    @GetMapping()
    public Collection<Usuario> buscarTodos() {
        return usuarioService.buscarTodos();
    }

    @DeleteMapping()
    public void deletar(@RequestParam Integer id) {
        usuarioService.deletar(id);
    }

    @PostMapping()
    public void inserir(@RequestBody Usuario usuario) {
        usuarioService.inserir(usuario);
    }

    @PutMapping()
    public void atualizar(@RequestBody Usuario usuario) {
        usuarioService.atualizar(usuario);
    }
}