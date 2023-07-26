package br.com.multiinovacoes.gcon.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.multiinovacoes.gcon.model.Manifestante;

public interface ManifestanteRepository extends JpaRepository<Manifestante, Long> {
	
	public Manifestante findByNumeroDocumentoAndSenha(String numeroDocumento, String senha);
	
	@Query("SELECT coalesce(max(m.id), 0) FROM Manifestante m")
	public Long getMaxId();


}
