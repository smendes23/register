package br.com.agrotis.register.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.OffsetDateTime;

@Builder
@Getter
@Setter
@Entity
@NamedQuery(name = "Propriedade.findAllProperties",
        query = "SELECT p FROM Propriedade p ORDER BY p.id ASC")
@AllArgsConstructor
@NoArgsConstructor
public class Propriedade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private OffsetDateTime dataExclusao;

}
