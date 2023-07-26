package br.com.multiinovacoes.gcon.config.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.multiinovacoes.gcon.model.Anexo;

public interface AnexoRepository extends JpaRepository<Anexo, Long> {
	
	public List<Anexo> findByOrgaoAndAtendimento(Long orgao, Long atendimento);

	@Query("SELECT coalesce(max(a.id), 0) FROM Anexo a")
	public Long getMaxSequencialId();


}
