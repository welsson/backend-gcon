package br.com.multiinovacoes.gcon.config.model.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.multiinovacoes.gcon.config.model.dto.ModeloDocumentoLaiDto;
import br.com.multiinovacoes.gcon.config.model.request.ModeloDocumentoLaiRequest;
import br.com.multiinovacoes.gcon.model.ModeloDocumentoLai;

@Mapper(componentModel = "spring")
public interface ModeloDocumentoLaiMapper {
	
	
	List<ModeloDocumentoLaiDto> fromResponseList(List<ModeloDocumentoLai> list);
	
	ModeloDocumentoLaiDto toDto(ModeloDocumentoLai area);
	
	@Mapping(target = "id", ignore = true)
	ModeloDocumentoLaiDto fromModeloDocumento(ModeloDocumentoLaiRequest request);
	
	ModeloDocumentoLai toModeloDocumento(ModeloDocumentoLaiDto dto);


}
