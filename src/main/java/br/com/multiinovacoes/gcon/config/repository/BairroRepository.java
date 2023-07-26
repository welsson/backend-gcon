package br.com.multiinovacoes.gcon.config.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.multiinovacoes.gcon.model.Bairro;


@Repository
public interface BairroRepository extends JpaRepository<Bairro, Long> {
	
	public List<Bairro> findByOrgaoOrderByDescricaoAsc(Long orgao);


}
