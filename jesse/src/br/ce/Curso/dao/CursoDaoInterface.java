package br.ce.Curso.dao;

import java.util.List;

import br.ce.Curso.entity.Curso;

public interface CursoDaoInterface {

	public Curso salvar(Curso entity) throws Exception;

	public Curso atualizar(Curso entity) throws Exception;

	public List<Curso> listar(Curso entity);

	public Curso recuperar(Long cdId);

	public boolean excluir(Long cdId);
}
