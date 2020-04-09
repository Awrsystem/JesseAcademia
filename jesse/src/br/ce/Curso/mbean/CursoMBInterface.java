package br.ce.Curso.mbean;

import java.util.List;

import br.ce.Curso.entity.Curso;
import br.ce.Disciplina.entity.Disciplina;

public interface CursoMBInterface {

	public Curso salvar(Curso entity) throws Exception;

	public Curso atualizar(Curso entity) throws Exception;

	public List<Curso> listar(Curso entity);

	public Curso recuperar(Long cdId);

	public boolean excluir(Long cdId);

	List<Disciplina> listarDisciplinaAtivo(Disciplina entity);
}
