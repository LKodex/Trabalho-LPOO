package io.github.lkodex.trabalho_lpoo.model.dao;

import io.github.lkodex.trabalho_lpoo.Database;
import io.github.lkodex.trabalho_lpoo.model.Cliente;
import io.github.lkodex.trabalho_lpoo.model.Produto;

import java.util.List;

public class ProdutoDAO {
    public ProdutoDAO(){

    }

    // CRUD //
    public void createProduto(Produto produto){
        for (Produto produtoDB : Database.produtos){
            if (produtoDB.getCodigo() == produto.getCodigo()){
                updateProduto(produto);
                return;
            }
        }
        Database.produtos.add(produto);
    }

    public Produto readProduto(int codigo){
        for (Produto produto : Database.produtos) {
            if (produto.getCodigo() == codigo){
                return produto;
            }
        }
        return null;
    }

    public void updateProduto(Produto produto){
        int aux = 0;
        for (Produto produtoDB : Database.produtos){
            if (produtoDB.getCodigo() == (produto.getCodigo())){
                Database.produtos.set(aux, produto);
                return;
            }
            aux++;
        }
    }

    public void deleteProduto(Produto produto) {
        Database.produtos.remove(produto);
    }

    public List<Produto> getTable(){
        return Database.produtos;
    }
}
