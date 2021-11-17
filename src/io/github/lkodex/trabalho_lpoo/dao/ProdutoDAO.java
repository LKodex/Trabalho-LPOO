package io.github.lkodex.trabalho_lpoo.dao;

import io.github.lkodex.trabalho_lpoo.Database;
import io.github.lkodex.trabalho_lpoo.model.Produto;

public class ProdutoDAO {
    private Database database;

    public ProdutoDAO(Database database){
        this.database = database;
    }

    // CRUD //
    public void createProduto(Produto produto){
        database.produtos.add(produto);
    }

    public Produto readProduto(int index){
        return database.produtos.get(index);
    }

    public void updateProduto(int index, Produto produto){
        database.produtos.set(index, produto);
    }

    public void deleteProduto(int index){
        database.produtos.remove(index);
    }

    public void deleteProduto(Produto produto) {
        database.produtos.remove(produto);
    }
}