package io.github.lkodex.trabalho_lpoo.model.dao;

import io.github.lkodex.trabalho_lpoo.Database;
import io.github.lkodex.trabalho_lpoo.model.Funcionario;

public class FuncionarioDAO {
    public FuncionarioDAO(){

    }

    // CRUD //
    public void createFuncionario(Funcionario funcionario){
        Database.funcionarios.add(funcionario);
    }

    public Funcionario readFuncionario(int index){
        return Database.funcionarios.get(index);
    }

    public void updateFuncionario(int index, Funcionario funcionario){
        Database.funcionarios.set(index, funcionario);
    }

    public void deleteFuncionario(int index){
        Database.funcionarios.remove(index);
    }

    public void deleteFuncionario(Funcionario funcionario) {
        Database.funcionarios.remove(funcionario);
    }
}
