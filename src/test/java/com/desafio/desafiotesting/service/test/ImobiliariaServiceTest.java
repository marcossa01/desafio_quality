package com.desafio.desafiotesting.service.test;

import com.desafio.desafiotesting.domain.Bairro;
import com.desafio.desafiotesting.domain.Casa;
import com.desafio.desafiotesting.domain.Comodo;
import com.desafio.desafiotesting.exception.BusinessException;
import com.desafio.desafiotesting.exception.NullException;
import com.desafio.desafiotesting.repository.BairroRepository;
import com.desafio.desafiotesting.repository.CasaRepository;
import com.desafio.desafiotesting.service.BairroService;
import com.desafio.desafiotesting.service.CasaService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

public class ImobiliariaServiceTest {
    /*
    Verifique se o total de metros quadrados
    calculados por propriedade está correto.
    Retorna o cálculo correto do total de
    metros quadrados de uma propriedade.*/
    @Test
    public void verificaSeTotalM2EstaCerto() {

        List<Casa> casas = mockCasas();

        CasaRepository mockCasaRepository = Mockito.mock(CasaRepository.class);
        Mockito.doNothing().when(mockCasaRepository).salvar(mockCasas().get(0));
        Mockito.when(mockCasaRepository.findByNome(casas.get(0).getNome())).thenReturn(casas.get(0));
        CasaService casaService = new CasaService(mockCasaRepository);

        //casaService.salvarCasa(casas.get(0));
        NullException excecaoEsperada = assertThrows(
                NullException.class,
                () -> casaService.salvarCasa(casas.get(3))
        );

        //assertion
        assertEquals(89.5,casaService.calcularAreaTotal(casas.get(0)));
        assertTrue(excecaoEsperada.getMessage().contains("o campo bairro esta vazio"));
        assertNotNull(mockCasaRepository);
    }

	/*Verifique se o bairro de entrada existe no
	repositório de bairros.
	Se cumprir:
	Permite continuar normalmente.
	Se não cumprir:
  	Relate a incompatibilidade com uma
    exceção.*/
	@Test
	public void verificaBairroExistente() {
		List<Bairro> bairro = mockTesteBairro();

		BairroRepository mockBairroRepository = Mockito.mock(BairroRepository.class);
		Mockito.doNothing().when(mockBairroRepository).salvar(bairro.get(0));
		Mockito.when(mockBairroRepository.findByNome(bairro.get(0).getNome())).thenReturn(bairro.get(0));
		BairroService bairroService = new BairroService(mockBairroRepository);

		//act
		bairroService.salvar(bairro.get(0));
		BusinessException excecaoEsperada = assertThrows(
				BusinessException.class,
				() -> bairroService.salvar(bairro.get(4))
		);

		//assertion
		assertEquals(new Bairro("Vila velha", BigDecimal.valueOf(10000)), bairroService.findByNome(bairro.get(0).getNome()));
		assertNotNull(bairroService);
		assertTrue(excecaoEsperada.getMessage().contains("nao e permitido cadastrar bairro som informar dados"));
	}

    /*
	Verifique se o maior cômodo foi realmente
	devolvido.
	Retorna o cômodo com o maior tamanho*/
    @Test
    public void verificaSeComodoMaiorEstaCorreto() {/*
		//arrange
		Anuncio anuncio = Anuncio.builder()
				.codigo("MLB0988")
				.titulo("chave inglesa")
				.categoria("ferramentas")
				.preco(new BigDecimal(0)).build();

		AnuncioRepository mock = Mockito.mock(AnuncioRepository.class);
		AnuncioService anuncioService = new AnuncioService(mock);

	    BusinessException excecaoEsperada = assertThrows(
	    		BusinessException.class,
	            () -> anuncioService.registrar(anuncio) //act
	     );

	    //assertion
	    assertTrue(excecaoEsperada.getMessage().contains("Nao eh permitido registro de anuncio com valor zero"));*/
    }

	/*

	Verifique se de fato o total de metros
	quadrados por cômodo está correto.
	Retorna o cálculo correto do total de
	metros quadrados de um cômodo.
	 */
    @Test
    public void verificaTotalM2DoComodo() {/*
		//arrange
		Anuncio anuncio = Anuncio.builder()
				.codigo("MLB0988")
				.titulo("chave inglesa")
				.categoria("ferramentas")
				.preco(new BigDecimal(0)).build();

		AnuncioRepository mock = Mockito.mock(AnuncioRepository.class);
		AnuncioService anuncioService = new AnuncioService(mock);

	    BusinessException excecaoEsperada = assertThrows(
	    		BusinessException.class,
	            () -> anuncioService.registrar(anuncio) //act
	     );

	    //assertion
	    assertTrue(excecaoEsperada.getMessage().contains("Nao eh permitido registro de anuncio com valor zero"));*/
    }

    public List<Bairro> mockTesteBairro() {
        List<Bairro> bairros = new ArrayList<>();
        Bairro bairro = new Bairro("Vila velha", BigDecimal.valueOf(10000));
        Bairro bairro1 = new Bairro("Vila nova", BigDecimal.valueOf(11000));
        Bairro bairro2 = new Bairro("Vila antiga", BigDecimal.valueOf(12000));
        Bairro bairro3 = new Bairro("Vila atual", BigDecimal.valueOf(13000));
        Bairro bairro4 = new Bairro(null, BigDecimal.valueOf(14000));
        bairros.add(bairro);
        bairros.add(bairro1);
        bairros.add(bairro2);
        bairros.add(bairro3);
        bairros.add(bairro4);
        return bairros;
    }

    public List<Casa> mockCasas(){
        List<Casa> casas = new ArrayList<>();

        List<Comodo> comodos = new ArrayList<>();
        Comodo comodo1 = new Comodo("quarto", 6.5, 3.0);
        Comodo comodo2 = new Comodo("cozinha", 2.0, 3.0);
        Comodo comodo3 = new Comodo("banheiro", 2.0, 2.0);
        Comodo comodo4 = new Comodo("sala", 5.0, 3.0);
        Comodo comodo5 = new Comodo("suite", 9.0, 5.0);
        comodos.add(comodo1);
        comodos.add(comodo2);
        comodos.add(comodo3);
        comodos.add(comodo4);
        comodos.add(comodo5);

        Casa casa = new Casa("casa1", "Vila velha",comodos);
        Casa casa1 = new Casa("casa2", "Vila nova",comodos);
        Casa casa2 = new Casa("casa4", "Vila antiga",comodos);
        Casa casa3 = new Casa("casa5",null,comodos);
        casas.add(casa);
        casas.add(casa1);
        casas.add(casa2);
        casas.add(casa3);

        return casas;
    }
}
