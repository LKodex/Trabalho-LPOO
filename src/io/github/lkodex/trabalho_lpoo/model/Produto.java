package io.github.lkodex.trabalho_lpoo.model;

public class Produto implements Comparable<Produto>{
    // Attributes //
    private String nomeProduto;
    private Float valor;
    private Fornecedor empresa;

    // Constructor //
    public Produto(String nomeProduto, Float valor, Fornecedor empresa){
        this.nomeProduto = nomeProduto;
        this.valor = valor;
        this.empresa = empresa;
    }

    // Methods //
    public int compareTo(Produto produto){
        return this.nomeProduto.compareTo(produto.getNomeProduto());
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nomeProduto='" + nomeProduto + '\'' +
                ", valor=" + valor +
                '}';
    }

    // Getters & Setters //
    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Fornecedor getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Fornecedor empresa) {
        this.empresa = empresa;
    }
}
