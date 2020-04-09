package br.ce.TipoCurso.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.ce.TipoCurso.entity.TipoCurso;
import br.ce.generic.GenericDaoImp;

@Repository("TipoCursoDao")
@Transactional
public class TipoCursoDaoImp extends GenericDaoImp implements TipoCursoDaoInterface {

	@Override
	public TipoCurso salvar(TipoCurso entity) throws Exception {
		StringBuilder query = new StringBuilder("INSERT INTO tipocurso (nm_tipocurso, FL_SITUACAO) VALUES ('");
		query.append(entity.getNmTipoCurso()).append("', ").append(entity.getFlSituacao()).append(")");
		entity.setCdId(super.save(query));
		return entity;
	}

	@Override
	public TipoCurso atualizar(TipoCurso entity) throws Exception {
		if (entity.getCdId() != null) {
			StringBuilder query = new StringBuilder("UPDATE tipocurso SET ");
			query.append("nm_tipocurso = \'").append(entity.getNmTipoCurso()).append("\', FL_SITUACAO = ")
					.append(entity.getFlSituacao()).append(" WHERE CD_ID = ").append(entity.getCdId());
			super.executeCommand(query);
		}
		return entity;
	}

	public List<TipoCurso> listar(TipoCurso entity) {
		StringBuilder query = new StringBuilder("SELECT CD_ID, nm_tipocurso, FL_SITUACAO FROM ");
		query.append("tipocurso WHERE 1=1");
		if (entity.getNmTipoCurso() != null && !entity.getNmTipoCurso().isEmpty())
			query.append(" AND nm_tipocurso ILIKE '%").append(entity.getNmTipoCurso()).append("%' ");
		if (entity.getFlSituacao() != null)
			query.append(" AND FL_SITUACAO = ").append(entity.getFlSituacao());
		
		query.append(" ORDER BY nm_tipocurso ASC");
			
		return transformarResultado(super.executeSqlSelect(query));
	}

	@Override
	public TipoCurso recuperar(Long cdId) {
		StringBuilder query = new StringBuilder("SELECT CD_ID, nm_tipocurso, FL_SITUACAO FROM ");
		query.append("tipocurso WHERE CD_ID = ").append(cdId);
		List<TipoCurso> list = transformarResultado(super.executeSqlSelect(query));
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public boolean excluir(Long cdId) {
		try {
			super.executeCommand(new StringBuilder("DELETE FROM tipocurso WHERE CD_ID = ").append(cdId));
			return this.recuperar(cdId) == null;
		} catch (Exception e) {
			return false;
		}
	}

	private List<TipoCurso> transformarResultado(List<Map<String, Object>> listMap) {
		List<TipoCurso> listTipoCurso = new ArrayList<TipoCurso>();

		if (listMap != null) {
			TipoCurso tipoCurso = null;
			for (Map<String, Object> map : listMap) {
				tipoCurso = new TipoCurso();
				tipoCurso.setCdId((Long) map.get("CD_ID"));
				tipoCurso.setNmTipoCurso((String) map.get("nm_tipocurso"));
				tipoCurso.setFlSituacao((Boolean) map.get("FL_SITUACAO"));
				listTipoCurso.add(tipoCurso);
			}
		}

		return listTipoCurso;
	}
}