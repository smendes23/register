package br.com.agrotis.register.domain.mapper;

import br.com.agrotis.register.domain.entity.Produtor;
import br.com.agrotis.register.dto.LaboratorioDto;
import br.com.agrotis.register.dto.ProdutorDto;
import br.com.agrotis.register.dto.PropriedadeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProdutorMapper {

    private final PropriedadeMapper propriedadeMapper;
    private final LaboratorioMapper laboratorioMapper;

    public ProdutorDto toDto(final Produtor produtor){
        return ProdutorDto
                .builder()
                .dataFinal(produtor.getDataFinal())
                .dataInicial(produtor.getDataInicial())
                .infosProriedade(PropriedadeDto
                        .builder()
                        .id(produtor.getInfosProriedade().getId())
                        .nome(produtor.getInfosProriedade().getNome())
                        .build())
                .laboratorio(LaboratorioDto
                        .builder()
                        .id(produtor.getLaboratorio().getId())
                        .nome(produtor.getLaboratorio().getNome())
                        .build())
                .nome(produtor.getNome())
                .build();
    }

    public Produtor toEntity(final  ProdutorDto dto){
        return Produtor
                .builder()
                .dataFinal(dto.getDataFinal())
                .dataInicial(dto.getDataInicial())
                .observacoes(dto.getObservacoes())
                .infosProriedade(propriedadeMapper.toEntity(dto.getInfosProriedade()))
                .laboratorio(laboratorioMapper.toEntity(dto.getLaboratorio()))
                .build();
    }
}
