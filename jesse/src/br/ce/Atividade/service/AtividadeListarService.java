package br.ce.Atividade.service;

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

import br.ce.Atividade.entity.Atividade;
import br.ce.Atividade.mbean.AtividadeMBInterface;
import br.ce.Login.service.JSPSecurity;
import br.ce.Disciplina.entity.Disciplina;
import br.ce.Disciplina.mbean.DisciplinaMBInterface;
import br.ce.generic.CustomApplicationContextAware;


@RestController
@RequestMapping("/Atividade")
public class AtividadeListarService {

	private AtividadeMBInterface getMB() {
		return (AtividadeMBInterface) CustomApplicationContextAware.getBean("AtividadeMB");
	}
	
	private DisciplinaMBInterface getDisciplinaMB() {
		return (DisciplinaMBInterface) CustomApplicationContextAware.getBean("DisciplinaMB");
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
		
		mav = new ModelAndView("Atividade/AtividadeListar");
		mav.addObject("listAtividade", getMB().listar(new Atividade()));
		mav.addObject("filtro", new Atividade());
		mav.addObject("listDisciplina", getDisciplinaMB().listarDisciplinaAtivo(new Disciplina()));
		return mav;
	}

	/**
	 * metodo que eh chamado quando a a url /moto/ eh chamado
	 */
	@RequestMapping(value = { "/pesquisar", "/pesquisar/" })
	protected ModelAndView pesquisar(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Atividade Atividade) throws ServletException, IOException {
		ModelAndView mav = new ModelAndView("Atividade/AtividadeListar");
		mav.addObject("listAtividade", getMB().listar(Atividade));
		mav.addObject("filtro", Atividade);
		return mav;
	}
	
	/**
	 * metodo que eh chamado quando a a url /moto/ eh chamado
	 */
	@RequestMapping(value = { "/excluir/{cdId}" })
	protected ModelAndView pesquisar(HttpServletRequest request, HttpServletResponse response, @PathVariable String cdId) throws ServletException, IOException {
		getMB().excluir(new Long(cdId));
		ModelAndView mav = new ModelAndView("Atividade/AtividadeListar");
		mav.addObject("listAtividade", getMB().listar(new Atividade()));
		mav.addObject("filtro", new Atividade());
		return mav;
	}
}
