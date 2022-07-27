package br.com.agrotis.register.domain.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutorRequestDto {

    @NotNull(message = "Nome obrigatorio")
    private String nome;

    @NotNull(message = "Data inicial obrigatoria")
    private OffsetDateTime dataInicial;

    private OffsetDateTime dataFinal;

    @NotNull(message = "Infos Propriedade obrigatoria")
    private Integer infosPropriedade;

    @NotNull(message = "Laboratorio obrigatorio")
    private Integer laboratorio;

    private String observacoes;
}
