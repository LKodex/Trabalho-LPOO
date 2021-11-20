package io.github.lkodex.trabalho_lpoo.model;

public class Endereco {
    // Attributes //
    private String rua;
    private int numero;
    private String bairro;
    private String cidade;
    private String cep;

    // Constructors //
    public Endereco(String rua, int numero, String bairro, String cidade, String cep){
        this.rua = rua.strip();
        this.numero = numero;
        this.bairro = bairro.strip();
        this.cidade = cidade.strip();
        this.cep = cep.strip();
    }

    public Endereco(String rua, int numero, String bairro, String cidade){
        this.rua = rua.strip();
        this.numero = numero;
        this.bairro = bairro.strip();
        this.cidade = cidade.strip();
    }

    // Methods
    @Override
    public String toString(){
        if (cep != null){
            return String.format("%s, %d - %s. %s. %s.", rua, numero, bairro, cidade, cep);
        }
        return String.format("%s, %d - %s. %s.", rua, numero, bairro, cidade);
    }

    // Getters & Setters //
    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
