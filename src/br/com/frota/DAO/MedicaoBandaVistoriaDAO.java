package br.com.frota.DAO;

import br.com.frota.model.MedicaoBandaVistoria;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicaoBandaVistoriaDAO extends ConexaoDB {

    private static final String INSERT_MEDICAO_BANDA_VISTORIA_SQL = "INSERT INTO medicao_banda_vistoria (valor, id_pneu_banda, id_medicao_vistoria) VALUES (?, ?, ?);";
    private static final String SELECT_MEDICAO_BANDA_VISTORIA_BY_ID = "SELECT id, valor, id_pneu_banda, id_medicao_vistoria FROM medicao_banda_vistoria WHERE id = ?";
    private static final String SELECT_ALL_MEDICAO_BANDA_VISTORIA = "SELECT * FROM medicao_banda_vistoria;";
    private static final String DELETE_MEDICAO_BANDA_VISTORIA_SQL = "DELETE FROM medicao_banda_vistoria WHERE id = ?;";
    private static final String UPDATE_MEDICAO_BANDA_VISTORIA_SQL = "UPDATE medicao_banda_vistoria SET valor = ?, id_pneu_banda = ?, id_medicao_vistoria = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM medicao_banda_vistoria;";

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

    public void insertMedicaoBandaVistoria(MedicaoBandaVistoria entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSERT_MEDICAO_BANDA_VISTORIA_SQL)) {
            preparedStatement.setFloat(1, entidade.getValor());
            preparedStatement.setInt(2, entidade.getIdPneuBanda());
            preparedStatement.setInt(3, entidade.getIdMedicaoVistoria());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public MedicaoBandaVistoria selectMedicaoBandaVistoria(int id) {
        MedicaoBandaVistoria entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_MEDICAO_BANDA_VISTORIA_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                float valor = rs.getFloat("valor");
                Integer idPneuBanda = rs.getInt("id_pneu_banda");
                Integer idMedicaoVistoria = rs.getInt("id_medicao_vistoria");
                entidade = new MedicaoBandaVistoria(id, valor, idPneuBanda, idMedicaoVistoria);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<MedicaoBandaVistoria> selectAllMedicaoBandaVistorias() {
        List<MedicaoBandaVistoria> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_MEDICAO_BANDA_VISTORIA)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getFloat("id");
                Integer valor = rs.getInt("valor");
                Integer idPneuBanda = rs.getInt("id_pneu_banda");
                Integer idMedicaoVistoria = rs.getInt("id_medicao_vistoria");
                entidades.add(new MedicaoBandaVistoria(id, valor, idPneuBanda, idMedicaoVistoria));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteMedicaoBandaVistoria(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE_MEDICAO_BANDA_VISTORIA_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateMedicaoBandaVistoria(MedicaoBandaVistoria entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE_MEDICAO_BANDA_VISTORIA_SQL)) {
            statement.setFloat(1, entidade.getValor());
            statement.setInt(2, entidade.getIdPneuBanda());
            statement.setInt(3, entidade.getIdMedicaoVistoria());
            statement.setInt(4, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
