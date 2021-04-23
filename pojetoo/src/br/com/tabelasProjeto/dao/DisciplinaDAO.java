package br.com.tabelasProjeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import GestaoAcademica.Aluno;
import GestaoAcademica.Disciplina;
import br.com.tabelaprojeto.factory.connectionFactory;

public class DisciplinaDAO {
	
	
	public void save(Disciplina d) {
		String sql = "INSERT INTO Disciplina(nome,cargahoraria,id,id_professor) VALUES(?,?,?,?)";
	    
		Connection conn = null;
	    PreparedStatement pstm = null;
	   
	    try {
	    	//Criar uma conexão com o banco de dados
	    conn = connectionFactory.createConnectiontoMySQL();	
	    
	      //Criamos uma PreparedStatement, para executar uma query
	    pstm = (PreparedStatement) conn.prepareStatement(sql);
	    pstm.setString(2,d.getCargahoraria());
	    pstm.setString(1,d.getNome());
	    pstm.setString(3,d.getId());
	    pstm.setString(4,d.getId_professor());
	    
	    //executar a query
	    pstm.execute();
	    System.err.println("Disciplina salva com sucesso!");
	    }catch(Exception e) {
	    	e.printStackTrace();
	    	
	    }finally {
	    	
	    	try{
	    		//fechar as conexões
	    	if(pstm != null) {
	    		pstm.close();
	    	}
	    	if(conn != null) {
	    		conn.close();
	    	}
	    	
	    }catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
}

	public List<Disciplina> getDisciplina(){
		String sql = "SELECT * FROM Disciplina";
		
		List<Disciplina> disciplina = new ArrayList<Disciplina>();
		 Connection comn = null;
		 PreparedStatement pstm = null;
		 //classe que vai recuperar os dados do banco."""SELECT""""
		 ResultSet rset = null;
		 try {
			 comn = connectionFactory.createConnectiontoMySQL();
			
			 pstm = comn.prepareStatement(sql);
			
			 rset = pstm.executeQuery();
		     
			 while (rset.next()) {
				
				 Disciplina d = new Disciplina();
				 
				 //Recuperar a carga Horária 
				 d.setCargahoraria(rset.getString("cargahoraria"));
				 //Recuperar o nome
				 d.setNome(rset.getString("nome"));
				
				 //recuperar o id
				 d.setId(rset.getString("id"));
				 d.setId_professor(rset.getString("id_professor"));
				 disciplina.add(d);
			}
		 }catch (Exception e) {
				e.printStackTrace();
				
			}finally {
				try {
					if(rset != null) {
						rset.close();
					}
					if(pstm!=null) {
						pstm.close();
					}
					if(comn!=null) {
						comn.close();
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			  
	return disciplina;
	}
	public void alterar(Disciplina d ) throws Exception{
		Connection conm = connectionFactory.createConnectiontoMySQL();	
	    
		PreparedStatement pstm = null;
	  try {    
		pstm =  conm.prepareStatement("UPDATE Disciplina cargahoraria = ?,nome =?  WHERE id = ?");
	    
		pstm.setString(2,d.getNome());
		pstm.setString(1,d.getCargahoraria());
		pstm.setString(3,d.getId());
		pstm.executeUpdate();
	  }catch (Exception e) {
		  e.printStackTrace();
	  }finally {
			try{
	    		//fechar as conexões
	    	if(pstm != null) {
	    		pstm.close();
	    	}
	    	if(conm != null) {
	    		conm.close();
	    	}
	    	
	    }catch (Exception e) {
	    	e.printStackTrace();
	    }
	  }
	  
	}
	public void deletar(Disciplina d ) throws Exception{
		Connection conm = connectionFactory.createConnectiontoMySQL();	
	    
		PreparedStatement pstm = null;
	  try {    
		pstm =  conm.prepareStatement("DELETE FROM DISCIPLINA");
		
		pstm.executeUpdate();

		System.err.println("disciplina deletada com sucesso!!");
	  }catch (Exception e) {
		  e.printStackTrace();
	  }finally {
			try{
	    		//fechar as conexões
	    	if(pstm != null) {
	    		pstm.close();
	    	}
	    	if(conm != null) {
	    		conm.close();
	    	}
	    	
	    }catch (Exception e) {
	    	e.printStackTrace();
	    }
	  }
	  
	}
}
