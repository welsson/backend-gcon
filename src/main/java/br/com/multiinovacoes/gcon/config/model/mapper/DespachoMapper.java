package br.com.multiinovacoes.gcon.config.model.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.multiinovacoes.gcon.config.model.dto.DespachoDto;
import br.com.multiinovacoes.gcon.config.model.request.DespachoRequest;
import br.com.multiinovacoes.gcon.model.Despacho;

@Mapper(componentModel = "spring")
public interface DespachoMapper {
	
	
	List<DespachoDto> fromResponseList(List<Despacho> list);
	
	@Mapping(target = "usuario", ignore = true)
	DespachoDto toDto(Despacho despacho);
	  
	@Mapping(target = "usuario", ignore = true)
	DespachoDto fromDespacho(DespachoRequest request); 
	
	@Mapping(target = "usuario", ignore = true)
	Despacho toDespacho(DespachoDto dto);

	

}
