//Model
//Chamada pelo service, implementa regras de negócio da classe, devolve para a service

package net.weg.api.model;

import lombok.*;

import java.sql.*;

@Data
@NoArgsConstructor

public class Usuario {
    private Integer id;
    private String nome;
    private String senha;
    private Integer idade;
    private Carro carro;

    public Usuario(ResultSet rs) throws SQLException {
        this.id = rs.getInt("id");
        this.nome = rs.getString("nome");
        this.senha = rs.getString("senha");
        this.idade = rs.getInt("idade");
        if (rs.getInt("id_carro") != 0) {
            this.carro = new Carro(rs.getInt("id"));
        }
    }
}