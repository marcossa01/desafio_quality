package com.desafio.desafiotesting.resources;

import com.desafio.desafiotesting.domain.dto.CasaDto;
import com.desafio.desafiotesting.service.CasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/casas")
public class CasaResource {

    @Autowired
    private CasaService casaService;


    @PostMapping("/cadastrarCasa")
    public ResponseEntity<CasaDto> cadastrarCasa(@Valid @RequestBody CasaDto casa){
        casaService.salvarCasa(CasaDto.converte(casa));
        return ResponseEntity.ok(casa);
    }

    @GetMapping
    public ResponseEntity<List<CasaDto>> findAll() {
        List<CasaDto> list = CasaDto.converteLista(casaService.findAll());
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{nome}")
    public ResponseEntity<CasaDto> findByNome(@Valid @PathVariable String nome) {
        CasaDto casa = CasaDto.converte(casaService.findByNome(nome));
        return ResponseEntity.ok(casa);
    }

    @GetMapping(value = "/area/{nome}")
    public ResponseEntity<String> areaTotal(@Valid @PathVariable String nome) {
        String casa = casaService.getAreaCasa(nome);
        return ResponseEntity.ok(casa);
    }

    @GetMapping(value = "/valorCasa/{nome}")
    public ResponseEntity<String> valorCasa(@Valid @PathVariable String nome) {
        String valorCasa = casaService.getValorCasa(nome);
        return ResponseEntity.ok(valorCasa);
    }

    @GetMapping(value = "/maiorComodo/{nome}")
    public ResponseEntity<String> maiorComodo(@Valid @PathVariable String nome){
        String maiorComodo = casaService.getMaiorComodo(nome);
        return ResponseEntity.ok(maiorComodo);
    }
    @GetMapping(value = "/areaComodos/{nome}")
    public ResponseEntity<CasaDto> areaComodos(@Valid @PathVariable String nome) {
        CasaDto casa = CasaDto.converte(casaService.findByNome(nome));
        return ResponseEntity.ok(casa);
    }

}
