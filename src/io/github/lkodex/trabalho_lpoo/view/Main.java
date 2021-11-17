package io.github.lkodex.trabalho_lpoo.view;

import io.github.lkodex.trabalho_lpoo.Database;
import io.github.lkodex.trabalho_lpoo.model.Cliente;
import io.github.lkodex.trabalho_lpoo.model.Compra;
import io.github.lkodex.trabalho_lpoo.model.Funcionario;
import io.github.lkodex.trabalho_lpoo.model.Produto;

import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int opcao;
        boolean exit = false;
        Database database = new Database();

        try (Scanner scanner = new Scanner(System.in)) {
            while (!exit){
                System.out.print("\n1.\tListar Clientes");
                System.out.print("\n2.\tListar Funcionários");
                System.out.print("\n3.\tListar Compras");
                System.out.print("\n4.\tFechar");

                System.out.print("\nOpção:\t");
                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        for (Cliente cliente : database.clientes){
                            System.out.printf("\n%-30s | %s | %s", cliente.getNome(), cliente.getCpf(), cliente.getCelular());
                        }
                        break;
                    case 2:
                        for (Funcionario funcionario : database.funcionarios){
                            System.out.printf("\n%-30s | %s | %s | %s | R$%.2f", funcionario.getNome(), funcionario.getCpf(), funcionario.getCelular(), funcionario.getFuncao(), funcionario.getSalario());
                        }
                        break;
                    case 3:
                        for (Compra compra : database.compras){
                            compra.listarCompra();
                        }
                        break;
                    case 4:
                        exit = true;
                        System.out.print("\nEncerrando programa, até breve...\n");
                        break;
                    default:
                        System.out.print("\nDigite um número de 1 à 4!\n");
                }
            }
        }


    }
}
