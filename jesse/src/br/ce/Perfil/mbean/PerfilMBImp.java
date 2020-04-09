package br.ce.Perfil.mbean;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ce.Perfil.dao.PerfilDaoInterface;
import br.ce.Perfil.entity.Perfil;
import br.ce.Perfil.mbean.PerfilMBInterface;
import br.ce.generic.CustomApplicationContextAware;

@Service("PerfilMB")
public class PerfilMBImp implements PerfilMBInterface {
	protected PerfilDaoInterface getDao() {
		return (PerfilDaoInterface) CustomApplicationContextAware.getBean("PerfilDao");
	}

	public Perfil salvar(Perfil entity) throws Exception {
		return getDao().salvar(entity);
	}

	public Perfil atualizar(Perfil entity) throws Exception {
		return getDao().atualizar(entity);
	}

	public List<Perfil> listar(Perfil entity) {
		return getDao().listar(entity);
	}

	public Perfil recuperar(Long cdId) {
		return getDao().recuperar(cdId);
	}

	public boolean excluir(Long cdId) {
		return getDao().excluir(cdId);
	}

	@Override
	public List<Perfil> listaPerfilAtivo(Perfil entity) {
		// TODO Auto-generated method stub
		entity.setFlSituacao(true);
		return getDao().listar(entity);
		
	}

}
