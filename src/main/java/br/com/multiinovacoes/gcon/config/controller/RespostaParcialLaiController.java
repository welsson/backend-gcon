package br.com.multiinovacoes.gcon.config.controller;

import static br.com.multiinovacoes.gcon.config.controller.RespostaParcialLaiController.RESPOSTA_PARCIAL_LAI;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.multiinovacoes.gcon.config.model.mapper.RespostaParcialLaiMapper;
import br.com.multiinovacoes.gcon.config.model.request.RespostaParcialLaiRequest;
import br.com.multiinovacoes.gcon.config.model.response.ListaRespostaParcialResponse;
import br.com.multiinovacoes.gcon.config.model.response.RespostaParcialResponse;
import br.com.multiinovacoes.gcon.config.repository.RespostaParcialLaiRepository;
import br.com.multiinovacoes.gcon.config.service.RespostaParcialLaiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", maxAge = 3600)
@Validated
@Api(value = "Resposta Parcial Lai", produces = APPLICATION_JSON_VALUE)
@RestController
@RequestMapping(path = RESPOSTA_PARCIAL_LAI	)
public class RespostaParcialLaiController {
	
	public static final String RESPOSTA_PARCIAL_LAI = "/resposta-parcial-lai";
	public static final String LISTAR = "/listar/atendimento/{codigo}";
	public static final String PARAMETRO = "/{codigo}";

	
	@Autowired
	RespostaParcialLaiRepository respostaParcialRepository;
	
	@Autowired
	RespostaParcialLaiService respostaParcialService;
	
	@Autowired
	RespostaParcialLaiMapper respostaParcialMapper;
	
	@ApiOperation(value = "Obter lista de respostas parciais", nickname = LISTAR)
	@GetMapping(path = LISTAR, produces = APPLICATION_JSON_VALUE)
	public ListaRespostaParcialResponse getRespostasParciais(@PathVariable Long codigo) {
		return new ListaRespostaParcialResponse(respostaParcialService.getRespostaParcials(codigo));
	}

	@ApiOperation(value = "Obter uma respostaParcial para edição", nickname = PARAMETRO)
	@GetMapping(path = PARAMETRO, produces = APPLICATION_JSON_VALUE)
	public RespostaParcialResponse getEditarRespostaParcial(@PathVariable Long codigo) {
		return new RespostaParcialResponse(respostaParcialService.getRespostaParcial(codigo));
	}
	
	@ApiOperation(value = "Enviar uma respostaParcial", nickname = RESPOSTA_PARCIAL_LAI) 
	@PostMapping(produces = APPLICATION_JSON_VALUE)
	public void salvarRespostaParcial(@Valid @RequestBody RespostaParcialLaiRequest request) {
		respostaParcialService.salvarRespostaParcial(request);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Excluir uma respostaParcial", nickname = PARAMETRO)
	@DeleteMapping(path = PARAMETRO, produces = APPLICATION_JSON_VALUE)
	public void excluirRespostaParcial(@PathVariable Long codigo) {
		respostaParcialService.excluir(codigo);
	}


}
