package br.ce.Atividade.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.ce.Atividade.entity.Atividade;
import br.ce.Atividade.mbean.AtividadeMBInterface;
import br.ce.Disciplina.entity.Disciplina;
import br.ce.Disciplina.mbean.DisciplinaMBInterface;
import br.ce.generic.CustomApplicationContextAware;


@RestController
@RequestMapping("/Atividade")
public class AtividadeEditarService {
	private AtividadeMBInterface getMB() {
		return (AtividadeMBInterface) CustomApplicationContextAware.getBean("AtividadeMB");
	}
	
	private DisciplinaMBInterface getDisciplinaMB() {
		return (DisciplinaMBInterface) CustomApplicationContextAware.getBean("DisciplinaMB");
	}

	
	/**
	 * metodo que eh chamado quando a a url /moto/novo eh chamado
	 */
	@RequestMapping("/novo")
	protected ModelAndView novo(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("Atividade/AtividadeEditar");
		Atividade Atividade = new Atividade();
		mav.addObject("Atividade", Atividade);
		mav.addObject("listDisciplina", getDisciplinaMB().listarDisciplinaAtivo(new Disciplina()));
		return mav;
	}
	
	

	/**
	 * metodo que eh chamado quando a a url /moto/editar/{id} eh chamado substitui-se o {id} pelo cdId da entity que sera editada
	 */
	@RequestMapping("/editar/{cdId}")
	protected ModelAndView editar(HttpServletRequest request, HttpServletResponse response, @PathVariable String cdId) {
		try {
			ModelAndView mav = new ModelAndView("Atividade/AtividadeEditar");
			mav.addObject("Atividade", getMB().recuperar(new Long(cdId)));
			mav.addObject("listDisciplina", getDisciplinaMB().listarDisciplinaAtivo(new Disciplina()));
			return mav;
		} catch (Exception e) {
			return montarPaginaMensagem(e);
		}
	}
	
	

	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	protected ModelAndView salvar(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Atividade Atividade) {
		try {
			if (Atividade.getCdId() != null && Atividade.getCdId() != 0L)
				getMB().atualizar(Atividade);
			else
				getMB().salvar(Atividade);

			ModelAndView mav = new ModelAndView("Atividade/AtividadeListar");
			mav.addObject("listAtividade", getMB().listar(new Atividade()));
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
