//Repository
//Chamada pela service logo após o retorno da model, tradução dos comandos SQL para o banco de dados, depois disso ela envia o comando para o banco de dados
//que retorna para repository que retorna para service, e que posteriormente restorna para a controller.

package net.weg.api.repository;

import java.util.*;

public interface ICrud<T, ID> {
    void inserir(T obj);

    T buscarUm(ID id);

    Set<T> buscarTodos();

    void atualizar(T obj);

    void deletar(ID id);
}