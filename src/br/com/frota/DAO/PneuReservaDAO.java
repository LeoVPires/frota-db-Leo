package br.com.frota.DAO;

import br.com.frota.model.PneuReserva;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PneuReservaDAO extends ConexaoDB {

    private static final String INSERT_PNEU_RESERVA_SQL = "INSERT INTO pneu_reserva (observacao, id_veiculo, id_pneu) VALUES (?, ?, ?);";
    private static final String SELECT_PNEU_RESERVA_BY_ID = "SELECT id, observacao, id_veiculo, id_pneu FROM pneu_reserva WHERE id = ?";
    private static final String SELECT_ALL_PNEU_RESERVA = "SELECT * FROM pneu_reserva;";
    private static final String DELETE_PNEU_RESERVA_SQL = "DELETE FROM pneu_reserva WHERE id = ?;";
    private static final String UPDATE_PNEU_RESERVA_SQL = "UPDATE pneu_reserva SET observacao = ?, id_veiculo = ?, id_pneu = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM pneu_reserva;";

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

    public void insertPneuReserva(PneuReserva entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSERT_PNEU_RESERVA_SQL)) {
            preparedStatement.setString(1, entidade.getObservacao());
            preparedStatement.setInt(2, entidade.getIdVeiculo());
            preparedStatement.setInt(3, entidade.getIdPneu());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public PneuReserva selectPneuReserva(int id) {
        PneuReserva entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_PNEU_RESERVA_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String observacao = rs.getString("observacao");
                Integer idVeiculo = rs.getInt("id_veiculo");
                Integer idPneu = rs.getInt("id_pneu");
                entidade = new PneuReserva(id, observacao, idVeiculo, idPneu);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<PneuReserva> selectAllPneuReservas() {
        List<PneuReserva> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_PNEU_RESERVA)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String observacao = rs.getString("observacao");
                Integer idVeiculo = rs.getInt("id_veiculo");
                Integer idPneu = rs.getInt("id_pneu");
                entidades.add(new PneuReserva(id, observacao, idVeiculo, idPneu));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deletePneuReserva(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE_PNEU_RESERVA_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updatePneuReserva(PneuReserva entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE_PNEU_RESERVA_SQL)) {
            statement.setString(1, entidade.getObservacao());
            statement.setInt(2, entidade.getIdVeiculo());
            statement.setInt(3, entidade.getIdPneu());
            statement.setInt(4, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
