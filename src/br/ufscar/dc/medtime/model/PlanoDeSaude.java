package br.ufscar.dc.medtime.model;

/**
 * Created by Cristian on 23/10/2015.
 */
public class PlanoDeSaude {
    private int cod;
    private String tipo;
    private String carencia;
    private String tipo_quarto;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCarencia() {
        return carencia;
    }

    public void setCarencia(String carencia) {
        this.carencia = carencia;
    }

    public String getTipo_quarto() {
        return tipo_quarto;
    }

    public void setTipo_quarto(String tipo_quarto) {
        this.tipo_quarto = tipo_quarto;
    }
}
