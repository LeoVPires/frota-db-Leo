package br.com.frota.DAO;

import br.com.frota.model.EixoVeiculo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EixoVeiculoDAO extends ConexaoDB {

    private static final String INSERT_EIXO_VEICULO_SQL = "INSERT INTO eixo_veiculo (id_veiculo, id_eixo, id_pneu) VALUES (?, ?, ?);";
    private static final String SELECT_EIXO_VEICULO_BY_ID = "SELECT id, id_veiculo, id_eixo, id_pneu FROM eixo_veiculo WHERE id = ?";
    private static final String SELECT_ALL_EIXO_VEICULO = "SELECT * FROM eixo_veiculo;";
    private static final String DELETE_EIXO_VEICULO_SQL = "DELETE FROM eixo_veiculo WHERE id = ?;";
    private static final String UPDATE_EIXO_VEICULO_SQL = "UPDATE eixo_veiculo SET id_veiculo = ?, id_eixo = ?, id_pneu = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM eixo_veiculo;";

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

    public void insertEixoVeiculo(EixoVeiculo entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSERT_EIXO_VEICULO_SQL)) {
            preparedStatement.setInt(1, entidade.getIdVeiculo());
            preparedStatement.setInt(2, entidade.getIdEixo());
            preparedStatement.setInt(3, entidade.getIdPneu());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public EixoVeiculo selectEixoVeiculo(int id) {
        EixoVeiculo entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_EIXO_VEICULO_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Integer idVeiculo = rs.getInt("id_veiculo");
                Integer idEixo = rs.getInt("id_eixo");
                Integer idPneu = rs.getInt("id_pneu");
                entidade = new EixoVeiculo(id, idVeiculo, idEixo, idPneu);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<EixoVeiculo> selectAllEixoVeiculos() {
        List<EixoVeiculo> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_EIXO_VEICULO)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                Integer idVeiculo = rs.getInt("id_veiculo");
                Integer idEixo = rs.getInt("id_eixo");
                Integer idPneu = rs.getInt("id_pneu");
                entidades.add(new EixoVeiculo(id, idVeiculo, idEixo, idPneu));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteEixoVeiculo(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE_EIXO_VEICULO_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateEixoVeiculo(EixoVeiculo entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE_EIXO_VEICULO_SQL)) {
            statement.setInt(1, entidade.getIdVeiculo());
            statement.setInt(2, entidade.getIdEixo());
            statement.setInt(3, entidade.getIdPneu());
            statement.setInt(4, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
