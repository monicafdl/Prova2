package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Banco.Conexao;
import Model.Responsavel;
import Model.Aluno;

public class AlunoController {
	public void create(Aluno aluno)
	{
		if(canCreate(aluno)) {
			int id = aluno.getResponsavel().getId();
			try {
				Conexao con = new Conexao();
				Statement st = con.conexao.createStatement();
				String query = "INSERT INTO aluno values('"+aluno.getCpf()+"', "
						+ "'"+aluno.getNome()+"', "+id+" )";
				st = con.conexao.createStatement();
				st.execute(query);
				ResultSet r = st.getResultSet();
				con.conexao.close();
				
			} catch (SQLException e) {
				System.out.println("PC");
				e.printStackTrace();
			} finally {
			
			}	
			
			
			
		}
		

	}
	public void remover(Aluno aluno)
	{
		
		try {
			Conexao con = new Conexao();
			Statement st = con.conexao.createStatement();
			String query = "DELETE FROM aluno WHERE cpf = '"+aluno.getCpf()+"';";
			st = con.conexao.createStatement();
			st.execute(query);
			ResultSet r = st.getResultSet();
			con.conexao.close();
		} catch (SQLException e) {
			System.out.println("PR");
			e.printStackTrace();
		} finally {
		
		}	
	
		

	}
	public void editar(Aluno aluno)
	{
		
		
		try {
			Conexao con = new Conexao();
			Statement st = con.conexao.createStatement();
			int id = aluno.getResponsavel().getId();
			String query = "UPDATE aluno set nome='"+aluno.getNome()+"', responsavel='"+id+"' where cpf="+aluno.getCpf();
			st = con.conexao.createStatement();
			st.execute(query);
			ResultSet r = st.getResultSet();
			con.conexao.close();
		} catch (SQLException e) {
			System.out.println("PE");
			e.printStackTrace();
		} finally {
		
		}	
		

	}
	
	
	public boolean canCreate(Aluno aluno) {
		
		try {
			Conexao con = new Conexao();
			Statement st = con.conexao.createStatement();
			String query = "SELECT * FROM aluno where cpf='" +aluno.getCpf() +"'";
			st = con.conexao.createStatement();
			st.executeQuery(query);
			ResultSet r = st.getResultSet();

			if(!r.next()) {
				con.conexao.close();
				return true;
			} else {
				con.conexao.close();
				return false;
			}
			
		} catch (SQLException e) {
			System.out.println("ERRO");
			e.printStackTrace();
			
		} finally {
		
		}	
		return false;
	}
	
	public Responsavel getResponsavel(int id) {
		try {
			Conexao con = new Conexao();
			String query = "SELECT * from responsavel where id="+id;
			Statement st = con.conexao.createStatement();
			ResultSet r = st.executeQuery(query);
			r.next();
			Responsavel responsavel = new Responsavel(r.getString("nome"));
			
			responsavel.setId(r.getInt("id"));
			con.conexao.close();
			return responsavel;


		} catch (SQLException e) {
			
			System.out.println("GetResponsavel");
			e.printStackTrace();
		} finally {
		
		}
		return null;
	}

	public List<Aluno> listar() {
		
		
		List<Aluno> l= new ArrayList<Aluno>();
		try {
			Conexao con = new Conexao();
			String query = "SELECT * from aluno";
			Statement st = con.conexao.createStatement();
			ResultSet r = st.executeQuery(query);
		    while (r.next())
		      {
		    	Aluno aluno = new Aluno(r.getString("cpf"), r.getString("nome"), getResponsavel(r.getInt("responsavel")));
		        l.add(aluno);
		      }	
			con.conexao.close();

		} catch (SQLException e) {
			System.out.println("PL");
			e.printStackTrace();
		} finally {
		
		}
		return l;
	}
	
	
	}
