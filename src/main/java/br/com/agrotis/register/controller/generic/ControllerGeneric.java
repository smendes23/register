package br.com.agrotis.register.controller.generic;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ControllerGeneric<T , R> {

    ResponseEntity<T> salvar(@RequestBody R dto) throws Exception;

    List<T> listarTodos() throws Exception;

    ResponseEntity<T> buscarPorId(@PathVariable Integer id) throws Exception;

    void deletar(@PathVariable Integer id) throws Exception;
}
