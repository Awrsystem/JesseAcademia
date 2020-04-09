package br.ce.TipoCurso.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.ce.TipoCurso.entity.TipoCurso;
import br.ce.TipoCurso.mbean.TipoCursoMBInterface;
import br.ce.generic.CustomApplicationContextAware;

@RestController
@RequestMapping("/TipoCurso")
public class TipoCursoEditarService {
	private TipoCursoMBInterface getMB() {
		return (TipoCursoMBInterface) CustomApplicationContextAware.getBean("TipoCursoMB");
	}

	/**
	 * metodo que eh chamado quando a a url /moto/novo eh chamado
	 */
	@RequestMapping("/novo")
	protected ModelAndView novo(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("TipoCurso/TipoCursoEditar");
		TipoCurso TipoCurso = new TipoCurso();
		TipoCurso.setFlSituacao(true);
		mav.addObject("TipoCurso", TipoCurso);
		return mav;
	}

	/**
	 * metodo que eh chamado quando a a url /moto/editar/{id} eh chamado substitui-se o {id} pelo cdId da entity que sera editada
	 */
	@RequestMapping("/editar/{cdId}")
	protected ModelAndView editar(HttpServletRequest request, HttpServletResponse response, @PathVariable String cdId) {
		try {
			ModelAndView mav = new ModelAndView("TipoCurso/TipoCursoEditar");
			mav.addObject("TipoCurso", getMB().recuperar(new Long(cdId)));
			return mav;
		} catch (Exception e) {
			return montarPaginaMensagem(e);
		}
	}

	/**
	 * metodo que eh chamado quando a a url /moto/salvar eh chamado
	 */
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	protected ModelAndView salvar(HttpServletRequest request, HttpServletResponse response, @ModelAttribute TipoCurso TipoCurso) {
		try {
			if (TipoCurso.getCdId() != null && TipoCurso.getCdId() != 0L)
				getMB().atualizar(TipoCurso);
			else
				getMB().salvar(TipoCurso);

			ModelAndView mav = new ModelAndView("TipoCurso/TipoCursoListar");
			mav.addObject("listTipoCurso", getMB().listar(new TipoCurso()));
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