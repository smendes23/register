package br.com.agrotis.register.domain.mapper;

import br.com.agrotis.register.domain.entity.Produtor;
import br.com.agrotis.register.domain.request.ProdutorRequestDto;
import br.com.agrotis.register.domain.response.ProdutorResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProdutorMapper {

    private final LaboratorioMapper laboratorioMapper;
    private final PropriedadeMapper propriedadeMapper;

    public ProdutorResponseDto toDto(final Produtor produtor){
        return ProdutorResponseDto
                .builder()
                .dataFinal(produtor.getDataFinal())
                .dataInicial(produtor.getDataInicial())
                .infosPropriedade(propriedadeMapper.toDto(produtor.getPropriedade()))
                .laboratorio(laboratorioMapper.toDto(produtor.getLaboratorio()))
                .nome(produtor.getNome())
                .observacoes(produtor.getObservacoes())
                .id(produtor.getId())
                .build();
    }

    public Produtor toEntity(final ProdutorRequestDto dto){
        return Produtor
                .builder()
                .nome(dto.getNome())
                .dataFinal(dto.getDataFinal())
                .dataInicial(dto.getDataInicial())
                .observacoes(dto.getObservacoes())
                .build();
    }
}
