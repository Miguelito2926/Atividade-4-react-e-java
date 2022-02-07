package br.com.crud.model;

public class Destino {
	
	private int Id_destino;
	private String descricao;
	private String data;
	private double preco;
	
	public Destino() {
		super();
	}

	public Destino(int id_destino, String descricao, String data, double preco) {
		super();
		Id_destino = id_destino;
		this.descricao = descricao;
		this.data = data;
		this.preco = preco;
	}

	public int getId_destino() {
		return Id_destino;
	}

	public void setId_destino(int id_destino) {
		Id_destino = id_destino;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	

}
