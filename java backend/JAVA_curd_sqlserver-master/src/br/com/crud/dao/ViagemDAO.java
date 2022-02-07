package br.com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import br.com.crud.factory.ConnectionFactory;
import br.com.crud.model.Cliente;
import br.com.crud.model.Destino;
import br.com.crud.model.Viagem;


public class ViagemDAO {
	
	public void save(Viagem viagem) {
		/*
		 * Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar na base
		 * de dados
		 */

		String sql = "INSERT INTO Viagem(Id_Cadastro, Id_Destino)" + "VALUES(?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Cria uma conexão com o banco
			conn = ConnectionFactory.createConnectionSQLServer();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adicionar o valor do primeiro parámetro da sql
			pstm.setInt(1, viagem.getId_cadastro());

			// Adicionar o valor do segundo parâmetro da sql
			pstm.setInt(2, viagem.getId_destino());

			// Executar a sql para inserção dos dados
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fecha as conexões
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
		//metodo exclui cadastro
	public void removeById(int id) {
		String sql = "DELETE FROM Viagem WHERE Id_viagem = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionSQLServer();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);
						
			pstm.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	//metodo atualiza cadastro
	public void update(Viagem viagem) {
		String sql = "UPDATE Viagem SET Id_Cadastro, Id_Destino WHERE Id_viagem = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Cria uma conexão com o banco
			conn = ConnectionFactory.createConnectionSQLServer();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setInt(1, viagem.getId_cadastro());

			// Adicionar o valor do segundo parâmetro da sql
			pstm.setInt(2, viagem.getId_destino());

		
			pstm.setInt(3, viagem.getId_viagem());

			// Executa a sql para inserção dos dados
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Fecha as conexões
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<Viagem> getViagem() {

		String sql = "SELECT v.Id_Viagem,c.Id_cadastro,c.nome,c.email,d.Id_destino,d.descricao,d.data as dataviagem,d.preco  FROM Viagem as v inner join Cliente as c on v.Id_cadastro = c.Id_cadastro inner join Destinos as d on v.Id_destino = d.Id_destino";

		List<Viagem> viagem = new ArrayList<Viagem>();

		Connection conn = null;
		PreparedStatement pstm = null;

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionSQLServer();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {
				Viagem viagem1 = new Viagem();
				Cliente cliente = new Cliente();
				Destino destino = new Destino();

				// Recupera o id do banco e atribui ele ao objeto
				viagem1.setId_viagem(rset.getInt("Id_viagem"));

				// Recupera o nome do banco e atribui ele ao objeto
				viagem1.setId_cadastro(rset.getInt("Id_cadastro"));

				// Recupera a email do banco e atribui ele ao objeto
				cliente.setNome(rset.getString("nome"));
				
				cliente.setEmail(rset.getString("email"));
				viagem1.setCliente(cliente);
				
								
				destino.setId_destino(rset.getInt("Id_destino"));
				
				destino.setDescricao(rset.getString("descricao"));
				
				destino.setData(rset.getString("dataviagem"));
				
				destino.setPreco(rset.getDouble("preco"));				
				
				viagem1.setDestino(destino);
				
				// Adiciona o contato recuperado, a lista de contatos
				viagem.add(viagem1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return viagem;
	}
}
