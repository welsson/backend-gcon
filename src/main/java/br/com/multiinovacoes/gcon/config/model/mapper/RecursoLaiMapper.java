package br.com.multiinovacoes.gcon.config.model.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.com.multiinovacoes.gcon.config.model.dto.RecursoLaiDto;
import br.com.multiinovacoes.gcon.config.model.request.RecursoLaiRequest;
import br.com.multiinovacoes.gcon.model.RecursoLai;

@Mapper(componentModel = "spring")
public interface RecursoLaiMapper {
	

	List<RecursoLaiDto> fromResponseList(List<RecursoLai> list);
	 
	RecursoLaiDto toDto(RecursoLai area);
	 
	RecursoLai fromRecursoLai(RecursoLaiRequest request);
	
	RecursoLai toRecursoLai(RecursoLaiDto dto);   
	



}
