package br.com.agrotis.register.repository;

import br.com.agrotis.register.domain.entity.Produtor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutorRepository extends JpaRepository<Produtor, Integer> {

    List<Produtor> findAllProducer();
}