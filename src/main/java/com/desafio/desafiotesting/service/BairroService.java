package com.desafio.desafiotesting.service;

import com.desafio.desafiotesting.domain.Bairro;
import com.desafio.desafiotesting.service.exceptions.BairroNullException;
import org.springframework.stereotype.Service;

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
        Optional<Bairro> bairro = bairros.stream().filter(b -> b.getNome().equals(nome)).findFirst();
        return bairro.orElseThrow(() -> new BairroNullException("Bairro não encontrado"));
    }

    public void salvar(Bairro bairro) {
        bairros.add(bairro);
    }
}
