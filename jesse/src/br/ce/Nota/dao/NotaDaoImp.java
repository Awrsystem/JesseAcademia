package br.ce.Nota.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;






import br.ce.Atividade.entity.Atividade;
import br.ce.Usuario.entity.Usuario;
import br.ce.Nota.entity.Nota;
import br.ce.generic.GenericDaoImp;

@Repository("NotaDao")
@Transactional
public class NotaDaoImp extends GenericDaoImp implements NotaDaoInterface{
	
	@Override
	public Nota salvar(Nota entity) throws Exception {
		StringBuilder query = new StringBuilder("INSERT INTO nota (fk_atividade, fk_aluno, vl_nota) VALUES (");
		query.append(entity.getFkAtividade()).append(", ").append(entity.getFkAluno()).append(", ")
		.append(entity.getVlNota()).append(")");
		entity.setCdId(super.save(query));
		return entity;
	}
	
	

	@Override
	public Nota atualizar(Nota entity) throws Exception {
		if (entity.getCdId() != null) {
			StringBuilder query = new StringBuilder("UPDATE nota SET ");
			query.append("fk_atividade = ").append(entity.getFkAtividade()).append(", fk_aluno = ").append(entity.getFkAluno())
			.append(", vl_nota = ").append(entity.getVlNota())
				.append(" WHERE CD_ID = ").append(entity.getCdId());
			super.executeCommand(query);
		}
			
		return entity;
	}
			
		public List<Nota> listar(Nota entity) {
			StringBuilder query = new StringBuilder("SELECT USUARIO.NM_USUARIO, ATIVIDADE.NM_ATIVIDADE, NOTA.CD_ID, VL_NOTA, FK_ATIVIDADE, FK_ALUNO FROM ");
			query.append("NOTA INNER JOIN USUARIO ON USUARIO.CD_ID = NOTA.FK_ALUNO INNER JOIN ATIVIDADE ON ATIVIDADE.CD_ID = NOTA.FK_ATIVIDADE WHERE 1=1 ");
			if (entity.getVlNota() != null)
				query.append(" AND VL_NOTA = ").append(entity.getVlNota());
			if (entity.getFkAluno() != null)
				query.append(" AND FK_ALUNO = ").append(entity.getFkAluno());
			if (entity.getFkAtividade() != null)
				query.append(" AND FK_ATIVIDADE = ").append(entity.getFkAtividade());
			
			
			return transformarResultado(super.executeSqlSelect(query));
		}


		@Override
		public Nota recuperar(Long cdId) {
			StringBuilder query = new StringBuilder("SELECT ATIVIDADE.NM_ATIVIDADE, USUARIO.NM_USUARIO, NOTA.CD_ID, VL_NOTA, FK_ALUNO, FK_ATIVIDADE FROM ");
			query.append("NOTA INNER JOIN USUARIO ON USUARIO.CD_ID = NOTA.FK_ALUNO INNER JOIN ATIVIDADE ON ATIVIDADE.CD_ID = NOTA.FK_ATIVIDADE WHERE NOTA.CD_ID = ").append(cdId);
			List<Nota> list = transformarResultado(super.executeSqlSelect(query));
			return list.size() > 0 ? list.get(0) : null;
		}
		


	@Override
	public boolean excluir(Long cdId) {
		try {
			super.executeCommand(new StringBuilder("DELETE FROM nota WHERE CD_ID = ").append(cdId));
			return this.recuperar(cdId) == null;
		} catch (Exception e) {
			return false;
		}
	}

	private List<Nota> transformarResultado(List<Map<String, Object>> listMap) {
		List<Nota> listNota = new ArrayList<Nota>();

		if (listMap != null) {
			Nota nota = null;
			for (Map<String, Object> map : listMap) {
				nota = new Nota();
				Atividade atividade = new Atividade();
				Usuario usuario = new Usuario();
				nota.setCdId((Long) map.get("CD_ID"));
				nota.setFkAtividade((Long) map.get("fk_atividade"));
				nota.setFkAluno((Long) map.get("fk_aluno"));
				nota.setVlNota((Double) map.get("vl_nota"));
				nota.setAtividade(atividade);
				nota.setUsuario(usuario);
				nota.getAtividade().setNmAtividade((String) map.get("nm_atividade"));
				nota.getUsuario().setNmUsuario((String) map.get("nm_usuario"));
				listNota.add(nota);
			}
		}
		
		

		return listNota;
	}

}
