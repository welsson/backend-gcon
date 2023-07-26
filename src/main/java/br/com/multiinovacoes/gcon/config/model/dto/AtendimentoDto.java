package br.com.multiinovacoes.gcon.config.model.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;


@Api
public class AtendimentoDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2426378029381142933L;
	
	
	@ApiModelProperty(value = "id do atendimento")
	private Long id;
	
	@ApiModelProperty(value = "Orgao do atendimento")
	private Long orgao;
	
	@ApiModelProperty(value = "Número do atendimento")
	private Long numeroAtendimento;

	@ApiModelProperty(value = "Número do protocolo")
	private String numeroProtocolo;
	
	@ApiModelProperty(value = "Ano de atendimento")
	private Integer anoAtendimento;
	
	@ApiModelProperty(value = "Manter sigilo do atendimento")
	private Boolean manterSigilo;
	
	@ApiModelProperty(value = "Tipo de usuário do atendimento")
	private Long tipoUsuario;
	
	@ApiModelProperty(value = "Assunto do atendimento")
	private Long assunto;

	@ApiModelProperty(value = "Nome solicitante do atendimento")
	private String nomeSolicitante;
	
	@ApiModelProperty(value = "Tipo de documento do atendimento")
	private Long tipoDocumento;
	
	@ApiModelProperty(value = "Número do documento do atendimento")
	private String numeroDocumento;
	
	@ApiModelProperty(value = "Estado civil do atendimento")
	private Integer estadoCivil;
	
	@ApiModelProperty(value = "Cep do endereço atendimento")
	private String cep;
	
	@ApiModelProperty(value = "Endereço do atendimento")
	private String endereco;
	
	@ApiModelProperty(value = "Número do endereço  do atendimento")
	private String numero;
	
	@ApiModelProperty(value = "Complemento do endereço do atendimento")
	private String complemento;
	
	@ApiModelProperty(value = "Ud do endereço do atendimento")
	private String uf;
	
	@ApiModelProperty(value = "Bairro do endereço do atendimento")
	private String bairro;
	
	@ApiModelProperty(value = "Municipio do endereço do atendimento")
	private String municipio;
	
	@ApiModelProperty(value = "Email do atendimento")
	private String email;
	
	@ApiModelProperty(value = "DDD fone do atendimento")
	private String dddFone;
	
	@ApiModelProperty(value = "Fone do atendimento")
	private String fone;
	
	@ApiModelProperty(value = "DDD celular do atendimento")
	private String dddCelular;
	
	@ApiModelProperty(value = "Fone celular do atendimento")
	private String foneCelular;
	
	@ApiModelProperty(value = "Data de entrada do atendimento")
	private LocalDate dataEntrada;
	
	@ApiModelProperty(value = "Origem manifestação do atendimento")
	private Long origemManifestacao;
	
	@ApiModelProperty(value = "Descrição do atendimento")
	private String descricao;
	
	@ApiModelProperty(value = "Descrição oque do atendimento")
	private String descricaoOque;
	
	@ApiModelProperty(value = "Natureza do atendimento")
	private Long natureza;
	
	@ApiModelProperty(value = "Protocolo de origem do atendimento")
	private String protocoloOrigem;
	
	@ApiModelProperty(value = "Senha de acesso do atendimento")
	private String senhaManifestante;

	@ApiModelProperty(value = "Identifica se a manifestação e anonima ou identificada")
	private String identificado;
	
	@ApiModelProperty(value = "Pega a logomarca do órgão")
	private String logotipo;
	
	@ApiModelProperty(value = "Sequencial Orgao")
	private Long sequencialOrgao;
	
	@ApiModelProperty(value = "Modalidade de ensino")
	private Integer modalidadeEnsino;
	
	@ApiModelProperty(value = "Bairro de ocorrência")
	private Integer bairroOcorrencia;

	public Long getAssunto() {
		return assunto;
	}

	public void setAssunto(Long assunto) {
		this.assunto = assunto;
	}

	public Integer getBairroOcorrencia() {
		return bairroOcorrencia;
	}

	public void setBairroOcorrencia(Integer bairroOcorrencia) {
		this.bairroOcorrencia = bairroOcorrencia;
	}

	public Integer getModalidadeEnsino() {
		return modalidadeEnsino;
	}

	public void setModalidadeEnsino(Integer modalidadeEnsino) {
		this.modalidadeEnsino = modalidadeEnsino;
	}

	public Long getSequencialOrgao() {
		return sequencialOrgao;
	}

	public void setSequencialOrgao(Long sequencialOrgao) {
		this.sequencialOrgao = sequencialOrgao;
	}

	private List<ListaAnexoDto> listaAnexoDto;

	public List<ListaAnexoDto> getListaAnexoDto() {
		return listaAnexoDto;
	}

	public void setListaAnexoDto(List<ListaAnexoDto> listaAnexoDto) {
		this.listaAnexoDto = listaAnexoDto;
	}

	public String getLogotipo() {
		return logotipo;
	}

	public void setLogotipo(String logotipo) {
		this.logotipo = logotipo;
	}

	public String getIdentificado() {
		return identificado;
	}

	public void setIdentificado(String identificado) {
		this.identificado = identificado;
	}

	public String getProtocoloOrigem() {
		return protocoloOrigem;
	}

	public void setProtocoloOrigem(String protocoloOrigem) {
		this.protocoloOrigem = protocoloOrigem;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getNumeroAtendimento() {
		return numeroAtendimento;
	}

	public void setNumeroAtendimento(Long numeroAtendimento) {
		this.numeroAtendimento = numeroAtendimento;
	}


	public Long getOrgao() {
		return orgao;
	}

	public void setOrgao(Long orgao) {
		this.orgao = orgao;
	}

	public String getNumeroProtocolo() {
		return numeroProtocolo;
	}

	public void setNumeroProtocolo(String numeroProtocolo) {
		this.numeroProtocolo = numeroProtocolo;
	}

	public Integer getAnoAtendimento() {
		return anoAtendimento;
	}

	public void setAnoAtendimento(Integer anoAtendimento) {
		this.anoAtendimento = anoAtendimento;
	}

	public Boolean getManterSigilo() {
		return manterSigilo;
	}

	public void setManterSigilo(Boolean manterSigilo) {
		this.manterSigilo = manterSigilo;
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

	public Integer getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(Integer estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDddFone() {
		return dddFone;
	}

	public void setDddFone(String dddFone) {
		this.dddFone = dddFone;
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

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Long getOrigemManifestacao() {
		return origemManifestacao;
	}

	public void setOrigemManifestacao(Long origemManifestacao) {
		this.origemManifestacao = origemManifestacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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


	public String getSenhaManifestante() {
		return senhaManifestante;
	}

	public void setSenhaManifestante(String senhaManifestante) {
		this.senhaManifestante = senhaManifestante;
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
