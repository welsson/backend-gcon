package br.com.multiinovacoes.gcon.config.model.request;

import java.time.LocalDate;
import java.util.List;

import br.com.multiinovacoes.gcon.model.Usuario;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class DespachoRequest  {

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

	@ApiModelProperty(value = "Descrição do Despacho")	
	private String descricao;
	
	private Boolean copiaDirigente;

	@ApiModelProperty(value = "Data do despacho")	
	private LocalDate dataDespacho;

	@ApiModelProperty(value = "Email do despacho")	
	private String emailEnviado;

	@ApiModelProperty(value = "Usuario do despacho")	
	private Usuario usuario;

	@ApiModelProperty(value = "Status do despacho")	
	private Integer status;
	
    private List<Long>selectedAnexos;	

	public List<Long> getSelectedAnexos() {
		return selectedAnexos;
	}

	public void setSelectedAnexos(List<Long> selectedAnexos) {
		this.selectedAnexos = selectedAnexos;
	}
	
	public Long getSetorOrigem() {
		return setorOrigem;
	}

	public void setSetorOrigem(Long setorOrigem) {
		this.setorOrigem = setorOrigem;
	}

	public Boolean getCopiaDirigente() {
		return copiaDirigente;
	}

	public void setCopiaDirigente(Boolean copiaDirigente) {
		this.copiaDirigente = copiaDirigente;
	}

	public void setSetorDestino(Long setorDestino) {
		this.setorDestino = setorDestino;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	
	public LocalDate getDataDespacho() {
		return dataDespacho;
	}


	public void setDataDespacho(LocalDate dataDespacho) {
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
		DespachoRequest other = (DespachoRequest) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
