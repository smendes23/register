package br.com.agrotis.register.controller;

import br.com.agrotis.register.controller.generic.ControllerGeneric;
import br.com.agrotis.register.domain.mapper.PropriedadeMapper;
import br.com.agrotis.register.domain.request.PropriedadeRequestDto;
import br.com.agrotis.register.domain.response.PropriedadeResponseDto;
import br.com.agrotis.register.service.PropriedadeService;
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
@RequestMapping("/propriedade")
public class PropriedadeController implements ControllerGeneric<PropriedadeResponseDto, PropriedadeRequestDto> {

    private final PropriedadeService service;
    private final PropriedadeMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public ResponseEntity<PropriedadeResponseDto> salvar(@RequestBody PropriedadeRequestDto dto) throws Exception {
        return ResponseEntity.ok(service.salvar(dto));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Override
    public List<PropriedadeResponseDto> listarTodos() throws Exception {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public ResponseEntity<PropriedadeResponseDto> buscarPorId(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Override
    public void deletar(@PathVariable Integer id) throws Exception {
        service.deletar(id);
    }
}
