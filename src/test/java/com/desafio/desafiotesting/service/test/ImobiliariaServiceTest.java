package com.desafio.desafiotesting.service.test;

import com.desafio.desafiotesting.domain.Bairro;
import com.desafio.desafiotesting.domain.Casa;
import com.desafio.desafiotesting.domain.Comodo;
import com.desafio.desafiotesting.exception.BusinessException;
import com.desafio.desafiotesting.exception.NullException;
import com.desafio.desafiotesting.exception.RepositoryException;
import com.desafio.desafiotesting.repository.BairroRepository;
import com.desafio.desafiotesting.repository.CasaRepository;
import com.desafio.desafiotesting.service.BairroService;
import com.desafio.desafiotesting.service.CasaService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

        NullException excecaoEsperada = assertThrows(
                NullException.class,
                () -> casaService.salvarCasa(casas.get(3))
        );

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

		bairroService.salvar(bairro.get(0));
		BusinessException excecaoEsperada = assertThrows(
				BusinessException.class,
				() -> bairroService.salvar(bairro.get(4))
		);

		assertEquals(new Bairro("Vila velha", BigDecimal.valueOf(10000)), bairroService.findByNome(bairro.get(0).getNome()));
		assertNotNull(bairroService);
		assertTrue(excecaoEsperada.getMessage().contains("nao e permitido cadastrar bairro som informar dados"));
	}

    /*
	Verifique se o maior cômodo foi realmente
	devolvido.
	Retorna o cômodo com o maior tamanho*/
    @Test
    public void verificaSeComodoMaiorEstaCorreto() {
		List<Casa> casas = mockCasas();

        CasaRepository mockCasaRepository = Mockito.mock(CasaRepository.class);
        Mockito.doNothing().when(mockCasaRepository).salvar(mockCasas().get(3));
        Mockito.when(mockCasaRepository.findByNome(casas.get(3).getNome())).thenReturn(casas.get(3));
        CasaService casaService = new CasaService(mockCasaRepository);

        RepositoryException excecaoEsperada = assertThrows(
                RepositoryException.class,
                () -> casaService.getAreaCasa(casas.get(1).getNome())
        );

        assertTrue(excecaoEsperada.getMessage().contains("Casa inexistente."));
        assertEquals("Suite", StringUtils.capitalize("suite"), casaService.getMaiorComodo(casas.get(3).getNome()));
        assertEquals("45.0", StringUtils.capitalize("45.0"), casaService.getMaiorComodo(casas.get(3).getNome()));
    }

	/*

	Verifique se de fato o total de metros
	quadrados por cômodo está correto.
	Retorna o cálculo correto do total de
	metros quadrados de um cômodo.
	 */
    @Test
    public void verificaTotalM2DoComodo() {
		List<Casa> casas = mockCasas();

        CasaRepository mockCasaRepository = Mockito.mock(CasaRepository.class);
        Mockito.doNothing().when(mockCasaRepository).salvar(mockCasas().get(3));
        Mockito.when(mockCasaRepository.findByNome(casas.get(3).getNome())).thenReturn(casas.get(3));
        CasaService casaService = new CasaService(mockCasaRepository);

        RepositoryException excecaoEsperada = assertThrows(
                RepositoryException.class,
                () -> casaService.getMaiorComodo(null)
        );

        assertTrue(excecaoEsperada.getMessage().contains("Imovel inexistente."));
        //metros quadrados do quarto
        assertEquals("19.5", StringUtils.capitalize("19.5"), casaService.getMaiorComodo(casas.get(3).getNome()));
        //metros quadrados da cozinha
        assertEquals("6.0", StringUtils.capitalize("6.0"), casaService.getMaiorComodo(casas.get(3).getNome()));
        //metros quadrados do banheiro
        assertEquals("4.0", StringUtils.capitalize("4.0"), casaService.getMaiorComodo(casas.get(3).getNome()));
        //metros quadrados da sala
        assertEquals("15.0", StringUtils.capitalize("15.0"), casaService.getMaiorComodo(casas.get(3).getNome()));
        //metros quadrados da suite
        assertEquals("45.0", StringUtils.capitalize("45.0"), casaService.getMaiorComodo(casas.get(3).getNome()));
        assertNotNull(casaService.findAll());
    }


    @Test
    @AutoConfigureMockMvc
    public void chamadaControllerOK(){


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
        Casa casa1 = new Casa("", "Vila nova",comodos);
        Casa casa2 = new Casa("casa4", "Vila antiga",comodos);
        Casa casa3 = new Casa("casa5",null,comodos);
        casas.add(casa);
        casas.add(casa1);
        casas.add(casa2);
        casas.add(casa3);

        return casas;
    }

}
