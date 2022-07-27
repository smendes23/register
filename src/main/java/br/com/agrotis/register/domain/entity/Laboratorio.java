package br.com.agrotis.register.domain.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.time.OffsetDateTime;


@Builder
@Entity
@Getter
@Setter
@Table(name = "laboratorio")
@NamedQuery(name = "Laboratorio.findAllLabs",
        query = "SELECT l FROM Laboratorio l ORDER BY l.id ASC")
@AllArgsConstructor
@NoArgsConstructor
public class Laboratorio  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private OffsetDateTime dataExclusao;
}
