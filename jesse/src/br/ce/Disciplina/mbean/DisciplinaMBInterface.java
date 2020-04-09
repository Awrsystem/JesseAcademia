package br.ce.Disciplina.mbean;
import java.util.List;

import br.ce.Curso.entity.Curso;
import br.ce.Disciplina.entity.Disciplina;

public interface DisciplinaMBInterface {
	
	public Disciplina salvar(Disciplina entity) throws Exception;

	public Disciplina atualizar(Disciplina entity) throws Exception;

	public String listar(Disciplina entity) throws Exception;

	public Disciplina recuperar(Long long1) throws Exception;

	public boolean excluir(Long long1) throws Exception;
}