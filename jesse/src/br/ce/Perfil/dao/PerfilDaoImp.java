package br.ce.Perfil.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.ce.Perfil.dao.PerfilDaoInterface;
import br.ce.Perfil.entity.Perfil;
import br.ce.generic.GenericDaoImp;

@Repository("PerfilDao")
@Transactional
public class PerfilDaoImp extends GenericDaoImp implements PerfilDaoInterface{
	
	@Override
	public Perfil salvar(Perfil entity) throws Exception {
		StringBuilder query = new StringBuilder("INSERT INTO perfil (nm_perfil, ds_identificador, FL_SITUACAO) VALUES ('");
		query.append(entity.getNmPerfil()).append("', '").append(entity.getDsIdentificador()).append("', ")
		.append(entity.getFlSituacao()).append(")");
		entity.setCdId(super.save(query));
		return entity;
	}

	@Override
	public Perfil atualizar(Perfil entity) throws Exception {
		if (entity.getCdId() != null) {
			StringBuilder query = new StringBuilder("UPDATE perfil SET ");
			query.append("nm_perfil = '").append(entity.getNmPerfil()).append("', ds_identificador = '").append(entity.getDsIdentificador())
				.append("', FL_SITUACAO = ").append(entity.getFlSituacao())
				.append(" WHERE CD_ID = ").append(entity.getCdId());
			super.executeCommand(query);
		}
		
			
		return entity;
	}
	public List<Perfil> listar(Perfil entity) {
		StringBuilder query = new StringBuilder("SELECT CD_ID, nm_perfil, ds_identificador, FL_SITUACAO FROM ");
		query.append("perfil WHERE 1=1");
		if (entity.getNmPerfil() != null && !entity.getNmPerfil().isEmpty())
			query.append(" AND nm_perfil ILIKE '%").append(entity.getNmPerfil()).append("%' ");
		if (entity.getFlSituacao() != null)
			query.append(" AND FL_SITUACAO = ").append(entity.getFlSituacao());
		
		query.append(" ORDER BY nm_perfil ASC");
			
		return transformarResultado(super.executeSqlSelect(query));
		
	}

	@Override
	public Perfil recuperar(Long cdId) {
		StringBuilder query = new StringBuilder("SELECT CD_ID, nm_perfil, ds_identificador, FL_SITUACAO FROM ");
		query.append("perfil WHERE CD_ID = ").append(cdId);
		List<Perfil> list = transformarResultado(super.executeSqlSelect(query));
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public boolean excluir(Long cdId) {
		try {
			super.executeCommand(new StringBuilder("DELETE FROM perfil WHERE CD_ID = ").append(cdId));
			return this.recuperar(cdId) == null;
		} catch (Exception e) {
			return false;
		}
	}

	private List<Perfil> transformarResultado(List<Map<String, Object>> listMap) {
		List<Perfil> listPerfil = new ArrayList<Perfil>();

		if (listMap != null) {
			Perfil perfil = null;
			for (Map<String, Object> map : listMap) {
				perfil = new Perfil();
				perfil.setCdId((Long) map.get("CD_ID"));
				perfil.setNmPerfil((String) map.get("nm_perfil"));
				perfil.setDsIdentificador((String) map.get("ds_identificador"));
				perfil.setFlSituacao((Boolean) map.get("FL_SITUACAO"));
				listPerfil.add(perfil);
			}
		}

		return listPerfil;
	}

}