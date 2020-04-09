package br.ce.Curso.service;

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
import br.ce.TipoCurso.entity.TipoCurso;
import br.ce.TipoCurso.mbean.TipoCursoMBInterface;
import br.ce.generic.CustomApplicationContextAware;


@RestController
@RequestMapping("/Curso")
public class CursoEditarService {
	private CursoMBInterface getMB() {
		return (CursoMBInterface) CustomApplicationContextAware.getBean("CursoMB");
	}
	
	private TipoCursoMBInterface getTipoCursoMB() {
		return (TipoCursoMBInterface) CustomApplicationContextAware.getBean("TipoCursoMB");
	}

	/**
	 * metodo que eh chamado quando a a url /moto/novo eh chamado
	 */
	@RequestMapping("/novo")
	protected ModelAndView novo(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("Curso/CursoEditar");
		Curso Curso = new Curso();
		Curso.setFlSituacao(true);
		mav.addObject("Curso", Curso);
		mav.addObject("listTipoCurso", getTipoCursoMB().listarTipoCursoAtivo(new TipoCurso()));
		return mav;
	}

	/**
	 * metodo que eh chamado quando a a url /moto/editar/{id} eh chamado substitui-se o {id} pelo cdId da entity que sera editada
	 */
	@RequestMapping("/editar/{cdId}")
	protected ModelAndView editar(HttpServletRequest request, HttpServletResponse response, @PathVariable String cdId) {
		try {
			ModelAndView mav = new ModelAndView("Curso/CursoEditar");
			mav.addObject("Curso", getMB().recuperar(new Long(cdId)));
			mav.addObject("listTipoCurso", getTipoCursoMB().listarTipoCursoAtivo(new TipoCurso()));
			return mav;
		} catch (Exception e) {
			return montarPaginaMensagem(e);
		}
	}

	/**
	 * metodo que eh chamado quando a a url /moto/salvar eh chamado
	 */
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	protected ModelAndView salvar(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Curso Curso) {
		try {
			if (Curso.getCdId() != null && Curso.getCdId() != 0L)
				getMB().atualizar(Curso);
			else
				getMB().salvar(Curso);

			ModelAndView mav = new ModelAndView("Curso/CursoListar");
			mav.addObject("listCurso", getMB().listar(new Curso()));
			mav.addObject("mensagem", "Salvo/Editado com sucesso");
			return mav;
		} catch (Exception e) {
			return montarPaginaMensagem(e);
		}
	}

	private ModelAndView montarPaginaMensagem(Exception e) {
		ModelAndView mav = new ModelAndView("paginaMensagem");
		mav.addObject("mensagem", "Erro ao salvar registro");
		mav.addObject("mensagemDetalhe", e.getMessage());
		return mav;
	}
	
	
}
