package com.github.dan.araujo.carrinho.compras.carrinho.compras.controller;

import com.github.dan.araujo.carrinho.compras.carrinho.compras.model.Carrinho;
import com.github.dan.araujo.carrinho.compras.carrinho.compras.model.Item;
import com.github.dan.araujo.carrinho.compras.carrinho.compras.repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/carrinho")
public class CarrinhoController {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Carrinho addItem(@PathVariable("id") Integer id, @RequestBody Item itens) {
        Optional<Carrinho> carrinhoSalvo = carrinhoRepository.findById(id);
        Carrinho carrinho;
        if (carrinhoSalvo.equals(Optional.empty())) {
            carrinho = new Carrinho(id);
        } else {
            carrinho = carrinhoSalvo.get();
        }
        carrinho.getItens().add(itens);
        return carrinhoRepository.save(carrinho);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Carrinho> encontrarPorId(@PathVariable("id") Integer id) {
        return carrinhoRepository.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void limpar(@PathVariable("id") Integer id) {
        carrinhoRepository.deleteById(id);
    }
}

