package br.com.multiinovacoes.gcon.config.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.multiinovacoes.gcon.model.Assunto;


@Repository
public interface AssuntoRepository extends JpaRepository<Assunto, Long> {
	
	public List<Assunto> findByOrgaoAndAreaOrderByDescricaoAsc(Long orgao, Long area);
	
	public Assunto findByOrgaoAndId(Long orgao, Long idAssunto);

}
