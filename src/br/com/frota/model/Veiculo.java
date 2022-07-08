package br.com.frota.model;

public class Veiculo extends GenericModel {
    private String descricao;
    private Integer idMarca;

    public Veiculo(String descricao) {
        this.descricao = descricao;
    }

    public Veiculo(Integer id, String descricao, Integer idMarca) {
        this.descricao = descricao;
        this.idMarca = idMarca;
        super.setId(id);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public Integer getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    @Override
    public String toString() {
        return "Veiculo {" +
                "id='" + this.getId() + "\'" +
                "descricao='" + descricao + "\'" +
                "id_marca='" + idMarca + "\'" +
                '}';
    }
}
