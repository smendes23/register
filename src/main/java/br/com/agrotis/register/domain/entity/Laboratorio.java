package br.com.agrotis.register.domain.entity;

import br.com.agrotis.register.domain.base.BaseEntity;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Builder
@Data
@Table(name = "laboratorio")
public class Laboratorio extends BaseEntity {

    public Laboratorio() {
        super();
    }
}
