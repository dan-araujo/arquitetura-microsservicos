package com.github.dan.araujo.carrinho.compras.carrinho.compras.model;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("item")
public class Item {

    private Integer idProduto;
    private Integer quantidade;

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Item{" +
                "idProduto=" + idProduto +
                ", quantidade=" + quantidade +
                '}';
    }
}
