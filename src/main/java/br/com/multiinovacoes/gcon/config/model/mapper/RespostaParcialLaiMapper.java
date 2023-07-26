package br.com.multiinovacoes.gcon.config.model.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.multiinovacoes.gcon.config.model.dto.RespostaParcialLaiDto;
import br.com.multiinovacoes.gcon.config.model.request.RespostaParcialLaiRequest;
import br.com.multiinovacoes.gcon.model.RespostaParcialLai;

@Mapper(componentModel = "spring")
public interface RespostaParcialLaiMapper {
	
	
	List<RespostaParcialLaiDto> fromResponseList(List<RespostaParcialLai> list);
	
	RespostaParcialLaiDto toDto(RespostaParcialLai respostaParcial);
	
	@Mapping(target = "descricaoFormaEnvio", ignore = true)
	@Mapping(target = "descricaoRespostaHTML", ignore = true)
	RespostaParcialLaiDto fromRespostaParcial(RespostaParcialLaiRequest request);   
	
	@Mapping(target = "usuario", ignore = true)
	RespostaParcialLai toRespostaParcial(RespostaParcialLaiDto dto);


}
