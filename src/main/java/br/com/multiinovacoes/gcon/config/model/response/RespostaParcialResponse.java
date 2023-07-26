package br.com.multiinovacoes.gcon.config.model.response;

import br.com.multiinovacoes.gcon.config.model.dto.RespostaParcialLaiDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Resposta Parcial Lai Response")
public class RespostaParcialResponse {
	
	@ApiModelProperty(value = "Resposta Parcial Dto")
	private RespostaParcialLaiDto respostaParcialLaiDto;
	
	public RespostaParcialResponse(RespostaParcialLaiDto respostaParcialLaiDto) {
		this.respostaParcialLaiDto = respostaParcialLaiDto;
	}



	public RespostaParcialLaiDto getRespostaParcialLaiDto() {
		return respostaParcialLaiDto;
	}



	public void setRespostaParcialLaiDto(RespostaParcialLaiDto respostaParcialLaiDto) {
		this.respostaParcialLaiDto = respostaParcialLaiDto;
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
