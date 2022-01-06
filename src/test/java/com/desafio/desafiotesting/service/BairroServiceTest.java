package com.desafio.desafiotesting.service;

import com.desafio.desafiotesting.domain.Bairro;
import com.desafio.desafiotesting.service.exceptions.BairroNullException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class BairroServiceTest {

    private BairroService bairroService;

    @Before
    public void setup() {
        bairroService = new BairroService();
    }

    @Test
    public void testBairroExisteList() {
        //Cenario
        Bairro b1 = new Bairro("Bairro1", new BigDecimal(100.00));
        bairroService.salvar(b1);

        //Acão
        Bairro bairro = bairroService.findByNome("Bairro1");
        Assert.assertEquals("Bairro1", bairro.getNome());
    }
}
