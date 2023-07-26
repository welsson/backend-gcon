package br.com.multiinovacoes.gcon.config.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.multiinovacoes.gcon.model.RespostaParcial;

@Repository
public interface RespostaParcialRepository extends JpaRepository<RespostaParcial, Long> {
	
	public List<RespostaParcial> findByCodigoAtendimentoAndAnoAtendimentoAndOrgao(Long codigoAtendimento, String ano, Long orgao);
	

}
