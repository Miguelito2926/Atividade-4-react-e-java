package br.com.crud.teste;


import br.com.crud.dao.ClienteDAO;
import br.com.crud.model.Cliente;

public class ClienteTeste {

	public static void main(String[] args) {
		ClienteDAO clienteDAO = new ClienteDAO();
		
		// ------------ Cria um contato e salva no banco
		/*Cliente cadastro = new Cliente();
		cadastro.setNome("Miguelite");
		cadastro.setEmail("juniorprol@hotmail");		
		clienteDAO.save(cadastro);
		*/
		
		// ------------ Atualiza o cadastro com id = 1 com os dados do objeto contato1
	/*	Cliente cadastro1 = new Cliente();
		cadastro1.setId_Cadastro(10);
		cadastro1.setNome("Izadora");
		cadastro1.setEmail("nextbox");		
		clienteDAO.update(cadastro1);
		*/
		
		
		// ------------ Remove o cadastro com id
		 
		// clienteDAO.removeById(10);
		
		// ------------ Lista todos os contatos do banco de dados
		
		for (Cliente c : clienteDAO.getCliente()) {
			System.out.println("Nome: " + c.getNome()+", " + " Email:" +" "+c.getEmail());
		}
	}
	
}

