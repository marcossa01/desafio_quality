package com.desafio.desafiotesting.resources;

import com.desafio.desafiotesting.domain.Casa;
import com.desafio.desafiotesting.domain.dto.CasaDto;
import com.desafio.desafiotesting.service.CasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/casas")
public class CasaResource {

    @Autowired
    private CasaService casaService;


    @PostMapping("/cadastrarCasa")
    public ResponseEntity<CasaDto> cadastrarCasa(@RequestBody @Valid  CasaDto casa, UriComponentsBuilder uriBuilder){
        casaService.salvarCasa(CasaDto.converte(casa));
        URI uri = uriBuilder
                .path("/{nome}")
                .buildAndExpand(casa.getNome())
                .toUri();
        return ResponseEntity.created(uri).body(casa);
    }

    @GetMapping
    public ResponseEntity<List<CasaDto>> findAll() {
        List<CasaDto> list = CasaDto.converteLista(casaService.findAll());
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{nome}")
    public ResponseEntity<Casa> findByNome(@PathVariable String nome) {
        Casa casa = casaService.findByNome(nome);
        return ResponseEntity.ok(casa);
    }

    @GetMapping(value = "/area/{nome}")
    public ResponseEntity<String> areaTotal(@PathVariable String nome) {
        String casa = casaService.getAreaCasa(nome);
        return ResponseEntity.ok(casa);
    }

    @GetMapping(value = "/valorCasa/{nome}")
    public ResponseEntity<String> valorCasa(@PathVariable String nome) {
        String valorCasa = casaService.getValorCasa(nome);
        return ResponseEntity.ok(valorCasa);
    }

    @GetMapping(value = "/maiorComodo/{nome}")
    public ResponseEntity<String> maiorComodo(@PathVariable String nome){
        String maiorComodo = casaService.getMaiorComodo(nome);
        return ResponseEntity.ok(maiorComodo);
    }

    @GetMapping(value = "/areaComodos/{nome}")
    public ResponseEntity<String> areaComodos(@PathVariable String nome) {
        return ResponseEntity.ok(casaService.getAreaComodos(nome));
    }

}
