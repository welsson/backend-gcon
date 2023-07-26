package br.com.multiinovacoes.gcon.config.controller;

import static br.com.multiinovacoes.gcon.config.controller.SetorLaiController.SETOR_LAI;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.multiinovacoes.gcon.config.model.dto.SetorLaiDto;
import br.com.multiinovacoes.gcon.config.model.mapper.SetorLaiMapper;
import br.com.multiinovacoes.gcon.config.model.request.SetorLaiRequest;
import br.com.multiinovacoes.gcon.config.model.response.ListaSetorLaiResponse;
import br.com.multiinovacoes.gcon.config.model.response.SetorLaiResponse;
import br.com.multiinovacoes.gcon.config.repository.SetorLaiRepository;
import br.com.multiinovacoes.gcon.config.service.SetorLaiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", maxAge = 3600)
@Validated
@Api(value = "Setor", produces = APPLICATION_JSON_VALUE)
@RestController
@RequestMapping(path = SETOR_LAI	)
public class SetorLaiController {
	
	public static final String SETOR_LAI = "/setores-lai";
	public static final String LISTAR = "/listar";
	public static final String PARAMETRO = "/{codigo}";
	public static final String LISTAR_ESPECIFICO = "/listarEspecifico/{codigoAtendimento}";
	public static final String LISTAR_ESPECIFICO_ATENDIMENTO = "/listarEspecifico";
	
	@Autowired
	SetorLaiRepository setorRepository;
	
	@Autowired
	SetorLaiService setorService;
	
	@Autowired
	SetorLaiMapper setorMapper;

	
	@ApiOperation(value = "Obter lista de setores", nickname = LISTAR)
	@GetMapping(path = LISTAR, produces = APPLICATION_JSON_VALUE)
	public ListaSetorLaiResponse getListaSetores(Long orgao) {
		return new ListaSetorLaiResponse(setorService.getListaSetores(orgao));
	}

	@ApiOperation(value = "Obter lista de setores especificos sem o setor encaminhado aberto", nickname = LISTAR_ESPECIFICO_ATENDIMENTO)
	@GetMapping(path = LISTAR_ESPECIFICO_ATENDIMENTO, produces = APPLICATION_JSON_VALUE)
	public ListaSetorLaiResponse getListaSetoresSemSetorEncaminhadoAberto(Long orgao, Long atendimento) {
		return new ListaSetorLaiResponse(setorService.getListaSetores(orgao, atendimento));
	}

	@ApiOperation(value = "Obter lista de setores especificos do encaminhamento", nickname = LISTAR_ESPECIFICO)
	@GetMapping(path = LISTAR_ESPECIFICO, produces = APPLICATION_JSON_VALUE)
	public ListaSetorLaiResponse getListaSetoresEspecifico(@PathVariable Long codigoAtendimento) {
		return new ListaSetorLaiResponse(setorService.getSetoresDestino(codigoAtendimento));
	}


	@ApiOperation(value = "Obter uma setor para edição", nickname = PARAMETRO)
	@GetMapping(path = PARAMETRO, produces = APPLICATION_JSON_VALUE)
	public SetorLaiResponse getEditarSetor(@PathVariable Long codigo) {
		return new SetorLaiResponse(setorService.getSetor(codigo));
	}
	
	@ApiOperation(value = "Enviar uma setor", nickname = SETOR_LAI)
	@PostMapping(produces = APPLICATION_JSON_VALUE)
	public SetorLaiResponse salvarSetor(@Valid @RequestBody SetorLaiRequest request) {
		SetorLaiDto setorDto = setorMapper.fromSetor(request);
		return new SetorLaiResponse(setorService.salvarSetor(setorDto));
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Excluir uma setor", nickname = PARAMETRO)
	@DeleteMapping(path = PARAMETRO, produces = APPLICATION_JSON_VALUE)
	public void excluirSetor(@PathVariable Long codigo) {
		setorRepository.deleteById(codigo);
	}
	
	@ApiOperation(value = "Atualizar uma setor", nickname = PARAMETRO)
	@PutMapping(path = PARAMETRO, produces = APPLICATION_JSON_VALUE)
	public SetorLaiResponse atualizarSetor(@PathVariable Long codigo, @Valid @RequestBody SetorLaiDto request) {
		return new SetorLaiResponse(setorService.salvarSetor(request));
	}
	

	@ApiOperation(value = "Obter uma setor pelo filtro", nickname = SETOR_LAI)
	@GetMapping(produces = APPLICATION_JSON_VALUE)
	public ListaSetorLaiResponse getPesquisaSetor(@RequestParam(required = false, defaultValue = "%") String descricao, Long orgao) {
		return new ListaSetorLaiResponse(setorService.getPesquisaSetorDescricao(orgao, descricao));
	}


}
