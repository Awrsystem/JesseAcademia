package br.ce.Atividade.mbean;

import java.util.List;

import br.ce.Atividade.entity.Atividade;

public interface AtividadeMBInterface {

	public Atividade salvar(Atividade entity) throws Exception;

	public Atividade atualizar(Atividade entity) throws Exception;

	public List<Atividade> listar(Atividade entity);

	public Atividade recuperar(Long cdId);

	public boolean excluir(Long cdId);

	List<Atividade> listarAtividadeAtivo(Atividade entity);


}
