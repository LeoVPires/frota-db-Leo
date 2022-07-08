package br.com.frota.model;

import javax.swing.text.Position;

public class PneuReserva extends GenericModel {
    private String observacao;
    private Integer idVeiculo;
    private Integer idPneu;

    public PneuReserva(String observacao) {
        this.observacao = observacao;
    }

    public PneuReserva(Integer id, String observacao, Integer idVeiculo, Integer idPneu) {
        this.observacao = observacao;
        this.idVeiculo = idVeiculo;
        this.idPneu = idPneu;
        super.setId(id);
    }

    public String getDescricao() {
        return observacao;
    }

    public void setDescricao(String observacao) {
        this.observacao = observacao;
    }
    
    public Integer getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Integer idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public Integer getIdPneu() {
        return idPneu;
    }

    public void setIdPneu(Integer idPneu) {
        this.idPneu = idPneu;
    }

    @Override
    public String toString() {
        return "PneuReserva {" +
                "id='" + this.getId() + "\'" +
                "observacao='" + observacao + "\'" +
                "id_veiculo='" + idVeiculo + "\'" +
                "id_pneu='" + idPneu + "\'" +
                '}';
    }
}
