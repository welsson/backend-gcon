package br.com.multiinovacoes.gcon.config.model.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.multiinovacoes.gcon.config.model.dto.TipoManifestanteDto;
import br.com.multiinovacoes.gcon.model.TipoManifestante;

@Mapper(componentModel = "spring")
public interface TipoManifestanteMapper {
	
	
	List<TipoManifestanteDto> fromResponseList(List<TipoManifestante> list);
	
	TipoManifestanteDto toDto(TipoManifestante tipoManifestante);
	
	@Mapping(target = "tipoDocumento", ignore = true)
	TipoManifestante toTipoManifestante(TipoManifestanteDto dto);


}
