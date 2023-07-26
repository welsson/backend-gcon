package br.com.multiinovacoes.gcon.config.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.multiinovacoes.gcon.config.model.dto.AtendimentoDto;
import br.com.multiinovacoes.gcon.config.model.dto.ListaAnexoDto;
import br.com.multiinovacoes.gcon.config.model.dto.PesquisaSatisfacaoDto;
import br.com.multiinovacoes.gcon.config.model.dto.ResumoAtendimentoDto;
import br.com.multiinovacoes.gcon.config.model.mapper.AtendimentoMapper;
import br.com.multiinovacoes.gcon.config.model.mapper.RespostaParcialMapper;
import br.com.multiinovacoes.gcon.config.model.request.PesquisaSatisfacaoRequest;
import br.com.multiinovacoes.gcon.config.repository.AnexoRepository;
import br.com.multiinovacoes.gcon.config.repository.AssuntoRepository;
import br.com.multiinovacoes.gcon.config.repository.AtendimentoRepository;
import br.com.multiinovacoes.gcon.config.repository.ConfiguracaoRepository;
import br.com.multiinovacoes.gcon.config.repository.FeriadoRepository;
import br.com.multiinovacoes.gcon.config.repository.NaturezaRepository;
import br.com.multiinovacoes.gcon.config.repository.OrgaoRepository;
import br.com.multiinovacoes.gcon.config.repository.PerguntaSatisfacaoRepository;
import br.com.multiinovacoes.gcon.config.repository.PesquisaSatisfacaoRepository;
import br.com.multiinovacoes.gcon.config.repository.RespostaParcialRepository;
import br.com.multiinovacoes.gcon.config.repository.RespostaSatisfacaoRepository;
import br.com.multiinovacoes.gcon.mail.Mailer;
import br.com.multiinovacoes.gcon.model.Anexo;
import br.com.multiinovacoes.gcon.model.Atendimento;
import br.com.multiinovacoes.gcon.model.Configuracao;
import br.com.multiinovacoes.gcon.model.Feriado;
import br.com.multiinovacoes.gcon.model.Orgao;
import br.com.multiinovacoes.gcon.model.PerguntaSatisfacao;
import br.com.multiinovacoes.gcon.model.PesquisaSatisfacao;
import br.com.multiinovacoes.gcon.model.RespostaParcial;
import br.com.multiinovacoes.gcon.model.RespostaSatisfacao;



@Service
@Transactional
public class AtendimentoService {
	
	
	@Autowired
	private AtendimentoMapper atendimentoMapper;
	
	@Autowired
	private AtendimentoRepository atendimentoRepository;
	
	@Autowired
	private ConfiguracaoRepository configuracaoRepository;
	
	@Autowired
	private FeriadoRepository feriadoRepository;
	
	@Autowired
	private AnexoRepository anexoRepository;
	
	@Autowired
	private Mailer mailer;

	@Autowired
	private RespostaParcialRepository respostaParcialRepository;
	
	@Autowired
	private PerguntaSatisfacaoRepository perguntaSatisfacaoRepository;
	
	@Autowired
	private RespostaSatisfacaoRepository respostaSatisfacaoRepository;
	
	@Autowired
	private PesquisaSatisfacaoRepository pesquisaSatisfacaoRepository;
	
	@Autowired
	private RespostaParcialMapper respostaParcialMapper;
	
	@Autowired
	private OrgaoRepository orgaoRepository;
	
	@Autowired
	private AssuntoRepository assuntoRepository;
	
	@Autowired
	private NaturezaRepository naturezaRepository; 
	
	private static final String NOME_SOLICITANTE_ANONIMO = "Anônimo";
	
	public AtendimentoDto salvarAtendimento(AtendimentoDto atendimentoDto, Integer idAplicacao) throws IOException{
		    atendimentoDto.setOrgao(atendimentoDto.getOrgao());
			Configuracao conf = configuracaoRepository.findByOrgao(atendimentoDto.getOrgao());
		    Atendimento atendimento = atendimentoMapper.toAtendimento(atendimentoDto);
		    String logo = atendimentoDto.getLogotipo();
		    Orgao orgao = orgaoRepository.getById(atendimentoDto.getOrgao());

		    
		    
		    if (atendimentoDto.getIdentificado().equals("0")) {
		    	atendimento.setNomeSolicitante(NOME_SOLICITANTE_ANONIMO);
		    	atendimento.setEndereco(NOME_SOLICITANTE_ANONIMO);
		    	atendimento.setBairro(NOME_SOLICITANTE_ANONIMO);
		    	atendimento.setMunicipio(NOME_SOLICITANTE_ANONIMO);
		    	atendimento.setComplemento(NOME_SOLICITANTE_ANONIMO);
		    	atendimento.setEmail("");
		    	atendimento.setCep("");
		    	atendimento.setNumeroDocumento("");
		    	atendimento.setNumero("");
		    	atendimento.setUf("");
		    	atendimento.setDddCelular("");
		    	atendimento.setFoneCelular("");
		    	atendimento.setProtocoloOrigem("");
		    	atendimento.setTipoDocumento("0");
		    	atendimento.setModalidadeEnsino(0);
		    	atendimento.setDataNascimento(new Timestamp(0));
		    }else {
		    	atendimento.setBairro(atendimento.getBairro() == null ? "" :atendimento.getBairro());
		    	atendimento.setMunicipio(atendimento.getMunicipio() == null ? "" : atendimento.getMunicipio());
		    	atendimento.setComplemento(atendimento.getComplemento() == null ? "" : atendimento.getComplemento());
		    	atendimento.setCep(atendimento.getCep() == null ? "" : atendimento.getCep());
		    	atendimento.setNumeroDocumento(atendimento.getNumeroDocumento() == null ? "" : atendimento.getNumeroDocumento());
		    	atendimento.setNumero(atendimento.getNumero() == null ? "" : atendimento.getNumero());
		    	atendimento.setDddCelular(atendimento.getDddCelular() == null ? "" : atendimento.getDddCelular());
		    	atendimento.setFoneCelular(atendimento.getFoneCelular() == null ? "" : atendimento.getFoneCelular());
		    	atendimento.setProtocoloOrigem(atendimento.getProtocoloOrigem() == null ? "" : atendimento.getProtocoloOrigem());
			    atendimento.setEndereco(atendimento.getEndereco() == null ? "" : atendimento.getEndereco());
			    atendimento.setUf(atendimento.getUf() == null ? "" : atendimento.getUf());
			    atendimento.setBairroOcorrencia(atendimento.getBairroOcorrencia() == null ? 0 : atendimento.getBairroOcorrencia());
		    }

	    	atendimento.setArea(51l);
		    atendimento.setStatus(0);
		    atendimento.setDescricaoSolucao("");
		    atendimento.setStatusAtendimento(0);
		    atendimento.setPriorizacao(0l);
		    atendimento.setSetor(conf.getSetor());
		    atendimento.setDataPrazo(adicionarDiasUteis(conf.getQtdDiasVencer(), atendimentoDto.getOrgao()));
		    atendimento.setDataPrazoPrevisto(adicionarDiasUteis(conf.getQtdDiasVencer(), atendimentoDto.getOrgao()));
		    atendimento.setDataQuando("");
		    atendimento.setDescricao("");
		    atendimento.setDescricaoComo("");
		    atendimento.setDescricaoFatos(atendimento.getDescricaoOque());
		    atendimento.setDescricaoOnde("");
		    atendimento.setDescricaoQuando("");
		    atendimento.setDescricaoQuem("");
		    atendimento.setTempoDuracaoAtendimento("");
		    atendimento.setEstadoCivil(0);
		    atendimento.setDddFone("");
		    atendimento.setFone("");
		    atendimento.setObservacao("");
		    atendimento.setSatisfaz(0);
		    atendimento.setResposta("");
		    atendimento.setOrigemManifestacao(3l);
		    atendimento.setCodigoAtendimentoResposta(1);
		    atendimento.setJustificativaProrrogacao("");
		    atendimento.setCodigoMunicipio(0);
		    atendimento.setOrgao(atendimentoDto.getOrgao()); 
		    atendimento.setAnoAtendimento(LocalDate.now().getYear());
		    atendimento.setUsuarioCriacao(3l);
		    atendimento.setDataCriacao(LocalDateTime.now()); 
		    atendimento.setUsuarioAlteracao(3l);
		    atendimento.setDataAlteracao(LocalDateTime.now());
		    atendimento.setProvidencia("");
		    atendimento.setCodigoModelo(1l);
		    atendimento.setTotalDias(0);
		    atendimento.setDataConclusao(new Timestamp(0)); 
		    atendimento.setAssunto(0l);
		    
		    SimpleDateFormat sdf = new SimpleDateFormat("ssmm");
		    Date date = new Date();
		    atendimento.setSenhaManifestante(sdf.format(date));
		    atendimento.setPendente(0);
		    if (atendimentoDto.getManterSigilo() != null)
		    	atendimento.setManterSigilo(Boolean.TRUE.equals(atendimentoDto.getManterSigilo()) ? 1 : 0);
		    else
		    	atendimento.setManterSigilo(0);		    
		    atendimento.setTipoUsuario(atendimentoDto.getIdentificado().equals("0") ? 0l : atendimento.getTipoUsuario());
		    atendimento.setDataEntrada(LocalDate.now());
		    atendimento.setNumeroAtendimento(atendimentoRepository.getMaxNumeroAtendimento(LocalDate.now().getYear())+1);
		    atendimento.setNumeroProtocolo(atendimento.getAnoAtendimento() +""+atendimento.getNumeroAtendimento());
		    atendimento.setSequencialOrgao(atendimentoRepository.getMaxSequencialOrgao(LocalDate.now().getYear(), atendimentoDto.getOrgao())+1);
		    atendimentoRepository.save(atendimento);
		    
		    String[] anexosEmail = null;
		    
		    if (atendimentoDto.getListaAnexoDto() != null) {
		    	anexosEmail = new String[atendimentoDto.getListaAnexoDto().size()];
		    	for (int i = 0; i < anexosEmail.length; i++) {
		    		ListaAnexoDto anexos = atendimentoDto.getListaAnexoDto().get(i); 			
			    	String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			    	String nomeArq = timeStamp + "_" + anexos.getNomeArquivo();
			    	if (idAplicacao == 1)
			    		buildFile(anexos.getStringBase64(), nomeArq);
			    	else
			    		buildFileUBEC(anexos.getStringBase64(), nomeArq, atendimento.getOrgao());
			    	Anexo anexo = new Anexo();
			    	anexo.setAtendimento(atendimento.getId());
			    	anexo.setDataAnexo(LocalDate.now());
			    	anexo.setNomeArquivo(nomeArq);
			    	anexo.setNumeroAtendimento(atendimento.getNumeroAtendimento());
			    	anexo.setOrgao(atendimento.getOrgao());
			    	anexo.setOrigem(0);
			    	anexo.setVisivel(1);
			    	anexo.setId(anexoRepository.getMaxSequencialId()+1);
			    	anexoRepository.save(anexo);
			    	anexosEmail[i] = "C:\\jboss-4.2.1.GA_UBEC\\server\\default\\deploy\\multiwork.war\\arquivos\\"+atendimento.getOrgao().toString()+"\\"+anexo.getNomeArquivo();
			    }
		    }
			String template = null;
		    Map<String, Object> variaveis = new HashMap<>();
		    variaveis.put("sigla", orgao.getSigla());
		if (atendimentoDto.getIdentificado().equals("1")) {
			variaveis.put("atendimento", atendimento);
			variaveis.put("url", atendimento.getOrgao());
			variaveis.put("logo", logo);
				template = "mail/emailcadastromanifestacao";
				mailer.enviarEmail(Arrays.asList(atendimento.getEmail()), template, variaveis, orgao.getSigla(), "suporte@welssoncavalcante.com.br", "Cadastro de Atendimento", anexosEmail);
		}
		if (atendimentoDto.getNatureza() == 5) {
			variaveis.put("atendimento", atendimento);
			variaveis.put("texto", atendimento.getDescricaoOque());
			variaveis.put("logo", logo);			
			template = "mail/emailouvidoriadenuncia";
			mailer.enviarEmail(Arrays.asList("geraldo.silva@ubec.edu.br","rosilandia.oliveira@ubec.edu.br","dineves@portalimm.com.br"), template, variaveis, orgao.getSigla(), "suporte@welssoncavalcante.com.br", "Cadastro de Atendimento", anexosEmail);
		}else {
			template = "mail/emailouvidoria";
			mailer.enviarEmail(Arrays.asList(orgao.getEmailOrgao()), template, variaveis, orgao.getSigla(), "suporte@welssoncavalcante.com.br", "Cadastro de Atendimento", anexosEmail);
			if (orgao.getSigla().equals("UCB") || orgao.getSigla().equals("UNILESTE") || orgao.getSigla().equals("FICR") || orgao.getSigla().equals("UNICATOLICA")) {
				mailer.enviarEmail(Arrays.asList("ouvidoria@ubec.edu.br"), template, variaveis, orgao.getSigla(), "suporte@welssoncavalcante.com.br", "Cadastro de Atendimento", anexosEmail);
			}
		}
		return atendimentoMapper.toDto(atendimento);
	}
	
	
	public List<ResumoAtendimentoDto> getResumo(Long orgao, String cpf,  String numero, String senha, Integer idAplicacao) {

		List<Atendimento> listaAtendimento = new ArrayList<>();
		List<ResumoAtendimentoDto> listaResumo = new ArrayList<>();
		
		if (idAplicacao == 1) {
			if (cpf != null && !cpf.equals("")) {
				listaAtendimento = atendimentoRepository.findByOrgaoAndNumeroDocumento(orgao, cpf);
			}else {
				listaAtendimento = atendimentoRepository.findByOrgaoAndNumeroProtocoloAndSenhaManifestante(orgao, numero, senha);
			}
		}else {
			listaAtendimento = atendimentoRepository.findByOrgaoAndAnoAtendimentoAndSequencialOrgaoAndSenhaManifestante(orgao, Integer.parseInt(numero.substring(0, 4)), Long.parseLong(numero.substring(4, numero.length())), senha);
		}
		
		ResumoAtendimentoDto resumo = null;

		for (Atendimento atendimento : listaAtendimento) {
			resumo = new ResumoAtendimentoDto();
			List<RespostaParcial> listRespostaParcial = respostaParcialRepository.findByCodigoAtendimentoAndAnoAtendimentoAndOrgao(atendimento.getNumeroAtendimento(), atendimento.getAnoAtendimento().toString(), atendimento.getOrgao());
			resumo = new ResumoAtendimentoDto();
			if (atendimento.getSatisfaz() == 0) {
				List<PerguntaSatisfacao> listaPerguntas = perguntaSatisfacaoRepository.findByOrgaoAndStatus(atendimento.getOrgao(), 0);
				List<RespostaSatisfacao> listaRespostasSatisfacao = new ArrayList<>();
				
				for (int i = 0; i < listaPerguntas.size(); i++) {
					listaRespostasSatisfacao = respostaSatisfacaoRepository.findByPerguntaSatisfacaoAndStatus(listaPerguntas.get(i).getId(), 0);
					listaPerguntas.get(i).setListaRespostaSatisfacao(listaRespostasSatisfacao);
				}
				resumo.setListaPergunta(listaPerguntas);
			}
			
    	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			
    	    resumo.setNumeroProtocolo(atendimento.getNumeroProtocolo());
    	    if (atendimento.getAssunto() != null && atendimento.getAssunto() > 0)
    	    	resumo.setAssunto(assuntoRepository.findByOrgaoAndId(atendimento.getOrgao(), atendimento.getAssunto()).getDescricao());
    	    else
    	    	resumo.setAssunto("Assunto não encontrado");
    	    if (atendimento.getStatus() == 1) {
    	    	resumo.setSituacao("Concluída");
    	    }else {
    	    	resumo.setSituacao("Em atendimento");
    	    }
	    	resumo.setNatureza(naturezaRepository.getById(atendimento.getNatureza()).getDescricao());
			resumo.setNomeSolicitante(atendimento.getNomeSolicitante());
			resumo.setDescricaoFatos(atendimento.getDescricaoFatos());
			resumo.setDataCriacao(atendimento.getDataCriacao().format(formatter));
			resumo.setRespostaConclusao(atendimento.getResposta());
			resumo.setRespondeuPesquisa(atendimento.getSatisfaz());
			resumo.setIdAtendimento(atendimento.getId());
			resumo.setManifestacaoConcluida(atendimento.getDataConclusao().toString().contains("1969-12-31") ? "Não" : "Sim");
			resumo.setListaResposta(respostaParcialMapper.fromResponseList(listRespostaParcial));
			listaResumo.add(resumo);
			
		}
		
		return listaResumo;

	}
	
	
	public Boolean getSalvarPesquisaSatisfacao(PesquisaSatisfacaoRequest pesquisaSatisfacao) {
		try {
			for (PesquisaSatisfacaoDto pergunta : pesquisaSatisfacao.getListaPergunta()) {
				PesquisaSatisfacao pesquisa = new PesquisaSatisfacao();
				pesquisa.setIdAtendimento(pesquisaSatisfacao.getIdAtendimento());
				pesquisa.setIdPergunta(pergunta.getIdPergunta());
				pesquisa.setIdResposta(pergunta.getIdResposta());
				pesquisa.setId(pesquisaSatisfacaoRepository.getMaxId()+1);
				pesquisaSatisfacaoRepository.save(pesquisa);
			}
			Atendimento atendimento = atendimentoRepository.getById(pesquisaSatisfacao.getIdAtendimento());
			atendimento.setSatisfaz(1);
			atendimentoRepository.save(atendimento);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	
	public LocalDate adicionarDiasUteis(Integer qtdeDiasAcrescentados, Long codigoOrgao) {
		List<Feriado> feriadoInfoList = null;
		LocalDate data = LocalDate.now();
		while(qtdeDiasAcrescentados > 0){
			data = data.plusDays(1);
			feriadoInfoList = feriadoRepository.findByOrgaoAndDataFeriado(codigoOrgao, data);
			if (!feriadoInfoList.isEmpty()){
				++qtdeDiasAcrescentados;
			}
			if (data.getDayOfWeek() != DayOfWeek.SATURDAY && data.getDayOfWeek() != DayOfWeek.SUNDAY) {
				--qtdeDiasAcrescentados;
			}
		}
		return data;
	}
	
	
	private void buildFile(String base64, String urlAnexo)throws IOException {
		try {
			byte[] anexo2 = Base64.decodeBase64(base64);
			OutputStream out = new FileOutputStream(
					"C:\\gcon_arquivos\\arquivos\\"+urlAnexo);
			out.write(anexo2);
			out.close();
		}catch (Exception e) {
			e.getMessage();
		}
			
	}
	
	
	private void buildFileUBEC(String base64, String urlAnexo, Long codigoOrgao)throws IOException {
		try {
			byte[] anexo2 = Base64.decodeBase64(base64.split(",")[1]);
			OutputStream out = new FileOutputStream(
					"C:\\jboss-4.2.1.GA_UBEC\\server\\default\\deploy\\multiwork.war\\arquivos\\"+codigoOrgao.toString()+"\\"+urlAnexo);
			out.write(anexo2);
			out.close();
		}catch (Exception e) {
			e.getMessage();
		}
			
	}
	
	
//	public Integer ajuste(Long codigoOrgao) {
//		List<Atendimento> lista = atendimentoRepository.findByOrgao(codigoOrgao);
//		int contador = 0;
//		for (Atendimento atendimento : lista) {
//			if (!atendimento.getEmail().equals("")) {
//				Map<String, Object> variaveis = new HashMap<>();
//				variaveis.put("atendimento", atendimento);
//				variaveis.put("url", atendimento.getOrgao());
//				variaveis.put("logo", "");
//				String template = "mail/emailcadastromanifestacao";
//				mailer.enviarEmail(Arrays.asList(atendimento.getEmail()), template, variaveis, "UCB");
//				contador = contador + 1;
//			}
//		}
//		return contador;
//	}



}
