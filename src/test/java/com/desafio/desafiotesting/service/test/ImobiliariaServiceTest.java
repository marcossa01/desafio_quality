package com.desafio.desafiotesting.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.desafio.desafiotesting.exception.BusinessException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ImobiliariaServiceTest {

	@Test
	public void deveRegistrarUmAnuncio() {/*
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
	
	@Test
	public void naoDeveRegistrarAnuncioQuandoPrecoForZero() {/*
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
