package br.com.multiinovacoes.gcon.config.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.multiinovacoes.gcon.model.Setor;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Long> {

	public List<Setor> findByOrgaoAndDescricaoContainingIgnoreCaseOrderByDescricaoAsc(Long orgao, String descricao);

	public List<Setor> findByOrgaoAndStatusAndIdNotInOrderByDescricaoAsc(Long orgao, Integer status, List<Long> idList);

	public List<Setor> findByIdInOrderByDescricaoAsc(List<Long> idList);
	
	public List<Setor> findByOrgaoOrderByDescricaoAsc(Long orgao);
	
	public List<Setor> findByOrgaoAndStatusOrderByDescricaoAsc(Long orgao, Integer status);


}
