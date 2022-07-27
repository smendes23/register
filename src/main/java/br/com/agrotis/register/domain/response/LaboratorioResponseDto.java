package br.com.agrotis.register.domain.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;

import java.time.OffsetDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LaboratorioResponseDto {

    private Integer id;

    private String nome;

    private OffsetDateTime dataExclusao;
}
