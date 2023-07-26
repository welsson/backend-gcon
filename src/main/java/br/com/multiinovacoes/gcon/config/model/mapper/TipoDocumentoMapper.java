package br.com.multiinovacoes.gcon.config.model.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.com.multiinovacoes.gcon.config.model.dto.TipoDocumentoDto;
import br.com.multiinovacoes.gcon.model.TipoDocumento;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TipoDocumentoMapper {
	
	
	List<TipoDocumentoDto> fromResponseList(List<TipoDocumento> list);
	
	TipoDocumentoDto toDto(TipoDocumento tipoDocumento);
	
	@Mapping(target = "orgao", ignore = true)
	TipoDocumento toTipoDocumento(TipoDocumentoDto dto);


}
