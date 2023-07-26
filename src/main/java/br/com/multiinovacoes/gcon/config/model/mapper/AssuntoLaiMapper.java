package br.com.multiinovacoes.gcon.config.model.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.multiinovacoes.gcon.config.model.dto.AssuntoLaiDto;
import br.com.multiinovacoes.gcon.config.model.request.AssuntoLaiRequest;
import br.com.multiinovacoes.gcon.model.AssuntoLai;

@Mapper(componentModel = "spring")
public interface AssuntoLaiMapper {
	
	
	List<AssuntoLaiDto> fromResponseList(List<AssuntoLai> list);
	
	AssuntoLaiDto toDto(AssuntoLai assunto);
	 
	@Mapping(target = "id", ignore = true)
	AssuntoLaiDto fromAssuntoLai(AssuntoLaiRequest request);
	
	AssuntoLai toAssuntoLai(AssuntoLaiDto dto);


}
