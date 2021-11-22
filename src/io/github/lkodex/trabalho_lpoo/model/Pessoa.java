package io.github.lkodex.trabalho_lpoo.model;

public abstract class Pessoa implements Verificavel {
    // Attributes //
    private String nome;
    private String cpf;
    private Endereco endereco;
    private String celular;

    // Constructos //
    public Pessoa(String nome, String cpf, Endereco endereco, String celular){
        this.nome = nome.strip();
        this.cpf = cpf.strip().replaceAll("[^0-9]", "");
        this.endereco = endereco;
        this.celular = celular.strip();
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
        char[] cpfFormatado = new char[14];
        char[] cpfArray = this.cpf.toCharArray();

        cpfFormatado[13] = cpfArray[10];
        cpfFormatado[12] = cpfArray[9];

        cpfFormatado[11] = '-';

        cpfFormatado[10] = cpfArray[8];
        cpfFormatado[9] = cpfArray[7];
        cpfFormatado[8] = cpfArray[6];

        cpfFormatado[7] = '.';

        cpfFormatado[6] = cpfArray[5];
        cpfFormatado[5] = cpfArray[4];
        cpfFormatado[4] = cpfArray[3];

        cpfFormatado[3] = '.';

        cpfFormatado[2] = cpfArray[2];
        cpfFormatado[1] = cpfArray[1];
        cpfFormatado[0] = cpfArray[0];

        return new String(cpfFormatado);
    }

    public static String formatarCpf(String cpf){
        if (cpf.length() != 11){
            return cpf;
        }

        char[] cpfFormatado = new char[14];
        char[] cpfArray = cpf.toCharArray();

        cpfFormatado[13] = cpfArray[10];
        cpfFormatado[12] = cpfArray[9];

        cpfFormatado[11] = '-';

        cpfFormatado[10] = cpfArray[8];
        cpfFormatado[9] = cpfArray[7];
        cpfFormatado[8] = cpfArray[6];

        cpfFormatado[7] = '.';

        cpfFormatado[6] = cpfArray[5];
        cpfFormatado[5] = cpfArray[4];
        cpfFormatado[4] = cpfArray[3];

        cpfFormatado[3] = '.';

        cpfFormatado[2] = cpfArray[2];
        cpfFormatado[1] = cpfArray[1];
        cpfFormatado[0] = cpfArray[0];

        return new String(cpfFormatado);
    }

    public String getCpfCensurado(){
        if (cpf.length() != 11){
            return cpf;
        }

        char[] cpfFormatado = new char[14];
        char[] cpfArray = cpf.toCharArray();

        cpfFormatado[13] = '*';
        cpfFormatado[12] = '*';

        cpfFormatado[11] = '-';

        cpfFormatado[10] = cpfArray[8];
        cpfFormatado[9] = cpfArray[7];
        cpfFormatado[8] = cpfArray[6];

        cpfFormatado[7] = '.';

        cpfFormatado[6] = cpfArray[5];
        cpfFormatado[5] = cpfArray[4];
        cpfFormatado[4] = cpfArray[3];

        cpfFormatado[3] = '.';

        cpfFormatado[2] = '*';
        cpfFormatado[1] = '*';
        cpfFormatado[0] = '*';

        return new String(cpfFormatado);
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
