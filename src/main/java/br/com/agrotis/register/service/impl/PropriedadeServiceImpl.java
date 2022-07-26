package br.com.agrotis.register.service.impl;

import br.com.agrotis.register.domain.entity.Propriedade;
import br.com.agrotis.register.domain.mapper.PropriedadeMapper;
import br.com.agrotis.register.dto.PropriedadeDto;
import br.com.agrotis.register.repository.GenericRepository;
import br.com.agrotis.register.service.PropriedadeService;
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
public class PropriedadeServiceImpl implements PropriedadeService {

    private final GenericRepository<Propriedade> repository;
    private final PropriedadeMapper mapper;

    @Override
    public List<PropriedadeDto> listarTodos() throws Exception {
        return repository
                .findAll()
                .stream()
                .filter(Objects::nonNull)
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Propriedade buscarPorId(Integer id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("asdasd"));
    }

    @Transactional
    @Override
    public Propriedade salvar(PropriedadeDto entity) throws Exception {
        try{
            return repository.save(mapper.toEntity(entity));
        }catch (Exception e){
            throw new Exception("Nao foi possivel salvar o objeto");
        }
    }


    @Transactional
    @Override
    public void deletar(Integer id) throws Exception {
        try {
            var Propriedade = buscarPorId(id);
            repository.delete(Propriedade);
        } catch (Exception e) {
            log.error("Nao foi possivel remover o Propriedade, causa: "+e.getCause());
        }
    }
}
