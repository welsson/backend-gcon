package br.com.multiinovacoes.gcon.config.model.dto;

import io.swagger.annotations.ApiModelProperty;

public class BairroDto {
	
	@ApiModelProperty(value = "Id do Bairro")	
	private Long id;

	@ApiModelProperty(value = "Descrição do Bairro")
	private String descricao;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
