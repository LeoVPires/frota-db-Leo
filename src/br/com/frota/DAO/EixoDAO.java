package br.com.frota.DAO;

import br.com.frota.model.Eixo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EixoDAO extends ConexaoDB {

    private static final String INSERT_VEICULO_SQL = "INSERT INTO eixo (descricao, posicao, id_tipo_eixo) VALUES (?, ?, ?);";
    private static final String SELECT_VEICULO_BY_ID = "SELECT id, descricao, posicao, id_tipo_eixo FROM eixo WHERE id = ?";
    private static final String SELECT_ALL_VEICULO = "SELECT * FROM eixo;";
    private static final String DELETE_VEICULO_SQL = "DELETE FROM eixo WHERE id = ?;";
    private static final String UPDATE_VEICULO_SQL = "UPDATE eixo SET descricao = ?, posicao = ?, id_tipo_eixo = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM eixo;";

    public Integer count() {
        Integer count = 0;
        try (PreparedStatement preparedStatement = prapararSQL(TOTAL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public void insertEixo(Eixo entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSERT_VEICULO_SQL)) {
            preparedStatement.setString(1, entidade.getDescricao());
            preparedStatement.setString(2, entidade.getPosicao());
            preparedStatement.setString(3, entidade.getidTipoEixo());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Eixo selectEixo(int id) {
        Eixo entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_VEICULO_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String descricao = rs.getString("descricao");
                Integer posicao = rs.getString("posicao");
                Integer idTipoEixo = rs.getString("id_tipo_eixo");
                entidade = new Eixo(id, descricao, posicao, idTipoEixo);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<Eixo> selectAllEixos() {
        List<Eixo> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_VEICULO)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                Integer posicao = rs.getString("posicao");
                Integer idTipoEixo = rs.getString("id_tipo_eixo");
                entidades.add(new Eixo(id, descricao, idTipoEixo));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteEixo(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE_VEICULO_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateEixo(Eixo entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE_VEICULO_SQL)) {
            statement.setString(1, entidade.getDescricao());
            statement.setString(2, entidade.getPosicao());
            statement.setString(3, entidade.getIdTipoEixo());
            statement.setInt(4, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
