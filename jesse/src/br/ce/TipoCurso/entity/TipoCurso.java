package br.ce.TipoCurso.entity;

public class TipoCurso {
	public Long cdId;
	private String nmTipoCurso;
	private Boolean flSituacao;

	public TipoCurso() {

	}

	public Long getCdId() {
		return cdId;
	}

	public void setCdId(Long cdId) {
		this.cdId = cdId;
	}

	public String getNmTipoCurso() {
		return nmTipoCurso;
	}

	public void setNmTipoCurso(String nmTipoCurso) {
		this.nmTipoCurso = nmTipoCurso;
	}

	public Boolean getFlSituacao() {
		return flSituacao;
	}

	public void setFlSituacao(Boolean flSituacao) {
		this.flSituacao = flSituacao;
	}

	public String getFlSituacaoString() {
		return flSituacao ? "Ativo" : "Inativo";
	}
}