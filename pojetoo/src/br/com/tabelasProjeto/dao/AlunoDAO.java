package br.com.tabelasProjeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.PreparableStatement;

import GestaoAcademica.Aluno;
import br.com.tabelaprojeto.factory.connectionFactory;

public class AlunoDAO {

	public void save(Aluno a) {
		String sql = "INSERT INTO Aluno(matricula,cpf,idade,nome,c) VALUES(?,?,?,?,?)";
	    
		Connection conn = null;
	    PreparedStatement pstm = null;
	   
	    try {
	    	//Criar uma conexão com o banco de dados
	    conn = connectionFactory.createConnectiontoMySQL();	
	    
	      //Criamos uma PreparedStatement, para executar uma query
	    pstm = (PreparedStatement) conn.prepareStatement(sql);
	    pstm.setString(1,a.getMatricula());
	    pstm.setString(2,a.getCpf());
	    pstm.setInt(3,a.getIdade());
	    pstm.setString(4, a.getNome());
	    pstm.setString(5, a.getCurso());
	    
	    //executar a query
	    pstm.execute();
	    System.err.println("Aluno salvo com sucesso!");
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

	public List<Aluno> getAlunos(){
		String sql = "SELECT * FROM Aluno";
		
		List<Aluno> aluno = new ArrayList<Aluno>();
		 Connection comn = null;
		 PreparedStatement pstm = null;
		 //classe que vai recuperar os dados do banco."""SELECT""""
		 ResultSet rset = null;
		 try {
			 comn = connectionFactory.createConnectiontoMySQL();
			
			 pstm = comn.prepareStatement(sql);
			
			 rset = pstm.executeQuery();
		     
			 while (rset.next()) {
				
				 Aluno a = new Aluno();
				 
				 //Recuperar a matricula 
				 a.setMatricula(rset.getString("matricula"));
				 //Recuperar o nome
				 a.setNome(rset.getString("nome"));
				 //Recuperar o cpf
				 a.setCpf(rset.getString("cpf"));
				 //Recuperar a idade
				 a.setIdade(rset.getInt("idade"));
				 //recuperar o curso
				 a.setCurso(rset.getString("c"));
				 
				 aluno.add(a);
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
			  
	return aluno;
	}

public void alterar(Aluno a) throws Exception{
	Connection conm = connectionFactory.createConnectiontoMySQL();	
    
	PreparedStatement pstm = null;
  try {    
	pstm =  conm.prepareStatement("UPDATE Aluno  SET nome = ?,idade = ?,c = ? WHERE matricula =?");
    
	pstm.setString(1,a.getNome());
	pstm.setInt(2,a.getIdade());
	pstm.setString(3,a.getCurso());
	pstm.setString(4,a.getMatricula());
	
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

public void deletar(Aluno a) throws Exception{
	Connection conm = connectionFactory.createConnectiontoMySQL();	
    
	PreparedStatement pstm = null;
  try {    
	pstm =  conm.prepareStatement("DELETE FROM ALUNO");
	pstm.setString(1,a.getNome() );
    

	
	pstm.executeUpdate();
	System.err.println("Usuario removido!!!");
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

