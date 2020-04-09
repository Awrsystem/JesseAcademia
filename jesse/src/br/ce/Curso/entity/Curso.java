package br.ce.Curso.entity;

import br.ce.TipoCurso.entity.TipoCurso;

public class Curso {
	public Long cdId;
	private String nmCurso;
	private long fkTipoCurso;
	private double vlMensalCurso;
	private int nrDuracao;
	private TipoCurso tipoCurso;

	public Long getCdId() {
		return cdId;
	}
	public void setCdId(Long cdId) {
		this.cdId = cdId;
	}
	public String getNmCurso() {
		return nmCurso;
	}
	public void setNmCurso(String nmCurso) {
		this.nmCurso = nmCurso;
	}
	public long getFkTipoCurso() {
		return fkTipoCurso;
	}
	public void setFkTipoCurso(long fkTipoCurso) {
		this.fkTipoCurso = fkTipoCurso;
	}
	public double getVlMensalCurso() {
		return vlMensalCurso;
	}
	public void setVlMensalCurso(double vlMensalCurso) {
		this.vlMensalCurso = vlMensalCurso;
	}
	public int getNrDuracao() {
		return nrDuracao;
	}
	public void setNrDuracao(int nrDuracao) {
		this.nrDuracao = nrDuracao;
	}
	public Boolean getFlSituacao() {
		return flSituacao;
	}
	public void setFlSituacao(Boolean flSituacao) {
		this.flSituacao = flSituacao;
	}
	private Boolean flSituacao;
	
	public String getFlSituacaoString() {
		return flSituacao ? "Ativo" : "Inativo";
	}
	public TipoCurso getTipoCurso() {
		return tipoCurso;
	}
	public void setTipoCurso(TipoCurso tipoCurso) {
		this.tipoCurso = tipoCurso;
	}
	
}
