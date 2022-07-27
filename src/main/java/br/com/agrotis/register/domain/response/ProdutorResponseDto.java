package br.com.agrotis.register.domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutorResponseDto {

    private Integer id;

    private String nome;

    private OffsetDateTime dataInicial;

    private OffsetDateTime dataFinal;

    private PropriedadeResponseDto infosPropriedade;

    private LaboratorioResponseDto laboratorio;

    private String observacoes;
}
