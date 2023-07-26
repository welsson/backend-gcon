package br.com.multiinovacoes.gcon.config.controller;

import static br.com.multiinovacoes.gcon.config.controller.AtendimentoController.ATENDIMENTO;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.multiinovacoes.gcon.config.model.dto.AtendimentoDto;
import br.com.multiinovacoes.gcon.config.model.dto.ResumoAtendimentoDto;
import br.com.multiinovacoes.gcon.config.model.mapper.AssuntoMapper;
import br.com.multiinovacoes.gcon.config.model.mapper.AtendimentoMapper;
import br.com.multiinovacoes.gcon.config.model.mapper.BairroMapper;
import br.com.multiinovacoes.gcon.config.model.mapper.LogoTipoMapper;
import br.com.multiinovacoes.gcon.config.model.mapper.RespostaParcialMapper;
import br.com.multiinovacoes.gcon.config.model.mapper.TipoDocumentoMapper;
import br.com.multiinovacoes.gcon.config.model.mapper.TipoManifestanteMapper;
import br.com.multiinovacoes.gcon.config.model.request.AtendimentoRequest;
import br.com.multiinovacoes.gcon.config.model.request.PesquisaSatisfacaoRequest;
import br.com.multiinovacoes.gcon.config.model.response.AtendimentoResponse;
import br.com.multiinovacoes.gcon.config.model.response.ListaAssuntoResponse;
import br.com.multiinovacoes.gcon.config.model.response.ListaBairroResponse;
import br.com.multiinovacoes.gcon.config.model.response.ListaTipoDocumentoResponse;
import br.com.multiinovacoes.gcon.config.model.response.ListaTipoManifestanteResponse;
import br.com.multiinovacoes.gcon.config.model.response.LogoTipoResponse;
import br.com.multiinovacoes.gcon.config.model.response.ResumoAtendimentoResponse;
import br.com.multiinovacoes.gcon.config.repository.AssuntoRepository;
import br.com.multiinovacoes.gcon.config.repository.AtendimentoRepository;
import br.com.multiinovacoes.gcon.config.repository.BairroRepository;
import br.com.multiinovacoes.gcon.config.repository.LogoTipoRepository;
import br.com.multiinovacoes.gcon.config.repository.NaturezaRepository;
import br.com.multiinovacoes.gcon.config.repository.RespostaParcialRepository;
import br.com.multiinovacoes.gcon.config.repository.TipoDocumentoRepository;
import br.com.multiinovacoes.gcon.config.repository.TipoManifestanteRepository;
import br.com.multiinovacoes.gcon.config.service.AtendimentoService;
import br.com.multiinovacoes.gcon.mail.Mailer;
import br.com.multiinovacoes.gcon.model.Natureza;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", maxAge = 3600)
@Validated
@Api(value = "Atendimento", produces = APPLICATION_JSON_VALUE)
@RestController
@RequestMapping(path = ATENDIMENTO	)
public class AtendimentoController {
	
	public static final String ATENDIMENTO = "/atendimentos";
	public static final String ATENDIMENTO_UBEC = "/ubec";
	public static final String LOGO_TIPO = "/logotipo";
	public static final String TIPO_MANIFESTANTE = "/tipoManifestantes";
	public static final String NATUREZAS = "/naturezas";
	public static final String ASSUNTOS = "/assuntos";
	public static final String BAIRROS = "/bairros";
	public static final String TIPO_DOCUMENTOS = "/tipoDocumentos";
	public static final String CONSULTA_TIPO_DOCUMENTO = "/consulta-tipodocumento";
	public static final String CONSULTA = "/consulta";
	public static final String CONSULTA_ATENDIMENTO = "/consultaAtendimento";
	public static final String CONSULTA_RESPOSTA_PARCIAL = "/consultaRespostaParcial";
	public static final String PESQUISA_SATISFACAO = "/pesquisaSatisfacao";

	
	@Autowired 
	AtendimentoRepository atendimentoRepository;
	
	@Autowired
	AtendimentoService atendimentoService;
	
	@Autowired
	AtendimentoMapper atendimentoMapper;
	
	@Autowired
	TipoManifestanteRepository tipoManifestanteRepository;
	
	@Autowired
	LogoTipoRepository logotipoRepository;
	
	@Autowired
	TipoManifestanteMapper tipoManifestanteMapper;

	@Autowired
	LogoTipoMapper logoTipoMapper;
	
	@Autowired
	TipoDocumentoRepository tipoDocumentoRepository;
	
	@Autowired
	TipoDocumentoMapper tipodDocumentoMapper;
	
	@Autowired
	BairroMapper bairroMapper;
	
	@Autowired
	AssuntoMapper assuntoMapper;
	
	@Autowired
	RespostaParcialRepository respostaParcialRepository;
	
	@Autowired
	RespostaParcialMapper respostaMapper;
	
	@Autowired
	NaturezaRepository naturezaRepository;
	
	@Autowired
	AssuntoRepository assuntoRepository;
	
	@Autowired
	BairroRepository bairroRepository;

	@Autowired
	private Mailer mailer;

	@ApiOperation(value = "Enviar uma atendimento", nickname = PESQUISA_SATISFACAO)
	@PostMapping(path = PESQUISA_SATISFACAO, produces = APPLICATION_JSON_VALUE)
	public Boolean salvarPesquisaSatisfacao(@Valid @RequestBody PesquisaSatisfacaoRequest request) {
		return atendimentoService.getSalvarPesquisaSatisfacao(request);
	}

	@ApiOperation(value = "Cadastrar uma manifestação")
	@PostMapping(produces = APPLICATION_JSON_VALUE)
	public AtendimentoResponse  salvarAtendimento(@Valid @RequestBody AtendimentoRequest request) throws Exception{
		AtendimentoDto atendimentoDto = atendimentoMapper.fromAtendimento(request);
		return new AtendimentoResponse(atendimentoService.salvarAtendimento(atendimentoDto, 1));
	}

	@ApiOperation(value = "Cadastrar uma manifestação", nickname = ATENDIMENTO_UBEC)
	@PostMapping(path = ATENDIMENTO_UBEC, produces = APPLICATION_JSON_VALUE)
	public AtendimentoResponse  salvarAtendimentoUBEC(@Valid @RequestBody AtendimentoRequest request) throws Exception{
		AtendimentoDto atendimentoDto = atendimentoMapper.fromAtendimento(request);
		return new AtendimentoResponse(atendimentoService.salvarAtendimento(atendimentoDto, 2));
	}
	
	@ApiOperation(value = "Obter lista de naturezas", nickname = NATUREZAS)
	@GetMapping(path = NATUREZAS, produces = APPLICATION_JSON_VALUE)
	public  ResponseEntity<?> getListaNaturezas(Long orgao) {
		List<Natureza> lista = naturezaRepository.findAll(Sort.by("descricao"));
		return ResponseEntity.ok(lista); 
	}

	@ApiOperation(value = "Obter lista de assunto", nickname = ASSUNTOS)
	@GetMapping(path = ASSUNTOS, produces = APPLICATION_JSON_VALUE)
	public  ListaAssuntoResponse getListaAssuntos(Long orgao) {
		return new ListaAssuntoResponse(assuntoMapper.fromResponseList(assuntoRepository.findByOrgaoAndAreaOrderByDescricaoAsc(orgao, 51l)));
	}

	@ApiOperation(value = "Obter lista de bairros", nickname = BAIRROS)
	@GetMapping(path = BAIRROS, produces = APPLICATION_JSON_VALUE)
	public  ListaBairroResponse getListaBairros(Long orgao) {
		return new ListaBairroResponse(bairroMapper.fromResponseList(bairroRepository.findByOrgaoOrderByDescricaoAsc(orgao))); 
	}

	
	@ApiOperation(value = "Obter lista de tipo manifestantes", nickname = TIPO_MANIFESTANTE)
	@GetMapping(path = TIPO_MANIFESTANTE, produces = APPLICATION_JSON_VALUE)
	public ListaTipoManifestanteResponse getListaTipoManifestantes(Long orgao) {
		return new ListaTipoManifestanteResponse(tipoManifestanteMapper.fromResponseList(tipoManifestanteRepository.getListaTiposManifestantesSite(orgao, 0)));
	}

	@ApiOperation(value = "Obter o atendimento", nickname = CONSULTA)
	@GetMapping(path = CONSULTA, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getConsulta(Long orgao, String cpf, String numero, String senha) {
	 List<ResumoAtendimentoDto> resumo = atendimentoService.getResumo(orgao, cpf, numero, senha, 2);
	 if (!resumo.isEmpty())
		 return ResponseEntity.ok(resumo); 
	 else
		 return ResponseEntity.notFound().build();
	}
	
	@ApiOperation(value = "Obter o atendimento", nickname = CONSULTA_ATENDIMENTO)
	@GetMapping(path = CONSULTA_ATENDIMENTO, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<ResumoAtendimentoResponse> getConsultaAtendimento(Long orgao, String cpf, String numero, String senha) {
	 List<ResumoAtendimentoDto> resumo = atendimentoService.getResumo(orgao, cpf, numero, senha, 2);
	 if (!resumo.isEmpty()) {
		 ResumoAtendimentoResponse resumoAtendimento = new ResumoAtendimentoResponse(resumo.get(0));
		 return ResponseEntity.ok(resumoAtendimento); 
	 }else {
		 return ResponseEntity.notFound().build();
	 }
	}

	
	@ApiOperation(value = "Obter o logotipo", nickname = LOGO_TIPO)
	@GetMapping(path = LOGO_TIPO, produces = APPLICATION_JSON_VALUE)
	public LogoTipoResponse getEditarLogoTipo(Long orgao) {
		return new LogoTipoResponse(logoTipoMapper.toDto(logotipoRepository.findByOrgao(orgao)));
	}
	
	@ApiOperation(value = "Obter lista de tipo documentos", nickname = TIPO_DOCUMENTOS)
	@GetMapping(path = TIPO_DOCUMENTOS, produces = APPLICATION_JSON_VALUE)
	public ListaTipoDocumentoResponse getListaTipoDocumentos(Long orgao) {
		return new ListaTipoDocumentoResponse(tipodDocumentoMapper.fromResponseList(tipoDocumentoRepository.findByOrgao(orgao)));
	}
	
	@PostMapping("/anexo")
	public String uploadAnexo(@RequestParam MultipartFile[] anexo) throws IOException {
		for (int i = 0; i < anexo.length; i++) {
			OutputStream out = new FileOutputStream(
					"C:\\jboss-4.2.1.GA_UBEC\\server\\default\\deploy\\multiwork.war\\arquivos\\" + anexo[i].getOriginalFilename());
			out.write(anexo[i].getBytes());
			out.close();
		}
		return "ok";
	}
	
	@GetMapping(path = "ajusteProtocolo", produces = APPLICATION_JSON_VALUE)
	public Integer ajusteNumeroProtocoloCorreto(Long orgao) {
		//return atendimentoService.ajuste(orgao);
		return 0;
	}
	
	@ApiOperation(value = "Obter lista de tipo documentos", nickname = CONSULTA_TIPO_DOCUMENTO)
	@GetMapping(path = CONSULTA_TIPO_DOCUMENTO, produces = APPLICATION_JSON_VALUE)
	public Long consultaTipoDocumento(Long orgao, Long codigoTipoManifestante) {
		return tipoManifestanteRepository.findByOrgaoAndIdAndStatus(orgao, codigoTipoManifestante, 0).getTipoDocumento();
	}
	
//	@GetMapping(path = "email", produces = APPLICATION_JSON_VALUE)
//	public void enviarEmail() {
//	    Map<String, Object> variaveis = new HashMap<>();
//	    variaveis.put("sigla", "TESTE");
//		String template = "mail/emailouvidoria";
//		mailer.enviarEmail(Arrays.asList("welssoncavalcante@gmail.com"), template, variaveis, "TESTE", "multi@multiinovacoes.com.br");
//	}


}
