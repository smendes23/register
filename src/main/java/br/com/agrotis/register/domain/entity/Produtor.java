package br.com.agrotis.register.domain.entity;

import br.com.agrotis.register.domain.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.OffsetDateTime;

@Builder
@Getter
@Entity
@Table(name = "produtor")
@AllArgsConstructor
@NoArgsConstructor
public class Produtor extends BaseEntity {

    @Column(name = "data_inicial", nullable = false)
    private OffsetDateTime dataInicial;

    @Column(name = "data_final", nullable = false)
    private OffsetDateTime dataFinal;

    @OneToOne
    private Propriedade infosProriedade;

    @OneToOne
    private Laboratorio laboratorio;

    @Column(name = "sharing_time", length = 256)
    private String observacoes;

}
