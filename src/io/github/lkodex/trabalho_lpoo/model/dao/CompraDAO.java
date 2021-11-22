package io.github.lkodex.trabalho_lpoo.model.dao;

import io.github.lkodex.trabalho_lpoo.Database;
import io.github.lkodex.trabalho_lpoo.model.Cliente;
import io.github.lkodex.trabalho_lpoo.model.Compra;

import java.util.List;

public class CompraDAO {
    public CompraDAO(){

    }

    // CRUD //
    public void createCompra(Compra compra){
        for (Compra compraDB : Database.compras){
            if (compraDB.getCodigoCompra() == compra.getCodigoCompra()){
                updateCompra(compra);
                return;
            }
        }
        Database.compras.add(compra);
    }

    public Compra readCompra(int codigo){
        for (Compra compra : Database.compras) {
            if (compra.getCodigoCompra() == codigo){
                return compra;
            }
        }
        return null;
    }

    public void updateCompra(Compra compra){
        int codigoCompra = compra.getCodigoCompra();
        int aux = 0;
        for (Compra compraBD : Database.compras){
            if (compraBD.getCodigoCompra() == codigoCompra){
                Database.compras.set(aux, compra);
                return;
            }
            aux++;
        }
    }

    public void deleteCompra(Compra compra) {
        Database.compras.remove(compra);
    }

    public List<Compra> getTable(){
        return Database.compras;
    }
}
