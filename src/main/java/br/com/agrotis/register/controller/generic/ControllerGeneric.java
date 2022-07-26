package br.com.agrotis.register.controller.generic;

import br.com.agrotis.register.domain.base.BaseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ControllerGeneric<T extends BaseEntity, R> {

    ResponseEntity<T> salvar(@RequestBody R dto) throws Exception;

    List<R> listarTodos() throws Exception;

    ResponseEntity<R> buscarPorId(@PathVariable Integer id);

    ResponseEntity<String> deletar(@PathVariable Integer id);
}
