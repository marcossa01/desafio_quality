package com.desafio.desafiotesting.repository;

import com.desafio.desafiotesting.domain.Bairro;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BairroRepository {

    List<Bairro> bairros;

    public BairroRepository(List<Bairro> bairros) {
        this.bairros = bairros;
    }

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
