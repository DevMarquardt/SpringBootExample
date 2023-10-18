//Service
//é acionada pela controller ou outras services, implementa regras de negócio, normalmente envolvendo outras classes/entidades
//acionar as camadas model, repository

package net.weg.api.service;

import net.weg.api.model.Usuario;
import net.weg.api.repository.UsuarioDAO;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UsuarioService {
    private UsuarioDAO usuarioDAO;
    private CarroService carroService;

    public UsuarioService() {
        this.carroService = new CarroService();
        this.usuarioDAO = new UsuarioDAO();
    }

    public void inserir(Usuario usuario) {
        try {
            carroService.buscarUm(usuario.getCarro().getId());
        } catch (Exception e) {
            carroService.inserir(usuario.getCarro());
        }
        usuarioDAO.inserir(usuario);

    }

    public Usuario buscarUm(Integer id) {
        Usuario usuario = usuarioDAO.buscarUm(id);
        try {
            usuario.setCarro(carroService.buscarUm(usuario.getCarro().getId()));
        } catch (Exception ignore) {
        }
        return usuario;
    }

    public Collection<Usuario> buscarTodos() {
        Collection<Usuario> usuarios = usuarioDAO.buscarTodos();
        for (Usuario usuario : usuarios) {
            try {
                usuario.setCarro(carroService.buscarUm(usuario.getCarro().getId()));
            } catch (Exception ignore) {
            }
        }
        return usuarios;
    }

    public void deletar(Integer id) {
        usuarioDAO.deletar(id);
    }

    public void atualizar(Usuario usuario) {
        try {
            carroService.buscarUm(usuario.getCarro().getId());
        } catch (Exception e) {
            carroService.inserir(usuario.getCarro());
        }
        usuarioDAO.atualizar(usuario);
    }
}