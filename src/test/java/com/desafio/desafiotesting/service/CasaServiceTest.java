package com.desafio.desafiotesting.service;

import com.desafio.desafiotesting.domain.Casa;
import com.desafio.desafiotesting.domain.Comodo;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CasaServiceTest {

    private CasaService casaService;

    @Before
    public void setup(){
        casaService = new CasaService();
    }

    @Test
    public void testAreaTotalCasa() {
        //Cenario
        List<Comodo> list = Arrays.asList(
                new Comodo("c1", 10.0, 5.0),
                new Comodo("c2", 20.0, 15.0),
                new Comodo("c3", 1.0, 30.0));

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
        List<Comodo> list = Arrays.asList(
                new Comodo("c1", 10.0, 5.0),
                new Comodo("c2", 20.0, 15.0),
                new Comodo("c3", 1.0, 30.0));

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
        List<Comodo> list = Arrays.asList(new Comodo("c1", 10.0, 5.0));

        Casa casaTeste = new Casa("CasaTeste", "BairroTeste", list);
        casaService.salvarCasa(casaTeste);

        //Acao
        String result = casaService.getAreaComodos("CasaTeste");

        //Verificacao
        Assert.assertEquals("A area de cada comodo da casa CasaTeste é: Comodo: c1 com 50.0 metros quadrados.", result);
    }
}
