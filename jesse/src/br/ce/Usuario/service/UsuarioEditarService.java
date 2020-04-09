package br.ce.Usuario.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.ce.Perfil.entity.Perfil;
import br.ce.Perfil.mbean.PerfilMBInterface;
import br.ce.Usuario.entity.Usuario;
import br.ce.Usuario.mbean.UsuarioMBInterface;
import br.ce.generic.CustomApplicationContextAware;


@RestController
@RequestMapping("/Usuario")
public class UsuarioEditarService {
	private UsuarioMBInterface getMB() {
		return (UsuarioMBInterface) CustomApplicationContextAware.getBean("UsuarioMB");
	}
	
	private PerfilMBInterface getPerfilMB() {
		return (PerfilMBInterface) CustomApplicationContextAware.getBean("PerfilMB");
	}

	/**
	 * metodo que eh chamado quando a a url /moto/novo eh chamado
	 */
	@RequestMapping("/novo")
	protected ModelAndView novo(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("Usuario/UsuarioEditar");
		Usuario usuario = new Usuario();
		usuario.setFlSituacao(true);
		mav.addObject("Usuario", usuario);
		mav.addObject("listPerfil", getPerfilMB().listaPerfilAtivo(new Perfil()));
		return mav;
	}
	/**
	 * metodo que eh chamado quando a a url /moto/editar/{id} eh chamado substitui-se o {id} pelo cdId da entity que sera editada
	 */
	@RequestMapping("/editar/{cdId}")
	protected ModelAndView editar(HttpServletRequest request, HttpServletResponse response, @PathVariable String cdId) {
		try {
			ModelAndView mav = new ModelAndView("Usuario/UsuarioEditar");
			mav.addObject("Usuario", getMB().recuperar(new Long(cdId)));
			mav.addObject("listPerfil", getPerfilMB().listaPerfilAtivo(new Perfil()));
			return mav;
		} catch (Exception e) {
			return montarPaginaMensagem(e);
		}
	}

	/**
	 * metodo que eh chamado quando a a url /moto/salvar eh chamado
	 */
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	protected ModelAndView salvar(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Usuario Usuario) {
		try {
			if (Usuario.getCdId() != null && Usuario.getCdId() != 0L)
				getMB().atualizar(Usuario);
			else
				getMB().salvar(Usuario);

			ModelAndView mav = new ModelAndView("Usuario/UsuarioListar");
			mav.addObject("listUsuario", getMB().listar(new Usuario()));
			mav.addObject("mensagem", "Salvo/Editado com sucesso");
			return mav;
		} catch (Exception e) {
			return montarPaginaMensagem(e);
		}
	}

	private ModelAndView montarPaginaMensagem(Exception e) {
		ModelAndView mav = new ModelAndView("paginaMensagem");
		mav.addObject("mensagem", "Erro ao salvar registro");
		mav.addObject("mensagemDetalhe", e.getMessage());
		return mav;
	}
	
	
}
