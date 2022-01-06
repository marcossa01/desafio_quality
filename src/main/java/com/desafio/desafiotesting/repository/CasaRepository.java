package com.desafio.desafiotesting.repository;

import com.desafio.desafiotesting.domain.Casa;
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
public class CasaRepository {

    List<Casa> casas;
    /***
     * objectMapper para utilização na manipulação do JSON
     */
    private final ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    /***
     * PATH contendo o caminho/nome do arquivo JSON
     */
    private final String PATH = "casas.json";

    public CasaRepository(List<Casa> casas) {
        this.casas = casas;
    }

    public List<Casa> findAll() {
        try {
            File file = new File(PATH);
            FileInputStream is = new FileInputStream(file);
            casas = new ArrayList<>(Arrays.asList(objectMapper.readValue(is, Casa[].class)));
            return casas;
        } catch (IOException e) {
            throw new RepositoryException("Erro ao localizar casas");
        }
    }

    public Casa findByNome(String nome) {
        return findAll().stream().filter(c -> c.getNome().equals(nome)).findFirst().orElse(null);
    }

    public void salvar(Casa casa) {
        try {
            casas = findAll();
            if (this.findByNome(casa.getNome()) != null) throw new RepositoryException("Casa ja cadastrada.");
            List<Casa> novaLista2 =new ArrayList<>();
            novaLista2.add(casa);
            List<Casa> novaLista = new ArrayList<>(casas);
            novaLista.addAll(novaLista2);
            objectMapper.writeValue(new File(PATH), novaLista);
        } catch (IOException e) {
            throw new RepositoryException("Erro ao gravar Bairro");
        }
    }
}
