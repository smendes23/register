package br.com.agrotis.register.domain.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LaboratorioRequestDto {

    @NotNull(message = "Nome laboratorio obrigatorio")
    private String nome;
}
