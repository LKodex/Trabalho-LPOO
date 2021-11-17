package io.github.lkodex.trabalho_lpoo.dao;

import io.github.lkodex.trabalho_lpoo.Database;
import io.github.lkodex.trabalho_lpoo.model.Funcionario;

public class FuncionarioDAO {
    private Database database;

    public FuncionarioDAO(Database database){
        this.database = database;
    }

    // CRUD //
    public void createFuncionario(Funcionario funcionario){
        database.funcionarios.add(funcionario);
    }

    public Funcionario readFuncionario(int index){
        return database.funcionarios.get(index);
    }

    public void updateFuncionario(int index, Funcionario funcionario){
        database.funcionarios.set(index, funcionario);
    }

    public void deleteFuncionario(int index){
        database.funcionarios.remove(index);
    }

    public void deleteFuncionario(Funcionario funcionario) {
        database.funcionarios.remove(funcionario);
    }
}
