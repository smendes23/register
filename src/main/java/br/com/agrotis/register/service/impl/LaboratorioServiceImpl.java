package br.com.agrotis.register.service.impl;

import br.com.agrotis.register.domain.entity.Laboratorio;
import br.com.agrotis.register.domain.mapper.LaboratorioMapper;
import br.com.agrotis.register.domain.request.LaboratorioRequestDto;
import br.com.agrotis.register.domain.response.LaboratorioResponseDto;
import br.com.agrotis.register.repository.LaboratorioRepository;
import br.com.agrotis.register.service.LaboratorioService;
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
public class LaboratorioServiceImpl implements LaboratorioService {

    private final LaboratorioRepository repository;
    private final LaboratorioMapper mapper;

    @Override
    public List<LaboratorioResponseDto> listarTodos() throws Exception {
        return repository
                .findAllLabs()
                .stream()
                .filter(Objects::nonNull)
                .filter(lab -> Objects.isNull(lab.getDataExclusao()))
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public LaboratorioResponseDto buscarPorId(Integer id) throws Exception {
        return mapper.toDto(repository.getReferenceById(id)) ;
    }

    @Transactional
    @Override
    public LaboratorioResponseDto salvar(LaboratorioRequestDto entity) throws Exception {
        try{
            return mapper.toDto(repository.save(mapper.toEntity(entity)));
        }catch (Exception e ){
            throw  new Exception("Nao foi possivel salvar");
        }

    }

    @Transactional
    @Override
    public void deletar(Integer id) throws Exception {
        Laboratorio laboratorio = repository.getReferenceById(id);
        laboratorio.setDataExclusao(OffsetDateTime.now());
        repository.save(laboratorio);
    }
}
