package br.com.agrotis.register.controller;

import br.com.agrotis.register.controller.generic.ControllerGeneric;
import br.com.agrotis.register.domain.request.ProdutorRequestDto;
import br.com.agrotis.register.domain.response.ProdutorResponseDto;
import br.com.agrotis.register.exception.BusinessRuleException;
import br.com.agrotis.register.service.ProdutorService;
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
@RequestMapping("/produtor")
public class ProdutorController implements ControllerGeneric<ProdutorResponseDto, ProdutorRequestDto> {

    private final ProdutorService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public ResponseEntity<ProdutorResponseDto> salvar(@RequestBody ProdutorRequestDto dto) throws BusinessRuleException {
        return ResponseEntity.ok(service.salvar(dto));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Override
    public List<ProdutorResponseDto> listarTodos() throws BusinessRuleException {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public ResponseEntity<ProdutorResponseDto> buscarPorId(@PathVariable Integer id) throws BusinessRuleException {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Override
    public void deletar(@PathVariable Integer id) throws BusinessRuleException {
        service.deletar(id);
    }
}
