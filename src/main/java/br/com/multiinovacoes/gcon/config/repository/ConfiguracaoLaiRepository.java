package br.com.multiinovacoes.gcon.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.multiinovacoes.gcon.model.ConfiguracaoLai;

public interface ConfiguracaoLaiRepository extends JpaRepository<ConfiguracaoLai, Long> {
	
	public ConfiguracaoLai findByOrgao(Long orgao);


}
