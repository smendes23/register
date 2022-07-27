package br.com.agrotis.register.service;

import br.com.agrotis.register.domain.entity.Laboratorio;
import br.com.agrotis.register.domain.mapper.LaboratorioMapper;
import br.com.agrotis.register.domain.response.LaboratorioResponseDto;
import br.com.agrotis.register.exception.BusinessRuleException;
import br.com.agrotis.register.repository.LaboratorioRepository;
import br.com.agrotis.register.service.impl.LaboratorioServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
public class LaboratorioServiceTest {

    @InjectMocks
    private LaboratorioServiceImpl service;

    @Mock
    private LaboratorioRepository repository;

    @Mock
    private LaboratorioMapper mapper;

    @Test
    void givenListarTodos_WhenListNotNull_thenReturnOk(){
        List<Laboratorio> listaLaboratorios = List.of(Laboratorio
                .builder()
                .id(1)
                .nome("teste")
                .build());

        when(repository.findAllLabs()).thenReturn(listaLaboratorios);

        List<LaboratorioResponseDto> response = service.listarTodos();

        assertEquals(listaLaboratorios.size(), response.size());
    }

}
