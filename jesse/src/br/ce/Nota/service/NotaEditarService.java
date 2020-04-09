package br.ce.Nota.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.ce.Nota.entity.Nota;
import br.ce.Nota.mbean.NotaMBInterface;
import br.ce.Atividade.entity.Atividade;
import br.ce.Atividade.mbean.AtividadeMBInterface;
import br.ce.Usuario.entity.Usuario;
import br.ce.Usuario.mbean.UsuarioMBInterface;
import br.ce.generic.CustomApplicationContextAware;


@RestController
@RequestMapping("/Nota")
public class NotaEditarService {
	private NotaMBInterface getMB() {
		return (NotaMBInterface) CustomApplicationContextAware.getBean("NotaMB");
	}
	
	private AtividadeMBInterface getAtividadeMB() {
		return (AtividadeMBInterface) CustomApplicationContextAware.getBean("AtividadeMB");
	}

	private UsuarioMBInterface getUsuarioMB() {
		return (UsuarioMBInterface) CustomApplicationContextAware.getBean("UsuarioMB");
	}
	
	@RequestMapping("/novo")
	protected ModelAndView novo(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("Nota/NotaEditar");
		Nota Nota = new Nota();
		mav.addObject("Nota", Nota);
		mav.addObject("listAtividade", getAtividadeMB().listarAtividadeAtivo(new Atividade()));
		mav.addObject("listUsuario", getUsuarioMB().listarUsuarioAtivo(new Usuario()));
		return mav;
	}
	
	

	
	@RequestMapping("/editar/{cdId}")
	protected ModelAndView editar(HttpServletRequest request, HttpServletResponse response, @PathVariable String cdId) {
		try {
			ModelAndView mav = new ModelAndView("Nota/NotaEditar");
			mav.addObject("Nota", getMB().recuperar(new Long(cdId)));
			mav.addObject("listAtividade", getAtividadeMB().listarAtividadeAtivo(new Atividade()));
			mav.addObject("listUsuario", getUsuarioMB().listarUsuarioAtivo(new Usuario()));
			return mav;
		} catch (Exception e) {
			return montarPaginaMensagem(e);
		}
	}
	
	

	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	protected ModelAndView salvar(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Nota Nota) {
		try {
			if (Nota.getCdId() != null && Nota.getCdId() != 0L)
				getMB().atualizar(Nota);
			else
				getMB().salvar(Nota);

			ModelAndView mav = new ModelAndView("Nota/NotaListar");
			mav.addObject("listNota", getMB().listar(new Nota()));
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
