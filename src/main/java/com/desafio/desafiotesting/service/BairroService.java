package com.desafio.desafiotesting.service;

import com.desafio.desafiotesting.domain.Bairro;
import com.desafio.desafiotesting.exception.BusinessException;
import com.desafio.desafiotesting.repository.BairroRepository;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
        if (nome == null || nome.isEmpty())
            throw new BusinessException("nao e permitido cadastrar bairro com o nome em branco");
        return bairroRepository.findByNome(nome);
    }

    public void salvar(Bairro bairro) {
        if (bairro.getNome() == null || bairro.getValorMetroQuadrado().compareTo(BigDecimal.ZERO) <= 0)
            throw new BusinessException("nao e permitido cadastrar bairro som informar dados");
        bairroRepository.salvar(bairro);
    }
}
