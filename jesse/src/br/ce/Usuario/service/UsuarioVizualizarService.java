package br.ce.Usuario.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.ce.Perfil.entity.Perfil;
import br.ce.Perfil.mbean.PerfilMBInterface;
import br.ce.Usuario.mbean.UsuarioMBInterface;
import br.ce.generic.CustomApplicationContextAware;

@RestController
@RequestMapping("/Usuario")
public class UsuarioVizualizarService {

	private UsuarioMBInterface getMB() {
		return (UsuarioMBInterface) CustomApplicationContextAware.getBean("UsuarioMB");
	}
	
	private PerfilMBInterface getPerfilMB() {
		return (PerfilMBInterface) CustomApplicationContextAware.getBean("PerfilMB");
	}

	/**
	 * metodo que eh chamado quando a a url /moto/visualizar eh chamado
	 */
	@RequestMapping(value = { "/visualizar/{cdId}" })
	protected ModelAndView listar(HttpServletRequest request, HttpServletResponse response, @PathVariable String cdId) {
		ModelAndView mav = new ModelAndView("Usuario/UsuarioVisualizar");
		mav.addObject("Usuario", getMB().recuperar(new Long(cdId)));
		mav.addObject("listPerfil", getPerfilMB().listaPerfilAtivo(new Perfil()));
		return mav;
	}
	
}
