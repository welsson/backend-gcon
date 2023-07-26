package br.com.multiinovacoes.gcon.config.controller;

import static br.com.multiinovacoes.gcon.config.controller.DespachoController.DESPACHO;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.multiinovacoes.gcon.config.model.mapper.DespachoMapper;
import io.swagger.annotations.Api;

@CrossOrigin(origins = "*", maxAge = 3600)
@Validated
@Api(value = "Despacho", produces = APPLICATION_JSON_VALUE)
@RestController
@RequestMapping(path = DESPACHO	)
public class DespachoController {
	
	public static final String DESPACHO = "/despachos";
	public static final String LISTAR = "/listar/atendimento/{codigo}";
	public static final String PARAMETRO = "/{codigo}";

	
//	@Autowired
//	DespachoRepository despachoRepository;
	
	//@Autowired
	//DespachoService despachoService;
	
	@Autowired
	DespachoMapper despachoMapper;
	
	
//	@ApiOperation(value = "Obter lista de despachos", nickname = LISTAR)
//	@GetMapping(path = LISTAR, produces = APPLICATION_JSON_VALUE)
//	public ListaDespachoResponse getDespachos(@PathVariable Long codigo) {
//		return new ListaDespachoResponse(despachoService.getDespachos(codigo));
//	}

	
	
//	@ApiOperation(value = "Obter uma despacho para edição", nickname = PARAMETRO)
//	@GetMapping(path = PARAMETRO, produces = APPLICATION_JSON_VALUE)
//	public DespachoResponse getEditarDespacho(@PathVariable Long codigo) {
//		return new DespachoResponse(despachoService.getDespacho(codigo));
//	}
//	
//	@ApiOperation(value = "Enviar uma despacho", nickname = DESPACHO) 
//	@PostMapping(produces = APPLICATION_JSON_VALUE)
//	public void salvarDespacho(@Valid @RequestBody DespachoRequest request) {
//		despachoService.salvarDespacho(request);
//	}
//
//	@ResponseStatus(HttpStatus.NO_CONTENT)
//	@ApiOperation(value = "Excluir uma despacho", nickname = PARAMETRO)
//	@DeleteMapping(path = PARAMETRO, produces = APPLICATION_JSON_VALUE)
//	public void excluirDespacho(@PathVariable Long codigo) {
//		despachoService.excluir(codigo);
//	}


}
