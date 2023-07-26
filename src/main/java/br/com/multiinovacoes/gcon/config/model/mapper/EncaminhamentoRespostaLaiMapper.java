package br.com.multiinovacoes.gcon.config.model.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.com.multiinovacoes.gcon.config.model.dto.EncaminhamentoRespostaLaiDto;
import br.com.multiinovacoes.gcon.config.model.request.EncaminhamentoRespostaLaiRequest;
import br.com.multiinovacoes.gcon.model.EncaminhamentoRespostaLai;

@Mapper(componentModel = "spring")
public interface EncaminhamentoRespostaLaiMapper {
	
	
	List<EncaminhamentoRespostaLaiDto> fromResponseList(List<EncaminhamentoRespostaLaiDto> list);
	
	EncaminhamentoRespostaLaiDto toDto(EncaminhamentoRespostaLai encaminhamento); 
	
	EncaminhamentoRespostaLaiDto fromEncaminhamentoRespostaLai(EncaminhamentoRespostaLaiRequest request);   
	
	EncaminhamentoRespostaLai toEncaminhamentoLai(EncaminhamentoRespostaLaiDto dto);


}
