package GestaoAcademica;

import java.util.ArrayList;




public class Curso {
    private String nome;
	private String identificador;
	private ArrayList<Aluno> listaDeAlunos;


	public Curso() {
		
	}
	public Curso(String identificador) {
		listaDeAlunos = new ArrayList<Aluno>();
		
		this.identificador = identificador;
		
	}
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}	
	

	public ArrayList<Aluno> getListaDeAlunos() {
		
		return listaDeAlunos;
		
	}
	public void setListaDeAlunos(ArrayList<Aluno> listaDeAlunos) {
		this.listaDeAlunos = listaDeAlunos;
	}
	
	public void adicionarAluno(Aluno aluno) {
		listaDeAlunos.add(aluno);
		//System.out.println(aluno);
		}
	

	public void removerAluno(Aluno aluno) {
		
			listaDeAlunos.remove(aluno);
			//System.out.println(aluno);
	}	
    public ArrayList<Aluno> imprimirNaTela() {
    	return  listaDeAlunos ;
    }
    
		
	public String toString() {
		return this.identificador+" " ;
	}

}