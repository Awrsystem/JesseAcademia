package br.ce.TipoCurso.mbean;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ce.TipoCurso.dao.TipoCursoDaoInterface;
import br.ce.TipoCurso.entity.TipoCurso;
import br.ce.generic.CustomApplicationContextAware;

@Service("TipoCursoMB")
public class TipoCursoMBImp implements TipoCursoMBInterface {
	protected TipoCursoDaoInterface getDao() {
		return (TipoCursoDaoInterface) CustomApplicationContextAware.getBean("TipoCursoDao");
	}

	public TipoCurso salvar(TipoCurso entity) throws Exception {
		return getDao().salvar(entity);
	}

	public TipoCurso atualizar(TipoCurso entity) throws Exception {
		return getDao().atualizar(entity);
	}

	public List<TipoCurso> listar(TipoCurso entity) {
		return getDao().listar(entity);
	}

	public TipoCurso recuperar(Long cdId) {
		return getDao().recuperar(cdId);
	}

	public boolean excluir(Long cdId) {
		return getDao().excluir(cdId);
	}

	@Override
	public List<TipoCurso> listarTipoCursoAtivo(TipoCurso entity) {
		// TODO Auto-generated method stub
		entity.setFlSituacao(true);
		return getDao().listar(entity);
	}
}