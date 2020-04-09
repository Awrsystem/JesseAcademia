package br.ce.Disciplina.service;

import java.io.IOException;

import javax.security.sasl.SaslException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.ce.generic.CustomApplicationContextAware;
import br.ce.Curso.entity.Curso;
import br.ce.Curso.mbean.CursoMBInterface;
import br.ce.Disciplina.entity.Disciplina;
import br.ce.Disciplina.mbean.DisciplinaMBInterface;
import br.ce.Nota.entity.Nota;

@RestController
@RequestMapping("/Disciplina")
public class DisciplinaListarService {

	private DisciplinaMBInterface getMB() {
		return (DisciplinaMBInterface) CustomApplicationContextAware
				.getBean("disciplinaMB");
	}

	@RequestMapping(value = { "/", "" })
	protected ModelAndView listar(HttpServletRequest request,
			HttpServletResponse response) throws SaslException, IOException {
		ModelAndView mav = new ModelAndView("disciplina/disciplinaListar");
		mav.addObject("listDisciplina", getMB().listar(new Disciplina()));
		mav.addObject("filtro", new Disciplina());
		return mav;
	}

	@RequestMapping(value = { "/pesquisar", "/pesquisar/" })
	protected ModelAndView pesquisar(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute Disciplina disciplina)
			throws ServletException, IOException {
		ModelAndView mav = new ModelAndView("disciplina/notaDisciplina");
		mav.addObject("listDisciplina", getMB().listar(disciplina));
		mav.addObject("filtro", disciplina);
		return mav;
	}

	@RequestMapping(value = { "/excluir/{disciplina}" })
	protected ModelAndView excluir(HttpServletRequest request,
			HttpServletResponse response, @PathVariable String disciplina)
			throws ServletException, IOException {
		getMB().excluir(new Long(disciplina));
		ModelAndView mav = new ModelAndView("disciplina/disciplinaListar");
		mav.addObject("listDisciplina", getMB().listar(new Disciplina()));
		mav.addObject("filtro", new Disciplina());
		return mav;
	}
}