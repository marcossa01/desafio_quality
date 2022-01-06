package com.desafio.desafiotesting.service;

import com.desafio.desafiotesting.domain.Bairro;
import com.desafio.desafiotesting.exception.RepositoryException;
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
        Bairro bairro = bairroRepository.findByNome(nome);
        if (bairro == null) throw new RepositoryException("Bairro inexistente.");
        return bairro;
    }

    public void salvar(Bairro bairro) {
        this.verificarBairroExistente(bairro.getNome()); // lança exceção se bairro ja existe
        bairroRepository.salvar(bairro);
    }

    private void verificarBairroExistente(String nome){
        if ( bairroRepository.findByNome(nome) != null)
            throw new RepositoryException("Ja existe bairro com esse nome.");
    }
}
