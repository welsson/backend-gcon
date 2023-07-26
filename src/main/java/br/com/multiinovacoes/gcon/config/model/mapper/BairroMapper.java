package br.com.multiinovacoes.gcon.config.model.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.multiinovacoes.gcon.config.model.dto.BairroDto;
import br.com.multiinovacoes.gcon.model.Bairro;

@Mapper(componentModel = "spring")
public interface BairroMapper {
	
	
	List<BairroDto> fromResponseList(List<Bairro> list);
	
	BairroDto toDto(Bairro bairro);
	
	@Mapping(target = "idRpa", ignore = true)
	@Mapping(target = "status", ignore = true)
	@Mapping(target = "orgao", ignore = true)
	Bairro toBairro(BairroDto dto);


}
