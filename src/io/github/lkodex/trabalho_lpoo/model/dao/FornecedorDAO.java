package io.github.lkodex.trabalho_lpoo.model.dao;

import io.github.lkodex.trabalho_lpoo.Database;
import io.github.lkodex.trabalho_lpoo.model.Fornecedor;

import java.util.List;

public class FornecedorDAO {
    public FornecedorDAO(){

    }

    // CRUD //
    public void createFornecedor(Fornecedor fornecedor){
        String cnpj = fornecedor.getCnpj();
        for (Fornecedor fornecedorDB : Database.fornecedores){
            if (fornecedorDB.getCnpj().equals(cnpj)){
                updateFornecedor(fornecedor);
                return;
            }
        }
        Database.fornecedores.add(fornecedor);
    }

    public Fornecedor readFornecedor(String cnpj){
        cnpj = Fornecedor.formatarCnpj(cnpj);
        for (Fornecedor fornecedor : Database.fornecedores) {
            if (fornecedor.getCnpj().equals(cnpj)){
                return fornecedor;
            }
        }
        return null;
    }

    public void updateFornecedor(Fornecedor fornecedor){
        for (Fornecedor fornecedorDB : Database.fornecedores){
            if (fornecedorDB.getCnpj().equals(fornecedor.getCnpj())){
                Database.fornecedores.remove(fornecedorDB);
                Database.fornecedores.add(fornecedor);
                return;
            }
        }
    }

    public void deleteFornecedor(Fornecedor fornecedor) {
        Database.fornecedores.remove(fornecedor);
    }

    public List<Fornecedor> getTable(){
        return Database.fornecedores;
    }
}
