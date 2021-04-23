package GestaoAcademica;

import java.util.ArrayList;



public class Disciplina {
	
	private String nome;
	private String cargahoraria;
	private String id;
	private int falta;
	private double notaAluno;
	private ArrayList<Aluno> listaDeAlunos;
	private String id_professor;
	public Disciplina() {
		
	}
	public Disciplina(String nome, String cargahoraria,String id) {
		// TODO Auto-generated constructor stub
		this.nome=nome;
		this.cargahoraria = cargahoraria;
		this.id = id;
		listaDeAlunos = new ArrayList<>();
	}

	public Disciplina(String nome, String cargahoraria,String id,String id_professor) {
		// TODO Auto-generated constructor stub
		this.nome=nome;
		this.cargahoraria = cargahoraria;
		this.id = id;
		this.id_professor = id_professor ;
		listaDeAlunos = new ArrayList<>();
	}
	public Disciplina(String cargahoraria) {
		this.cargahoraria = cargahoraria;
	}
	
	
	
	public ArrayList<Aluno> getListaDeAlunos() {
		return listaDeAlunos;
	}
	
	public void adicionarAluno(Aluno aluno) {
		listaDeAlunos.add(aluno);
        aluno.getListaDeDisciplina().add(this);
		//System.out.println(aluno);
		}
	

	public void setListaDeAlunos(ArrayList<Aluno> listaDeAlunos) {
		this.listaDeAlunos = listaDeAlunos;
	}

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargahoraria() {
		return cargahoraria;
	}

	public void setCargahoraria(String cargahoraria) {
		this.cargahoraria = cargahoraria;
	}

	public double getNotaAluno() {
		return notaAluno;
	}

	public void setNotaAluno(double notaAluno) {
		this.notaAluno = notaAluno;
	}

	public int getFalta() {
		return falta;
	}

	public void setFalta(int falta) {
		this.falta = falta;
	}
	public String getId_professor() {
		return id_professor;
	}
	public void setId_professor(String id_professor) {
		this.id_professor = id_professor;
	}
	
	
}