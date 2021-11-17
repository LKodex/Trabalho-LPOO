package io.github.lkodex.trabalho_lpoo.dao;

import io.github.lkodex.trabalho_lpoo.Database;
import io.github.lkodex.trabalho_lpoo.model.Compra;

public class CompraDAO {
    private Database database;

    public CompraDAO(Database database){
        this.database = database;
    }

    // CRUD //
    public void createCompra(Compra compra){
        database.compras.add(compra);
    }

    public Compra readCompra(int index){
        return database.compras.get(index);
    }

    public void updateCompra(int index, Compra compra){
        database.compras.set(index, compra);
    }

    public void deleteCompra(int index){
        database.compras.remove(index);
    }

    public void deleteCompra(Compra compra) {
        database.compras.remove(compra);
    }
}
