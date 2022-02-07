package br.com.crud.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import br.com.crud.factory.ConnectionFactory;
import br.com.crud.model.Destino;

public class DestinoDAO {
	
	public void save(Destino destino) {
		/*
		 * Isso � uma sql comum, os ? s�o os par�metros que n�s vamos adicionar na base
		 * de dados
		 */

		String sql = "INSERT INTO Destinos(Descricao, Data, Preco)" + "VALUES(?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Cria uma conex�o com o banco
			conn = ConnectionFactory.createConnectionSQLServer();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adicionar o valor do primeiro par�metro da sql
			pstm.setString(1, destino.getDescricao());

			// Adicionar o valor do segundo par�metro da sql
			pstm.setString(2,destino.getData());

			// Adicionar o valor do terceiro par�metro da sql
						pstm.setDouble(3,destino.getPreco());
			
			// Executar a sql para inser��o dos dados
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fecha as conex�es
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
		
	//metodo exclui destino
	
	public void removeById(int id) {
		String sql = "DELETE FROM Destinos WHERE Id_destino = ?";

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
	//metodo atualiza destino
	public void update(Destino destino) {
		String sql = "UPDATE Destinos SET descricao = ?, data = ?, preco =? WHERE Id_destino = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Cria uma conex�o com o banco
			conn = ConnectionFactory.createConnectionSQLServer();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro par�metro da sql
			pstm.setString(1, destino.getDescricao());

			// Adicionar o valor do segundo par�metro da sql
			pstm.setString(2,destino.getData());

			pstm.setDouble(3,destino.getPreco());
		
			pstm.setInt(4, destino.getId_destino());

			// Executa a sql para inser��o dos dados
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Fecha as conex�es
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

	public List<Destino> getDestino() {

		String sql = "SELECT * FROM Destinos";

		List<Destino> destino = new ArrayList<Destino>();

		Connection conn = null;
		PreparedStatement pstm = null;

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionSQLServer();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, fa�a
			while (rset.next()) {
				Destino destino1 = new Destino();

				// Recupera o id do banco e atribui ele ao objeto
				destino1.setId_destino(rset.getInt("Id_destino"));

				// Recupera o destino do banco e atribui ele ao objeto
				destino1.setDescricao(rset.getString("descricao"));

				// Recupera a email do banco e atribui ele ao objeto
				destino1.setData(rset.getString("data"));
				
				destino1.setPreco(rset.getDouble("preco"));

				
				// Adiciona o contato recuperado, a lista de contatos
				destino.add(destino1);
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
		return destino;
	}
}
