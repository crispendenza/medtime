package br.ufscar.dc.medtime.model;

/**
 * Created by Cristian on 23/10/2015.
 */
public class Paciente extends Usuario{
    private Convenio convenio;
    private String rg;
    private String endereco;

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
