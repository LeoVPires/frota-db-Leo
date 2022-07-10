package br.com.frota.model;

import javax.swing.text.Position;

public class VistoriaPneu extends GenericModel {
    private String observacao;
    private String dataCadastro;
    private Integer idVistoriaVeiculo;
    private Integer idPneu;

    public VistoriaPneu(String observacao) {
        this.observacao = observacao;
    }

    public VistoriaPneu(Integer id, String observacao, String dataCadastro, Integer idVistoriaVeiculo, Integer idPneu) {
        this.observacao = observacao;
        this.dataCadastro = dataCadastro;
        this.idVistoriaVeiculo = idVistoriaVeiculo;
        this.idPneu = idPneu;
        super.setId(id);
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    
    public Integer getIdVistoriaVeiculo() {
        return idVistoriaVeiculo;
    }

    public void setIdVistoriaVeiculo(Integer idVistoriaVeiculo) {
        this.idVistoriaVeiculo = idVistoriaVeiculo;
    }
    
    public Integer getIdPneu() {
        return idPneu;
    }

    public void setIdPneu(Integer idPneu) {
        this.idPneu = idPneu;
    }
    
    @Override
    public String toString() {
        return "VistoriaPneu {" +
                "id='" + this.getId() + "\'" +
                "observacao='" + observacao + "\'" +
                "data_cadastro='" + dataCadastro + "\'" +
                "id_vistoria_veiculo='" + idVistoriaVeiculo + "\'" +
                "id_pneu='" + idPneu + "\'" +
                '}';
    }
}
