package com.desafio.desafiotesting.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.desafio.desafiotesting.domain.Bairro;
import com.desafio.desafiotesting.repository.BairroRepository;
import com.desafio.desafiotesting.service.BairroService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

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
	public void verificaBairroExistente() {
		//arrange
		Bairro bairroExiste = new Bairro("Este Bairro Existe", new BigDecimal(5000));
		Bairro bairroNaoExiste = new Bairro("Este Bairro não Existe", new BigDecimal(5000));

		BairroRepository mockBairroRepository = Mockito.mock(BairroRepository.class);
		Mockito.doNothing().when(mockBairroRepository).salvar(bairroExiste);
		Mockito.when(mockBairroRepository.findByNome(bairroExiste.getNome())).thenReturn(bairroExiste);
		BairroService bairroService = new BairroService(mockBairroRepository);

		//act
		bairroService.salvar(bairroExiste);

		//assertion
		assertEquals(bairroExiste, bairroService.findByNome(bairroExiste.getNome()));
		assertNotEquals(bairroNaoExiste, bairroService.findByNome(bairroNaoExiste.getNome()));
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
