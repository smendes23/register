package br.com.agrotis.register.repository;

import br.com.agrotis.register.domain.entity.Propriedade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropriedadeRepository extends JpaRepository<Propriedade, Integer> {

    List<Propriedade> findAllProperties();

}