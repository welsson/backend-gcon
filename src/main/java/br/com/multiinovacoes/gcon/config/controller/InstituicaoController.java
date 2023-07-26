package br.com.multiinovacoes.gcon.config.controller;

import static br.com.multiinovacoes.gcon.config.controller.InstituicaoController.INSTITUICAO;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import br.com.multiinovacoes.gcon.config.model.dto.InstituicaoDto;
import br.com.multiinovacoes.gcon.config.model.mapper.InstituicaoMapper;
import br.com.multiinovacoes.gcon.config.model.request.InstituicaoRequest;
import br.com.multiinovacoes.gcon.config.model.response.InstituicaoResponse;
import br.com.multiinovacoes.gcon.config.model.response.ListaInstituicaoResponse;
import br.com.multiinovacoes.gcon.config.repository.InstituicaoRepository;
import br.com.multiinovacoes.gcon.config.service.InstituicaoService;
import br.com.multiinovacoes.gcon.security.GconSecurity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", maxAge = 3600)
@Validated
@Api(value = "Instituição", produces = APPLICATION_JSON_VALUE)
@RestController
@RequestMapping(path = INSTITUICAO	)
public class InstituicaoController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(InstituicaoController.class);
	
	public static final String INSTITUICAO = "/instituicao";
	public static final String LISTAR = "/listar";
	public static final String PARAMETRO = "/{codigo}";

	
	@Autowired
	InstituicaoRepository instituicaoRepository;
	
	@Autowired
	InstituicaoService instituicaoService;
	
	@Autowired
	InstituicaoMapper instituicaoMapper;
	
	@Autowired
	GconSecurity gconSecurity;
	
	@ApiOperation(value = "Obter lista de instituicão", nickname = LISTAR)
	@GetMapping(path = LISTAR, produces = APPLICATION_JSON_VALUE)
	public ListaInstituicaoResponse getListaInstituicoes() {
		return new ListaInstituicaoResponse(instituicaoService.getListaInstituicoes(gconSecurity.getOrgao()));
	}
	
	@ApiOperation(value = "Obter uma instituicão para edição", nickname = PARAMETRO)
	@GetMapping(path = PARAMETRO, produces = APPLICATION_JSON_VALUE)
	public InstituicaoResponse getEditarInstituicao(@PathVariable Long codigo) {
		return new InstituicaoResponse(instituicaoService.getInstituicao(codigo));
	}
	
	@ApiOperation(value = "Enviar uma instituicão", nickname = INSTITUICAO)
	@PostMapping(produces = APPLICATION_JSON_VALUE)
	public InstituicaoResponse salvarInstituicao(@Valid @RequestBody InstituicaoRequest request) {
		InstituicaoDto instituicaoDto = instituicaoMapper.fromInstituicao(request);
		return new InstituicaoResponse(instituicaoService.salvarInstituicao(instituicaoDto));
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Excluir uma instituicão", nickname = PARAMETRO)
	@DeleteMapping(path = PARAMETRO, produces = APPLICATION_JSON_VALUE)
	public void excluirInstituicao(@PathVariable Long codigo) {
		instituicaoRepository.deleteById(codigo);
	}
	
	@ApiOperation(value = "Atualizar uma instituicão", nickname = PARAMETRO)
	@PutMapping(path = PARAMETRO, produces = APPLICATION_JSON_VALUE)
	public InstituicaoResponse atualizarInstituicao(@PathVariable Long codigo, @Valid @RequestBody InstituicaoDto request) {
		return new InstituicaoResponse(instituicaoService.salvarInstituicao(request));
	}
	

	@ApiOperation(value = "Obter uma instituicão pelo filtro", nickname = INSTITUICAO)
	@GetMapping(produces = APPLICATION_JSON_VALUE)
	public ListaInstituicaoResponse getPesquisaInstituicao(@RequestParam(required = false, defaultValue = "%") String descricao) {
		return new ListaInstituicaoResponse(instituicaoService.getPesquisaInstituicaoDescricao(gconSecurity.getOrgao(), descricao));
	}


}
