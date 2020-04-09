package br.ce.Nota.mbean;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ce.Nota.dao.NotaDaoInterface;
import br.ce.Nota.entity.Nota;
import br.ce.Usuario.entity.Usuario;
import br.ce.generic.CustomApplicationContextAware;

@Service("NotaMB")
public class NotaMBImp implements NotaMBInterface {
	protected NotaDaoInterface getDao() {
		return (NotaDaoInterface) CustomApplicationContextAware.getBean("NotaDao");
	}

	public Nota salvar(Nota entity) throws Exception {
		return getDao().salvar(entity);
	}

	public Nota atualizar(Nota entity) throws Exception {
		return getDao().atualizar(entity);
	}

	public List<Nota> listar(Nota entity) {
		return getDao().listar(entity);
	}

	public Nota recuperar(Long cdId) {
		return getDao().recuperar(cdId);
	}

	public boolean excluir(Long cdId) {
		return getDao().excluir(cdId);
	}

	@Override
	public List<Nota> listarNotaAtivo(Nota entity) {
		// TODO Auto-generated method stub
		return getDao().listar(entity);
	}

	@Override
	public List<Usuario> listarUsuarioAtivo(Usuario entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
