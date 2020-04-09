package br.ce.Nota.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.ce.Nota.mbean.NotaMBInterface;
import br.ce.Usuario.entity.Usuario;
import br.ce.Usuario.mbean.UsuarioMBInterface;
import br.ce.Atividade.entity.Atividade;
import br.ce.Atividade.mbean.AtividadeMBInterface;
import br.ce.generic.CustomApplicationContextAware;

@RestController
@RequestMapping("/Nota")
public class NotaVisualizarService {

	private NotaMBInterface getMB() {
		return (NotaMBInterface) CustomApplicationContextAware.getBean("NotaMB");
	}
	
	private AtividadeMBInterface getAtividadeMB() {
		return (AtividadeMBInterface) CustomApplicationContextAware.getBean("AtividadeMB");
	}
	private UsuarioMBInterface getUsuarioMB() {
		return (UsuarioMBInterface) CustomApplicationContextAware.getBean("UsuarioMB");
	}

	/**
	 * metodo que eh chamado quando a a url /moto/visualizar eh chamado
	 */
	@RequestMapping(value = { "/visualizar/{cdId}" })
	protected ModelAndView listar(HttpServletRequest request, HttpServletResponse response, @PathVariable String cdId) {
		ModelAndView mav = new ModelAndView("Nota/NotaVisualizar");
		mav.addObject("Nota", getMB().recuperar(new Long(cdId)));
		mav.addObject("listAtividade", getAtividadeMB().listarAtividadeAtivo(new Atividade()));
		mav.addObject("listUsuario", getUsuarioMB().listarUsuarioAtivo(new Usuario()));		
		return mav;
	}
	
}
