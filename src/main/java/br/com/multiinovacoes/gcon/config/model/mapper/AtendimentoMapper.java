package br.com.multiinovacoes.gcon.config.model.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.multiinovacoes.gcon.config.model.dto.AtendimentoDto;
import br.com.multiinovacoes.gcon.config.model.request.AtendimentoRequest;
import br.com.multiinovacoes.gcon.config.model.request.AtendimentoRequestPrefeitura;
import br.com.multiinovacoes.gcon.model.Atendimento;

@Mapper(componentModel = "spring")
public interface AtendimentoMapper {
	

	List<AtendimentoDto> fromResponseList(List<Atendimento> list);
	 
	@Mapping(target = "listaAnexoDto", ignore = true)
	@Mapping(target = "logotipo", ignore = true)
	@Mapping(target = "identificado", ignore = true)
	@Mapping(target = "manterSigilo", ignore = true)
	AtendimentoDto toDto(Atendimento area);
	 
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "logotipo", ignore = true)
	@Mapping(target = "numeroAtendimento", ignore = true)
	@Mapping(target = "numeroProtocolo", ignore = true)
	@Mapping(target = "origemManifestacao", ignore = true)
	@Mapping(target = "sequencialOrgao", ignore = true)
	@Mapping(target = "anoAtendimento", ignore = true)
	@Mapping(target = "estadoCivil", ignore = true)
	@Mapping(target = "dddFone", ignore = true)
	@Mapping(target = "fone", ignore = true)
	@Mapping(target = "descricao", ignore = true)
	@Mapping(target = "senhaManifestante", ignore = true)
	AtendimentoDto fromAtendimento(AtendimentoRequest request);
	
	
	@Mapping(target = "modalidadeEnsino", ignore = true)
	@Mapping(target = "anoAtendimento", ignore = true)
	@Mapping(target = "bairro", ignore = true)
	@Mapping(target = "cep", ignore = true)
	@Mapping(target = "complemento", ignore = true)
	@Mapping(target = "dataEntrada", ignore = true)
	@Mapping(target = "dddFone", ignore = true)
	@Mapping(target = "descricao", ignore = true)
	@Mapping(target = "endereco", ignore = true)
	@Mapping(target = "estadoCivil", ignore = true)
	@Mapping(target = "fone", ignore = true)
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "logotipo", ignore = true)
	@Mapping(target = "manterSigilo", ignore = true)
	@Mapping(target = "municipio", ignore = true)
	@Mapping(target = "numero", ignore = true)
	@Mapping(target = "numeroAtendimento", ignore = true)
	@Mapping(target = "numeroProtocolo", ignore = true)
	@Mapping(target = "origemManifestacao", ignore = true)
	@Mapping(target = "senhaManifestante", ignore = true)
	@Mapping(target = "sequencialOrgao", ignore = true)
	@Mapping(target = "uf", ignore = true)
	AtendimentoDto fromAtendimentoPrefeitura(AtendimentoRequestPrefeitura requestPrefeitura);
	
	@Mapping(target = "area", ignore = true)
	@Mapping(target = "justificativaProrrogacao", ignore = true)
	@Mapping(target = "descricaoSolucao", ignore = true)
	@Mapping(target = "usuarioAlteracao", ignore = true)
	@Mapping(target = "dataAlteracao", ignore = true)
	@Mapping(target = "codigoAtendimentoResposta", ignore = true)
	@Mapping(target = "codigoMunicipio", ignore = true)
	@Mapping(target = "providencia", ignore = true)
	@Mapping(target = "codigoModelo", ignore = true)
	@Mapping(target = "totalDias", ignore = true)
	@Mapping(target = "pendente", ignore = true)
	@Mapping(target = "dataNascimento", ignore = true)
	@Mapping(target = "setor", ignore = true)
	@Mapping(target = "usuarioCriacao", ignore = true)
	@Mapping(target = "dataCriacao", ignore = true)
	@Mapping(target = "tempoDuracaoAtendimento", ignore = true)
	@Mapping(target = "dataPrazo", ignore = true)
	@Mapping(target = "dataPrazoPrevisto", ignore = true)
	@Mapping(target = "descricaoComo", ignore = true)
	@Mapping(target = "descricaoOnde", ignore = true)
	@Mapping(target = "descricaoQuem", ignore = true)
	@Mapping(target = "descricaoQuando", ignore = true)
	@Mapping(target = "priorizacao", ignore = true)
	@Mapping(target = "statusAtendimento", ignore = true)
	@Mapping(target = "status", ignore = true)
	@Mapping(target = "resposta", ignore = true)
	@Mapping(target = "observacao", ignore = true)
	@Mapping(target = "dataConclusao", ignore = true)
	@Mapping(target = "satisfaz", ignore = true)
	@Mapping(target = "descricaoFatos", ignore = true)
	@Mapping(target = "dataQuando", ignore = true)
	@Mapping(target = "sequencialOrgao", ignore = true)
	@Mapping(target = "manterSigilo", ignore = true)
	Atendimento toAtendimento(AtendimentoDto dto);   
	



}
