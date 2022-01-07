package com.desafio.desafiotesting.service.test;

import com.desafio.desafiotesting.domain.Bairro;
import com.desafio.desafiotesting.domain.Casa;
import com.desafio.desafiotesting.domain.Comodo;
import com.desafio.desafiotesting.service.BairroService;
import com.desafio.desafiotesting.service.CasaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ImobiliariaServiceTest {

	@Mock
	private CasaService service;

	@Mock
	private BairroService bairroservice;

	@Spy // mock it partially
	@InjectMocks
	private CasaService servicerp = new CasaService();
	@BeforeEach
	public void beforeEach(){
		MockitoAnnotations.openMocks(this);
		this.service = servicerp;
	}
	/*
	Verifique se o total de metros quadrados
	calculados por propriedade está correto.

	Retorna o cálculo correto do total de
	metros quadrados de uma propriedade.*/
	@Test
	public void verificaSeTotalM2EstaCerto() {
		Casa casaTeste = retornaCasa();
		Mockito.when(service.findByNome("Casa1")).thenReturn(casaTeste);
		String areaCasa = service.getAreaCasa(casaTeste.getNome());
		Assertions.assertEquals("A área total da casa é de: 55.0 metros.", areaCasa);
	}

	/*Verifique se o bairro de entrada existe no repositório de bairros.
	Se cumprir:
	Permite continuar normalmente.
	Se não cumprir:
	Relate a incompatibilidade com uma
	exceção.*/
	@Test
	public void verificaBairroExistenteCasoExista() {
		Bairro bairroTeste = new Bairro("Liberdade", new BigDecimal("43"));
		BairroService bairroService = new BairroService();
		bairroService.salvar(bairroTeste);
		Bairro bairroLocalizado = bairroService.findByNome("Liberdade");
		Assertions.assertEquals("Liberdade", bairroLocalizado.getNome());
	}
	@Test
	public void verificaBairroExistenteCasoNãoExista() {
		Bairro bairroTeste = new Bairro("Liberdade", new BigDecimal("43"));
		bairroservice.salvar(bairroTeste);
		Mockito.when(bairroservice.findByNome(Mockito.any())).thenThrow(RuntimeException.class);
		try {
			bairroservice.findByNome("Liberdade");
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}

	/*
	Verifique se o maior cômodo foi realmente devolvido.
	Retorna o cômodo com o maior tamanho*/
	@Test
	public void verificaSeComodoMaiorEstaCorreto() {
		Bairro bairroTeste = new Bairro("Liberdade", new BigDecimal("43"));
		bairroservice.salvar(bairroTeste);
		Casa casaTeste = retornaCasa();
		Mockito.when(bairroservice.findByNome(Mockito.any())).thenReturn(bairroTeste);
		service.salvarCasa(casaTeste);
		String result = service.getMaiorComodo(casaTeste.getNome());
		Assertions.assertEquals("O maior comodo da casa Casa1: Quarto com área de 25.0 metros quadrados.", result);
	}

	/*
	Verifique se de fato o total de metros 	quadrados por cômodo está correto.
	Retorna o cálculo correto do total de 	metros quadrados de um cômodo.*/

	@Test
	public void verificaTotalM2DoComodo() {
		Bairro bairroTeste = new Bairro("Liberdade", new BigDecimal("43"));
		bairroservice.salvar(bairroTeste);
		Casa casaTeste = retornaCasa();
		Mockito.when(bairroservice.findByNome(Mockito.any())).thenReturn(bairroTeste);
		service.salvarCasa(casaTeste);
		String result = service.getAreaComodos(casaTeste.getNome());
		Assertions.assertEquals("A area de cada comodo da casa Casa1 é: <br>Comodo: Cozinha com 15.0 metros quadrados<br>Comodo: Sala com 15.0 metros quadrados<br>Comodo: Quarto com 25.0 metros quadrados<br>", result);
	}

	private Casa retornaCasa(){
		List<Comodo> comodos = new ArrayList<>();
		comodos.add(new Comodo("Cozinha", 3.0, 5.0));
		comodos.add(new Comodo("Sala", 3.0, 5.0));
		comodos.add(new Comodo("Quarto", 5.0, 5.0));
		Casa casa = new Casa("Casa1", "Liverdade", comodos);
		return casa;
	}
}
