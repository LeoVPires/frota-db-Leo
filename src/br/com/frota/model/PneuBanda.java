package br.com.frota.model;

import javax.swing.text.Position;

public class PneuBanda extends GenericModel {
    private String observacao;
    private Integer idPneu;
    private Integer ordem;
    private Integer idBanda;

    public PneuBanda(String observacao) {
        this.observacao = observacao;
    }

    public PneuBanda(Integer id, String observacao, Integer idPneu, Integer ordem, Integer idBanda) {
        this.observacao = observacao;
        this.idPneu = idPneu;
        this.ordem = ordem;
        this.idBanda = idBanda;
        super.setId(id);
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    public String getIdPneu() {
        return idPneu;
    }

    public void setIdPneu(String idPneu) {
        this.idPneu = idPneu;
    }
    
    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }
    
    public Integer getIdBanda() {
        return idBanda;
    }

    public void setIdBanda(Integer idBanda) {
        this.idBanda = idBanda;
    }
    
    @Override
    public String toString() {
        return "PneuBanda {" +
                "id='" + this.getId() + "\'" +
                "observacao='" + observacao + "\'" +
                "id_pneu='" + idPneu + "\'" +
                "ordem='" + ordem + "\'" +
                "id_banda='" + idBanda + "\'" +
                '}';
    }
}
