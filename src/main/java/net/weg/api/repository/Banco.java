//Repository
//Chamada pela service logo após o retorno da model, tradução dos comandos SQL para o banco de dados, depois disso ela envia o comando para o banco de dados
//que retorna para repository que retorna para service, e que posteriormente restorna para a controller.

package net.weg.api.repository;

import java.sql.*;

public class Banco {
    private static final String urlBanco = "jdbc:mysql://localhost:3306/aulajavabancodados";
    private static final String usuarioBD = "root";
    private static final String senhaBD = "root";

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(urlBanco, usuarioBD, senhaBD);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}