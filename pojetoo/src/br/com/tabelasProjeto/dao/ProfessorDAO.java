package br.com.tabelasProjeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import GestaoAcademica.Aluno;
import GestaoAcademica.Professor;
import br.com.tabelaprojeto.factory.connectionFactory;

public class ProfessorDAO {

	public void save(Professor p) {
		String sql = "INSERT INTO Professor(cpf,idade,nome,identificador,curso) VALUES(?,?,?,?,?)";
	    
		Connection conn = null;
	    PreparedStatement pstm = null;
	   
	    try {
	    	//Criar uma conexão com o banco de dados
	    conn = connectionFactory.createConnectiontoMySQL();	
	    
	      //Criamos uma PreparedStatement, para executar uma query
	    pstm = (PreparedStatement) conn.prepareStatement(sql);
	    pstm.setString(4,p.getIdentificador());
	    pstm.setString(1,p.getCpf());
	    pstm.setInt(2,p.getIdade());
	    pstm.setString(3,p.getNome());
	    pstm.setString(5,p.getCurso());
	    
	    //executar a query
	    pstm.execute();
	    System.err.println("Professor salvo com sucesso!");
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

	public List<Professor> getProfessores(){
String sql = "SELECT * FROM Professor";
		
		List<Professor> professor = new ArrayList<Professor>();
		 Connection comn = null;
		 PreparedStatement pstm = null;
		 //classe que vai recuperar os dados do banco."""SELECT""""
		 ResultSet rset = null;
		 try {
			 comn = connectionFactory.createConnectiontoMySQL();
			
			 pstm = comn.prepareStatement(sql);
			
			 rset = pstm.executeQuery();
		     
			 while (rset.next()) {
				
				 Professor p = new Professor();
				 
				 //Recuperar a Indentificador
				 p.setIdentificador(rset.getString("Identificador"));
				 //Recuperar o nome
				 p.setNome(rset.getString("nome"));
				 //Recuperar o cpf
				 p.setCpf(rset.getString("cpf"));
				 //Recuperar a idade
				 p.setIdade(rset.getInt("idade"));
				 //recuperar o curso
				 p.setCurso(rset.getString("curso"));
				 
				 professor.add(p);
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
			  
	return professor;
	}
	public void alterar(Professor p) throws Exception{

	Connection conm = connectionFactory.createConnectiontoMySQL();	
    
	PreparedStatement pstm = null;
  try {    
	pstm =  conm.prepareStatement("UPDATE Professor  SET nome = ?,idade = ?,cpf =? WHERE identificador =?");
    
	pstm.setString(1,p.getNome());
	pstm.setInt(2,p.getIdade());
	pstm.setString(3,p.getCpf());
	pstm.setString(4,p.getIdentificador());
	
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
	public void deletar(Professor p) throws Exception{

		Connection conm = connectionFactory.createConnectiontoMySQL();	
	    
		PreparedStatement pstm = null;
	  try {    
		pstm =  conm.prepareStatement("DELETE FROM Professor");
	    
		
		System.err.println("Professor deletado com sucesso!");
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

}

