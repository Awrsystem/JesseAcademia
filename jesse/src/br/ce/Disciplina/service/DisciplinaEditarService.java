package br.ce.Disciplina.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.ce.Curso.entity.Curso;
import br.ce.Curso.mbean.CursoMBInterface;
import br.ce.Disciplina.entity.Disciplina;
import br.ce.Disciplina.mbean.DisciplinaMBInterface;
import br.ce.generic.CustomApplicationContextAware;
import br.ce.TipoCurso.entity.TipoCurso;
import br.ce.TipoCurso.mbean.TipoCursoMBInterface;

@RestController
@RequestMapping("/Disciplina")
public class DisciplinaEditarService {
	private DisciplinaMBInterface getMB() {
		return (DisciplinaMBInterface) CustomApplicationContextAware.getBean("DisciplinaMB");
	}

	/**
	 * metodo que eh chamado quando a url /tipocurso/novo eh chamado
	 */
	@RequestMapping("/novo")
	protected ModelAndView novo(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("Disciplina/DisciplinaEditar");
		Disciplina Disciplina = new Disciplina();
		Disciplina.setSituacao(true);
		mav.addObject("Disciplina", Disciplina);
		return mav;
	}

	/**
	 * metodo que eh chamado quando a a url /tipocurso/editar/{id} eh chamado substitui-se o {id} pelo cdId da entity que sera editada
	 */
	@RequestMapping("/editar/{cdId}")
	protected ModelAndView editar(HttpServletRequest request, HttpServletResponse response, @PathVariable String cdId) {
		try {
			ModelAndView mav = new ModelAndView("Disciplina/DisciplinaEditar");
			mav.addObject("disciplina", getMB().recuperar(new Long(cdId)));
			return mav;
		} catch (Exception e) {
			return montarPaginaMensagem(e);
		}
	}

	/**
	 * metodo que eh chamado quando a a url /tipocurso/salvar eh chamado
	 */
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	protected ModelAndView salvar(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Disciplina disciplina) {
		try {
			if (Disciplina.getNomeDisciplina() != null && Disciplina.getNmDisciplina() != 0L)
				getMB().atualizar(disciplina);
			
			else
				getMB().salvar(disciplina);

			ModelAndView mav = new ModelAndView("disciplina/disciplinaListar");
			mav.addObject("listDisciplina", getMB().listar(new Disciplina()));
			mav.addObject("mensagem", "Salvo/Editado com sucesso");
			System.out.println(disciplina);
			return mav;
		} catch (Exception e) {
			return montarPaginaMensagem(e);
		}
	}

	private ModelAndView montarPaginaMensagem(Exception e) {
		ModelAndView mav = new ModelAndView("paginaMensagem");
		mav.addObject("mensagem", "Erro ao salvar disciplina");
		mav.addObject("mensagemDetalhe", e.getMessage());
		return mav;
	}
}