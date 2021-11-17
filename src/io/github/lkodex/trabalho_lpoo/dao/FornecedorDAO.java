package io.github.lkodex.trabalho_lpoo.dao;

import io.github.lkodex.trabalho_lpoo.Database;
import io.github.lkodex.trabalho_lpoo.model.Fornecedor;

public class FornecedorDAO {
    private Database database;

    public FornecedorDAO(Database database){
        this.database = database;
    }

    // CRUD //
    public void createFornecedor(Fornecedor fornecedor){
        database.fornecedores.add(fornecedor);
    }

    public Fornecedor readFornecedor(int index){
        return database.fornecedores.get(index);
    }

    public void updateFornecedor(int index, Fornecedor fornecedor){
        database.fornecedores.set(index, fornecedor);
    }

    public void deleteFornecedor(int index){
        database.fornecedores.remove(index);
    }

    public void deleteFornecedor(Fornecedor fornecedor) {
        database.fornecedores.remove(fornecedor);
    }
}
