package br.ufscar.dc.medtime.model;

/**
 * Created by Cristian on 23/10/2015.
 */
public class Regiao {
    private int cod;
    private String nome;
    private float latitude;
    private float longitude;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }


}
