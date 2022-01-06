package com.desafio.desafiotesting.service;

import com.desafio.desafiotesting.domain.Bairro;
import com.desafio.desafiotesting.repository.BairroRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BairroService {

    BairroRepository bairroRepository;

    public BairroService(BairroRepository bairroRepository) {
        this.bairroRepository = bairroRepository;
    }

    public List<Bairro> findAll() {
        return bairroRepository.findAll();
    }

    public Bairro findByNome(String nome) {
        return bairroRepository.findByNome(nome);
    }

    public void salvar(Bairro bairro) {
        bairroRepository.salvar(bairro);
    }
}
