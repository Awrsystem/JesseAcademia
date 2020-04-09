package br.ce.TipoCurso.dao;

import java.util.List;

import br.ce.TipoCurso.entity.TipoCurso;

public interface TipoCursoDaoInterface {
	
	public TipoCurso salvar(TipoCurso entity) throws Exception;

	public TipoCurso atualizar(TipoCurso entity) throws Exception;

	public List<TipoCurso> listar(TipoCurso entity);

	public TipoCurso recuperar(Long cdId);

	public boolean excluir(Long cdId);
}