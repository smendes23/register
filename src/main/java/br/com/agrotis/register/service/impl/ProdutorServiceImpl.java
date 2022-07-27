package br.com.agrotis.register.service.impl;

import br.com.agrotis.register.domain.entity.Produtor;
import br.com.agrotis.register.domain.mapper.ProdutorMapper;
import br.com.agrotis.register.domain.request.ProdutorRequestDto;
import br.com.agrotis.register.domain.response.ProdutorResponseDto;
import br.com.agrotis.register.repository.LaboratorioRepository;
import br.com.agrotis.register.repository.ProdutorRepository;
import br.com.agrotis.register.repository.PropriedadeRepository;
import br.com.agrotis.register.service.ProdutorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProdutorServiceImpl implements ProdutorService {

    private final ProdutorRepository repository;
    private final ProdutorMapper mapper;
    private final PropriedadeRepository propriedadeRepository;
    private final LaboratorioRepository laboratorioRepository;


    @Override
    public List<ProdutorResponseDto> listarTodos() throws Exception {
        return repository
                .findAllProducer()
                .stream()
                .filter(Objects::nonNull)
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProdutorResponseDto buscarPorId(Integer id) throws Exception {
        return repository
                .findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new Exception("asdasd"));
    }

    @Transactional
    @Override
    public ProdutorResponseDto salvar(ProdutorRequestDto dto) throws Exception {
        try{
            Produtor produtor = mapper.toEntity(dto);
            produtor.setLaboratorio(buscarPorId(dto.getLaboratorio(), laboratorioRepository)
                    .filter(lab->Objects.isNull(lab.getDataExclusao()))
                    .orElseThrow(() -> new RuntimeException("Laboratorio inexistente")));
            produtor.setPropriedade(buscarPorId(dto.getInfosPropriedade(), propriedadeRepository)
                    .filter(prop->Objects.isNull(prop.getDataExclusao()))
                    .orElseThrow(() -> new RuntimeException("Propriedade inexistente")));
            repository.save(produtor);
            return mapper.toDto(produtor);
        }catch (Exception e){
            throw new Exception("Nao foi possivel salvar o produtor, causa: "+e.getCause());
        }
    }

    @Transactional
    @Override
    public void deletar(Integer id) throws Exception {
        try {
            Produtor produtor = repository.findById(id).orElseThrow();
            repository.delete(produtor);
        } catch (Exception e) {
            log.error("Nao foi possivel remover o produtor, causa: "+e.getCause());
        }
    }

    private <T>  Optional<T>  buscarPorId(Integer id, JpaRepository<T, Integer> t){
        return Optional
                .ofNullable(t.findById(id))
                .orElseThrow(() -> new RuntimeException("nao foi possivel pegar"));
    }

}
