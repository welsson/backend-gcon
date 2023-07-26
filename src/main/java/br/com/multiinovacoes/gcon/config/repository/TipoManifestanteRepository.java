package br.com.multiinovacoes.gcon.config.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.multiinovacoes.gcon.model.TipoManifestante;

public interface TipoManifestanteRepository extends JpaRepository<TipoManifestante, Long> {
	
	public List<TipoManifestante> findByOrgaoAndStatus(Long orgao, Integer status);
	
	public TipoManifestante findByOrgaoAndIdAndStatus(Long orgao, Long idTipoManifestante, Integer status);
	
	@Query("SELECT t FROM TipoManifestante t where t.orgao = ?1 and t.status = ?2 "
			+ "and t.descricao <> 'Anônimo'")
	public List<TipoManifestante> getListaTiposManifestantesSite(Long orgao, Integer status);

}
