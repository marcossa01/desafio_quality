package com.desafio.desafiotesting.service;

import com.desafio.desafiotesting.domain.Casa;
import com.desafio.desafiotesting.domain.Comodo;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CasaServiceTest {

    @Test
    public void testAreaTotalCasa() {
        //Cenario
        CasaService casaService = new CasaService();

        List<Comodo> list = new ArrayList<>();
        Comodo c1 = new Comodo("c1", 10.0, 5.0);
        Comodo c2 = new Comodo("c2", 20.0, 15.0);
        Comodo c3 = new Comodo("c3", 1.0, 30.0);
        list.addAll(Arrays.asList(c1, c2, c3));

        Casa casaTeste = new Casa("CasaTeste", "BairroTeste", list);
        casaService.salvarCasa(casaTeste);

        //Ação
        String result = casaService.getAreaCasa("CasaTeste");

        //Verificacao
        Assert.assertEquals("A área total da casa é de: 380.0 metros.", result);
    }

    @Test
    public void testMaiorComodoCasa() {
        //Cenario
        CasaService casaService = new CasaService();

        List<Comodo> list = new ArrayList<>();
        Comodo c1 = new Comodo("c1", 10.0, 5.0);
        Comodo c2 = new Comodo("c2", 20.0, 15.0);
        Comodo c3 = new Comodo("c3", 1.0, 30.0);
        list.addAll(Arrays.asList(c1, c2, c3));

        Casa casaTeste = new Casa("CasaTeste", "BairroTeste", list);
        casaService.salvarCasa(casaTeste);

        //Acao
        String result = casaService.getMaiorComodo("CasaTeste");

        //Verificacao
        Assert.assertEquals("O maior comodo da casa CasaTeste: c2 com área de 300.0 metros quadrados.", result);
    }

    @Test
    public void testeAreaComodo() {

        //Cenario
        CasaService casaService = new CasaService();

        List<Comodo> list = new ArrayList<>();
        Comodo c1 = new Comodo("c1", 10.0, 5.0);
        list.add(c1);

        Casa casaTeste = new Casa("CasaTeste", "BairroTeste", list);
        casaService.salvarCasa(casaTeste);

        //Acao
        String result = casaService.getAreaComodos("CasaTeste");

        //Verificacao
        Assert.assertEquals("A area de cada comodo da casa CasaTeste é: Comodo: c1 com 50.0 metros quadrados.", result);
    }
}
