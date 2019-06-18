package Controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Responsavel;
import Banco.Conexao;

public class ResponsavelController {
	public void create(Responsavel responsavel)
	{
		try {
			Conexao con = new Conexao();
			String query = "INSERT INTO Responsavel(nome) VALUES ('" + responsavel.getNome()+"')";
			Statement st = con.conexao.createStatement();
			st.executeUpdate(query);
			con.conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		
		}
		

	}
	public void remover(Responsavel responsavel)
	{
		
		
		try {
			Conexao con = new Conexao();
			Statement st = con.conexao.createStatement();
			String query = "DELETE FROM responsavel where id=" + responsavel.getId()+"";
			st = con.conexao.createStatement();
			st.executeUpdate(query);
			con.conexao.close();
		} catch (SQLException e) {
			System.out.println("DR");
			e.printStackTrace();
		} finally {
		
		}
		

	}
	public void editar(Responsavel responsavel)
	{
		
		
		try {
			Conexao con = new Conexao();
			Statement st = con.conexao.createStatement();
			String query = "UPDATE responsavel SET nome='"+responsavel.getNome()+"' where id=" + responsavel.getId()+"";
			st = con.conexao.createStatement();
			st.executeUpdate(query);
			con.conexao.close();
		} catch (SQLException e) {
			System.out.println("DE");
			e.printStackTrace();
		} finally {
		
		}
		

	}
	
	public List<Responsavel> listar() {
		
		List<Responsavel> l= new ArrayList<Responsavel>();
		try {
			Conexao con = new Conexao();
			String query = "SELECT * from responsavel";
			Statement st = con.conexao.createStatement();
			ResultSet r = st.executeQuery(query);
		    while (r.next())
		      {
		    	Responsavel responsavel = new Responsavel(r.getString("nome"));
		    	responsavel.setId(r.getInt("id"));
		        l.add(responsavel);
		      }	
			con.conexao.close();

		} catch (SQLException e) {
			System.out.println("DL");
			e.printStackTrace();
		} finally {
		
		}
		return l;
	}
	
}
