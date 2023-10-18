//Service
//é acionada pela controller ou outras services, implementa regras de negócio, normalmente envolvendo outras classes/entidades
//acionar as camadas model, repository

package net.weg.api.service;

import java.util.*;
import net.weg.api.model.Carro;
import net.weg.api.repository.CarroDAO;
import org.springframework.stereotype.Service;

@Service
public class CarroService {

    private CarroDAO carroDAO;

    public CarroService(){
        this.carroDAO  = new CarroDAO();
    }

    public Carro buscarUm(Integer id) {
        return carroDAO.buscarUm(id);
    }

    public Collection<Carro> buscarTodos() {
        return carroDAO.buscarTodos();
    }

    public void atualizar(Carro carro) {
        carroDAO.atualizar(carro);
    }

    public void inserir(Carro carro) {
        carroDAO.inserir(carro);
    }

    public void deletar(Integer id) {
        carroDAO.deletar(id);
    }
}
