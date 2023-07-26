package br.com.multiinovacoes.gcon.config.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.multiinovacoes.gcon.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	public Optional<Usuario> findByCpf(String cpf);
	
	public Optional<Usuario> findByEmail(String email);
	
	public Optional<Usuario> findByIdAndSenhaInformada(Long id, String senhaInformada);
	
	

}
