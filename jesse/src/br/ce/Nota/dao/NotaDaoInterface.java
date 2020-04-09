package br.ce.Nota.dao;

import java.util.List;

import br.ce.Nota.entity.Nota;

public interface NotaDaoInterface {

	public Nota salvar(Nota entity) throws Exception;

	public Nota atualizar(Nota entity) throws Exception;

	public List<Nota> listar(Nota entity);

	public Nota recuperar(Long cdId);

	public boolean excluir(Long cdId);
}
