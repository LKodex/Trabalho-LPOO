package io.github.lkodex.trabalho_lpoo.dao;

import io.github.lkodex.trabalho_lpoo.Database;
import io.github.lkodex.trabalho_lpoo.model.Endereco;

public class EnderecoDAO {
    private Database database;

    public EnderecoDAO(Database database){
        this.database = database;
    }

    // CRUD //
    public void createEndereco(Endereco endereco){
        database.enderecos.add(endereco);
    }

    public Endereco readEndereco(int index){
        return database.enderecos.get(index);
    }

    public void updateEndereco(int index, Endereco endereco){
        database.enderecos.set(index, endereco);
    }

    public void deleteEndereco(int index){
        database.enderecos.remove(index);
    }

    public void deleteEndereco(Endereco endereco) {
        database.enderecos.remove(endereco);
    }
}
