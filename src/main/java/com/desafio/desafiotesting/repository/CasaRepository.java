package com.desafio.desafiotesting.repository;

import com.desafio.desafiotesting.domain.Casa;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CasaRepository {

    List<Casa> casas;

    public CasaRepository(List<Casa> casas) {
        this.casas = casas;
    }

    public List<Casa> findAll() {
        return casas.stream().map(c -> new Casa(c.getNome(), c.getBairro(), c.getComodos())).collect(Collectors.toList());
    }

    public Casa findByNome(String nome) {
        return casas.stream().filter(c -> c.getNome().equals(nome)).findFirst().orElse(null);
    }

    public void salvar(Casa casa) {
        casas.add(casa);
    }
}
