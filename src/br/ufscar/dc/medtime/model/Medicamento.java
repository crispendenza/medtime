package br.ufscar.dc.medtime.model;


public class Medicamento {
	private String nomeProduto;
	private String codigoProduto;
	private float valor;

	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public Medicamento(String nomeProduto, String codigoProduto,
			float valor) {
		this.nomeProduto = nomeProduto;
		this.codigoProduto = codigoProduto;
		this.valor = valor;
	}
	
	public Medicamento(){
		
	}
	public String toString() {  
		 return ("Codigo: " + this.getCodigoProduto() + " Valor: " + this.getValor() + " Nome:" + this.getNomeProduto());  
		} 

}
