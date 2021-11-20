package io.github.lkodex.trabalho_lpoo.model.dao;

import io.github.lkodex.trabalho_lpoo.Database;
import io.github.lkodex.trabalho_lpoo.model.Cliente;
import io.github.lkodex.trabalho_lpoo.model.Funcionario;

import java.util.List;

public class FuncionarioDAO {
    public FuncionarioDAO(){

    }

    // CRUD //
    public void createFuncionario(Funcionario funcionario){
        for (Funcionario funcionarioDB : Database.funcionarios){
            if (funcionarioDB.getCpf().equals(funcionario.getCpf())){
                updateFuncionario(funcionario);
                return;
            }
        }
        Database.funcionarios.add(funcionario);
    }

    public Funcionario readFuncionario(String cpf){
        for (Funcionario funcionario : Database.funcionarios) {
            if (funcionario.getCpf().equals(Funcionario.formatarCpf(cpf))){
                return funcionario;
            }
        }
        return null;
    }

    public void updateFuncionario(Funcionario funcionario){
        int aux = 0;
        for (Funcionario funcionarioDB : Database.funcionarios){
            if (funcionarioDB.getCpf().equals(funcionario.getCpf())){
                Database.funcionarios.set(aux, funcionario);
                return;
            }
            aux++;
        }
    }

    public void deleteFuncionario(Funcionario funcionario) {
        Database.funcionarios.remove(funcionario);
    }

    public List<Funcionario> getTable(){
        return Database.funcionarios;
    }
}
