package io.github.lkodex.trabalho_lpoo;

import io.github.lkodex.trabalho_lpoo.model.*;

import java.util.ArrayList;
import java.util.List;

public class Database {
    public List<Endereco> enderecos = new ArrayList<>();
    public List<Funcionario> funcionarios = new ArrayList<>();
    public List<Cliente> clientes = new ArrayList<>();
    public List<Fornecedor> fornecedores = new ArrayList<>();
    public List<Produto> produtos = new ArrayList<>();
    public List<Compra> compras = new ArrayList<>();

    //-- Start: Database --//
    public Database() {
        // Endereços
        enderecos.add(new Endereco("Rua Zero", 100, "Bairro", "Cidade"));
        enderecos.add(new Endereco("Rua Um", 2000, "Bairro", "Cidade"));
        enderecos.add(new Endereco("Rua Dois", 300, "Bairro", "Cidade"));
        enderecos.add(new Endereco("Av. Terceira", 400, "Bairro", "Cidade"));
        enderecos.add(new Endereco("Av. Quarta", 500, "Bairro", "Cidade"));
        enderecos.add(new Endereco("Av. Setima", 600, "Bairro", "Cidade"));
        // Fornecedores
        fornecedores.add(new Fornecedor("So Nos Computer Vendas de Informatica LTDA", "SoNosComputer", "111.111.111-11", enderecos.get(0), "67 99876-5432"));
        fornecedores.add(new Fornecedor("Tartaruga Motores Vendas de Peças Automotivas LTDA", "Tartaruga Motors", "999.999.999-99", enderecos.get(1), "67 99876-5432"));
        // Funcionários
        funcionarios.add(new Funcionario("Lucas", "000.000.000-00", enderecos.get(2), "67 99150-9220", 1000f, "Vendedor"));
        funcionarios.add(new Funcionario("Pedro", "666.666.666-66", enderecos.get(3), "67 98844-3366", 1500f, "Vendedor"));
        // Clientes
        clientes.add(new Cliente("Taldo", "333.333.333-33", enderecos.get(4), "67 94002-8922"));
        clientes.add(new Cliente("Amanda", "777.777.777-77", enderecos.get(5), "67 97773-7773"));
        // Produtos
        // SoNosComputer
        produtos.add(new Produto("Cooler de CPU (Multi-uso)", 300.49f, fornecedores.get(0)));
        produtos.add(new Produto("Notebook Gamer Negativo", 450.99f, fornecedores.get(0)));
        produtos.add(new Produto("Rato Gamer", 129.49f, fornecedores.get(0)));
        produtos.add(new Produto("Memória Rã (Moscas inclusas)", 117.99f, fornecedores.get(0)));
        produtos.add(new Produto("Mouse semi-óptico", 49.90f, fornecedores.get(0)));
        // Tartaruga Motors
        produtos.add(new Produto("Motor de Fusca", 1099.99f, fornecedores.get(1)));
        produtos.add(new Produto("Porta-luvas municiado", 17.17f, fornecedores.get(1)));
        produtos.add(new Produto("Aromatizante Colorido", 13.13f, fornecedores.get(1)));
        produtos.add(new Produto("Faz Sol Bro", 777.77f, fornecedores.get(1)));
        produtos.add(new Produto("Pneu de Concreto (Perfeito para passeios)", 259.49f, fornecedores.get(1)));

        // Compras
        compras.add(new Compra(funcionarios.get(0), clientes.get(0)));
        compras.add(new Compra(funcionarios.get(0), clientes.get(1)));
        compras.add(new Compra(funcionarios.get(1), clientes.get(0)));
        compras.add(new Compra(funcionarios.get(1), clientes.get(1)));

        // Gera 4 compras
        for (int i = 0; i < compras.size(); i++) {
            // Gera de 5 á 10 produtos
            for (int j = 0; j < (int) (Math.random() * 5) + 5; j++) {
                // Adiciona um novo produto de índice aleatório de 0 á 9
                compras.get(i).adicionarProduto(produtos.get((int) (Math.random() * 9)));
            }
        }
    }
    //-- End: Database --//
}