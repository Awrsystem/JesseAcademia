package br.ce.Atividade.entity;

import br.ce.Disciplina.entity.Disciplina;

public class Atividade {

	public Long cdId;
	private String nmAtividade;
	private long fkDisciplina;
	private Disciplina disciplina;

	public Long getCdId() {
		return cdId;
	}

	public void setCdId(Long cdId) {
		this.cdId = cdId;
	}

	public String getNmAtividade() {
		return nmAtividade;
	}

	public void setNmAtividade(String nmAtividade) {
		this.nmAtividade = nmAtividade;
	}

	public long getFkDisciplina() {
		return fkDisciplina;
	}

	public void setFkDisciplina(long fkDisciplina) {
		this.fkDisciplina = fkDisciplina;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

}
