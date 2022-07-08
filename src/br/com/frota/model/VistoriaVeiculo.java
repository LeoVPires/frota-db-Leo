package br.com.frota.model;

import javax.swing.text.Position;

public class VistoriaVeiculo extends GenericModel {
    private String observacao;
    private String dataVistoria;
    private Integer idVeiculo;
    private String username;

    public VistoriaVeiculo(String observacao) {
        this.observacao = observacao;
    }

    public VistoriaVeiculo(Integer id, String observacao, String dataVistoria, Integer idVeiculo, String username) {
        this.observacao = observacao;
        this.dataVistoria = dataVistoria;
        this.idVeiculo = idVeiculo;
        this.username = username;
        super.setId(id);
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    public String getDataVistoria() {
        return dataVistoria;
    }

    public void setDataVistoria(String dataVistoria) {
        this.dataVistoria = dataVistoria;
    }
    
    public Integer getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Integer idVeiculo) {
        this.idVeiculo = idVeiculo;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "VistoriaVeiculo {" +
                "id='" + this.getId() + "\'" +
                "observacao='" + observacao + "\'" +
                "data_vistoria='" + dataVistoria + "\'" +
                "id_veiculo='" + idVeiculo + "\'" +
                "username='" + username + "\'" +
                '}';
    }
}
