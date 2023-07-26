package br.com.multiinovacoes.gcon.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.multiinovacoes.gcon.model.LogoTipo;

public interface LogoTipoRepository extends JpaRepository<LogoTipo, Long> {
	
	
	public LogoTipo findByOrgao(Long orgao);
	


}
