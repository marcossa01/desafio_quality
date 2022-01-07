package com.desafio.desafiotesting.service;

import com.desafio.desafiotesting.domain.Bairro;
import com.desafio.desafiotesting.exception.RepositoryException;
import com.desafio.desafiotesting.repository.BairroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * Service bairro
 */
@Service
@AllArgsConstructor
public class BairroService {

    /***
     * repositório do bairro
     */
    BairroRepository bairroRepository;

    /***
     * busca todos os bairros
     * @return lista de lairros
     */
    public List<Bairro> findAll() {
        return bairroRepository.findAll();
    }

    public Bairro findByNome(String nome) {
        if (nome == null || nome.isEmpty())
            throw new BusinessException("nao e permitido cadastrar bairro com o nome em branco");
        return bairroRepository.findByNome(nome);
    }

    /***
     * salva bairro
     * @param bairro bairro
     */
    public void salvar(Bairro bairro) {
        if (bairro.getNome() == null || bairro.getValorMetroQuadrado().compareTo(BigDecimal.ZERO) <= 0)
            throw new BusinessException("nao e permitido cadastrar bairro som informar dados");
        this.verificarBairroExistente(bairro.getNome());
        bairroRepository.salvar(bairro);
    }

    /***
     * verifica se bairro não existe, lança exceção se bairro ja existe
     * @param nome nome
     */
    private void verificarBairroExistente(String nome){
        if ( bairroRepository.findByNome(nome) != null)
            throw new RepositoryException("Ja existe bairro com esse nome.");
    }
}
