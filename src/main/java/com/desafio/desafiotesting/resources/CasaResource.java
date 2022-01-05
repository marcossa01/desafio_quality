package com.desafio.desafiotesting.resources;

import com.desafio.desafiotesting.domain.dto.BairroDto;
import com.desafio.desafiotesting.domain.Casa;
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
        return ResponseEntity.ok(casa);
    }

    @PostMapping("/cadastrarBairro")
    public BairroDto cadastrarCasa(@RequestBody @Valid BairroDto bairro){
        casaService.salvarBairro(BairroDto.converte(bairro));
        return bairro;
    }

    @GetMapping
    public ResponseEntity<List<CasaDto>> findAll() {
        List<CasaDto> list = casaService.findAll();
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
    public ResponseEntity<Casa> areaComodos(@PathVariable String nome) {
        Casa casa = casaService.findByNome(nome);
        return ResponseEntity.ok(casa);
    }
}
