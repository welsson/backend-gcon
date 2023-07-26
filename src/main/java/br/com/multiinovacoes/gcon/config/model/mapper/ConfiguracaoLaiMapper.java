package br.com.multiinovacoes.gcon.config.model.mapper;

import org.mapstruct.Mapper;

import br.com.multiinovacoes.gcon.config.model.dto.ConfiguracaoLaiDto;
import br.com.multiinovacoes.gcon.config.model.request.ConfiguracaoLaiRequest;
import br.com.multiinovacoes.gcon.model.ConfiguracaoLai;

@Mapper(componentModel = "spring")
public interface ConfiguracaoLaiMapper {
	
	ConfiguracaoLaiDto toDto(ConfiguracaoLai configuracao);
	
	ConfiguracaoLaiDto fromConfiguracaoLai(ConfiguracaoLaiRequest request);
	
	ConfiguracaoLai toConfiguracaoLai(ConfiguracaoLaiDto dto);


}
