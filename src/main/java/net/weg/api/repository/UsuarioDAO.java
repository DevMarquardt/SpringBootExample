//Repository
//Chamada pela service logo após o retorno da model, tradução dos comandos SQL para o banco de dados, depois disso ela envia o comando para o banco de dados
//que retorna para repository que retorna para service, e que posteriormente restorna para a controller que retorna para o cliente no fim.

package net.weg.api.repository;

import java.sql.*;
import net.weg.api.model.Usuario;

public class UsuarioDAO extends DAOPadrao<Usuario, Integer> {


    public UsuarioDAO() {
        super("usuarios");
    }

    @Override
    public Usuario converter(ResultSet rs) throws SQLException {
        return new Usuario(rs);
    }

    @Override
    public void inserir(Usuario user) {
        String comandoSql = "insert into usuarios values(?,?,?,?,?);";
        try (PreparedStatement statement = connection.prepareStatement(comandoSql)) {
            statement.setInt(1, user.getId());
            statement.setString(2, user.getNome());
            statement.setString(3, user.getSenha());
            statement.setInt(4, user.getIdade());
            try {
                statement.setInt(5, user.getCarro().getId());
            } catch (NullPointerException e) {
                statement.setNull(5, 0);
            }
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void atualizar(Usuario obj) {
        String comandoSql = "update usuarios set nome = ?,senha=?,idade = ?, id_carro = ? where id= ?;";
        try (PreparedStatement statement = connection.prepareStatement(comandoSql)) {
            statement.setString(1, obj.getNome());
            statement.setString(2, obj.getSenha());
            statement.setInt(3, obj.getIdade());
            try {
                statement.setInt(4, obj.getCarro().getId());
            } catch (NullPointerException e) {
                statement.setInt(5, 0);
            }
            statement.setInt(5, obj.getId());
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}