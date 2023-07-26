package br.com.multiinovacoes.gcon.config.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.multiinovacoes.gcon.config.model.dto.ManifestanteDto;
import br.com.multiinovacoes.gcon.config.model.mapper.ManifestanteMapper;
import br.com.multiinovacoes.gcon.config.repository.ManifestanteRepository;
import br.com.multiinovacoes.gcon.model.Manifestante;

@Service
@Transactional
public class ManifestanteService {
	
	
	@Autowired
	private ManifestanteRepository manifestanteRepository;
	
	@Autowired
	private ManifestanteMapper manifestanteMapper;
	
	
	public ManifestanteDto salvar(ManifestanteDto manifestanteDto) {
		Manifestante manifestante = manifestanteMapper.toManifestante(manifestanteDto);
		manifestante.setId(manifestanteRepository.getMaxId());
		manifestanteRepository.save(manifestante);
		return manifestanteMapper.toDto(manifestante);
		
	}

}
