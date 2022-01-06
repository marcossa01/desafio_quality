package com.desafio.desafiotesting.service;

import com.desafio.desafiotesting.domain.Casa;
import com.desafio.desafiotesting.domain.Comodo;
import com.desafio.desafiotesting.domain.Bairro;
import com.desafio.desafiotesting.exception.RepositoryException;
import com.desafio.desafiotesting.repository.CasaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;

@Service
@AllArgsConstructor
public class CasaService {

    BairroService bairroService;
    CasaRepository casaRepository;

    //Calcula area total do Imovel
    private double calcularAreaTotal(Casa casa) {
        double areaTotal = 0;
        for (Comodo com : casa.getComodos()) areaTotal += com.calculaAreaComodo();
        return areaTotal;
    }

    public List<Casa> findAll() {
        return casaRepository.findAll();
    }

    public Casa findByNome(String nome) {
        Casa casa = casaRepository.findByNome(nome);
        if (casa == null) throw new RepositoryException("Casa inexistente.");
        return casa;
    }

    public String getAreaCasa(String nome) {
        Casa casa = findByNome(nome);
        double area = calcularAreaTotal(casa);
        return "A área total da casa é de: " + area + " metros.";
    }

    public String getValorCasa(String nome) {
        Casa casa = findByNome(nome);
        double area = calcularAreaTotal(casa);
        Bairro bairro = bairroService.findByNome(casa.getBairro());
        BigDecimal valorM2 = bairro.getValorMetroQuadrado();
        BigDecimal valorCasa = valorM2.multiply(new BigDecimal(area));
        return "O valor da casa é: " + NumberFormat.getCurrencyInstance().format(valorCasa);
    }

    public String getMaiorComodo(String nome) {
        Casa casa = findByNome(nome);
        double maiorComodo = 0;
        double areaComodo;
        String nomeComodo = "";
        for (Comodo c : casa.getComodos()) {
            areaComodo = c.calculaAreaComodo();
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
        for (Comodo com : casa.getComodos()) {
            areaComodos.append("Comodo: ").append(com.getNome()).append(" com ")
                    .append(com.calculaAreaComodo()).append(" metros quadrados<br>");
        }
        return "A area de cada comodo da casa " + nomeDaCasa + " é: <br>" + areaComodos;
    }

    public void salvarCasa(Casa casa) {
        bairroService.findByNome(casa.getBairro()); // lança exceção se nao existe o bairro
        this.verificarCasaExistente(casa.getNome()); // lança exceção se casa ja existe
        casaRepository.salvar(casa);
    }

    private void verificarCasaExistente(String nome){
        if ( casaRepository.findByNome(nome) != null )
            throw new RepositoryException("Já existe uma casa com esse nome");
    }
}
