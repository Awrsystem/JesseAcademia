package br.ce.Atividade.mbean;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ce.Atividade.dao.AtividadeDaoInterface;
import br.ce.Atividade.entity.Atividade;
import br.ce.generic.CustomApplicationContextAware;

@Service("AtividadeMB")
public class AtividadeMBImp implements AtividadeMBInterface {
	protected AtividadeDaoInterface getDao() {
		return (AtividadeDaoInterface) CustomApplicationContextAware.getBean("AtividadeDao");
	}

	public Atividade salvar(Atividade entity) throws Exception {
		return getDao().salvar(entity);
	}

	public Atividade atualizar(Atividade entity) throws Exception {
		return getDao().atualizar(entity);
	}

	public List<Atividade> listar(Atividade entity) {
		return getDao().listar(entity);
	}

	public Atividade recuperar(Long cdId) {
		return getDao().recuperar(cdId);
	}

	public boolean excluir(Long cdId) {
		return getDao().excluir(cdId);
	}

	@Override
	public List<Atividade> listarAtividadeAtivo(Atividade entity) {
		return getDao().listar(entity);
	}



}