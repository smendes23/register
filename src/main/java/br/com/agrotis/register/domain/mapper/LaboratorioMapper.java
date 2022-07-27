package br.com.agrotis.register.domain.mapper;

import br.com.agrotis.register.domain.entity.Laboratorio;
import br.com.agrotis.register.domain.request.LaboratorioRequestDto;
import br.com.agrotis.register.domain.response.LaboratorioResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LaboratorioMapper {

    public Laboratorio toEntity(LaboratorioRequestDto dto){
        return Laboratorio
                .builder()
                .nome(dto.getNome())
                .build();
    }

    public LaboratorioResponseDto toDto(Laboratorio laboratorio){
        return LaboratorioResponseDto
                .builder()
                .id(laboratorio.getId())
                .nome(laboratorio.getNome())
                .dataExclusao(laboratorio.getDataExclusao())
                .build();
    }
}
