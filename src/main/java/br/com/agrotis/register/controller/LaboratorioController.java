package br.com.agrotis.register.controller;


import br.com.agrotis.register.controller.generic.ControllerGeneric;
import br.com.agrotis.register.domain.request.LaboratorioRequestDto;
import br.com.agrotis.register.domain.response.LaboratorioResponseDto;
import br.com.agrotis.register.exception.BusinessRuleException;
import br.com.agrotis.register.service.LaboratorioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/laboratorio")
@Api(value="Laboratorio", description="dominio laboratorio")
public class LaboratorioController implements ControllerGeneric<LaboratorioResponseDto, LaboratorioRequestDto> {

    private final LaboratorioService service;

    @ApiOperation(value = "Cria um laboratorio",response = LaboratorioResponseDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Laboratorio salvo com sucesso")
    }
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public ResponseEntity<LaboratorioResponseDto> salvar(@RequestBody LaboratorioRequestDto dto) throws BusinessRuleException {
        return ResponseEntity.ok(service.salvar(dto));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Override
    public List<LaboratorioResponseDto> listarTodos() throws BusinessRuleException {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public ResponseEntity<LaboratorioResponseDto> buscarPorId(@PathVariable Integer id) throws BusinessRuleException {

        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Override
    public void deletar(@PathVariable Integer id) throws BusinessRuleException {
        service.deletar(id);
    }
}
