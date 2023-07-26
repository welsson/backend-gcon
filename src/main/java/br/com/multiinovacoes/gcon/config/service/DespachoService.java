//package br.com.multiinovacoes.gcon.config.service;
//
//import java.awt.geom.Area;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import br.com.multiinovacoes.gcon.config.enums.PriorizacaoEnum;
//import br.com.multiinovacoes.gcon.config.model.dto.DespachoDto;
//import br.com.multiinovacoes.gcon.config.model.mapper.DespachoMapper;
//import br.com.multiinovacoes.gcon.config.model.request.DespachoRequest;
//import br.com.multiinovacoes.gcon.config.repository.AnexoRepository;
//import br.com.multiinovacoes.gcon.config.repository.AssuntoRepository;
//import br.com.multiinovacoes.gcon.config.repository.AtendimentoRepository;
//import br.com.multiinovacoes.gcon.config.repository.DespachoRepository;
//import br.com.multiinovacoes.gcon.config.repository.NaturezaRepository;
//import br.com.multiinovacoes.gcon.config.repository.SetorRepository;
//import br.com.multiinovacoes.gcon.config.repository.TipoDocumentoRepository;
//import br.com.multiinovacoes.gcon.config.repository.UsuarioRepository;
//import br.com.multiinovacoes.gcon.mail.Mailer;
//import br.com.multiinovacoes.gcon.model.Anexo;
//import br.com.multiinovacoes.gcon.model.Assunto;
//import br.com.multiinovacoes.gcon.model.Atendimento;
//import br.com.multiinovacoes.gcon.model.Despacho;
//import br.com.multiinovacoes.gcon.model.Encaminhamento;
//import br.com.multiinovacoes.gcon.model.LogAtendimento;
//import br.com.multiinovacoes.gcon.model.Natureza;
//import br.com.multiinovacoes.gcon.model.OrigemManifestacao;
//import br.com.multiinovacoes.gcon.model.TipoDocumento;
//import br.com.multiinovacoes.gcon.model.Usuario;
//import br.com.multiinovacoes.gcon.repository.AreaRepository;
//import br.com.multiinovacoes.gcon.repository.EncaminhamentoRepository;
//import br.com.multiinovacoes.gcon.repository.LogAtendimentoRepository;
//import br.com.multiinovacoes.gcon.repository.OrigemManifestacaoRepository;
//import br.com.multiinovacoes.gcon.security.GconSecurity;
//
//@Service
//@Transactional
//public class DespachoService {
//	
//	
//	@Autowired
//	DespachoMapper despachoMapper;
//	
//	@Autowired
//	DespachoRepository despachoRepository;
//	
//	@Autowired
//	UsuarioRepository usuarioRepository;
//	
//	@Autowired
//	AtendimentoRepository atendimentoRepository;
//	
//	@Autowired
//	//EncaminhamentoRepository encaminhamentoRepository;
//	
//	@Autowired
//	private Mailer mailer;
//	
//	@Autowired
//	private AreaRepository areaRepository;
//	
//	@Autowired
//	private NaturezaRepository naturezaRepository;
//	
//	@Autowired
//	private OrigemManifestacaoRepository origemManifestacaoRepository;
//	
//	@Autowired
//	private AssuntoRepository assuntoRepository;
//	
//	@Autowired
//	private TipoDocumentoRepository tipoDocumentoRepository;
//	
//	@Autowired
//	private GconSecurity gconSecurity;
//	
//	@Autowired
//	private AnexoRepository anexoRepository;
//	
//	@Autowired
//	private SetorRepository setorRepository;
//	
//	@Autowired
//	private LogAtendimentoRepository logAtendimentoRepository;
//	
//	public List<DespachoDto> getDespachos(Long codigoAtendimento) {
//		Atendimento atendimento = atendimentoRepository.getById(codigoAtendimento);
//		List<DespachoDto> despachoDtoList = despachoMapper.fromResponseList(despachoRepository.consultaAtendimento(atendimento));
//		List<DespachoDto> listaRetorno = new ArrayList<>();
//		if (despachoDtoList != null) {
//			for (DespachoDto despachoDto : despachoDtoList) {
//				despachoDto.setDescricaoSetorOrigem(setorRepository.getById(despachoDto.getSetorOrigem()).getDescricao());
//				despachoDto.setDescricaoSetorDestino(setorRepository.getById(despachoDto.getSetorDestino()).getDescricao());
//				listaRetorno.add(despachoDto);
//			}
//		}
//		return listaRetorno;
//	}
//	
//	
//	public void salvarDespacho(DespachoRequest request) {
//		String[] anexos = new String[request.getSelectedAnexos().size()];
//		Usuario usuario = usuarioRepository.findById(gconSecurity.getIdUsuario()).orElse(null);
//		Atendimento atendimento = atendimentoRepository.getById(request.getAtendimento());
//		Encaminhamento enc = encaminhamentoRepository.findByAtendimentoAndSetorDestinoAndStatusAndCancelado(request.getAtendimento(), request.getSetorDestino(), Encaminhamento.STATUS_ABERTO, 0);
//		Despacho despacho =  despachoMapper.toDespacho(despachoMapper.fromDespacho(request));
//		despacho.setUsuario(usuario);
//		despacho.setDataDespacho(LocalDate.now());
//		despacho.setStatus(0);
//		despacho.setCodigoAtendimento(atendimento.getNumeroAtendimento());
//		despacho.setAnoAtendimento(atendimento.getAnoAtendimento());
//		despacho.setCodigoEncaminhamento(enc.getId());
//		despacho.setSetorOrigem(enc.getSetorOrigem());
//		despacho.setId(despachoRepository.getMaxId()+1);
//		despacho.setOrgaoOrigem(2l);
//		despacho.setOrgaoDestino(2l);
//		despachoRepository.save(despacho);
//		
//		LogAtendimento logAtendimento = 
//				  new LogAtendimento(
//						  logAtendimentoRepository.getMaxId()+1,
//						  atendimento.getId(),
//						  LocalDateTime.now(),
//						  atendimento.getUsuarioCriacao(),
//						  "Enviou despacho"
//						  );
//		logAtendimentoRepository.save(logAtendimento);
//	    
//		
//		Map<String, Object> variaveis = new HashMap<>();
//		variaveis.put("atendimento", atendimento);
//		variaveis.put("despacho", request.getDescricao());
//        		
//		Optional<Area> area = areaRepository.findById(atendimento.getArea());
//		Optional<Natureza> natureza = naturezaRepository.findById(atendimento.getNatureza());
//		Optional<OrigemManifestacao> origemManifestacao = origemManifestacaoRepository.findById(atendimento.getOrigemManifestacao());
//		Optional<Assunto> assunto =  assuntoRepository.findById(atendimento.getAssunto());
//		Optional<TipoDocumento> tipoDocumento =  tipoDocumentoRepository.findById(atendimento.getTipoDocumento());
//		
//		for (int i = 0; i < request.getSelectedAnexos().size(); i++) {
//			Optional<Anexo> anexo = anexoRepository.findById(request.getSelectedAnexos().get(i));
//			if (anexo.isPresent()) {
//				anexos[i] = "C:\\gcon_arquivos\\arquivos\\"+anexo.get().getNomeArquivo();
//			}
//		}
//		
//		
//		if (area.isPresent()) {
//			variaveis.put("area", area.get().getDescricao());
//		}else {
//			variaveis.put("area", "");
//		}
//		if (natureza.isPresent()) {
//			variaveis.put("natureza", natureza.get().getDescricao());	
//		}else {
//			variaveis.put("natureza", "");
//		}
//		if (origemManifestacao.isPresent()) {
//			variaveis.put("origemManifestacao", origemManifestacao.get().getDescricao());	
//		}else {
//			variaveis.put("origemManifestacao", "");
//		}
//		if (assunto.isPresent()) {
//			variaveis.put("assunto", assunto.get().getDescricao());
//		}else {
//			variaveis.put("assunto", "");
//		}
//		if (tipoDocumento.isPresent()) {
//			variaveis.put("tipoDocumento", tipoDocumento.get().getDescricao());
//		}else {
//			variaveis.put("tipoDocumento", "");
//		}
//		if (atendimento.getPriorizacao() != null) {
//			variaveis.put("priorizacao", PriorizacaoEnum.pegarDescricao(atendimento.getPriorizacao()).getDescricao());
//		}else {
//			variaveis.put("priorizacao", "");
//		}
//		
//		String template = "mail/emailencaminhamento";
//		
//		mailer.enviarEmail(Arrays.asList(request.getEmailEnviado()), template, variaveis, "", "Encaminhamento de Despacho Nº " + atendimento.getNumeroProtocolo(), anexos);
//		
//		
//	}
//	
//	public DespachoDto getDespacho(Long codigoDespacho) {
//		DespachoDto despachoDto = despachoMapper.toDto(despachoRepository.consultaDespacho(codigoDespacho));
//		despachoDto.setDescricaoSetorDestino(setorRepository.getById(despachoDto.getSetorDestino()).getDescricao());
//		return despachoDto;
//	}
//
//	
//	public void excluir(Long codigoDespacho) {
//		despachoRepository.deleteById(codigoDespacho);
//	}
//
//
//}
