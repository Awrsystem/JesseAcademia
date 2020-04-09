package br.ce.Nota.mbean;

import java.util.List;

import br.ce.Disciplina.entity.Disciplina;
import br.ce.Nota.entity.Nota;
import br.ce.Usuario.entity.Usuario;

public interface NotaMBInterface {

	public Nota salvar(Nota entity) throws Exception;

	public Nota atualizar(Nota entity) throws Exception;

	public List<Nota> listar(Nota entity);

	public Nota recuperar(Long cdId);

	public boolean excluir(Long cdId);

	public List<Nota> listarNotaAtivo (Nota entity);
	public List<Usuario> listarUsuarioAtivo (Usuario entity);
}
