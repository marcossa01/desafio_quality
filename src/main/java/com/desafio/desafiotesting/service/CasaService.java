package com.desafio.desafiotesting.service;

import com.desafio.desafiotesting.domain.Casa;
import com.desafio.desafiotesting.domain.Comodo;
import com.desafio.desafiotesting.domain.Bairro;
import com.desafio.desafiotesting.exception.RepositoryException;
import com.desafio.desafiotesting.repository.CasaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CasaService {

    @Autowired
    BairroService bairroService;
    CasaRepository casaRepository;

    public CasaService(CasaRepository casaRepository) {
        this.casaRepository = casaRepository;
    }

    //Calcula area total do Imovel
    private double calcularAreaTotal(Casa casa) {
        double areaTotal = 0;
        for (Comodo com : casa.getComodos()) areaTotal += com.getAreaComodo();
        return areaTotal;
    }

    public List<Casa> findAll() {
        return casaRepository.findAll();
    }

    public Casa findByNome(String nome) {
        return casaRepository.findByNome(nome);
    }

    public String getAreaCasa(String nome) {
        Casa casa = findByNome(nome);
        if (casa == null) throw new RepositoryException("Casa inexistente.");
        double area = calcularAreaTotal(casa);
        return "A área total da casa é de: " + area + " metros.";
    }

    public String getValorCasa(String nome) {
        Casa casa = findByNome(nome);
        if (casa == null) throw new RepositoryException("Casa inexistente.");
        double area = calcularAreaTotal(casa);
        Bairro bairro = bairroService.findByNome(casa.getBairro());
        if (bairro == null) throw new RepositoryException("Bairro inexistente.");
        BigDecimal valorM2 = bairro.getValorMetroQuadrado();
        BigDecimal valorCasa = valorM2.multiply(new BigDecimal(area));
        return "O valor da casa é: R$" + NumberFormat.getCurrencyInstance().format(valorCasa);
    }

    public String getMaiorComodo(String nome) {
        Casa casa = findByNome(nome);
        if (casa == null) throw new RepositoryException("Imovel inexistente.");
        double maiorComodo = 0;
        double areaComodo;
        String nomeComodo = "";
        for (Comodo c : casa.getComodos()) {
            areaComodo = c.getAreaComodo();
            if (areaComodo > maiorComodo) {
                maiorComodo = areaComodo;
                nomeComodo = c.getNome();
            }
        }
        return "O maior comodo da casa " + nome + ": " +
                nomeComodo + " com área de " + maiorComodo + " metros quadrados.";
    }

    public String getAreaComodos(String nomeDaCasa) {
        StringBuilder areaComodos = new StringBuilder();
        Casa casa = casaRepository.findByNome(nomeDaCasa);
        if (casa == null) throw new RepositoryException("Casa inexistente.");
        for (Comodo com : casa.getComodos()) {
            areaComodos.append("Comodo: ").append(com.getNome()).append(" com ")
                    .append(com.getAreaComodo()).append(" metros quadrados<br>");
        }
        return "A area de cada comodo da casa " + nomeDaCasa + " é: <br>" + areaComodos;
    }

    public void salvarCasa(Casa casa) {
        if(bairroService.findByNome(casa.getBairro()) == null ) throw new RepositoryException("Bairro informado não existe");
        casaRepository.salvar(casa);
    }
}
