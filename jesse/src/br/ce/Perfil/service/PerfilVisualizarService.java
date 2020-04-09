package br.ce.Perfil.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.ce.Perfil.mbean.PerfilMBInterface;
import br.ce.generic.CustomApplicationContextAware;

@RestController
@RequestMapping("/Perfil")
public class PerfilVisualizarService {

	private PerfilMBInterface getMB() {
		return (PerfilMBInterface) CustomApplicationContextAware.getBean("PerfilMB");
	}

	/**
	 * metodo que eh chamado quando a a url /moto/visualizar eh chamado
	 */
	@RequestMapping(value = { "/visualizar/{cdId}" })
	protected ModelAndView listar(HttpServletRequest request, HttpServletResponse response, @PathVariable String cdId) {
		ModelAndView mav = new ModelAndView("Perfil/PerfilVisualizar");
		mav.addObject("Perfil", getMB().recuperar(new Long(cdId)));
		return mav;
	}
	
}
