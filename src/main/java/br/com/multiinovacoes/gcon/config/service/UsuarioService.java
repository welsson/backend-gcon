package br.com.multiinovacoes.gcon.config.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.multiinovacoes.gcon.config.model.dto.AlterarSenhaDto;
import br.com.multiinovacoes.gcon.config.repository.RedefinicaoSenhaRepository;
import br.com.multiinovacoes.gcon.config.repository.UsuarioRepository;
import br.com.multiinovacoes.gcon.mail.Mailer;
import br.com.multiinovacoes.gcon.model.RedefinicaoSenha;
import br.com.multiinovacoes.gcon.model.Usuario;
import br.com.multiinovacoes.gcon.util.CriptografiaSenha;
import br.com.multiinovacoes.gcon.util.GeradorString;

@Transactional
@Service
public class UsuarioService {

	
	@Autowired
	private Mailer mailer;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private RedefinicaoSenhaRepository redefinicaoSenhaRepository;
	
	@Transactional
	public boolean getRedefinicaoSenha(String email) {
		 Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
		 if (usuario.isPresent()) {
			 RedefinicaoSenha redefinicaoSenha = new RedefinicaoSenha();
			 redefinicaoSenha.setCodigoUsuario(usuario.get().getId());
			 redefinicaoSenha.setDataSolicitacao(LocalDateTime.now());
			 redefinicaoSenha.setParametro(GeradorString.getRandomString());
			 redefinicaoSenha.setSenhaRedefinida(0);
			 redefinicaoSenha.setDataExpira(LocalDateTime.now().plusHours(24));
			 redefinicaoSenhaRepository.save(redefinicaoSenha);
			 
			 Map<String, Object> variaveis = new HashMap<>();
			 variaveis.put("url", "https://portalouvidoria.com.br:8501/gconweb/redefinicao-senha-lai/"+redefinicaoSenha.getParametro());
			 String template = "mail/emailredefinicaosenha";
			 mailer.enviarEmail(Arrays.asList(usuario.get().getEmail()), template, variaveis, "Sistema FIEPE", "suporte@welssoncavalcante.com.br", "Redefinição de Senha", null);
             return true;				
		 }
		 return false;
	}
	
	@Transactional
	public boolean alterarSenha(AlterarSenhaDto alterarSenha) {
		 Optional<Usuario> usuario = usuarioRepository.findByIdAndSenhaInformada(alterarSenha.getIdUsuario(), alterarSenha.getSenhaAntiga());
		 if (usuario.isPresent()) {
			 
			 usuario.get().setSenhaInformada(alterarSenha.getSenhaNova());
			 usuario.get().setSenha(CriptografiaSenha.getSenhaCodificada(alterarSenha.getSenhaNova()));
			 usuarioRepository.save(usuario.get());
			 
			 RedefinicaoSenha redefinicaoSenha = new RedefinicaoSenha();
			 redefinicaoSenha.setCodigoUsuario(usuario.get().getId());
			 redefinicaoSenha.setDataSolicitacao(LocalDateTime.now());
			 redefinicaoSenha.setParametro("");
			 redefinicaoSenha.setSenhaRedefinida(1);
			 redefinicaoSenha.setDataExpira(LocalDateTime.now());
			 redefinicaoSenhaRepository.save(redefinicaoSenha);
             return true;				
		 }
		 return false;
	}
	
	
	
}