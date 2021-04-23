package GestaoAcademica;


import java.util.ArrayList;

public class Professor extends Pessoa {

	private String identificador;
	private String curso;
	private ArrayList<Disciplina> listaDisciplinaProfessor;
	

	
	public Professor() {

	}
	public Professor(String cpf,int idade,String nome,String indentificador) {
		super(cpf,nome,idade); 
		this.identificador = indentificador;
		listaDisciplinaProfessor = new ArrayList<>();
		
	}
	
	public Professor(String cpf,int idade,String nome,String indentificador,String curso) {
		super(cpf,nome,idade); 
		this.identificador = indentificador;
		this.curso = curso;
		listaDisciplinaProfessor = new ArrayList<>();
		
	}
	
	
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public ArrayList<Disciplina> getListaDisciplinaProfessor() {
		return listaDisciplinaProfessor;
	}
	public void setListaDisciplinaProfessor(ArrayList<Disciplina> listaDisciplinaProfessor) {
		this.listaDisciplinaProfessor = listaDisciplinaProfessor;
	}
	public void pegarCurso(Disciplina curso) {
		listaDisciplinaProfessor.add(curso);
	}
	
	public void atribuirNota(Disciplina d, Aluno a , double nota){
		a.receberNota(d, nota);
	}
	
	public void addFalta(Aluno a,int falta,Disciplina d) {
		for (int i = 0; i < a.getListaDeDisciplina().size(); i++) {
			if(a.getListaDeDisciplina().get(i).getNome().equals(d.getNome())) {
				a.getListaDeDisciplina().get(i).setFalta(a.getListaDeDisciplina().get(i).getFalta()+falta);
			}
		}
	}
	
}	
