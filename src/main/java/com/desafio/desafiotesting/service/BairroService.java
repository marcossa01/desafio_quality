package com.desafio.desafiotesting.service;

import com.desafio.desafiotesting.domain.Bairro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public List<Bairro> findAll() {
        return bairros.stream().map(b -> new Bairro(b.getNome(), b.getValorMetroQuadrado())).collect(Collectors.toList());
    }

    public Bairro findByNome(String nome) {
        return bairros.stream().filter(b -> b.getNome().equals(nome)).findFirst().orElse(null);
    }

    public void salvar(Bairro bairro) {
        bairros.add(bairro);
    }


}
