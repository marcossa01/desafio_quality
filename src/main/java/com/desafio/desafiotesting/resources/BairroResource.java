package com.desafio.desafiotesting.resources;

import com.desafio.desafiotesting.domain.dto.BairroDto;
import com.desafio.desafiotesting.service.BairroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/bairros")
public class BairroResource {

    @Autowired
    private BairroService bairroService;

    @GetMapping
    public ResponseEntity<List<BairroDto>> findAll() {
        List<BairroDto> list = BairroDto.converteLista(bairroService.findAll());
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{nome}")
    public ResponseEntity<BairroDto> findByNome(@PathVariable String nome) {
        BairroDto obj = BairroDto.converte(bairroService.findByNome(nome));
        return ResponseEntity.ok(obj);
    }

    @PostMapping("/cadastrarBairro")
    public ResponseEntity<BairroDto> cadastrarCasa(@RequestBody @Valid BairroDto bairro, UriComponentsBuilder uriBuilder){
        bairroService.salvar(BairroDto.converte(bairro));
        URI uri = uriBuilder
                .path("/bairros/{nome}")
                .buildAndExpand(bairro.getNome())
                .toUri();
        return ResponseEntity.created(uri).body(bairro);
    }
}
