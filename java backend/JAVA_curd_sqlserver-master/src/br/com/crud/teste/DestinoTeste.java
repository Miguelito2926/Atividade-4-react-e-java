package br.com.crud.teste;


import br.com.crud.dao.DestinoDAO;

import br.com.crud.model.Destino;

public class DestinoTeste {

	public static void main(String[] args) {
		
		
DestinoDAO destinoDAO = new DestinoDAO();
		
		// ------------ Cria um contato e salva no banco
		/*Destino destino = new Destino();
		destino.setDescricao("Rio de Janeiro - RJ");
		destino.setData("22/06/2030");		
		destino.setPreco(400.25);
		destinoDAO.save(destino);
		*/


		// ------------ Atualiza o destino com id = 1 com os dados do objeto contato1
		/*Destino destino1 = new Destino();
		destino1.setId_destino(2);
		destino1.setDescricao("Salvador - BA");
		destino1.setData("10/10/2023");	
		destino1.setPreco(600.00);
		destinoDAO.update(destino1);
		*/
		
		
		// ------------ Remove o cadastro com id
		 
		 destinoDAO.removeById(3);
		
		// ------------ Lista todos os contatos do banco de dados
		
		for (Destino c : destinoDAO.getDestino()) {
			System.out.println("Descrição: " + c.getDescricao()+", " + " Data da viagem:" +" "+c.getData()+ " Preço da Viagem:" +" "+c.getPreco());
		}
	}
	
}	



