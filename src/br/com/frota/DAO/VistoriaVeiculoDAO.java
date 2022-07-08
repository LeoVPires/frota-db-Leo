package br.com.frota.DAO;

import br.com.frota.model.VistoriaVeiculo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VistoriaVeiculoDAO extends ConexaoDB {

    private static final String INSERT_VISTORIA_VEICULO_SQL = "INSERT INTO vistoria_veiculo (observacao, data_vistoria, id_veiculo, username) VALUES (?, ?, ?, ?);";
    private static final String SELECT_VISTORIA_VEICULO_BY_ID = "SELECT id, observacao, data_vistoria, id_veiculo, username FROM vistoria_veiculo WHERE id = ?";
    private static final String SELECT_ALL_VISTORIA_VEICULO = "SELECT * FROM vistoria_veiculo;";
    private static final String DELETE_VISTORIA_VEICULO_SQL = "DELETE FROM vistoria_veiculo WHERE id = ?;";
    private static final String UPDATE_VISTORIA_VEICULO_SQL = "UPDATE vistoria_veiculo SET observacao = ?, data_vistoria = ?, id_veiculo = ?, username = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM vistoria_veiculo;";

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

    public void insertVistoriaVeiculo(VistoriaVeiculo entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSERT_VISTORIA_VEICULO_SQL)) {
            preparedStatement.setString(1, entidade.getObservacao());
            preparedStatement.setString(2, entidade.getDataVistoria());
            preparedStatement.setInt(3, entidade.getIdVeiculo());
            preparedStatement.setString(4, entidade.getUsername());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public VistoriaVeiculo selectVistoriaVeiculo(int id) {
        VistoriaVeiculo entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_VISTORIA_VEICULO_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String observacao = rs.getString("observacao");
                String dataVistoria = rs.getString("data_vistoria");
                Integer idVeiculo = rs.getInt("id_veiculo");
                String username = rs.getString("username");
                entidade = new VistoriaVeiculo(id, observacao, dataVistoria, idVeiculo, username);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<VistoriaVeiculo> selectAllVistoriaVeiculos() {
        List<VistoriaVeiculo> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_VISTORIA_VEICULO)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String observacao = rs.getString("observacao");
                String dataVistoria = rs.getString("data_vistoria");
                Integer idVeiculo = rs.getInt("id_veiculo");
                String username = rs.getString("username");
                entidades.add(new VistoriaVeiculo(id, observacao, dataVistoria, idVeiculo, username));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteVistoriaVeiculo(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE_VISTORIA_VEICULO_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateVistoriaVeiculo(VistoriaVeiculo entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE_VISTORIA_VEICULO_SQL)) {
            statement.setString(1, entidade.getObservacao());
            statement.setString(2, entidade.getDataVistoria());
            statement.setInt(3, entidade.getIdVeiculo());
            statement.setString(4, entidade.getUsername());
            statement.setInt(5, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
