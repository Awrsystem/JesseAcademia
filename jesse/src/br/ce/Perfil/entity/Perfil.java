package br.ce.Perfil.entity;

public class Perfil {
	
	public Long cdId;
	private String nmPerfil;
	private String dsIdentificador;
	private Boolean flSituacao;

	public Perfil() {

	}

	public Long getCdId() {
		return cdId;
	}

	public void setCdId(Long cdId) {
		this.cdId = cdId;
	}

	public String getNmPerfil() {
		return nmPerfil;
	}

	public void setNmPerfil(String nmPerfil) {
		this.nmPerfil = nmPerfil;
	}

	public String getDsIdentificador() {
		return dsIdentificador;
	}

	public void setDsIdentificador(String dsIdentificador) {
		this.dsIdentificador = dsIdentificador;
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