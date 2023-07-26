package br.com.multiinovacoes.gcon.config.model.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;


public class AreaLaiDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2426378029381142933L;

	@ApiModelProperty(value = "Id da área")
	private Long id;

	@ApiModelProperty(value = "Id do órgão")
	private Long orgao;

	@ApiModelProperty(value = "Descrição da área")
	private String descricao;
	
	@ApiModelProperty(value = "Status da área")
	private Integer status;
	
	@ApiModelProperty(value = "Instituição da área")
	private Long instituicao;
	
	
	public AreaLaiDto() {
	}
	
	
	public AreaLaiDto(Long id) {
		this.id = id;
	}

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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getOrgao() {
		return orgao;
	}

	public void setOrgao(Long orgao) {
		this.orgao = orgao;
	}

	public Long getInstituicao() {
		return instituicao;
	}


	public void setInstituicao(Long instituicao) {
		this.instituicao = instituicao;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AreaLaiDto other = (AreaLaiDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
