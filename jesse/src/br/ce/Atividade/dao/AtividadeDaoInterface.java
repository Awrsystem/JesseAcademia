package br.ce.Atividade.dao;

import java.util.List;

import br.ce.Atividade.entity.Atividade;

public interface AtividadeDaoInterface {

	public Atividade salvar(Atividade entity) throws Exception;

	public Atividade atualizar(Atividade entity) throws Exception;

	public List<Atividade> listar(Atividade entity);

	public Atividade recuperar(Long cdId);

	public boolean excluir(Long cdId);

	public List<Atividade> listarAtividadeAtivo(Atividade entity);

}
