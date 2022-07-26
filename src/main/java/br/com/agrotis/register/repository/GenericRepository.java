package br.com.agrotis.register.repository;

import br.com.agrotis.register.domain.base.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericRepository<T extends BaseEntity> extends JpaRepository<T, Integer> {
}