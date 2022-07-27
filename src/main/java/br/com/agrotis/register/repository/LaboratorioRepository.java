package br.com.agrotis.register.repository;

import br.com.agrotis.register.domain.entity.Laboratorio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LaboratorioRepository extends JpaRepository<Laboratorio, Integer> {

    List<Laboratorio> findAllLabs();

}