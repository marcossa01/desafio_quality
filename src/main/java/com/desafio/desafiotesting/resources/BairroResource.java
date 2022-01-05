package com.desafio.desafiotesting.resources;

import com.desafio.desafiotesting.domain.Bairro;
import com.desafio.desafiotesting.domain.dto.BairroDto;
import com.desafio.desafiotesting.service.BairroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/bairros")
public class BairroResource {

    @Autowired
    private BairroService service;

    @GetMapping
    public ResponseEntity<List<BairroDto>> findAll() {
        List<BairroDto> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{nome}")
    public ResponseEntity<BairroDto> findByNome(@PathVariable String nome) {
        BairroDto obj = service.findByNome(nome);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody BairroDto bairro) {
        Bairro obj = service.dtoFrom(bairro);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{nome}").buildAndExpand(obj.getNome()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
