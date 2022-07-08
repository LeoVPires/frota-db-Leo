package br.com.frota.model;

import javax.swing.text.Position;

public class EixoVeiculo extends GenericModel {
    private Integer idEixo;
    private Integer idVeiculo;
    private Integer idPneu;

    public EixoVeiculo(Integer id, Integer idVeiculo, Integer idEixo, Integer idPneu) {
        this.idEixo = idEixo;
        this.idVeiculo = idVeiculo;
        this.idPneu = idPneu;
        super.setId(id);
    }

    public Integer getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Integer idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public Integer getIdEixo() {
        return idEixo;
    }

    public void setIdEixo(Integer idEixo) {
        this.idEixo = idEixo;
    }

    public Integer getIdPneu() {
        return idPneu;
    }

    public void setIdPneu(Integer idPneu) {
        this.idPneu = idPneu;
    }

    @Override
    public String toString() {
        return "EixoVeiculo {" +
                "id='" + this.getId() + "\'" +
                "id_veiculo='" + idVeiculo + "\'" +
                "id_eixo='" + idEixo + "\'" +
                "id_pneu='" + idPneu + "\'" +
                '}';
    }
}
