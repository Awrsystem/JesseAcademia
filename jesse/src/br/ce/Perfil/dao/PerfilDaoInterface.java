package br.ce.Perfil.dao;

import java.util.List;

import br.ce.Perfil.entity.Perfil;

public interface PerfilDaoInterface {
	
	public Perfil salvar(Perfil entity) throws Exception;

	public Perfil atualizar(Perfil entity) throws Exception;

	public List<Perfil> listar(Perfil entity);

	public Perfil recuperar(Long cdId);

	public boolean excluir(Long cdId);

}
