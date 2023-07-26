package br.com.multiinovacoes.gcon.config.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.multiinovacoes.gcon.model.Atendimento;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {
	
	public List<Atendimento> findByOrgaoAndDescricaoContainingIgnoreCase(Long orgao, String descricao);
	
	public List<Atendimento> findByOrgao(Long orgao);
	
	public List<Atendimento> findByOrgaoAndNumeroDocumento(Long orgao, String numeroDocumento);
	
	public List<Atendimento> findByOrgaoAndNumeroProtocoloAndSenhaManifestante(Long orgao, String numeroProtocolo, String senhaManifestante);
	
	public List<Atendimento> findByOrgaoAndAnoAtendimentoAndSequencialOrgaoAndSenhaManifestante(Long orgao, Integer ano, Long numeroAtendimento, String senhaManifestante);
	
	@Query("SELECT coalesce(max(a.numeroAtendimento), 0) FROM Atendimento a where a.anoAtendimento = ?1")
	public Long getMaxNumeroAtendimento(Integer ano);

	@Query("SELECT coalesce(max(a.sequencialOrgao), 0) FROM Atendimento a where a.anoAtendimento = ?1 and a.orgao = ?2")
	public Long getMaxSequencialOrgao(Integer ano, Long orgao);


}
