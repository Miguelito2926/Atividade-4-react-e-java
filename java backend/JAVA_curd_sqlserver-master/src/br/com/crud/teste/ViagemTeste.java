package br.com.crud.teste;

import br.com.crud.dao.ViagemDAO;

import br.com.crud.model.Viagem;

public class ViagemTeste {

	public static void main(String[] args) {
		
		ViagemDAO viagemDAO = new ViagemDAO();
		
		
		// ------------ Cria um contato e salva no banco
				/*Viagem viagem = new Viagem();
				viagem.setId_cadastro(2);
				viagem.setId_destino(2);				
				viagemDAO.save(viagem);
				*/
		
		
		// ------------ Atualiza o cadastro com id = 1 com os dados do objeto contato1
	/*Viagem viagem2 = new Viagem();
			viagem2.setId_cadastro(2);
		*/
		
		

			
		
		// ------------ Remove o cadastro com id
		 
		// viagemDAO.removeById(2);
		
		
		
		
				// ------------ Lista todos os contatos do banco de dados
				
				for (Viagem v : viagemDAO.getViagem()) {
					System.out.println("Clinte: " + v.getCliente().getNome() + ",   E-mail: "+ v.getCliente().getEmail() + "\n Destino:" +" "+ v.getDestino().getDescricao() +"  \n" + " Data da Viagem:" +" "+v.getDestino().getData() +"  \n Valor:"+ v.getDestino().getPreco()+"\n");		

	}

}
	
}
