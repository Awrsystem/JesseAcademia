package br.ce.TipoCurso.mbean;

import java.util.List;

import br.ce.TipoCurso.entity.TipoCurso;

public interface TipoCursoMBInterface {
	
	public TipoCurso salvar(TipoCurso entity) throws Exception;

	public TipoCurso atualizar(TipoCurso entity) throws Exception;

	public List<TipoCurso> listar(TipoCurso entity);

	public TipoCurso recuperar(Long cdId);

	public boolean excluir(Long cdId);
	
	public List<TipoCurso> listarTipoCursoAtivo (TipoCurso entity);
}