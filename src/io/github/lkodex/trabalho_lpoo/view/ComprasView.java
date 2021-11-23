package io.github.lkodex.trabalho_lpoo.view;

import io.github.lkodex.trabalho_lpoo.controller.ComprasController;
import io.github.lkodex.trabalho_lpoo.model.Compra;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComprasView extends JFrame {
    private final ComprasController controller;

    private JButton buttonInserir;
    private JButton buttonRemover;

    private JTable tableProdutosLista;
    private JScrollPane tableScrollPane;

    // Campos para inserir, alterar ou excluir novas listas de Compras
    private JTextField codigoProdutoInput;
    private JTextField quantidadeInput;

    // Labels para informar sobre os campos de entrada
    private JLabel codigoProdutoText;
    private JLabel quantidadeText;

    private JLabel clienteText;
    private JLabel clienteNomeText;

    private JLabel vendedorText;
    private JLabel vendedorNomeText;

    private JLabel totalText;
    private JLabel totalValorText;

    public ComprasView(Compra compra) {
        this.controller = new ComprasController(this, compra.getCodigoCompra());
        initComponents();
    }

    private void initComponents() {
        // Default Configs //
        // Permite controle total de cada elemento
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1015, 700);
        setTitle("Sistema de Compras -> Compras -> Lista de produtos comprados");
        setResizable(false);
        // Centraliza a janela
        setLocationRelativeTo(null);

        // Cria o conteúdo a ser adicionado à tela //
        // Botão Inserir
        buttonInserir = new JButton();
        buttonInserir.setText("Inserir");
        buttonInserir.setBounds(275, 575, 200, 50);
        buttonInserir.setFont(new Font("Courier", Font.PLAIN, 13));
        buttonInserir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                buttonInserirActionPerformed(event);
            }
        });

        // Botão Excluir
        buttonRemover = new JButton();
        buttonRemover.setText("Remover");
        buttonRemover.setBounds(525, 575, 200, 50);
        buttonRemover.setFont(new Font("Courier", Font.PLAIN, 13));
        buttonRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                buttonRemoverActionPerformed(event);
            }
        });

        // Tabela
        tableProdutosLista = new JTable();
        tableProdutosLista.setBounds(25, 125, 950, 350);
        tableProdutosLista.setModel(new DefaultTableModel(new Object[][]{}, new String[]{"CODIGO DE PRODUTO", "NOME DO PRODUTO", "VALOR (R$)", "EMPRESA"}));
        tableProdutosLista.setEnabled(false);
        // Painel para a tabela
        tableScrollPane = new JScrollPane();
        tableScrollPane.setViewportView(tableProdutosLista);
        tableScrollPane.setBounds(25, 125, 950, 350);

        // Informação de comprador, vendedor e total da compra
        clienteText = new JLabel();
        clienteText.setText("Comprado por:");
        clienteText.setBounds(50, 25, 100, 50);
        clienteText.setFont(new Font("Courier", Font.PLAIN, 13));

        clienteNomeText = new JLabel();
        clienteNomeText.setText("???");
        clienteNomeText.setBounds(150, 25, 200, 50);
        clienteNomeText.setFont(new Font("Courier", Font.PLAIN, 13));

        vendedorText = new JLabel();
        vendedorText.setText("Vendido por:");
        vendedorText.setBounds(50, 50, 100, 50);
        vendedorText.setFont(new Font("Courier", Font.PLAIN, 13));

        vendedorNomeText = new JLabel();
        vendedorNomeText.setText("???");
        vendedorNomeText.setBounds(150, 50, 200, 50);
        vendedorNomeText.setFont(new Font("Courier", Font.PLAIN, 13));

        totalText = new JLabel();
        totalText.setText("Total (R$):");
        totalText.setBounds(50, 75, 100, 50);
        totalText.setFont(new Font("Courier", Font.PLAIN, 13));

        totalValorText = new JLabel();
        totalValorText.setText("0.00");
        totalValorText.setBounds(150, 75, 200, 50);
        totalValorText.setFont(new Font("Courier", Font.PLAIN, 13));

        // Campos para inserir, alterar ou excluir novos Clientes
        // Campos de entradas
        codigoProdutoInput = new JTextField();
        codigoProdutoInput.setBounds(400, 510, 60, 30);
        codigoProdutoInput.setFont(new Font("Courier", Font.PLAIN, 13));

        quantidadeInput = new JTextField(); // Usado também para atualizar e excluir cadastro
        quantidadeInput.setBounds(650, 510, 60, 30);
        quantidadeInput.setFont(new Font("Courier", Font.PLAIN, 13));

        // Campos de informações sobre entrada
        codigoProdutoText = new JLabel();
        codigoProdutoText.setText("Código de Produto:");
        codigoProdutoText.setBounds(270, 500, 150, 50);
        codigoProdutoText.setFont(new Font("Courier", Font.PLAIN, 13));

        quantidadeText = new JLabel();
        quantidadeText.setText("Quantidade:");
        quantidadeText.setBounds(550, 500, 150, 50);
        quantidadeText.setFont(new Font("Courier", Font.PLAIN, 13));

        // Adiciona o conteúdo à janela //
        add(buttonInserir);
        add(buttonRemover);

        add(tableScrollPane);

        add(clienteText);
        add(clienteNomeText);

        add(vendedorText);
        add(vendedorNomeText);

        add(totalText);
        add(totalValorText);

        add(codigoProdutoText);
        add(codigoProdutoInput);

        add(quantidadeText);
        add(quantidadeInput);

        atualizarTabela();

        // Torna a janela visível
        setVisible(true);
    }

    // Action Listeners
    private void buttonInserirActionPerformed(ActionEvent event) {
        controller.inserirProduto();
    }

    private void buttonRemoverActionPerformed(ActionEvent event) {
        controller.removerProduto();
    }

    // Mehtods
    public void exibirMensagem(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    private void atualizarTabela() {
        controller.atualizarTabela();
    }

    // Getters & Setters


    public JTextField getCodigoProdutoInput() {
        return codigoProdutoInput;
    }

    public void setCodigoProdutoInput(JTextField codigoProdutoInput) {
        this.codigoProdutoInput = codigoProdutoInput;
    }

    public JTextField getQuantidadeInput() {
        return quantidadeInput;
    }

    public void setQuantidadeInput(JTextField quantidadeInput) {
        this.quantidadeInput = quantidadeInput;
    }

    public JLabel getClienteNomeText() {
        return clienteNomeText;
    }

    public void setClienteNomeText(JLabel clienteNomeText) {
        this.clienteNomeText = clienteNomeText;
    }

    public JLabel getVendedorNomeText() {
        return vendedorNomeText;
    }

    public void setVendedorNomeText(JLabel vendedorNomeText) {
        this.vendedorNomeText = vendedorNomeText;
    }

    public JLabel getTotalValorText() {
        return totalValorText;
    }

    public void setTotalValorText(JLabel totalValorText) {
        this.totalValorText = totalValorText;
    }

    public JTable getTableProdutosLista() {
        return tableProdutosLista;
    }

    public void setTableProdutosLista(JTable tableProdutosLista) {
        this.tableProdutosLista = tableProdutosLista;
    }
}
