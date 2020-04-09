package br.ce.Usuario.entity;

import br.ce.Perfil.entity.Perfil;

public class Usuario {
	
	public Long cdId;
	private String nmUsuario;
	private String dsSenha;
	private String dsEmail;
	private int fkPerfil;
	private Boolean flSituacao;
	private Perfil perfil;

	public Usuario() {

	}

	public Long getCdId() {
		return cdId;
	}

	public void setCdId(Long cdId) {
		this.cdId = cdId;
	}

	public String getNmUsuario() {
		return nmUsuario;
	}

	public void setNmUsuario(String nmUsuario) {
		this.nmUsuario = nmUsuario;
	}

	public String getDsSenha() {
		return dsSenha;
	}

	public void setDsSenha(String dsSenha) {
		this.dsSenha = dsSenha;
	}

	public String getDsEmail() {
		return dsEmail;
	}

	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
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

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public int getFkPerfil() {
		return fkPerfil;
	}

	public void setFkPerfil(int fkPerfil) {
		this.fkPerfil = fkPerfil;
	}

}
