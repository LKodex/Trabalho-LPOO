package io.github.lkodex.trabalho_lpoo.model;

public class Cliente extends Pessoa {
    // Constructors //
    public Cliente(String nome, String cpf, Endereco endereco, String celular) {
        super(nome, cpf, endereco, celular);
    }

    // Methods //
    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + this.getNome() + '\'' +
                ", cpf='" + this.getCpf() + '\'' +
                ", celular='" + this.getCelular() + '\'' +
                '}';
    }
}
