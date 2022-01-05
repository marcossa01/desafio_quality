package com.desafio.desafiotesting.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ImobiliariaServiceTest {
/*
Verifique se o total de metros quadrados
calculados por propriedade está correto.

Retorna o cálculo correto do total de
metros quadrados de uma propriedade.*/
	@Test
	public void verificaSeTotalM2EstaCerto() {}

	/*Verifique se o bairro de entrada existe no
repositório de bairros.

Se cumprir:
Permite continuar normalmente.
Se não cumprir:
Relate a incompatibilidade com uma
exceção.*/
	@Test
	public void verificaBairroExistente() {/*
		//arrange
		Anuncio anuncio = Anuncio.builder()
				.codigo("MLB0988")
				.titulo("chave inglesa")
				.categoria("ferramentas")
				.preco(new BigDecimal(15.00)).build();
				
		AnuncioRepository mock = Mockito.mock(AnuncioRepository.class);
		Mockito.when(mock.salva(anuncio)).thenReturn(anuncio);
		AnuncioService anuncioService = new AnuncioService(mock);
		
		//act
		Anuncio anuncioRegistro = anuncioService.registrar(anuncio);
		
		//assertion
		assertEquals(anuncio.getId(), anuncioRegistro.getId());*/
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
}
