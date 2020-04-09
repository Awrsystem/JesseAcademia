package br.ce.Curso.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.ce.Curso.mbean.CursoMBInterface;
import br.ce.TipoCurso.entity.TipoCurso;
import br.ce.TipoCurso.mbean.TipoCursoMBInterface;
import br.ce.generic.CustomApplicationContextAware;

@RestController
@RequestMapping("/Curso")
public class CursoVisualizarService {

	private CursoMBInterface getMB() {
		return (CursoMBInterface) CustomApplicationContextAware.getBean("CursoMB");
	}
	
	private TipoCursoMBInterface getTipoCursoMB() {
		return (TipoCursoMBInterface) CustomApplicationContextAware.getBean("TipoCursoMB");
	}

	/**
	 * metodo que eh chamado quando a a url /moto/visualizar eh chamado
	 */
	@RequestMapping(value = { "/visualizar/{cdId}" })
	protected ModelAndView listar(HttpServletRequest request, HttpServletResponse response, @PathVariable String cdId) {
		ModelAndView mav = new ModelAndView("Curso/CursoVisualizar");
		mav.addObject("Curso", getMB().recuperar(new Long(cdId)));
		mav.addObject("listTipoCurso", getTipoCursoMB().listarTipoCursoAtivo(new TipoCurso()));
		return mav;
	}
	
}
