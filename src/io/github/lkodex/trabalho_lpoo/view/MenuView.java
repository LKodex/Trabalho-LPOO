package io.github.lkodex.trabalho_lpoo.view;

import io.github.lkodex.trabalho_lpoo.Database;
import io.github.lkodex.trabalho_lpoo.controller.MenuController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuView extends JFrame {
    private final MenuController controller;

    private JLabel infoClique;

    private JButton buttonClientes;
    private JButton buttonCompras;
    private JButton buttonFornecedores;
    private JButton buttonFuncionarios;
    private JButton buttonProdutos;

    public MenuView(){
        Database.initDatabase();
        this.controller = new MenuController(this);
        initComponents();
    }

    private void initComponents(){
        // Default Configs //
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450, 600);
        setTitle("Sistema de Compras -> Menu");
        setResizable(false);
        // Centraliza a janela
        setLocationRelativeTo(null);

        // Cria o conteúdo a ser adicionado à tela //
        infoClique = new JLabel();
        // Texto definido como parágrafo HTML pra quebra automática de linha
        infoClique.setText("<html><p style=\"text-align:center;\">Clique para inserir, visualizar, atualizar ou excluir:</p></html>");
        infoClique.setPreferredSize(new Dimension(350, 150));
        infoClique.setFont(new Font("Courier", Font.BOLD, 20));

        buttonClientes = new JButton();
        buttonClientes.setText("CLIENTES");
        buttonClientes.setPreferredSize(new Dimension(300, 70));
        buttonClientes.setFont(new Font("Courier", Font.PLAIN, 15));
        // Action Listener
        buttonClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                buttonClientesActionPerformed(event);
            }
        });

        buttonCompras = new JButton();
        buttonCompras.setText("COMPRAS");
        buttonCompras.setPreferredSize(new Dimension(300, 70));
        buttonCompras.setFont(new Font("Courier", Font.PLAIN, 15));
        // Action Listener
        buttonCompras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                buttonComprasActionPerformed(event);
            }
        });

        buttonFornecedores = new JButton();
        buttonFornecedores.setText("FORNECEDORES");
        buttonFornecedores.setPreferredSize(new Dimension(300, 70));
        buttonFornecedores.setFont(new Font("Courier", Font.PLAIN, 15));
        // Action Listener
        buttonFornecedores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                buttonFornecedoresActionPerformed(event);
            }
        });

        buttonFuncionarios = new JButton();
        buttonFuncionarios.setText("FUNCIONARIOS");
        buttonFuncionarios.setPreferredSize(new Dimension(300, 70));
        buttonFuncionarios.setFont(new Font("Courier", Font.PLAIN, 15));
        // Action Listener
        buttonFuncionarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                buttonFuncionariosActionPerformed(event);
            }
        });

        buttonProdutos = new JButton();
        buttonProdutos.setText("PRODUTOS");
        buttonProdutos.setPreferredSize(new Dimension(300, 70));
        buttonProdutos.setFont(new Font("Courier", Font.PLAIN, 15));
        // Action Listener
        buttonProdutos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                buttonProdutosActionPerformed(event);
            }
        });

        // Adiciona o conteúdo à janela //
        add(infoClique);
        add(buttonClientes);
        add(buttonCompras);
        add(buttonFornecedores);
        add(buttonFuncionarios);
        add(buttonProdutos);

        // Torna a janela visível
        setVisible(true);
    }

    // Action Listeners //
    public void buttonClientesActionPerformed(ActionEvent event){
        controller.clientesClicked();
    }

    public void buttonComprasActionPerformed(ActionEvent event){
        controller.comprasClicked();
    }

    public void buttonFornecedoresActionPerformed(ActionEvent event){
        controller.fornecedoresClicked();
    }

    public void buttonFuncionariosActionPerformed(ActionEvent event){
        controller.funcionariosClicked();
    }

    public void buttonProdutosActionPerformed(ActionEvent event){
        controller.produtosClicked();
    }


}
