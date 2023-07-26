package br.com.multiinovacoes.gcon.config.model.mapper;

import org.mapstruct.Mapper;

import br.com.multiinovacoes.gcon.config.model.dto.LogoTipoDto;
import br.com.multiinovacoes.gcon.model.LogoTipo;

@Mapper(componentModel = "spring")
public interface LogoTipoMapper {
	
	LogoTipoDto toDto(LogoTipo logoTipo);
	
	
	LogoTipo toLogoTipo(LogoTipoDto dto);


}
