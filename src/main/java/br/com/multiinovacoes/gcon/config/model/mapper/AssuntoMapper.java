package br.com.multiinovacoes.gcon.config.model.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.multiinovacoes.gcon.config.model.dto.AssuntoDto;
import br.com.multiinovacoes.gcon.model.Assunto;

@Mapper(componentModel = "spring")
public interface AssuntoMapper {
	
	
	List<AssuntoDto> fromResponseList(List<Assunto> list);
	
	AssuntoDto toDto(Assunto assunto);
	
	@Mapping(target = "area", ignore = true)
	@Mapping(target = "status", ignore = true)
	@Mapping(target = "orgao", ignore = true)
	Assunto toAssunto(AssuntoDto dto);


}
