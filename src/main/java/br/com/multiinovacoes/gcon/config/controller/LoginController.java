package br.com.multiinovacoes.gcon.config.controller;

import static br.com.multiinovacoes.gcon.config.controller.LoginController.LOGIN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.multiinovacoes.gcon.config.model.dto.AlterarSenhaDto;
import br.com.multiinovacoes.gcon.config.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", maxAge = 3600)
@Validated
@Api(value = "Login", produces = APPLICATION_JSON_VALUE)
@RestController
@RequestMapping(path = LOGIN	)
public class LoginController {
	
	public static final String LOGIN = "/login";
	public static final String ESQUECEU_SENHA = "/esqueceu-senha";
	public static final String ALTERAR_SENHA = "/alterar-senha";
	
	@Autowired
	private UsuarioService usuarioService;

	
	@ApiOperation(value = "Enviar uma atendimento", nickname = ESQUECEU_SENHA)
	@PostMapping(path = ESQUECEU_SENHA, produces = APPLICATION_JSON_VALUE)
	public Boolean esqueceuSenha(@RequestBody String email) {
		 boolean retorno = usuarioService.getRedefinicaoSenha(email);
		 return retorno; 
	}
	
	@ApiOperation(value = "Alterar Senha", nickname = ALTERAR_SENHA)
	@PostMapping(path = ALTERAR_SENHA, produces = APPLICATION_JSON_VALUE)
	public Boolean alterarSenha(@RequestBody AlterarSenhaDto alterarSenha) {
		 boolean retorno = usuarioService.alterarSenha(alterarSenha);
		 return retorno; 
	}


}
