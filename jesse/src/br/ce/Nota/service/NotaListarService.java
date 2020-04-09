package br.ce.Nota.service;

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

import br.ce.Nota.entity.Nota;
import br.ce.Nota.mbean.NotaMBInterface;
import br.ce.Usuario.entity.Usuario;
import br.ce.Usuario.mbean.UsuarioMBInterface;
import br.ce.Login.service.JSPSecurity;
import br.ce.Atividade.entity.Atividade;
import br.ce.Atividade.mbean.AtividadeMBInterface;
import br.ce.generic.CustomApplicationContextAware;


@RestController
@RequestMapping("/Nota")
public class NotaListarService {

	private NotaMBInterface getMB() {
		return (NotaMBInterface) CustomApplicationContextAware.getBean("NotaMB");
	}
	
	private AtividadeMBInterface getAtividadeMB() {
		return (AtividadeMBInterface) CustomApplicationContextAware.getBean("AtividadeMB");
	}
	private UsuarioMBInterface getUsuarioMB() {
		return (UsuarioMBInterface) CustomApplicationContextAware.getBean("UsuarioMB");
	}

	
	@RequestMapping(value = { "/", "" })
	protected ModelAndView listar(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		ModelAndView mav = JSPSecurity.autenticar(session);
		
		if (mav!= null){
			
			return mav;
			
		}
		
		mav = new ModelAndView("Nota/NotaListar");
		mav.addObject("listNota", getMB().listar(new Nota()));
		mav.addObject("filtro", new Nota());
		mav.addObject("listAtividade", getAtividadeMB().listarAtividadeAtivo(new Atividade()));
		mav.addObject("listUsuario", getUsuarioMB().listarUsuarioAtivo(new Usuario()));
		return mav;
	}


	@RequestMapping(value = { "/pesquisar", "/pesquisar/" })
	protected ModelAndView pesquisar(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Nota Nota) throws ServletException, IOException {
		ModelAndView mav = new ModelAndView("Nota/NotaListar");
		mav.addObject("listNota", getMB().listar(Nota));
		mav.addObject("filtro", Nota);
		return mav;
	}
	
	@RequestMapping(value = { "/excluir/{cdId}" })
	protected ModelAndView pesquisar(HttpServletRequest request, HttpServletResponse response, @PathVariable String cdId) throws ServletException, IOException {
		getMB().excluir(new Long(cdId));
		ModelAndView mav = new ModelAndView("Nota/NotaListar");
		mav.addObject("listNota", getMB().listar(new Nota()));
		mav.addObject("filtro", new Nota());
		return mav;
	}
}
