package br.com.agrotis.register.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;

import java.time.OffsetDateTime;

@Builder
@Getter
@Setter
@Entity
@Table(name = "produtor")
@NamedQuery(name = "Produtor.findAllProducer",
        query = "SELECT p FROM Produtor p ORDER BY p.id ASC")
@AllArgsConstructor
@NoArgsConstructor
public class Produtor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @Column(name = "data_inicial", nullable = false)
    private OffsetDateTime dataInicial;

    @Column(name = "data_final", nullable = false)
    private OffsetDateTime dataFinal;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PROPRIEDADE_ID")
    private Propriedade propriedade;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "LABORATORIO_ID")
    private Laboratorio laboratorio;

    @Column(name = "observacoes", length = 256)
    private String observacoes;

}
