package com.github.dan.araujo.catalogo.produtos.controller;

import com.github.dan.araujo.catalogo.produtos.model.Produto;
import com.github.dan.araujo.catalogo.produtos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @RequestMapping(method = RequestMethod.POST)
    Produto criar(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Optional<Produto> encontrarPorId(@PathVariable Integer id) {
        return produtoRepository.findById(id);
    }
}
