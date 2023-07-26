package br.com.multiinovacoes.gcon.config.model.request;


import java.util.List;

import javax.validation.constraints.NotNull;

import br.com.multiinovacoes.gcon.config.model.dto.ListaAnexoDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;


@Api
public class AtendimentoRequestPrefeitura {

	
	@ApiModelProperty(value = "Tipo de usuário do atendimento")
	private Long tipoUsuario;

	@ApiModelProperty(value = "Nome solicitante do atendimento")
	private String nomeSolicitante;
	
	@ApiModelProperty(value = "Tipo de documento do atendimento")
	private Long tipoDocumento;
	
	@ApiModelProperty(value = "Número do documento do atendimento")
	private String numeroDocumento;
	
	@ApiModelProperty(value = "Email do atendimento")
	private String email;

	@ApiModelProperty(value = "DDD do atendimento")
	private String ddd;
	
	@ApiModelProperty(value = "Fone do atendimento")
	private String fone;

	@ApiModelProperty(value = "DDD celular do atendimento")
	private String dddCelular;
	
	@ApiModelProperty(value = "Fone celular do atendimento")
	private String foneCelular;

	@NotNull
	@ApiModelProperty(value = "Descrição oque do atendimento")
	private String descricaoOque;

	@NotNull
	@ApiModelProperty(value = "Natureza do atendimento")
	private Long natureza;

	@NotNull
	@ApiModelProperty(value = "Assunto do atendimento")
	private Long assunto;

	@ApiModelProperty(value = "Protocolo de origem do atendimento")
	private String protocoloOrigem;

	@NotNull
	@ApiModelProperty(value = "Orgao do atendimento")
	private Long orgao;

	@NotNull
	@ApiModelProperty(value = "Bairro ocorrencia do atendimento")
	private Long bairroOcorrencia;
	
	@NotNull
	@ApiModelProperty(value = "Identificação do manifestante")
	private String identificado;
	
	@ApiModelProperty(value = "Lista de anexos")
	private List<ListaAnexoDto> listaAnexoDto;

	public List<ListaAnexoDto> getListaAnexoDto() {
		return listaAnexoDto;
	}

	public void setListaAnexoDto(List<ListaAnexoDto> listaAnexoDto) {
		this.listaAnexoDto = listaAnexoDto;
	}


	public Long getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(Long tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getNomeSolicitante() {
		return nomeSolicitante;
	}

	public void setNomeSolicitante(String nomeSolicitante) {
		this.nomeSolicitante = nomeSolicitante;
	}

	public Long getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(Long tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getDddCelular() {
		return dddCelular;
	}

	public void setDddCelular(String dddCelular) {
		this.dddCelular = dddCelular;
	}

	public String getFoneCelular() {
		return foneCelular;
	}

	public void setFoneCelular(String foneCelular) {
		this.foneCelular = foneCelular;
	}

	public String getDescricaoOque() {
		return descricaoOque;
	}

	public void setDescricaoOque(String descricaoOque) {
		this.descricaoOque = descricaoOque;
	}

	public Long getNatureza() {
		return natureza;
	}

	public void setNatureza(Long natureza) {
		this.natureza = natureza;
	}

	public Long getAssunto() {
		return assunto;
	}

	public void setAssunto(Long assunto) {
		this.assunto = assunto;
	}

	public String getProtocoloOrigem() {
		return protocoloOrigem;
	}

	public void setProtocoloOrigem(String protocoloOrigem) {
		this.protocoloOrigem = protocoloOrigem;
	}

	public Long getOrgao() {
		return orgao;
	}

	public void setOrgao(Long orgao) {
		this.orgao = orgao;
	}

	public Long getBairroOcorrencia() {
		return bairroOcorrencia;
	}

	public void setBairroOcorrencia(Long bairroOcorrencia) {
		this.bairroOcorrencia = bairroOcorrencia;
	}

	public String getIdentificado() {
		return identificado;
	}

	public void setIdentificado(String identificado) {
		this.identificado = identificado;
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
