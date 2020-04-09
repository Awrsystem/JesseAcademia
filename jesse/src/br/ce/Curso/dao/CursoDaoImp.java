package br.ce.Curso.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.ce.Curso.dao.CursoDaoInterface;
import br.ce.Curso.entity.Curso;
import br.ce.TipoCurso.entity.TipoCurso;
import br.ce.generic.GenericDaoImp;

@Repository("CursoDao")
@Transactional
public class CursoDaoImp extends GenericDaoImp implements CursoDaoInterface{
	
	@Override
	public Curso salvar(Curso entity) throws Exception {
		StringBuilder query = new StringBuilder("INSERT INTO curso (nm_curso, fk_tipo_curso, vl_mensal_curso, nr_duracao, FL_SITUACAO) VALUES ('");
		query.append(entity.getNmCurso()).append("', ").append(entity.getFkTipoCurso()).append(", ").append(entity.getVlMensalCurso()).append(", ")
		.append(entity.getNrDuracao()).append(", ").append(entity.getFlSituacao()).append(")");
		entity.setCdId(super.save(query));
		return entity;
	}

	@Override
	public Curso atualizar(Curso entity) throws Exception {
		if (entity.getCdId() != null) {
			StringBuilder query = new StringBuilder("UPDATE curso SET ");
			query.append("nm_curso = '").append(entity.getNmCurso()).append("', fk_tipo_curso = ").append(entity.getFkTipoCurso())
				.append(", vl_mensal_curso = ").append(entity.getVlMensalCurso()).append(", nr_duracao = ").append(entity.getNrDuracao())
				.append(", FL_SITUACAO = ").append(entity.getFlSituacao())
				.append(" WHERE CD_ID = ").append(entity.getCdId());
			super.executeCommand(query);
		}
		
			
		return entity;
	}
	public List<Curso> listar(Curso entity) {
		StringBuilder query = new StringBuilder("SELECT c.CD_ID, c.nm_curso, c.fk_tipo_curso, c.vl_mensal_curso, c.nr_duracao, c.FL_SITUACAO, nm_tipocurso FROM ");
		query.append("curso c INNER JOIN tipocurso tp ON (tp.CD_ID = fk_tipo_curso) WHERE 1=1 ");
		if (entity.getNmCurso() != null && !entity.getNmCurso().isEmpty())
			query.append(" AND nm_curso ILIKE '%").append(entity.getNmCurso()).append("%' ");
		if (entity.getFlSituacao() != null)
			query.append(" AND FL_SITUACAO = ").append(entity.getFlSituacao());
	
		return transformarResultado(super.executeSqlSelect(query));
	}

		
		@Override
		public Curso recuperar(Long cdId) {
			StringBuilder query = new StringBuilder("SELECT CURSO.CD_ID, NM_CURSO, FK_TIPO_CURSO, VL_MENSAL_CURSO, "
					+ "NR_DURACAO, CURSO.FL_SITUACAO, NM_TIPOCURSO FROM ");
			query.append("CURSO INNER JOIN TIPOCURSO ON TIPOCURSO.CD_ID = CURSO.FK_TIPO_CURSO WHERE CURSO.CD_ID = ").append(cdId);
			List<Curso> list = transformarResultado(super.executeSqlSelect(query));
			return list.size() > 0 ? list.get(0) : null;

			}
		
		


	@Override
	public boolean excluir(Long cdId) {
		try {
			super.executeCommand(new StringBuilder("DELETE FROM curso WHERE CD_ID = ").append(cdId));
			return this.recuperar(cdId) == null;
		} catch (Exception e) {
			return false;
		}
	}

	private List<Curso> transformarResultado(List<Map<String, Object>> listMap) {
		List<Curso> listCurso = new ArrayList<Curso>();

		if (listMap != null) {
			Curso curso = null;
			for (Map<String, Object> map : listMap) {
				curso = new Curso();
				TipoCurso tipoCurso = new TipoCurso();
				curso.setCdId((Long) map.get("CD_ID"));
				curso.setNmCurso((String) map.get("nm_curso"));
				curso.setFkTipoCurso((long) map.get("fk_tipo_curso"));
				curso.setVlMensalCurso((double) map.get("vl_mensal_curso"));
				curso.setNrDuracao((int) map.get("nr_duracao"));
				curso.setFlSituacao((Boolean) map.get("FL_SITUACAO"));
				curso.setTipoCurso(tipoCurso);
				curso.getTipoCurso().setNmTipoCurso((String) map.get("nm_tipocurso"));
				listCurso.add(curso);
			}
		}

		return listCurso;
	}

}
