package com.desafio.desafiotesting.service;

import com.desafio.desafiotesting.domain.Casa;
import com.desafio.desafiotesting.domain.Comodo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComodoService {

    List<Comodo> comodos = new ArrayList<>();

    public void salvarComodo(Comodo comodo) {
        comodos.add(comodo);
    }

}
