package br.com.multiinovacoes.gcon.config.model.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.com.multiinovacoes.gcon.config.model.dto.RespostaParcialDto;
import br.com.multiinovacoes.gcon.model.RespostaParcial;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RespostaParcialMapper {
	
	
	List<RespostaParcialDto> fromResponseList(List<RespostaParcial> list);
	
	RespostaParcialDto toDto(RespostaParcial respostaParcial);
	
	@Mapping(target = "orgao", ignore = true)
	@Mapping(target = "codigoAtendimento", ignore = true)
	@Mapping(target = "cancelado", ignore = true)
	@Mapping(target = "anoAtendimento", ignore = true)
	@Mapping(target = "status", ignore = true)
	@Mapping(target = "descricaoRespostaHTML", ignore = true)
	@Mapping(target = "modeloDocumento", ignore = true)
	@Mapping(target = "emailEnviado", ignore = true)
	@Mapping(target = "dataResposta", ignore = true)
	@Mapping(target = "formaEnvio", ignore = true)
	@Mapping(target = "descricaoFormaEnvio", ignore = true)
	RespostaParcial toRespostaParcial(RespostaParcialDto dto);


}
