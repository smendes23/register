package br.com.agrotis.register.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutorDto {

    private String nome;
    private OffsetDateTime dataInicial;
    private OffsetDateTime dataFinal;
    private PropriedadeDto infosProriedade;
    private LaboratorioDto laboratorio;
    private String observacoes;
}
