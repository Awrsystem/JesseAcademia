package br.ce.Usuario.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;






import br.ce.Perfil.entity.Perfil;
import br.ce.Usuario.entity.Usuario;
import br.ce.generic.GenericDaoImp;

@Repository("UsuarioDao")
@Transactional
public class UsuarioDaoImp extends GenericDaoImp implements UsuarioDaoInterface {

	
	@Override
	public Usuario salvar(Usuario entity) throws Exception {
		StringBuilder query = new StringBuilder("INSERT INTO usuario (nm_usuario, ds_senha, ds_email, fk_perfil, FL_SITUACAO) VALUES ('");
		query.append(entity.getNmUsuario()).append("', '").append(entity.getDsSenha()).append("', '").append(entity.getDsEmail()).append("', ")
		.append(entity.getFkPerfil()).append(", ").append(entity.getFlSituacao()).append(")");
		entity.setCdId(super.save(query));
		return entity;
	}
	
	

	@Override
	public Usuario atualizar(Usuario entity) throws Exception {
		if (entity.getCdId() != null) {
			StringBuilder query = new StringBuilder("UPDATE usuario SET ");
			query.append("nm_usuario = '").append(entity.getNmUsuario()).append("', ds_senha = '").append(entity.getDsSenha())
				.append("', ds_email = '").append(entity.getDsEmail()).append("', fk_perfil = ").append(entity.getFkPerfil())
				.append(", FL_SITUACAO = ").append(entity.getFlSituacao())
				.append(" WHERE CD_ID = ").append(entity.getCdId());
			super.executeCommand(query);
			
		}
		
		return entity;
	}
	public List<Usuario> listar(Usuario entity) {
		StringBuilder query = new StringBuilder("SELECT u.CD_ID, nm_usuario, ds_senha, ds_email, fk_perfil, u.FL_SITUACAO, nm_perfil FROM ");
		query.append("usuario u INNER JOIN perfil p ON (p.CD_ID = fk_perfil) WHERE 1=1 ");
		if (entity.getNmUsuario() != null && !entity.getNmUsuario().isEmpty())
			query.append(" AND nm_usuario ILIKE '%").append(entity.getNmUsuario()).append("%' ");
		if (entity.getFlSituacao() != null)
			query.append(" AND FL_SITUACAO = ").append(entity.getFlSituacao());
		
		query.append(" ORDER BY nm_usuario ASC");
		
	
		
		return transformarResultado(super.executeSqlSelect(query));
		
		
	}

	@Override
	public Usuario recuperar(Long cdId) {
		StringBuilder query = new StringBuilder("SELECT u.CD_ID, nm_usuario, ds_senha, ds_email, fk_perfil, u.FL_SITUACAO, nm_perfil FROM ");
		query.append("usuario u INNER JOIN perfil p ON p.CD_ID = u.fk_perfil WHERE u.CD_ID = ").append(cdId);
		List<Usuario> list = transformarResultado(super.executeSqlSelect(query));
		return list.size() > 0 ? list.get(0) : null;
		
							
	}

	@Override
	public boolean excluir(Long cdId) {
		try {
			super.executeCommand(new StringBuilder("DELETE FROM usuario WHERE CD_ID = ").append(cdId));
			return this.recuperar(cdId) == null;
		} catch (Exception e) {
			return false;
		}
	}

	private List<Usuario> transformarResultado(List<Map<String, Object>> listMap) {
		List<Usuario> listUsuario = new ArrayList<Usuario>();

		if (listMap != null) {
			Usuario usuario = null;
			for (Map<String, Object> map : listMap) {
				usuario = new Usuario();
				Perfil perfil = new Perfil();
				usuario.setCdId((Long) map.get("CD_ID"));
				usuario.setNmUsuario((String) map.get("nm_usuario"));
				usuario.setDsSenha((String) map.get("ds_senha"));
				usuario.setDsEmail((String) map.get("ds_email"));
				usuario.setFkPerfil((int) map.get("fk_perfil"));
				usuario.setFlSituacao((Boolean) map.get("FL_SITUACAO"));
				usuario.setPerfil(perfil);
				usuario.getPerfil().setNmPerfil((String) map.get("nm_perfil"));
				usuario.getPerfil().setDsIdentificador((String) map.get("ds_identificador"));
				listUsuario.add(usuario);
			}
			
		}

		return listUsuario;
	}


	public Usuario autenticar(Usuario entity) {
		
		StringBuilder query = new StringBuilder("SELECT u.CD_ID, nm_usuario, ds_senha, ds_email, fk_perfil, u.FL_SITUACAO, nm_perfil, ds_identificador FROM ");
		query.append("usuario u INNER JOIN perfil p ON p.CD_ID = u.fk_perfil WHERE 1=1 ")
		.append(" AND ds_email = '").append(entity.getDsEmail())
		.append("' AND ds_senha = '").append(entity.getDsSenha()).append("'");
		
		List<Usuario> list = transformarResultado(super.executeSqlSelect(query));
		return list.size() > 0 ? list.get(0) : null;

	}
}

