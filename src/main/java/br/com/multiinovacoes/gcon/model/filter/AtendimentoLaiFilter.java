package br.com.multiinovacoes.gcon.model.filter;

public class AtendimentoLaiFilter {
	
	  private String solicitante;
	  private String dataInicio;
	  private String dataFinal;
	  private Long assunto;
	  private String palavraChave;
	  private String protocolo;
	  

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Long getAssunto() {
		return assunto;
	}

	public void setAssunto(Long assunto) {
		this.assunto = assunto;
	}

	public String getPalavraChave() {
		return palavraChave;
	}

	public void setPalavraChave(String palavraChave) {
		this.palavraChave = palavraChave;
	}

	public String getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}
	  
	  
	  

}
