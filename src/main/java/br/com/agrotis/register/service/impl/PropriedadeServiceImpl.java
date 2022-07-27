package br.com.agrotis.register.service.impl;

import br.com.agrotis.register.domain.entity.Propriedade;
import br.com.agrotis.register.domain.mapper.PropriedadeMapper;
import br.com.agrotis.register.domain.request.PropriedadeRequestDto;
import br.com.agrotis.register.domain.response.PropriedadeResponseDto;
import br.com.agrotis.register.repository.PropriedadeRepository;
import br.com.agrotis.register.service.PropriedadeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class PropriedadeServiceImpl implements PropriedadeService {

    private final PropriedadeRepository repository;
    private final PropriedadeMapper mapper;

    @Override
    public List<PropriedadeResponseDto> listarTodos() throws Exception {
        return repository
                .findAllProperties()
                .stream()
                .filter(Objects::nonNull)
                .filter(prop -> Objects.isNull(prop.getDataExclusao()))
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PropriedadeResponseDto buscarPorId(Integer id) throws Exception {
        return mapper.toDto(repository.findById(id).orElseThrow(() -> new Exception("asdasd")));
    }

    @Transactional
    @Override
    public PropriedadeResponseDto salvar(PropriedadeRequestDto entity) throws Exception {
        return mapper.toDto(repository.save(mapper.toEntity(entity)));
    }


    @Transactional
    @Override
    public void deletar(Integer id) throws Exception {
        Propriedade propriedade = repository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Nao foi possivel carregar a propriedade"));
        propriedade.setDataExclusao(OffsetDateTime.now());
        repository.save(propriedade);
    }
}
