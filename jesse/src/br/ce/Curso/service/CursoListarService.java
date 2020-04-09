package br.ce.Curso.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.ce.Curso.entity.Curso;
import br.ce.Curso.mbean.CursoMBInterface;
import br.ce.Login.service.JSPSecurity;
import br.ce.TipoCurso.entity.TipoCurso;
import br.ce.TipoCurso.mbean.TipoCursoMBInterface;
import br.ce.generic.CustomApplicationContextAware;


@RestController
@RequestMapping("/Curso")
public class CursoListarService {

	private CursoMBInterface getMB() {
		return (CursoMBInterface) CustomApplicationContextAware.getBean("CursoMB");
	}
	
	private TipoCursoMBInterface getTipoCursoMB() {
		return (TipoCursoMBInterface) CustomApplicationContextAware.getBean("TipoCursoMB");
	}

	/**
	 * metodo que eh chamado quando a a url /moto/ eh chamado
	 */
	@RequestMapping(value = { "/", "" })
	protected ModelAndView listar(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		ModelAndView mav = JSPSecurity.autenticar(session);
		
		if (mav!= null){
			
			return mav;
			
		}
		
		mav = new ModelAndView("Curso/CursoListar");
		mav.addObject("listCurso", getMB().listar(new Curso()));
		mav.addObject("filtro", new Curso());
		mav.addObject("listTipoCurso", getTipoCursoMB().listarTipoCursoAtivo(new TipoCurso()));
		return mav;
	}

	/**
	 * metodo que eh chamado quando a a url /moto/ eh chamado
	 */
	@RequestMapping(value = { "/pesquisar", "/pesquisar/" })
	protected ModelAndView pesquisar(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Curso Curso) throws ServletException, IOException {
		ModelAndView mav = new ModelAndView("Curso/CursoListar");
		mav.addObject("listCurso", getMB().listar(Curso));
		mav.addObject("filtro", Curso);
		return mav;
	}
	
	/**
	 * metodo que eh chamado quando a a url /moto/ eh chamado
	 */
	@RequestMapping(value = { "/excluir/{cdId}" })
	protected ModelAndView pesquisar(HttpServletRequest request, HttpServletResponse response, @PathVariable String cdId) throws ServletException, IOException {
		getMB().excluir(new Long(cdId));
		ModelAndView mav = new ModelAndView("Curso/CursoListar");
		mav.addObject("listCurso", getMB().listar(new Curso()));
		mav.addObject("filtro", new Curso());
		return mav;
	}
}
