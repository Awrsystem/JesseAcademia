package br.ce.Perfil.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.ce.Perfil.entity.Perfil;
import br.ce.Perfil.mbean.PerfilMBInterface;
import br.ce.generic.CustomApplicationContextAware;


@RestController
@RequestMapping("/Perfil")
public class PerfilEditarService {
	private PerfilMBInterface getMB() {
		return (PerfilMBInterface) CustomApplicationContextAware.getBean("PerfilMB");
	}

	/**
	 * metodo que eh chamado quando a a url /moto/novo eh chamado
	 */
	@RequestMapping("/novo")
	protected ModelAndView novo(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("Perfil/PerfilEditar");
		Perfil perfil = new Perfil();
		perfil.setFlSituacao(true);
		mav.addObject("perfil", perfil);
		return mav;
	}

	/**
	 * metodo que eh chamado quando a a url /moto/editar/{id} eh chamado substitui-se o {id} pelo cdId da entity que sera editada
	 */
	@RequestMapping("/editar/{cdId}")
	protected ModelAndView editar(HttpServletRequest request, HttpServletResponse response, @PathVariable String cdId) {
		try {
			ModelAndView mav = new ModelAndView("Perfil/PerfilEditar");
			mav.addObject("Perfil", getMB().recuperar(new Long(cdId)));
			return mav;
		} catch (Exception e) {
			return montarPaginaMensagem(e);
		}
	}

	/**
	 * metodo que eh chamado quando a a url /moto/salvar eh chamado
	 */
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	protected ModelAndView salvar(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Perfil Perfil) {
		try {
			if (Perfil.getCdId() != null && Perfil.getCdId() != 0L)
				getMB().atualizar(Perfil);
			else
				getMB().salvar(Perfil);

			ModelAndView mav = new ModelAndView("Perfil/PerfilListar");
			mav.addObject("listPerfil", getMB().listar(new Perfil()));
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
