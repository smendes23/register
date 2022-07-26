package br.com.agrotis.register.controller;

import br.com.agrotis.register.controller.generic.ControllerGeneric;
import br.com.agrotis.register.domain.entity.Produtor;
import br.com.agrotis.register.dto.ProdutorDto;
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
public class ProdutorController implements ControllerGeneric<Produtor, ProdutorDto> {

    private final ProdutorService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public ResponseEntity<Produtor> salvar(@RequestBody ProdutorDto dto) throws Exception {
        return ResponseEntity.ok(service.salvar(dto));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Override
    public List<ProdutorDto> listarTodos() throws Exception {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public ResponseEntity<ProdutorDto> buscarPorId(@PathVariable Integer id) {
        return null;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Override
    public ResponseEntity<String> deletar(@PathVariable Integer id) {
        return null;
    }
}