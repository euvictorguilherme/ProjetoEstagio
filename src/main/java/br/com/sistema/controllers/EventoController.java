package br.com.sistema.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.sistema.models.Requisicao;
import br.com.sistema.repository.RequisicaoRepository;

@Controller
public class EventoController {// classe @Controller, controla todas as requests e gerencia exibição dos html's
	
	@Autowired
	private RequisicaoRepository rr;
	
	@RequestMapping(value = "/withoutPermission",method=RequestMethod.GET)// request para usuario tentando enviar requisição
	public String userPermission(){
		return "/withoutPermission";
	}
	
	@RequestMapping(value = "/cadastrarEvento",method=RequestMethod.GET)// request para usuario tentando enviar requisição
	public String form(){
		return "evento/requisicao";
	}
	
	@RequestMapping(value = "/",method=RequestMethod.GET)// request para início
	public String form2(){
		return "evento/inicio";
	}
	
	@RequestMapping(value = "/cadastrarEventoAdm",method=RequestMethod.GET)// request para levar administradores ao requisicaoAdm
	public String form3(){
		return "evento/requisicaoAdm";
	}
	
	@RequestMapping(value = "/cadastrarEventoAdm",method=RequestMethod.POST)// pega e salva os dados no Banco de dados das requisicoes de Adm's
	public String form(Requisicao req){
		
		rr.save(req);
		return "redirect:/upload";
	}
	
	@RequestMapping(value = "/cadastrarEvento",method=RequestMethod.POST)// não salva requisição, usuario sem permissão
	public String form4(Requisicao req){
		
		return "redirect:/withoutPermission";
	}
	
	
	@RequestMapping("/informacoesRequisicoes") // request que retorna todos as requisiçoes realizadas
	public ModelAndView listaEventos() {
		ModelAndView mv = new ModelAndView("envios");
		Iterable<Requisicao> requisicoes = rr.findAll();
		mv.addObject("requisicoes", requisicoes);
		return mv;
		
	}
}	
