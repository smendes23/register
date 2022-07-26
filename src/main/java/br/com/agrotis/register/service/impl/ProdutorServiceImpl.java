package br.com.agrotis.register.service.impl;

import br.com.agrotis.register.domain.entity.Produtor;
import br.com.agrotis.register.domain.mapper.ProdutorMapper;
import br.com.agrotis.register.dto.ProdutorDto;
import br.com.agrotis.register.repository.GenericRepository;
import br.com.agrotis.register.service.ProdutorService;
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
public class ProdutorServiceImpl implements ProdutorService {

    private final GenericRepository<Produtor> repository;
    private final ProdutorMapper mapper;


    @Override
    public List<ProdutorDto> listarTodos() throws Exception {
        return repository
                .findAll()
                .stream()
                .filter(Objects::nonNull)
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Produtor buscarPorId(Integer id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("asdasd"));
    }

    @Transactional
    @Override
    public Produtor salvar(ProdutorDto entity) throws Exception {
        try{
            return repository.save(mapper.toEntity(entity));
        }catch (Exception e){
            throw new Exception("Nao foi possivel salvar o produtor, causa: "+e.getCause());
        }
    }

    @Transactional
    @Override
    public void deletar(Integer id) throws Exception {
        try {
            var produtor = buscarPorId(id);
            repository.delete(produtor);
        } catch (Exception e) {
            log.error("Nao foi possivel remover o produtor, causa: "+e.getCause());
        }
    }

}
