package br.com.multiinovacoes.gcon.config.model.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.multiinovacoes.gcon.config.model.dto.FeriadoDto;
import br.com.multiinovacoes.gcon.config.model.request.FeriadoRequest;
import br.com.multiinovacoes.gcon.model.Feriado;

@Mapper(componentModel = "spring")
public interface FeriadoMapper {
	
	
	List<FeriadoDto> fromResponseList(List<Feriado> list);
	
	@Mapping(target = "status", ignore = true)
	FeriadoDto toDto(Feriado feriado);
	
	@Mapping(target = "id", ignore = true)
	FeriadoDto fromFeriado(FeriadoRequest request);
	
	@Mapping(target = "usuario", ignore = true)
	Feriado toFeriado(FeriadoDto dto);


}
