package br.ce.Atividade.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.ce.Atividade.entity.Atividade;
import br.ce.generic.GenericDaoImp;

@Repository("AtividadeDao")
@Transactional
public class AtividadeDaoImp extends GenericDaoImp implements AtividadeDaoInterface{
	
	@Override
	public Atividade salvar(Atividade entity) throws Exception {
		StringBuilder query = new StringBuilder("INSERT INTO atividade (nm_atividade, fk_disciplina) VALUES ('");
		query.append(entity.getNmAtividade()).append("', ").append(entity.getFkDisciplina()).append(")");
		entity.setCdId(super.save(query));
		return entity;
	}
	

	@Override
	public Atividade atualizar(Atividade entity) throws Exception {
		if (entity.getCdId() != null) {
			StringBuilder query = new StringBuilder("UPDATE atividade SET ");
			query.append("nm_atividade = ").append(entity.getNmAtividade()).append("', fk_disciplina = ").append(entity.getFkDisciplina())
				.append(" WHERE CD_ID = ").append(entity.getCdId());
			super.executeCommand(query);
		}
			
		return entity;
	}
	public List<Atividade> listar(Atividade entity) {
		StringBuilder query = new StringBuilder("SELECT a.CD_ID, a.nm_atividade, a.fk_disciplina, d.nm_disciplina FROM ");
		query.append("atividade a INNER JOIN disciplina d ON (d.CD_ID = a.fk_disciplina) WHERE 1=1 ");
		if (entity.getNmAtividade() != null && !entity.getNmAtividade().isEmpty())
			query.append(" AND nm_atividade ILIKE '%").append(entity.getNmAtividade()).append("%' ");
		
		return transformarResultado(super.executeSqlSelect(query));
	}

		
		@Override
		public Atividade recuperar(Long cdId) {
			StringBuilder query = new StringBuilder("SELECT a.CD_ID, a.nm_atividade, a.fk_disciplina, d.nm_disciplina FROM ");
			query.append("atividade a INNER JOIN disciplina d ON d.CD_ID = a.fk_disciplina where a.cd_id = ").append(cdId);
			List<Atividade> list = transformarResultado(super.executeSqlSelect(query));
			return list.size() > 0 ? list.get(0) : null;

			}
		


	@Override
	public boolean excluir(Long cdId) {
		try {
			super.executeCommand(new StringBuilder("DELETE FROM atividade WHERE CD_ID = ").append(cdId));
			return this.recuperar(cdId) == null;
		} catch (Exception e) {
			return false;
		}
	}

	private List<Atividade> transformarResultado(List<Map<String, Object>> listMap) {
		List<Atividade> listAtividade = new ArrayList<Atividade>();

		if (listMap != null) {
			Atividade atividade = null;
			for (Map<String, Object> map : listMap) {
				atividade = new Atividade();
				Disciplina disciplina = new Disciplina();
				atividade.setCdId((Long) map.get("CD_ID"));
				atividade.setNmAtividade((String) map.get("nm_atividade"));
				atividade.setFkDisciplina((long) map.get("fk_disciplina"));
				atividade.setDisciplina(disciplina);
				atividade.getDisciplina().setNomeDisciplina((String) map.get("nm_disciplina"));
				listAtividade.add(atividade);
			}
		}
		
		

		return listAtividade;
	}


	@Override
	public List<Atividade> listarAtividadeAtivo(Atividade entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
