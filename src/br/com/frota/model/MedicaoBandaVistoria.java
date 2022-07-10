package br.com.frota.model;

import javax.swing.text.Position;

public class MedicaoBandaVistoria extends GenericModel {
    private float valor;
    private Integer idPneuBanda;
    private Integer idMedicaoVistoria;

    public MedicaoBandaVistoria(Integer id, float valor, Integer idPneuBanda, Integer idMedicaoVistoria) {
        this.valor = valor;
        this.idPneuBanda = idPneuBanda;
        this.idMedicaoVistoria = idMedicaoVistoria;
        super.setId(id);
    }

    public Integer getIdPneuBanda() {
        return idPneuBanda;
    }

    public void setIdPneuBanda(Integer idPneuBanda) {
        this.idPneuBanda = idPneuBanda;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Integer getIdMedicaoVistoria() {
        return idMedicaoVistoria;
    }

    public void setIdMedicaoVistoria(Integer idMedicaoVistoria) {
        this.idMedicaoVistoria = idMedicaoVistoria;
    }

    @Override
    public String toString() {
        return "MedicaoBandaVistoria {" +
                "id='" + this.getId() + "\'" +
                "valor='" + valor + "\'" +
                "id_pneu_banda='" + idPneuBanda + "\'" +
                "id_medicao_vistoria='" + idMedicaoVistoria + "\'" +
                '}';
    }
}
