package br.com.multiinovacoes.gcon.config.model.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.multiinovacoes.gcon.config.model.dto.AnexoLaiDto;
import br.com.multiinovacoes.gcon.config.model.request.AnexoLaiRequest;
import br.com.multiinovacoes.gcon.model.AnexoLai;

@Mapper(componentModel = "spring")
public interface AnexoLaiMapper {
	
	
	List<AnexoLaiDto> fromResponseList(List<AnexoLai> list);
	
	AnexoLaiDto toDto(AnexoLai anexo);
	 
	AnexoLaiDto fromAnexo(AnexoLaiRequest request);
	
	@Mapping(target = "dataAnexo", ignore = true)
	AnexoLai toAnexo(AnexoLaiDto dto);


}
