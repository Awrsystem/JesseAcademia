package br.ce.TipoCurso.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.ce.TipoCurso.entity.TipoCurso;
import br.ce.TipoCurso.mbean.TipoCursoMBInterface;
import br.ce.generic.CustomApplicationContextAware;

@RestController
@RequestMapping("/TipoCurso")
public class TipoCursoListarService {
	private TipoCursoMBInterface getMB() {
		return (TipoCursoMBInterface) CustomApplicationContextAware.getBean("TipoCursoMB");
	}

	/**
	 * metodo que eh chamado quando a a url /moto/ eh chamado
	 */
	@RequestMapping(value = { "/", "" })
	protected ModelAndView listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModelAndView mav = new ModelAndView("TipoCurso/TipoCursoListar");
		mav.addObject("listTipoCurso", getMB().listar(new TipoCurso()));
		mav.addObject("filtro", new TipoCurso());
		return mav;
	}

	/**
	 * metodo que eh chamado quando a a url /moto/ eh chamado
	 */
	@RequestMapping(value = { "/pesquisar", "/pesquisar/" })
	protected ModelAndView pesquisar(HttpServletRequest request, HttpServletResponse response, @ModelAttribute TipoCurso TipoCurso) throws ServletException, IOException {
		ModelAndView mav = new ModelAndView("TipoCurso/TipoCursoListar");
		mav.addObject("listTipoCurso", getMB().listar(TipoCurso));
		mav.addObject("filtro", TipoCurso);
		return mav;
	}
	
	/**
	 * metodo que eh chamado quando a a url /moto/ eh chamado
	 */
	@RequestMapping(value = { "/excluir/{cdId}" })
	protected ModelAndView pesquisar(HttpServletRequest request, HttpServletResponse response, @PathVariable String cdId) throws ServletException, IOException {
		getMB().excluir(new Long(cdId));
		ModelAndView mav = new ModelAndView("TipoCurso/TipoCursoListar");
		mav.addObject("listTipoCurso", getMB().listar(new TipoCurso()));
		mav.addObject("filtro", new TipoCurso());
		return mav;
	}
}