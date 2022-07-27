package br.com.agrotis.register.domain.mapper;

import br.com.agrotis.register.domain.entity.Propriedade;
import br.com.agrotis.register.domain.request.PropriedadeRequestDto;
import br.com.agrotis.register.domain.response.PropriedadeResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PropriedadeMapper {

    public Propriedade toEntity(PropriedadeRequestDto dto){
        return Propriedade
                .builder()
                .nome(dto.getNome())
                .build();
    }

    public PropriedadeResponseDto toDto(Propriedade propriedade){
        return PropriedadeResponseDto
                .builder()
                .id(propriedade.getId())
                .nome(propriedade.getNome())
                .dataExclusao(propriedade.getDataExclusao())
                .build();
    }
}
