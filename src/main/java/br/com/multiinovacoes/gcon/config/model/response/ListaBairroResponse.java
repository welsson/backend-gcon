package br.com.multiinovacoes.gcon.config.model.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import br.com.multiinovacoes.gcon.config.model.dto.BairroDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude
@ApiModel("Lista Bairro Response")
public class ListaBairroResponse {
	
	@ApiModelProperty(value = "Lista de Bairros")
	private List<BairroDto> bairroDtoList;
	
	public ListaBairroResponse(List<BairroDto> bairroDtoList) {
		this.bairroDtoList = bairroDtoList;
	}


	public List<BairroDto> getBairroDtoList() {
		return bairroDtoList;
	}


	public void setBairroDtoList(List<BairroDto> bairroDtoList) {
		this.bairroDtoList = bairroDtoList;
	}


	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	


}
