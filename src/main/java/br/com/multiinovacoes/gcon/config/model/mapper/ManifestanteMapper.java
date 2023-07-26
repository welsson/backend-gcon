package br.com.multiinovacoes.gcon.config.model.mapper;

import org.mapstruct.Mapper;

import br.com.multiinovacoes.gcon.config.model.dto.ManifestanteDto;
import br.com.multiinovacoes.gcon.config.model.request.ManifestanteRequest;
import br.com.multiinovacoes.gcon.model.Manifestante;

@Mapper(componentModel = "spring")
public interface ManifestanteMapper {
	
	ManifestanteDto toDto(Manifestante manifestante);
	
	Manifestante toManifestante(ManifestanteDto dto);
	
	ManifestanteDto fromManifestante(ManifestanteRequest request);


}
