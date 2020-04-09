package br.ce.Usuario.mbean;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ce.Usuario.dao.UsuarioDaoInterface;
import br.ce.Usuario.entity.Usuario;
import br.ce.Usuario.mbean.UsuarioMBInterface;
import br.ce.generic.CustomApplicationContextAware;

@Service("UsuarioMB")
public class UsuarioMBImp implements UsuarioMBInterface {
	protected UsuarioDaoInterface getDao() {
		return (UsuarioDaoInterface) CustomApplicationContextAware.getBean("UsuarioDao");
	}

	public Usuario salvar(Usuario entity) throws Exception {
		return getDao().salvar(entity);
	}

	public Usuario atualizar(Usuario entity) throws Exception {
		return getDao().atualizar(entity);
	}

	public List<Usuario> listar(Usuario entity) {
		return getDao().listar(entity);
	}

	public Usuario recuperar(Long cdId) {
		return getDao().recuperar(cdId);
	}

	public boolean excluir(Long cdId) {
		return getDao().excluir(cdId);
	}

	@Override
	public Usuario autenticar(Usuario entity) {
		// TODO Auto-generated method stub
		
		return getDao().autenticar(entity);
	}

}
