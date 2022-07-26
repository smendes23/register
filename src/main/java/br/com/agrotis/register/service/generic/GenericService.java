package br.com.agrotis.register.service.generic;

import br.com.agrotis.register.domain.base.BaseEntity;

import java.util.List;

public interface GenericService <T extends BaseEntity, R> {

    List<R> listarTodos() throws Exception;

    T buscarPorId(Integer id) throws Exception;

    T  salvar(R entity) throws Exception;

    void deletar(Integer id) throws Exception;
}
