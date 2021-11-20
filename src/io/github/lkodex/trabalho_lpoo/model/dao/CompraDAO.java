package io.github.lkodex.trabalho_lpoo.model.dao;

import io.github.lkodex.trabalho_lpoo.Database;
import io.github.lkodex.trabalho_lpoo.model.Compra;

public class CompraDAO {
    public CompraDAO(){

    }

    // CRUD //
    public void createCompra(Compra compra){
        Database.compras.add(compra);
    }

    public Compra readCompra(int index){
        return Database.compras.get(index);
    }

    public void updateCompra(int index, Compra compra){
        Database.compras.set(index, compra);
    }

    public void deleteCompra(int index){
        Database.compras.remove(index);
    }

    public void deleteCompra(Compra compra) {
        Database.compras.remove(compra);
    }
}
