package br.ce.Disciplina.entity;

public class Disciplina {
	
	
	private static String nomeDisciplina;
	private Long Curso;
	private Boolean situacao;

	public Disciplina() {

	}

	public static String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public Long getCurso() {
		return Curso;
	}

	public void setCurso(Long curso) {
		Curso = curso;
	}

	public Boolean getSituacao() {
		return situacao;
	}

	public void setSituacao(Boolean situacao) {
		this.situacao = situacao;
	}

	public static long getNmDisciplina() {
		// TODO Auto-generated method stub
		return 0;
	}
}