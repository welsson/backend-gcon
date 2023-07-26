package br.com.multiinovacoes.gcon.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.multiinovacoes.gcon.model.Configuracao;

public interface ConfiguracaoRepository extends JpaRepository<Configuracao, Long> {
	
	public Configuracao findByOrgao(Long orgao);


}
