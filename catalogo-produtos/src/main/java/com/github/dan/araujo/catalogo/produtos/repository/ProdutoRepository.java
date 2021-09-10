package com.github.dan.araujo.catalogo.produtos.repository;

import com.github.dan.araujo.catalogo.produtos.model.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Integer> {
}
