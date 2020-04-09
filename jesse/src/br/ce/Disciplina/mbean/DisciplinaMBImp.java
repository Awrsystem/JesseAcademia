package br.ce.Disciplina.mbean;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ce.Atividade.entity.Atividade;
import br.ce.Curso.dao.CursoDaoInterface;
import br.ce.Curso.entity.Curso;
import br.ce.generic.CustomApplicationContextAware;
import br.ce.Curso.mbean.CursoMBInterface;
import br.ce.Disciplina.entity.Disciplina;

@Service("DisciplinaMB")
public class DisciplinaMBImp implements CursoMBInterface {
	
	protected DisciplinaDaoInterface getDao() {
		return (DisciplinaDaoInterface) CustomApplicationContextAware.getBean("DisciplinaDao");
	}

	public Disciplina salvar(Disciplina entity) throws Exception {
		return getDao().salvar(entity);
	}

	public Disciplina atualizar(Disciplina entity) throws Exception {
		return getDao().atualizar(entity);
	}

	public List<Disciplina> listar(Disciplina entity) {
		return getDao().listar(entity);
	}

	public Disciplina recuperar1(Long cdId) {
		return getDao().recuperar(cdId);
	}

	public boolean excluir(Long cdId) {
		return getDao().excluir(cdId);
	}

	@Override
	public List<Disciplina> listarDisciplinaAtivo(Disciplina entity) {
		return getDao().listar(entity);
	}

	@Override
	public Curso salvar(Curso entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Curso atualizar(Curso entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Curso> listar(Curso entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Curso recuperar(Long cdId) {
		// TODO Auto-generated method stub
		return null;
	}



}