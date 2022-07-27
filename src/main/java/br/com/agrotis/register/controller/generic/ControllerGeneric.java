package br.com.agrotis.register.controller.generic;

import br.com.agrotis.register.exception.BusinessRuleException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ControllerGeneric<T , R> {

    ResponseEntity<T> salvar(@RequestBody R dto) throws BusinessRuleException;

    List<T> listarTodos() throws BusinessRuleException;

    ResponseEntity<T> buscarPorId(@PathVariable Integer id) throws BusinessRuleException;

    void deletar(@PathVariable Integer id) throws BusinessRuleException;
}
