package br.com.multiinovacoes.gcon.config.model.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.com.multiinovacoes.gcon.config.model.dto.DespachoLaiDto;
import br.com.multiinovacoes.gcon.config.model.request.DespachoLaiRequest;
import br.com.multiinovacoes.gcon.model.DespachoLai;

@Mapper(componentModel = "spring")
public interface DespachoLaiMapper {
	
	
	List<DespachoLaiDto> fromResponseList(List<DespachoLai> list);
	
	DespachoLaiDto toDto(DespachoLai despachoLai);
	  
	DespachoLaiDto fromDespachoLai(DespachoLaiRequest request); 
	
	DespachoLai toDespachoLai(DespachoLaiDto dto);

	

}
