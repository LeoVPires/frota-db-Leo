package br.com.frota.DAO;

import br.com.frota.model.MedicaoVistoria;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicaoVistoriaDAO extends ConexaoDB {

    private static final String INSERT_MEDICAO_VISTORIA_SQL = "INSERT INTO medicao_vistoria (raio, perfil, largura, indice_carga, indice_velocidade, id_marca_pneu, id_vistoria_pneu) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_MEDICAO_VISTORIA_BY_ID = "SELECT id, raio, perfil, largura, indice_carga, indice_velocidade, id_marca_pneu, id_vistoria_pneu FROM medicao_vistoria WHERE id = ?";
    private static final String SELECT_ALL_MEDICAO_VISTORIA = "SELECT * FROM medicao_vistoria;";
    private static final String DELETE_MEDICAO_VISTORIA_SQL = "DELETE FROM medicao_vistoria WHERE id = ?;";
    private static final String UPDATE_MEDICAO_VISTORIA_SQL = "UPDATE medicao_vistoria SET  reio = ?, perfil = ?, largura = ?, indice_carga = ?, indice_velocidade = ?, id_marca_pneu = ?, id_vistoria_pneu = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM medicao_vistoria;";

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

    public void insertMedicaoVistoria(MedicaoVistoria entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSERT_MEDICAO_VISTORIA_SQL)) {
            preparedStatement.setInt(1, entidade.getRaio());
            preparedStatement.setString(2, entidade.getPerfil());
            preparedStatement.setString(3, entidade.getLargura());
            preparedStatement.setString(4, entidade.getIndiceCarga());
            preparedStatement.setString(5, entidade.getIndiceVelocidade());
            preparedStatement.setInt(6, entidade.getIdMarcaPneu());
            preparedStatement.setInt(7, entidade.getIdVistoriaPneu());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public MedicaoVistoria selectMedicaoVistoria(int id) {
        MedicaoVistoria entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_MEDICAO_VISTORIA_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Integer raio = rs.getInt("raio");
                String perfil = rs.getString("perfil");
                String largura = rs.getString("largura");
                String indiceCarga = rs.getString("indice_carga");
                String indiceVelocidade = rs.getString("indice_velocidade");
                Integer idMarcaPneu = rs.getInt("id_marca_pneu");
                Integer idVistoriaPneu = rs.getInt("id_vistoria_pneu");
                entidade = new MedicaoVistoria(id, raio, perfil, largura, indiceCarga, indiceVelocidade, idMarcaPneu, idVistoriaPneu);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<MedicaoVistoria> selectAllMedicaoVistorias() {
        List<MedicaoVistoria> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_MEDICAO_VISTORIA)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                Integer raio = rs.getInt("raio");
                String perfil = rs.getString("perfil");
                String largura = rs.getString("largura");
                String indiceCarga = rs.getString("indice_carga");
                String indiceVelocidade = rs.getString("indice_velocidade");
                Integer idMarcaPneu = rs.getInt("id_marca_pneu");
                Integer idVistoriaPneu = rs.getInt("id_vistoria_pneu");
                entidades.add(new MedicaoVistoria(id, raio, perfil, largura, indiceCarga, indiceVelocidade, idMarcaPneu, idVistoriaPneu));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteMedicaoVistoria(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE_MEDICAO_VISTORIA_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateMedicaoVistoria(MedicaoVistoria entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE_MEDICAO_VISTORIA_SQL)) {
            statement.setInt(1, entidade.getRaio());
            statement.setString(2, entidade.getPerfil());
            statement.setString(3, entidade.getLargura());
            statement.setString(4, entidade.getIndiceCarga());
            statement.setString(5, entidade.getIndiceVelocidade());
            statement.setInt(6, entidade.getIdMarcaPneu());
            statement.setInt(7, entidade.getIdVistoriaPneu());
            statement.setInt(8, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
