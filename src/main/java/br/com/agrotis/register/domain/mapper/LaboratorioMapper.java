package br.com.agrotis.register.domain.mapper;

import br.com.agrotis.register.domain.entity.Laboratorio;
import br.com.agrotis.register.dto.LaboratorioDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LaboratorioMapper {

    public Laboratorio toEntity(LaboratorioDto dto){
        var laboratorio = new Laboratorio();
        laboratorio.setNome(dto.getNome());
        return laboratorio;
    }

    public LaboratorioDto toDto(Laboratorio laboratorio){
        return LaboratorioDto
                .builder()
                .id(laboratorio.getId())
                .nome(laboratorio.getNome())
                .build();
    }
}
