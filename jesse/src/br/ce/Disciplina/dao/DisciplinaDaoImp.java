package br.ce.Disciplina.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.ce.Disciplina.dao.Disciplina;
import br.ce.Curso.entity.Curso;
import br.ce.generic.GenericDaoImp;

@Repository("DisciplinaDao")
@Transactional
public class DisciplinaDaoImp extends GenericDaoImp implements DisciplinaDaoInterface {

	@Override
	public Disciplina salvar(Disciplina entity) throws Exception {
		StringBuilder query = new StringBuilder("INSERT INTO disciplina (nm_disciplina, fk_curso) VALUES ('");
		query.append(entity.getNmDisciplina()).append("', ").append(entity.getFkCurso()).append(")");
		entity.setCdId(super.save(query));
		return entity;
	}
	

	@Override
	public Disciplina atualizar(Disciplina entity) throws Exception {
		if (entity.getCdId() != null) {
			StringBuilder query = new StringBuilder("UPDATE disciplina SET ");
			query.append("NM_disciplina = ").append(entity.getNmDisciplina()).append("', fk_curso = ").append(entity.getFkCurso())
				.append(" WHERE CD_ID = ").append(entity.getCdId());
			super.executeCommand(query);
		}
			
		return entity;
	}
	public List<Disciplina> listar(Disciplina entity) {
		StringBuilder query = new StringBuilder("SELECT a.CD_ID, a.nm_disciplina, a.fk_curso, FROM ");
		query.append("disciplina a INNER JOIN curso d ON (d.CD_ID = a.fk_curso) WHERE 1=1 ");
		if (entity.getNmDisciplina() != null && !((List<br.ce.Disciplina.dao.Disciplina>) entity.getNmDisciplina()).isEmpty())
			query.append(" AND nm_disciplina ILIKE '%").append(entity.getNmDisciplina()).append("%' ");
		
		return transformarResultado(super.executeSqlSelect(query));
	}

		
		@Override
		public br.ce.Disciplina.entity.Disciplina recuperar1(Long cdId) {
			StringBuilder query = new StringBuilder("SELECT a.CD_ID, a.nm_disciplina, a.fk_curso, FROM ");
			query.append("disciplina a INNER JOIN curso d ON d.CD_ID = a.fk_curso where a.cd_id = ").append(cdId);
			List<Disciplina> list = transformarResultado(super.executeSqlSelect(query));
			return (br.ce.Disciplina.entity.Disciplina) (list.size() > 0 ? list.get(0) : null);

			}	


	@Override
	public boolean excluir(Long cdId) {
		try {
			super.executeCommand(new StringBuilder("DELETE FROM Disciplina WHERE CD_ID = ").append(cdId));
			return this.recuperar1(cdId) == null;
		} catch (Exception e) {
			return false;
		}
	}

	private List<Disciplina> transformarResultado(List<Map<String, Object>> listMap) {
		List<Disciplina> listDisciplina = new ArrayList<Disciplina>();

		if (listMap != null) {
			Disciplina Disciplina = null;
			for (Map<String, Object> map : listMap) {
				Disciplina Disciplina1 = new Disciplina();
				Disciplina1.setCdId((Long) map.get("CD_ID"));
				Disciplina1.setNmAtividade((String) map.get("nm_disciplina"));
				Disciplina1.setFkDisciplina((long) map.get("fk_curso"));
				listDisciplina.add(Disciplina1);
			}
		}
		
		

		return listDisciplina;
	}


	@Override
	public List<Disciplina> listarDisciplinaAtivo(Disciplina entity) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public br.ce.Disciplina.entity.Disciplina salvar(
			br.ce.Disciplina.entity.Disciplina entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public br.ce.Disciplina.entity.Disciplina atualizar(
			br.ce.Disciplina.entity.Disciplina entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<br.ce.Disciplina.entity.Disciplina> listar(
			br.ce.Disciplina.entity.Disciplina entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public br.ce.Disciplina.entity.Disciplina recuperar(Long cdId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<br.ce.Disciplina.entity.Disciplina> listarDisciplinaAtivo(
			br.ce.Disciplina.entity.Disciplina entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
