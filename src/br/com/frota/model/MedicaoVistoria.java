package br.com.frota.model;

import org.postgresql.core.VisibleBufferedInputStream;

public class MedicaoVistoria extends GenericModel {
    private Integer raio;
    private String perfil;
    private String largura;
    private String indiceCarga;
    private String indiceVelocidade;
    private Integer idMarcaPneu;
    private Integer idVistoriaPneu;

    public MedicaoVistoria(Integer id, Integer raio, String perfil, String largura, String indiceCarga, String indiceVelocidade, Integer idMarcaPneu, Integer idVistoriaPneu) {
        this.raio = raio;
        this.perfil = perfil;
        this.largura = largura;
        this.indiceCarga = indiceCarga;
        this.indiceVelocidade = indiceVelocidade;
        this.idMarcaPneu = idMarcaPneu;
        this.idVistoriaPneu = idVistoriaPneu;
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

    public Integer getIdVistoriaPneu() {
        return idVistoriaPneu;
    }

    public void setIdVistoriaPneu(Integer idVistoriaPneu) {
        this.idVistoriaPneu = idVistoriaPneu;
    }

    @Override
    public String toString() {
        return "MedicaoVistoria {" +
                "id='" + this.getId() + "\'" +
                "raio='" + raio + "\'" +
                "perfil='" + perfil + "\'" +
                "largura='" + largura + "\'" +
                "indice_carga='" + indiceCarga + "\'" +
                "indice_velocidade='" + indiceVelocidade + "\'" +
                "id_marca_pneu='" + idMarcaPneu + "\'" +
                "id_vistoria_pneu='" + idVistoriaPneu + "\'" +
                '}';
    }
}
