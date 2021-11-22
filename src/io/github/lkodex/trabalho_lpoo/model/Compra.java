package io.github.lkodex.trabalho_lpoo.model;

import java.util.*;

public class Compra {
    // Attributes //
    private int codigoCompra;
    private Funcionario funcionario;
    private Cliente cliente;
    private List<Produto> produtos = new ArrayList<>();

    // Constructors //
    public Compra(int codigoCompra, Funcionario funcionario, Cliente cliente){
        this.codigoCompra = codigoCompra;
        this.funcionario = funcionario;
        this.cliente = cliente;
    }

    // Methods //
    public void adicionarProduto(Produto produto){
        produtos.add(produto);
        Collections.sort(produtos);
    }

    public void removerProduto(Produto produto){
        produtos.remove(produto);
    }

    public void listarCompra(){
        double valorTotal = 0f;

        System.out.printf("\nComprado por:\t%s", this.cliente.getNome());
        System.out.printf("\nVendido por: \t%s", this.funcionario.getNome());

        for (Produto produto : this.produtos) {
            valorTotal += produto.getValor();
            System.out.printf("\n%-30s | R$%.2f", produto.getNomeProduto(), produto.getValor());
        }
        System.out.printf("\n%-30s | R$%.2f", "Total:", valorTotal);
    }

    // Getters & Setters
    public int getCodigoCompra() {
        return codigoCompra;
    }

    public void setCodigoCompra(int codigoCompra) {
        this.codigoCompra = codigoCompra;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
