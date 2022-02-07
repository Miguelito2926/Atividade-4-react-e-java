package br.com.crud.model;



public class Cliente {
	
	private int Id_cadastro;
	private String nome;
	private String email;
	
	
	public Cliente() {
		super();
	}


	public Cliente(int id_Cadastro, String nome, String email) {
		super();
		Id_cadastro = id_Cadastro;
		this.nome = nome;
		this.email = email;
	}


	public int getId_Cadastro() {
		return Id_cadastro;
	}


	public void setId_Cadastro(int id_Cadastro) {
		Id_cadastro = id_Cadastro;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
