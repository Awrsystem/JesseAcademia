package br.ce.Nota.entity;

import br.ce.Atividade.entity.Atividade;
import br.ce.Usuario.entity.Usuario;

public class Nota {

	public Long cdId;
	private Long fkAtividade;
	private Long fkAluno;
	private Double vlNota;
	private Atividade atividade;
	private Usuario usuario;

	public Long getCdId() {
		return cdId;
	}
	public void setCdId(Long cdId) {
		this.cdId = cdId;
	}
	public Long getFkAtividade() {
		return fkAtividade;
	}
	public void setFkAtividade(long fkAtividade) {
		this.fkAtividade = fkAtividade;
	}
	public Long getFkAluno() {
		return fkAluno;
	}
	public void setFkAluno(long fkAluno) {
		this.fkAluno = fkAluno;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Atividade getAtividade() {
		return atividade;
	}
	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}
	
	public Double getVlNota() {
		return vlNota;
	}
	
	public void setVlNota(double vlNota) {
		this.vlNota = vlNota;
	}
	
	
	

	
}
