package br.com.agrotis.register.domain.entity;

import br.com.agrotis.register.domain.base.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "laboratorio")
@NoArgsConstructor
public class Laboratorio extends BaseEntity {

}
