package io.github.lkodex.trabalho_lpoo.model;

public class Funcionario extends Pessoa {
    // Attributes //
    private double salario;
    private String funcao;

    // Constructors //
    public Funcionario(String nome, String cpf, Endereco endereco, String celular, double salario, String funcao) {
        super(nome, cpf, endereco, celular);
        this.salario = salario;
        this.funcao = funcao;
    }

    // Methods //
    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + this.getNome() + '\'' +
                ", cpf='" + this.getCpf() + '\'' +
                ", celular='" + this.getCelular() + '\'' +
                ", funcao='" + funcao + '\'' +
                ", salario=" + salario +
                '}';
    }

    // Getters & Setters //
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}
