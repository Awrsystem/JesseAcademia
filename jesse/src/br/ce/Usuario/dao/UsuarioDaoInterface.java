package br.ce.Usuario.dao;

import java.util.List;

import br.ce.Usuario.entity.Usuario;

public interface UsuarioDaoInterface {
	
	public Usuario salvar(Usuario entity) throws Exception;

	public Usuario atualizar(Usuario entity) throws Exception;

	public List<Usuario> listar(Usuario entity);

	public Usuario recuperar(Long cdId);

	public boolean excluir(Long cdId);

	public Usuario autenticar(Usuario entity);

}
