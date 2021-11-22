package io.github.lkodex.trabalho_lpoo.model.dao;

import io.github.lkodex.trabalho_lpoo.Database;
import io.github.lkodex.trabalho_lpoo.model.Cliente;

import java.util.List;

public class ClienteDAO {
    public ClienteDAO(){

    }

    // CRUD //
    public void createCliente(Cliente cliente){
        for (Cliente clienteDB : Database.clientes){
            if (clienteDB.getCpf().equals(cliente.getCpf())){
                updateCliente(cliente);
                return;
            }
        }
        Database.clientes.add(cliente);
    }

    public Cliente readCliente(String cpf){
        cpf = Cliente.formatarCpf(cpf);
        for (Cliente cliente : Database.clientes) {
            if (cliente.getCpf().equals(cpf)){
                return cliente;
            }
        }
        return null;
    }

    public void updateCliente(Cliente cliente){
        int aux = 0;
        for (Cliente clienteDB : Database.clientes){
            if (clienteDB.getCpf().equals(cliente.getCpf())){
                Database.clientes.set(aux, cliente);
                return;
            }
            aux++;
        }
    }

    public void deleteCliente(Cliente cliente) {
        Database.clientes.remove(cliente);
    }

    public List<Cliente> getTable(){
        return Database.clientes;
    }
}
