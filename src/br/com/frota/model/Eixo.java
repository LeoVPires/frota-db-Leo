package br.com.frota.model;

import javax.swing.text.Position;

public class Eixo extends GenericModel {
    private String descricao;
    private Integer posicao;
    private Integer idTipoEixo;

    public Eixo(String descricao) {
        this.descricao = descricao;
    }

    public Eixo(Integer id, String descricao, Integer posicao, Integer idTipoEixo) {
        this.descricao = descricao;
        this.posicao = posicao;
        this.idTipoEixo = idTipoEixo;
        super.setId(id);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public Integer getPosicao() {
        return posicao;
    }

    public void setPosicao(Integer posicao) {
        this.posicao = posicao;
    }

    public Integer getIdTipoEixo() {
        return idTipoEixo;
    }

    public void setIdTipoEixo(Integer idTipoEixo) {
        this.idTipoEixo = idTipoEixo;
    }

    @Override
    public String toString() {
        return "Eixo {" +
                "id='" + this.getId() + "\'" +
                "descricao='" + descricao + "\'" +
                "posicao='" + posicao + "\'" +
                "id_tipo_eixo='" + idTipoEixo + "\'" +
                '}';
    }
}
