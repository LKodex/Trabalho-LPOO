package io.github.lkodex.trabalho_lpoo.model;

public class Produto implements Comparable<Produto>{
    // Attributes //
    private int codigo;
    private String nomeProduto;
    private Double valor;
    private Fornecedor empresa;

    // Constructor //
    public Produto(int codigo, String nomeProduto, double valor, Fornecedor empresa){
        this.codigo = codigo;
        this.nomeProduto = nomeProduto.strip();
        this.valor = valor;
        this.empresa = empresa;
    }

    // Methods //
    public int compareTo(Produto produto){
        return this.valor.compareTo(produto.getValor());
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nomeProduto='" + nomeProduto + '\'' +
                ", valor=" + valor +
                '}';
    }

    // Getters & Setters //
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Fornecedor getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Fornecedor empresa) {
        this.empresa = empresa;
    }
}
