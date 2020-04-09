package br.ce.Usuario.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.ce.Perfil.entity.Perfil;
import br.ce.Perfil.mbean.PerfilMBInterface;
import br.ce.Usuario.entity.Usuario;
import br.ce.Usuario.mbean.UsuarioMBInterface;
import br.ce.generic.CustomApplicationContextAware;


@RestController
@RequestMapping("/Usuario")
public class UsuarioListarService {

	private UsuarioMBInterface getMB() {
		return (UsuarioMBInterface) CustomApplicationContextAware.getBean("UsuarioMB");
	}
	
	private PerfilMBInterface getPerfilMB() {
		return (PerfilMBInterface) CustomApplicationContextAware.getBean("PerfilMB");
	}

	/**
	 * metodo que eh chamado quando a a url /moto/ eh chamado
	 */
	@RequestMapping(value = { "/", "" })
	protected ModelAndView listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModelAndView mav = new ModelAndView("Usuario/UsuarioListar");
		mav.addObject("listUsuario", getMB().listar(new Usuario()));
		mav.addObject("filtro", new Usuario());
		mav.addObject("listPerfil", getPerfilMB().listaPerfilAtivo(new Perfil()));
		return mav;
	}

	/**
	 * metodo que eh chamado quando a a url /moto/ eh chamado
	 */
	@RequestMapping(value = { "/pesquisar", "/pesquisar/" })
	protected ModelAndView pesquisar(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Usuario Usuario) throws ServletException, IOException {
		ModelAndView mav = new ModelAndView("Usuario/UsuarioListar");
		mav.addObject("listUsuario", getMB().listar(Usuario));
		mav.addObject("filtro", Usuario);
		return mav;
	}
	
	/**
	 * metodo que eh chamado quando a a url /moto/ eh chamado
	 */
	@RequestMapping(value = { "/excluir/{cdId}" })
	protected ModelAndView pesquisar(HttpServletRequest request, HttpServletResponse response, @PathVariable String cdId) throws ServletException, IOException {
		getMB().excluir(new Long(cdId));
		ModelAndView mav = new ModelAndView("Usuario/UsuarioListar");
		mav.addObject("listUsuario", getMB().listar(new Usuario()));
		mav.addObject("filtro", new Usuario());
		return mav;
	}
}
