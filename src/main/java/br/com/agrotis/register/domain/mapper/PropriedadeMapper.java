package br.com.agrotis.register.domain.mapper;

import br.com.agrotis.register.domain.entity.Propriedade;
import br.com.agrotis.register.dto.PropriedadeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PropriedadeMapper {

    public Propriedade toEntity(PropriedadeDto dto){
        var propriedade = new Propriedade();
        propriedade.setNome(dto.getNome());
        return propriedade;
    }

    public PropriedadeDto toDto(Propriedade propriedade){
        return PropriedadeDto
                .builder()
                .id(propriedade.getId())
                .nome(propriedade.getNome())
                .build();
    }
}
