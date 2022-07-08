package br.com.frota.model;

public class Pneu extends GenericModel {
    private Integer raio;
    private String perfil;
    private String largura;
    private String indiceCarga;
    private String indiceVelocidade;
    private Integer idMarcaPneu;

    public Pneu(String descricao) {
        this.descricao = descricao;
    }

    public Pneu(Integer id, Integer raio, String perfil, String largura, String indiceCarga, String indiceVelocidade, Integer idMarcaPneu) {
        this.raio = raio;
        this.perfil = perfil;
        this.largura = largura;
        this.indiceCarga = indiceCarga;
        this.indiceVelocidade = indiceVelocidade;
        this.idMarcaPneu = idMarcaPneu;
        super.setId(id);
    }

    public Integer getRaio() {
        return raio;
    }

    public void setRaio(Integer raio) {
        this.raio = raio;
    }
    
    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getLargura() {
        return largura;
    }

    public void setLargura(String largura) {
        this.largura = largura;
    }
    
    public String getIndiceCarga() {
        return indiceCarga;
    }

    public void setIndiceCarga(Integer indiceCarga) {
        this.indiceCarga = indiceCarga;
    }

    public String getIndiceVelocidade() {
        return indiceVelocidade;
    }

    public void setIndiceVelocidade(Integer indiceVelocidade) {
        this.indiceVelocidade = indiceVelocidade;
    }
    
    public Integer getIdMarcaPneu() {
        return idMarcaPneu;
    }

    public void setIdMarcaPneu(Integer idMarcaPneu) {
        this.idMarcaPneu = idMarcaPneu;
    }

    @Override
    public String toString() {
        return "Pneu {" +
                "id='" + this.getId() + "\'" +
                "raio='" + raio + "\'" +
                "perfil='" + perfil + "\'" +
                "largura='" + largura + "\'" +
                "indice_carga='" + indiceCarga + "\'" +
                "indice_velocidade='" + indiceVelocidade + "\'" +
                "id_marca_pneu='" + idMarcaPneu + "\'" +
                '}';
    }
}
