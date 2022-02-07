package br.com.crud.model;

public class Viagem {
	
	private int Id_viagem;	
	// Relação entre as classes para o banco de dados
	private int Id_cadastro;
	private Cliente cliente;
	private int Id_destino;
	private Destino destino;
	
	
	
	public int getId_viagem() {
		return Id_viagem;
	}
	public void setId_viagem(int id_viagem) {
		Id_viagem = id_viagem;
	}
	public int getId_cadastro() {
		return Id_cadastro;
	}
	public void setId_cadastro(int id_cadastro) {
		Id_cadastro = id_cadastro;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public int getId_destino() {
		return Id_destino;
	}
	public void setId_destino(int id_destino) {
		Id_destino = id_destino;
	}
	public Destino getDestino() {
		return destino;
	}
	public void setDestino(Destino destino) {
		this.destino = destino;
	}
	



	
	

	
	
}
