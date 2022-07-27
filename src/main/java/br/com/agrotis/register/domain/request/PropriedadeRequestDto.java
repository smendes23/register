package br.com.agrotis.register.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PropriedadeRequestDto {

    @NotNull(message = "Nome propriedade obrigatorio")
    private String nome;
}
