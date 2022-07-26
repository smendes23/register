package br.com.agrotis.register.domain.entity;

import br.com.agrotis.register.domain.base.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Propriedade extends BaseEntity {

}
