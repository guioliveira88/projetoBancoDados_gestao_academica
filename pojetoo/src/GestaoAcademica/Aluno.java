package GestaoAcademica;

import java.util.ArrayList;


 

public class Aluno extends Pessoa {
	private String matricula;
	private String curso;
	private ArrayList<Disciplina> listaDeDisciplina;
    
	
    public Aluno() {
    	
    }
   
    public Aluno(String matricula,String cpf,int idade,String nome,String curso){
		super(cpf,nome,idade);
		listaDeDisciplina = new ArrayList<>();
		this.matricula = matricula;
		this.curso=curso;	    
	}
    
	public void setMatricula(String matricula) {
		this.matricula = matricula;

	}

	public String getMatricula() {
		return  matricula;
	}
	
	 public String getCurso() {
			return curso;
		}

		public void setCurso(String curso) {
			this.curso = curso;
		}

		public ArrayList<Disciplina> getListaDeDisciplina() {
			return listaDeDisciplina;
		}

		public void setListaDeDisciplina(ArrayList<Disciplina> listaDeDisciplina) {
			this.listaDeDisciplina = listaDeDisciplina;
		}
		

	public void addDisciplina(Disciplina d) {
		d.adicionarAluno(this);        
	}
	
	public void receberNota(Disciplina d,double nota) {
		if(listaDeDisciplina.contains(d)) {
			for(int i=0;i<listaDeDisciplina.size();i++) {
				if(listaDeDisciplina.get(i).getNome().equals(d.getNome())) {
					listaDeDisciplina.get(i).setNotaAluno(nota);
				}
			}
		}
	}
	
	
	@Override
	public String toString() {
		return  "matricula = " + matricula+" "+ super.toString();
	}
}

