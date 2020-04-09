package br.ce.TipoCurso.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.ce.TipoCurso.mbean.TipoCursoMBInterface;
import br.ce.generic.CustomApplicationContextAware;

@RestController
@RequestMapping("/TipoCurso")
public class TipoCursoVisualizarService {
	private TipoCursoMBInterface getMB() {
		return (TipoCursoMBInterface) CustomApplicationContextAware.getBean("TipoCursoMB");
	}

	/**
	 * metodo que eh chamado quando a a url /moto/visualizar eh chamado
	 */
	@RequestMapping(value = { "/visualizar/{cdId}" })
	protected ModelAndView listar(HttpServletRequest request, HttpServletResponse response, @PathVariable String cdId) {
		ModelAndView mav = new ModelAndView("TipoCurso/TipoCursoVisualizar");
		mav.addObject("TipoCurso", getMB().recuperar(new Long(cdId)));
		return mav;
	}
}