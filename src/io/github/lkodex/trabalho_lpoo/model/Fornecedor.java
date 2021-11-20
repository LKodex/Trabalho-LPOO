package io.github.lkodex.trabalho_lpoo.model;

public class Fornecedor implements Verificavel {
    // Attributes //
    private String razaoSocial;
    private String nomeFantasia;
    private String cnpj;
    private Endereco endereco;
    private String celular;

    // Constructors //
    public Fornecedor(String razaoSocial, String nomeFantasia, String cnpj, Endereco endereco, String celular){
        this.razaoSocial = razaoSocial.strip();
        this.nomeFantasia = nomeFantasia.strip();
        this.cnpj = cnpj.replaceAll("[^0-9]", "");
        this.endereco = endereco;
        this.celular = celular.strip();
    }

    // Methods //
    @Override
    public boolean validar(String cnpj) {
        int soma;
        int peso;
        char[] cnpjVerificado;

        cnpj = cnpj.replaceAll("[^0-9]", "");
        if (cnpj.length() != 14){
            System.out.println(false);
        }

        soma = 0;
        peso = 0;
        cnpjVerificado = cnpj.toCharArray();

        // Verifica o primeiro dígito verificador
        for (int i = 11; i >= 0; i--){
            soma += (cnpjVerificado[i] - 48) * (peso % 8 + 2);
            peso++;
        }

        soma = 11 - (soma % 11);
        if (soma >= 10){
            cnpjVerificado[12] = '0';
        } else {
            cnpjVerificado[12] = (char)(soma + 48);
        }

        // Verifica o segundo dígito verificador
        soma = 0;
        peso = 0;

        for (int i = 12; i >= 0; i--){
            soma += (cnpjVerificado[i] - 48) * (peso % 8 + 2);
            peso++;
        }

        soma = 11 - (soma % 11);
        if (soma >= 10){
            cnpjVerificado[13] = '0';
        } else {
            cnpjVerificado[13] = (char)(soma + 48);
        }

        // Verifica se o CNPJ verificado é igual ao CNPJ informado
        return cnpj.equals(new String(cnpjVerificado));
    }

    @Override
    public void solicitarNovo() {

    }

    // Getters & Setters //
    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        char[] cnpjFormatado = new char[18];
        char[] cnpjArray = this.cnpj.toCharArray();

        cnpjFormatado[17] = cnpjArray[12];
        cnpjFormatado[16] = cnpjArray[11];

        cnpjFormatado[15] = '-';

        cnpjFormatado[14] = cnpjArray[10];
        cnpjFormatado[13] = cnpjArray[9];
        cnpjFormatado[12] = cnpjArray[8];
        cnpjFormatado[11] =

        cnpjFormatado[10] = '.';

        cnpjFormatado[9] = cnpjArray[7];
        cnpjFormatado[8] = cnpjArray[6];
        cnpjFormatado[7] = cnpjArray[5];

        cnpjFormatado[6] = '.';

        cnpjFormatado[5] = cnpjArray[4];
        cnpjFormatado[4] = cnpjArray[3];
        cnpjFormatado[3] = cnpjArray[2];

        cnpjFormatado[2] = '.';

        cnpjFormatado[1] = cnpjArray[1];
        cnpjFormatado[0] = cnpjArray[0];

        return new String(cnpjFormatado);
    }

    public static String formatarCnpj(String cnpj){
        char[] cnpjFormatado = new char[18];
        char[] cnpjArray = cnpj.toCharArray();

        cnpjFormatado[17] = cnpjArray[12];
        cnpjFormatado[16] = cnpjArray[11];

        cnpjFormatado[15] = '-';

        cnpjFormatado[14] = cnpjArray[10];
        cnpjFormatado[13] = cnpjArray[9];
        cnpjFormatado[12] = cnpjArray[8];
        cnpjFormatado[11] =

                cnpjFormatado[10] = '.';

        cnpjFormatado[9] = cnpjArray[7];
        cnpjFormatado[8] = cnpjArray[6];
        cnpjFormatado[7] = cnpjArray[5];

        cnpjFormatado[6] = '.';

        cnpjFormatado[5] = cnpjArray[4];
        cnpjFormatado[4] = cnpjArray[3];
        cnpjFormatado[3] = cnpjArray[2];

        cnpjFormatado[2] = '.';

        cnpjFormatado[1] = cnpjArray[1];
        cnpjFormatado[0] = cnpjArray[0];

        return new String(cnpjFormatado);
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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
