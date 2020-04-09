package br.ce.Atividade.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.ce.Atividade.mbean.AtividadeMBInterface;
import br.ce.Disciplina.entity.Disciplina;
import br.ce.Disciplina.mbean.DisciplinaMBInterface;
import br.ce.generic.CustomApplicationContextAware;

@RestController
@RequestMapping("/Atividade")
public class AtividadeVisualizarService {

	private AtividadeMBInterface getMB() {
		return (AtividadeMBInterface) CustomApplicationContextAware.getBean("AtividadeMB");
	}
	
	private DisciplinaMBInterface getDisciplinaMB() {
		return (DisciplinaMBInterface) CustomApplicationContextAware.getBean("DisciplinaMB");
	}

	/**
	 * metodo que eh chamado quando a a url /moto/visualizar eh chamado
	 */
	@RequestMapping(value = { "/visualizar/{cdId}" })
	protected ModelAndView listar(HttpServletRequest request, HttpServletResponse response, @PathVariable String cdId) {
		ModelAndView mav = new ModelAndView("Atividade/AtividadeVisualizar");
		mav.addObject("Atividade", getMB().recuperar(new Long(cdId)));
		mav.addObject("listDisciplina", getDisciplinaMB().listarDisciplinaAtivo(new Disciplina()));
		return mav;
	}
	
}
