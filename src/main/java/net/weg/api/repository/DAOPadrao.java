//Repository
//Chamada pela service logo após o retorno da model, tradução dos comandos SQL para o banco de dados, depois disso ela envia o comando para o banco de dados
//que retorna para repository que retorna para service, e que posteriormente restorna para a controller.

package net.weg.api.repository;

import java.sql.*;
import java.util.*;

public abstract class DAOPadrao<T, ID> implements ICrud<T, ID> {

    protected Connection connection;
    private String tabela;

    public DAOPadrao(String tabela) {
//        this.connection = Banco.conectar();
        this.tabela = tabela;
    }

    protected void conectar() {
        this.connection = Banco.conectar();
    }

    @Override
    public Set<T> buscarTodos() {
        conectar();
        Set<T> listaTodos = new HashSet<>();
        try (PreparedStatement statement = connection.prepareStatement("select * from " + tabela + ";")) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                listaTodos.add(converter(rs));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                this.connection.close();
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
        return listaTodos;
    }


    public void deletar(Integer id) {
        conectar();
        try (PreparedStatement statement = connection.prepareStatement("delete from " + tabela + " where id=?;")) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                this.connection.close();
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
    }


        public T buscarUm (Integer id){
            conectar();
            try (PreparedStatement statement = connection.prepareStatement("select * from " + tabela + " where id=?")) {
                statement.setInt(1, id);
                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    return converter(rs);
                }
                throw new NoSuchElementException();
            } catch (SQLException throwables) {
                throw new RuntimeException();
            }finally {
                try{
                    this.connection.close();
                }catch (Exception e){
                    throw new RuntimeException();
                }
            }
        }

        public abstract T converter (ResultSet rs) throws SQLException;

    }