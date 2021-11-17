package io.github.lkodex.trabalho_lpoo.model;

public abstract class Pessoa implements Verificavel {
    // Attributes //
    private String nome;
    private String cpf;
    private Endereco endereco;
    private String celular;

    // Constructos //
    public Pessoa(String nome, String cpf, Endereco endereco, String celular){
        this.nome = nome;
        this.cpf = cpf;
        while (!this.validar(this.cpf)){
            this.solicitarNovo();
        }
        this.endereco = endereco;
        this.celular = celular;
    }
    // Methods //
    @Override
    public boolean validar(String cpf){
        int soma;
        int peso;
        char[] cpfVerificado;

        cpf = cpf.replaceAll("[^0-9]", "");
        if (cpf.length() != 11){
            return false;
        }

        soma = 0;
        peso = 10;
        cpfVerificado = cpf.toCharArray();

        // Verifica o primeiro dígito verificador
        for (int i = 0; i < 9; i++){
            soma += (cpfVerificado[i] - 48) * peso;
            peso--;
        }

        soma = 11 - (soma % 11);
        if (soma >= 10){
            cpfVerificado[9] = '0';
        } else {
            cpfVerificado[9] = (char)(soma + 48);
        }

        // Verifica o segundo dígito verificador
        soma = 0;
        peso = 11;

        for (int i = 0; i < 10; i++){
            soma += (cpfVerificado[i] - 48) * peso;
            peso--;
        }

        soma = 11 - (soma % 11);
        if (soma >= 10){
            cpfVerificado[10] = '0';
        } else {
            cpfVerificado[10] = (char)(soma + 48);
        }

        // Verifica se o CPF verificado é igual ao CPF informado
        return cpf.equals(new String(cpfVerificado));
    }

    @Override
    public void solicitarNovo(){

    }

    // Getters & Setters //
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}
