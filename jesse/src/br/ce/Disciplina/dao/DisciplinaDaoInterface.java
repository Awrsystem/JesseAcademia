package br.ce.Disciplina.dao;

import java.util.List;

import br.ce.Atividade.entity.Atividade;
import br.ce.Curso.entity.Curso;
import br.ce.Disciplina.entity.Disciplina;

public interface DisciplinaDaoInterface {
	
	public Disciplina salvar(Disciplina entity) throws Exception;

	public Disciplina atualizar(Disciplina entity) throws Exception;

	public List<Disciplina> listar(Disciplina entity) throws Exception;

	public Disciplina recuperar(Long cdId);

	public boolean excluir(Long cdId);

	public List<Disciplina> listarDisciplinaAtivo(Disciplina entity);

	br.ce.Disciplina.dao.Disciplina salvar(
			br.ce.Disciplina.dao.Disciplina entity) throws Exception;

	br.ce.Disciplina.dao.Disciplina atualizar(
			br.ce.Disciplina.dao.Disciplina entity) throws Exception;

	Disciplina recuperar1(Long cdId);

	List<br.ce.Disciplina.dao.Disciplina> listarDisciplinaAtivo(
			br.ce.Disciplina.dao.Disciplina entity);

}
