package br.com.agrotis.register.service.generic;

import java.util.List;

public interface GenericService <T , R> {

    List<T> listarTodos() throws Exception;

    T buscarPorId(Integer id) throws Exception;

    T  salvar(R entity) throws Exception;

    void deletar(Integer id) throws Exception;
}
