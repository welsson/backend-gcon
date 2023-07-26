package br.com.multiinovacoes.gcon.config.controller;

import static br.com.multiinovacoes.gcon.config.controller.ManifestanteController.MANIFESTANTE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.multiinovacoes.gcon.config.model.dto.ManifestanteDto;
import br.com.multiinovacoes.gcon.config.model.mapper.ManifestanteMapper;
import br.com.multiinovacoes.gcon.config.model.request.ManifestanteRequest;
import br.com.multiinovacoes.gcon.config.model.response.ManifestanteResponse;
import br.com.multiinovacoes.gcon.config.repository.ManifestanteRepository;
import br.com.multiinovacoes.gcon.config.service.ManifestanteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", maxAge = 3600)
@Validated
@Api(value = "Manifestante", produces = APPLICATION_JSON_VALUE)
@RestController
@RequestMapping(path = MANIFESTANTE	)
public class ManifestanteController {
	
	public static final String MANIFESTANTE = "/manifestante";
	public static final String EDITAR = "/editar";
	
	@Autowired
	ManifestanteMapper manifestanteMapper;
	
	@Autowired
	ManifestanteService manifestanteService;
	
	@Autowired
	ManifestanteRepository manifestanteRepository;
	
	
	@ApiOperation(value = "Cadastrar uma manifestante")
	@PostMapping(produces = APPLICATION_JSON_VALUE)
	public ManifestanteResponse  salvarAtendimento(@Valid @RequestBody ManifestanteRequest request) throws Exception{
		ManifestanteDto manifestanteDto = manifestanteMapper.fromManifestante(request);
		return new ManifestanteResponse(manifestanteService.salvar(manifestanteDto));
	}
	
	@ApiOperation(value = "Obter o manifestante", nickname = EDITAR)
	@GetMapping(path = EDITAR, produces = APPLICATION_JSON_VALUE)
	public ManifestanteResponse getEditar(Long id) {
		return new ManifestanteResponse(manifestanteMapper.toDto(manifestanteRepository.getById(id)));
	}
	

}
