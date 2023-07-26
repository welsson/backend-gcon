package br.com.multiinovacoes.gcon.config.model.dto;

import java.time.LocalDateTime;

import br.com.multiinovacoes.gcon.util.RegexHtml;
import io.swagger.annotations.ApiModelProperty;


public class DespachoLaiDto  {

	@ApiModelProperty(value = "Id do despacho")	
	private Long id;
	
	@ApiModelProperty(value = "Atendimento do despacho")	
	private Long atendimento;
	
	@ApiModelProperty(value = "Setor origem do despacho")	
	private Long setorOrigem;
	
	@ApiModelProperty(value = "Setor destino do despacho")	
	private Long setorDestino;
	
	@ApiModelProperty(value = "Modelo do despacho")	
	private Long modeloDocumento;

	@ApiModelProperty(value = "Despacho")	
	private String descricao;

	@ApiModelProperty(value = "Data do despacho")	
	private LocalDateTime dataDespacho;

	@ApiModelProperty(value = "Email do despacho")	
	private String emailEnviado;

	@ApiModelProperty(value = "Usuario do despacho")	
	private Long usuario;

	@ApiModelProperty(value = "Status do despacho")	
	private Integer status;
	
	@ApiModelProperty(value = "Código encaminhamento do despacho")	
	private Long codigoEncaminhamento;
	
	@ApiModelProperty(value = "Descrição do setor de origem")
	private String descricaoSetorOrigem;

	@ApiModelProperty(value = "Descrição do setor de destino")
	private String descricaoSetorDestino;

	@ApiModelProperty(value = "Data que foi encaminhado")
	private String dataFormatada;
	
	@ApiModelProperty(value = "Descrição sem HTML da resposta parcial")	
	private String descricaoRespostaHTML;
	
	public String getDescricaoRespostaHTML() {
		if (descricao != null)
			descricaoRespostaHTML =  RegexHtml.getMather(descricao);
		return descricaoRespostaHTML;
	}

	public void setDescricaoRespostaHTML(String descricaoRespostaHTML) {
		this.descricaoRespostaHTML = descricaoRespostaHTML;
	}

	public String getDescricaoSetorOrigem() {
		return descricaoSetorOrigem;
	}

	public void setDescricaoSetorOrigem(String descricaoSetorOrigem) {
		this.descricaoSetorOrigem = descricaoSetorOrigem;
	}

	public String getDescricaoSetorDestino() {
		return descricaoSetorDestino;
	}

	public void setDescricaoSetorDestino(String descricaoSetorDestino) {
		this.descricaoSetorDestino = descricaoSetorDestino;
	}

	public String getDataFormatada() {
		return dataFormatada;
	}

	public void setDataFormatada(String dataFormatada) {
		this.dataFormatada = dataFormatada;
	}

	public Long getSetorOrigem() {
		return setorOrigem;
	}

	public void setSetorOrigem(Long setorOrigem) {
		this.setorOrigem = setorOrigem;
	}

	public Long getCodigoEncaminhamento() {
		return codigoEncaminhamento;
	}

	public void setCodigoEncaminhamento(Long codigoEncaminhamento) {
		this.codigoEncaminhamento = codigoEncaminhamento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Long getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Long atendimento) {
		this.atendimento = atendimento;
	}
	
	public Long getSetorDestino() {
		return setorDestino;
	}

	public void setSetorDestino(Long setorDestino) {
		this.setorDestino = setorDestino;
	}

	public Long getModeloDocumento() {
		return modeloDocumento;
	}

	public void setModeloDocumento(Long modeloDocumento) {
		this.modeloDocumento = modeloDocumento;
	}


	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEmailEnviado() {
		return emailEnviado;
	}

	public void setEmailEnviado(String emailEnviado) {
		this.emailEnviado = emailEnviado;
	}

	public Long getUsuario() {
		return usuario;
	}

	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}

	public LocalDateTime getDataDespacho() {
		return dataDespacho;
	}


	public void setDataDespacho(LocalDateTime dataDespacho) {
		this.dataDespacho = dataDespacho;
	}


	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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
		DespachoLaiDto other = (DespachoLaiDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
