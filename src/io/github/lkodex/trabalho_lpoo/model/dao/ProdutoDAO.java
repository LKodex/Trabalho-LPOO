package io.github.lkodex.trabalho_lpoo.model.dao;

import io.github.lkodex.trabalho_lpoo.Database;
import io.github.lkodex.trabalho_lpoo.model.Produto;

public class ProdutoDAO {
    public ProdutoDAO(){

    }

    // CRUD //
    public void createProduto(Produto produto){
        Database.produtos.add(produto);
    }

    public Produto readProduto(int index){
        return Database.produtos.get(index);
    }

    public void updateProduto(int index, Produto produto){
        Database.produtos.set(index, produto);
    }

    public void deleteProduto(int index){
        Database.produtos.remove(index);
    }

    public void deleteProduto(Produto produto) {
        Database.produtos.remove(produto);
    }
}
