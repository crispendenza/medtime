package br.ufscar.dc.medtime.model;

/**
 * Created by Cristian on 23/10/2015.
 */
public class Convenio {
    private Regiao regiao;
    private PlanoDeSaude plano;

    private int cod;
    private String nome;
    private String cnpj;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }

    public PlanoDeSaude getPlano() {
        return plano;
    }

    public void setPlano(PlanoDeSaude plano) {
        this.plano = plano;
    }
}
