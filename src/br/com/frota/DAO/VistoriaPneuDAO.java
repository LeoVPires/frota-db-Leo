package br.com.frota.DAO;

import br.com.frota.model.VistoriaPneu;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VistoriaPneuDAO extends ConexaoDB {

    private static final String INSERT_VISTORIA_PNEU_SQL = "INSERT INTO vistoria_pneu (observacao, data_cadastro, id_vistoria_veiculo, id_pneu) VALUES (?, ?, ?, ?);";
    private static final String SELECT_VISTORIA_PNEU_BY_ID = "SELECT id, observacao, data_cadastro, id_vistoria_veiculo, id_pneu FROM vistoria_pneu WHERE id = ?";
    private static final String SELECT_ALL_VISTORIA_PNEU = "SELECT * FROM vistoria_pneu;";
    private static final String DELETE_VISTORIA_PNEU_SQL = "DELETE FROM vistoria_pneu WHERE id = ?;";
    private static final String UPDATE_VISTORIA_PNEU_SQL = "UPDATE vistoria_pneu SET observacao = ?, data_cadastro = ?, id_vistoria_veiculo = ?, id_pneu = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM vistoria_pneu;";

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

    public void insertVistoriaPneu(VistoriaPneu entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSERT_VISTORIA_PNEU_SQL)) {
            preparedStatement.setString(1, entidade.getObservacao());
            preparedStatement.setString(2, entidade.getDataCadastro());
            preparedStatement.setInt(3, entidade.getIdVistoriaVeiculo());
            preparedStatement.setInt(4, entidade.getIdPneu());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public VistoriaPneu selectVistoriaPneu(int id) {
        VistoriaPneu entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_VISTORIA_PNEU_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String observacao = rs.getString("observacao");
                String dataCadastro = rs.getString("data_cadastro");
                Integer idVistoriaVeiculo = rs.getInt("id_vistoria_veiculo");
                String idPneu = rs.getInt("id_pneu");
                entidade = new VistoriaPneu(id, observacao, dataCadastro, idVistoriaVeiculo, idPneu);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<VistoriaPneu> selectAllVistoriaPneus() {
        List<VistoriaPneu> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_VISTORIA_PNEU)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String observacao = rs.getString("observacao");
                String dataCadastro = rs.getString("data_cadastro");
                Integer idVistoriaVeiculo = rs.getInt("id_vistoria_veiculo");
                String idPneu = rs.getInt("id_pneu");
                entidades.add(new VistoriaPneu(id, observacao, dataCadastro, idVistoriaVeiculo, idPneu));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteVistoriaPneu(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE_VISTORIA_PNEU_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateVistoriaPneu(VistoriaPneu entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE_VISTORIA_PNEU_SQL)) {
            statement.setString(1, entidade.getObservacao());
            statement.setString(2, entidade.getDataCadastro());
            statement.setInt(3, entidade.getIdVistoriaVeiculo());
            statement.setInt(4, entidade.getIdPneu());
            statement.setInt(5, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
