//Model
//Chamada pelo service, implementa regras de negócio da classe, devolve para a service

package net.weg.api.model;

import lombok.Data;

import java.sql.*;

@Data
public class Carro {
    private int id;
    private String marca;
    private String modelo;
    private int ano;
    private double preco;

    public Carro(ResultSet rs) throws SQLException {
        this.id = rs.getInt("id");
        this.marca = rs.getString("marca");
        this.modelo = rs.getString("modelo");
        this.ano = rs.getInt("ano");
        this.preco = rs.getDouble("preco");
    }

    public Carro(int id) {
        this.id = id;
    }
}