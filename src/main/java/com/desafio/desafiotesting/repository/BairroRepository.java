package com.desafio.desafiotesting.repository;

import com.desafio.desafiotesting.domain.Bairro;
import com.desafio.desafiotesting.exception.RepositoryException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class BairroRepository {

    List<Bairro> bairros;
    /***
     * objectMapper para utilização na manipulação do JSON
     */
    private final ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    /***
     * PATH contendo o caminho/nome do arquivo JSON
     */
    private final String PATH = "bairros.json";

    public BairroRepository(List<Bairro> bairros) {
        this.bairros = bairros;
    }

    public List<Bairro> findAll() {
        try {
            File file = new File(PATH);
            FileInputStream is = new FileInputStream(file);
            bairros = new ArrayList<>(Arrays.asList(objectMapper.readValue(is, Bairro[].class)));
            return bairros;
        } catch (IOException e) {
            throw new RepositoryException("Erro ao localizar bairros");
        }
    }

    public Bairro findByNome(String nome) {
        return findAll().stream().filter(b -> b.getNome().equals(nome)).findFirst().orElse(null);
    }

    public void salvar(Bairro bairro) {
        try {
            bairros = findAll();
            if (this.findByNome(bairro.getNome()) != null) throw new RepositoryException("Bairro ja cadastrado.");
            List<Bairro> novaLista2 =new ArrayList<>();
            novaLista2.add(bairro);
            List<Bairro> novaLista = new ArrayList<>(bairros);
            novaLista.addAll(novaLista2);
            objectMapper.writeValue(new File(PATH), novaLista);
        } catch (IOException e) {
            throw new RepositoryException("Erro ao gravar Bairro");
        }
    }
}
