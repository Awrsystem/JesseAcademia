package br.ce.Perfil.mbean;

import java.util.List;

import br.ce.Perfil.entity.Perfil;

public interface PerfilMBInterface {
	
	public Perfil salvar(Perfil entity) throws Exception;

	public Perfil atualizar(Perfil entity) throws Exception;

	public List<Perfil> listar(Perfil entity);

	public Perfil recuperar(Long cdId);

	public boolean excluir(Long cdId);

	public List<Perfil> listaPerfilAtivo (Perfil entity);

}
