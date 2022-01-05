package com.desafio.desafiotesting.service;

import com.desafio.desafiotesting.domain.Casa;
import com.desafio.desafiotesting.domain.Comodo;
import com.desafio.desafiotesting.domain.dto.CasaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CasaService {

    @Autowired
    private ComodoService comodoService;

    List<Casa> casas = new ArrayList<>();

    public List<CasaDto> findAll() {
        List<CasaDto> list = casas.stream().map(x -> new CasaDto(x.getNome(), x.getEndereco())).collect(Collectors.toList());
        return list;
    }

    public Casa findByNome(String nome) {
        Optional<Casa> casa = casas.stream().filter(x -> x.getNome().equals(nome)).findFirst();
        return casa.orElse(null);
    }

    public String getAreaCasa(String nome) {
        Casa casa = findByNome(nome);
        Double area = 0.0;
        for (Comodo c : casa.getComodos()) {
            area += c.getLargura() * c.getComprimento();
        }
        return "A área total da casa é de: " + area + " metros.";
    }

    public String getValorCasa(String nome, Integer valorMetro) {
        Casa casa = findByNome(nome);
        Double area = 0.0;
        Double valorCasa;
        for (Comodo c : casa.getComodos()){
            area += c.getLargura() * c.getComprimento();
        }
        valorCasa = area * valorMetro;
        return "O valor da casa é: R$" + valorCasa;
    }

    public String getMaiorComodo(String nome) {
        Casa casa = findByNome(nome);
        Double maiorComodo = 0.0;
        Double comodo;
        String nomeCasa = null;
        for (Comodo c : casa.getComodos()) {
            comodo = c.getLargura() * c.getComprimento();
            if(comodo > maiorComodo) {
                maiorComodo = comodo;
                nomeCasa = c.getNome();
            }
        }
        return "O maior comodo da casa: " + nomeCasa;
    }

    public Casa insert(Casa obj) {
        obj.setNome(obj.getNome());
        obj.setEndereco(obj.getEndereco());
        for (Comodo c : obj.getComodos()) {
            c.setNome(c.getNome());
            c.setComprimento(c.getComprimento());
            c.setLargura(c.getLargura());
            comodoService.salvarComodo(c);
        }
        salvarCasa(obj);
        return obj;
    }



    public void salvarCasa(Casa casa) {
        casas.add(casa);
    }
}
