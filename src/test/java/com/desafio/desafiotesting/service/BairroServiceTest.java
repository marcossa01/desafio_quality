package com.desafio.desafiotesting.service;

import com.desafio.desafiotesting.domain.Bairro;
import com.desafio.desafiotesting.service.exceptions.BairroNullException;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class BairroServiceTest {

    @Test
    public void testBairroExisteList() {
        //Cenario
        BairroService bairroService = new BairroService();

        Bairro b1 = new Bairro("Bairro1", new BigDecimal(100.00));
        bairroService.salvar(b1);

        //Acão
        Bairro bairro = bairroService.findByNome("Bairro1");
        Assert.assertEquals("Bairro1", bairro.getNome());
    }
}
