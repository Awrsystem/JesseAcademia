package br.ce.Curso.mbean;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ce.Curso.dao.CursoDaoInterface;
import br.ce.Curso.entity.Curso;
import br.ce.generic.CustomApplicationContextAware;

@Service("CursoMB")
public class CursoMBImp implements CursoMBInterface {
	protected CursoDaoInterface getDao() {
		return (CursoDaoInterface) CustomApplicationContextAware.getBean("CursoDao");
	}

	public Curso salvar(Curso entity) throws Exception {
		return getDao().salvar(entity);
	}

	public Curso atualizar(Curso entity) throws Exception {
		return getDao().atualizar(entity);
	}

	public List<Curso> listar(Curso entity) {
		return getDao().listar(entity);
	}

	public Curso recuperar(Long cdId) {
		return getDao().recuperar(cdId);
	}

	public boolean excluir(Long cdId) {
		return getDao().excluir(cdId);
	}

}
