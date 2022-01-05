package com.desafio.desafiotesting.service;

import com.desafio.desafiotesting.domain.Bairro;
import com.desafio.desafiotesting.domain.dto.BairroDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BairroService {

    List<Bairro> bairros = new ArrayList<>();

    public List<BairroDto> findAll() {
        List<BairroDto> list = bairros.stream().map(x -> new BairroDto(x.getNome(), x.getValorMetroQuadrado())).collect(Collectors.toList());
        return list;
    }

    public BairroDto findByNome(String nome) {
        Optional<Bairro> bairro = bairros.stream().filter(x -> x.getNome().equals(nome)).findFirst();
        return fromDto(bairro.orElse(null));
    }

    public Bairro insert(Bairro obj) {
        obj.setNome(obj.getNome());
        obj.setValorMetroQuadrado(new BigDecimal(String.valueOf(obj.getValorMetroQuadrado())));
        salvar(obj);
        return obj;
    }

    public void salvar(Bairro bairro) {
        bairros.add(bairro);
    }

    public BairroDto fromDto(Bairro obj) {
        BairroDto bairro = new BairroDto(obj.getNome(), obj.getValorMetroQuadrado());
        return bairro;
    }

    public Bairro dtoFrom(BairroDto objDto) {
        Bairro bairro = new Bairro(objDto.getNome(), objDto.getValorMetroQuadrado());
        return bairro;
    }


}
