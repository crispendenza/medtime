package br.ufscar.dc.medtime.model;


public class Medicamento {
<<<<<<< HEAD
	private int id;
	private String nome;
	private String laboratorio;
	private float valor;
	private String tipo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String toString() {
		 return ("Codigo: " + this.getId() + " Valor: " + this.getValor() + " Nome:" + this.getNome());
=======
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
>>>>>>> 8c37b46ae70314dbc59ebcac4e41f59542122670
		} 

}
