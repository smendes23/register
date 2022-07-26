package br.com.agrotis.register.service.impl;

import br.com.agrotis.register.domain.entity.Laboratorio;
import br.com.agrotis.register.domain.mapper.LaboratorioMapper;
import br.com.agrotis.register.dto.LaboratorioDto;
import br.com.agrotis.register.repository.GenericRepository;
import br.com.agrotis.register.service.LaboratorioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class LaboratorioServiceImpl implements LaboratorioService {

    private final GenericRepository<Laboratorio> repository;
    private final LaboratorioMapper mapper;

    @Override
    public List<LaboratorioDto> listarTodos() throws Exception {
        return repository
                .findAll()
                .stream()
                .filter(Objects::nonNull)
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Laboratorio buscarPorId(Integer id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception(String.format("Nao foi possivel carregar o laboratorio de id: %d", id)));
    }

    @Transactional
    @Override
    public Laboratorio salvar(LaboratorioDto entity) throws Exception {
        try{
            return repository.save(mapper.toEntity(entity));
        }catch (Exception e ){
            throw  new Exception("Nao foi possivel salvar");
        }

    }

    @Transactional
    @Override
    public void deletar(Integer id) throws Exception {
        try {
            var Laboratorio = buscarPorId(id);
            repository.delete(Laboratorio);
        } catch (Exception e) {
            log.error("Nao foi possivel remover o Laboratorio, causa: "+e.getCause());
        }
    }
}
