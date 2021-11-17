package io.github.lkodex.trabalho_lpoo.dao;

import io.github.lkodex.trabalho_lpoo.Database;
import io.github.lkodex.trabalho_lpoo.model.Cliente;

public class ClienteDAO {
    private Database database;

    public ClienteDAO(Database database){
        this.database = database;
    }

    // CRUD //
    public void createCliente(Cliente cliente){
        database.clientes.add(cliente);
    }

    public Cliente readCliente(int index){
        return database.clientes.get(index);
    }

    public void updateCliente(int index, Cliente cliente){
        database.clientes.set(index, cliente);
    }

    public void deleteCliente(int index){
        database.clientes.remove(index);
    }

    public void deleteCliente(Cliente cliente) {
        database.clientes.remove(cliente);
    }
}
