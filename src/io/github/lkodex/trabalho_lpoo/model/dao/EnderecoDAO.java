package io.github.lkodex.trabalho_lpoo.model.dao;

import io.github.lkodex.trabalho_lpoo.Database;
import io.github.lkodex.trabalho_lpoo.model.Endereco;

public class EnderecoDAO {
    public EnderecoDAO(){

    }

    // CRUD //
    public void createEndereco(Endereco endereco){
        Database.enderecos.add(endereco);
    }

    public Endereco readEndereco(int index){
        return Database.enderecos.get(index);
    }

    public void updateEndereco(int index, Endereco endereco){
        Database.enderecos.set(index, endereco);
    }

    public void deleteEndereco(int index){
        Database.enderecos.remove(index);
    }

    public void deleteEndereco(Endereco endereco) {
        Database.enderecos.remove(endereco);
    }
}
