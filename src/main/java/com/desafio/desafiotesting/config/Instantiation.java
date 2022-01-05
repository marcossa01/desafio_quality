package com.desafio.desafiotesting.config;

import com.desafio.desafiotesting.domain.Casa;
import com.desafio.desafiotesting.domain.Comodo;
import com.desafio.desafiotesting.service.CasaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class Instantiation implements CommandLineRunner {

    private final CasaService casaService = new CasaService();

    @Override
    public void run(String... args) {

        System.out.println("Teste");

        Comodo comodo1 = new Comodo("Quarto", 10.5, 20.0);
        Comodo comodo2 = new Comodo("Cozinha", 10.5, 20.0);
        Comodo comodo3 = new Comodo("Sala", 10.5, 20.0);

        Comodo comodo4 = new Comodo("Banheiro", 5.0, 10.0);
        Comodo comodo5 = new Comodo("Quarto", 7.0, 10.5);
        Comodo comodo6 = new Comodo("Cozinha", 10.5, 15.0);

        Comodo comodo7 = new Comodo("Quarto", 10.0, 20.0);
        Comodo comodo8 = new Comodo("Cozinha", 10.5, 16.0);
        Comodo comodo9 = new Comodo("Sala", 15.5, 20.0);

        List<Comodo> c1 = new ArrayList<>(Arrays.asList(comodo1, comodo2, comodo3));
        List<Comodo> c2 = new ArrayList<>(Arrays.asList(comodo4, comodo5, comodo6));
        List<Comodo> c3 = new ArrayList<>(Arrays.asList(comodo7, comodo8, comodo9));

        Casa casa1 = new Casa("Casa1", "QNP 28 CONJUNTO U CASA 12", c1);
        casaService.salvarCasa(casa1);

        Casa casa2 = new Casa("Casa2", "QNP 32 CONJUNTO V CASA 18", c2);
        casaService.salvarCasa(casa2);

        Casa casa3 = new Casa("Casa3", "SHPS 103 CONJUNTO B CASA 07", c3);
        casaService.salvarCasa(casa3);

    }
}
