package br.com.agrotis.register.service.generic;

import br.com.agrotis.register.exception.BusinessRuleException;

import java.util.List;

public interface GenericService <T , R> {

    List<T> listarTodos() throws BusinessRuleException;

    T buscarPorId(Integer id) throws BusinessRuleException;

    T  salvar(R entity) throws BusinessRuleException;

    void deletar(Integer id) throws BusinessRuleException;
}
