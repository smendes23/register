package br.com.agrotis.register.controller;


import br.com.agrotis.register.controller.generic.ControllerGeneric;
import br.com.agrotis.register.domain.request.LaboratorioRequestDto;
import br.com.agrotis.register.domain.response.LaboratorioResponseDto;
import br.com.agrotis.register.service.LaboratorioService;
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
public class LaboratioController implements ControllerGeneric<LaboratorioResponseDto, LaboratorioRequestDto> {

    private final LaboratorioService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public ResponseEntity<LaboratorioResponseDto> salvar(@RequestBody LaboratorioRequestDto dto) throws Exception {
        return ResponseEntity.ok(service.salvar(dto));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Override
    public List<LaboratorioResponseDto> listarTodos() throws Exception {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public ResponseEntity<LaboratorioResponseDto> buscarPorId(@PathVariable Integer id) throws Exception {

        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Override
    public void deletar(@PathVariable Integer id) throws Exception {
        service.deletar(id);
    }
}
