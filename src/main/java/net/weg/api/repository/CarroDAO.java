//Repository
//Chamada pela service logo após o retorno da model, tradução dos comandos SQL para o banco de dados, depois disso ela envia o comando para o banco de dados
//que retorna para repository que retorna para service, e que posteriormente restorna para a controller.

package net.weg.api.repository;

import java.sql.*;
import net.weg.api.model.Carro;

public class CarroDAO extends DAOPadrao<Carro, Integer> {

    public CarroDAO(){
        super("carro");
    }

    @Override
    public Carro converter(ResultSet rs) throws SQLException {
        return new Carro(rs);
    }

    @Override
    public void inserir(Carro car) {
        String comandoSql = "insert into carro values(?,?,?,?,?);";
        try (PreparedStatement statement = connection.prepareStatement(comandoSql)){
            statement.setInt(1,car.getId());
            statement.setString(2,car.getMarca());
            statement.setString(3,car.getModelo());
            statement.setInt(4,car.getAno());
            statement.setDouble(5,car.getPreco());
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void atualizar(Carro car) {
        String comandoSql = "update carro set marca = ?,modelo = ?, ano = ?, preco = ? where id= ?;";
        try (PreparedStatement statement = connection.prepareStatement(comandoSql)){
            statement.setString(1,car.getMarca());
            statement.setString(2,car.getModelo());
            statement.setInt(3,car.getAno());
            statement.setDouble(4,car.getPreco());
            statement.setDouble(5,car.getId());
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}