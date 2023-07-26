package br.com.multiinovacoes.gcon.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.multiinovacoes.gcon.model.Natureza;

@Repository
public interface NaturezaRepository extends JpaRepository<Natureza, Long> {
	


}
