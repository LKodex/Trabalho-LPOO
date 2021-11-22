package io.github.lkodex.trabalho_lpoo.view;

import io.github.lkodex.trabalho_lpoo.controller.ProdutosController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProdutosView extends JFrame {
    private final ProdutosController controller;

    // Botões
    private JButton buttonInserir;
    private JButton buttonExcluir;

    private JTable tableProdutos;
    private JScrollPane tableScrollPane;

    // Campos de entrada
    private JTextField codigoInput;
    private JTextField nomeProdutoInput;
    private JTextField valorInput;
    private JTextField empresaCNPJInput;

    // Texto de informação
    private JLabel codigoText;
    private JLabel nomeProdutoText;
    private JLabel valorText;
    private JLabel empresaCNPJText;

    public ProdutosView(){
        this.controller = new ProdutosController(this);
        initComponents();
    }

    private void initComponents(){
        // Default Configs //
        // Permite controle total de cada elemento
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1015, 700);
        setTitle("Sistema de Compras -> Produtos");
        setResizable(false);
        // Centraliza a janela
        setLocationRelativeTo(null);

        // Cria o conteúdo a ser adicionado à tela //
        // Botão Inserir
        buttonInserir = new JButton();
        buttonInserir.setText("Inserir/Atualizar");
        buttonInserir.setBounds(250, 575, 200, 50);
        buttonInserir.setFont(new Font("Courier", Font.PLAIN, 13));
        buttonInserir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                buttonInserirActionPerformed(event);
            }
        });
        // Botão Excluir
        buttonExcluir = new JButton();
        buttonExcluir.setText("Excluir");
        buttonExcluir.setBounds(550, 575, 200, 50);
        buttonExcluir.setFont(new Font("Courier", Font.PLAIN, 13));
        buttonExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                buttonExcluirActionPerformed(event);
            }
        });

        // Tabela
        tableProdutos = new JTable();
        tableProdutos.setBounds(25, 25, 950, 350);
        tableProdutos.setModel(new DefaultTableModel(new Object[][] {}, new String[] {"CODIGO", "NOME DO PRODUTO", "VALOR (R$)", "EMPRESA"}));
        tableProdutos.setEnabled(false);
        tableProdutos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        // Painel para a tabela
        tableScrollPane = new JScrollPane();
        tableScrollPane.setViewportView(tableProdutos);
        tableScrollPane.setBounds(25, 25, 950, 350);

        // Adiciona o conteúdo à janela //

        // Campos para inserir, alterar ou excluir novos Clientes
        // Campos de entradas
        codigoInput = new JTextField();
        codigoInput.setBounds(200, 460, 250, 30);
        codigoInput.setFont(new Font("Courier", Font.PLAIN, 13));

        nomeProdutoInput = new JTextField(); // Usado também para atualizar e excluir cadastro
        nomeProdutoInput.setBounds(650, 460, 250, 30);
        nomeProdutoInput.setFont(new Font("Courier", Font.PLAIN, 13));

        valorInput = new JTextField();
        valorInput.setBounds(200, 510, 250, 30);
        valorInput.setFont(new Font("Courier", Font.PLAIN, 13));

        empresaCNPJInput = new JTextField();
        empresaCNPJInput.setBounds(650, 510, 250, 30);
        empresaCNPJInput.setFont(new Font("Courier", Font.PLAIN, 13));

        // TextoInfo
        codigoText = new JLabel();
        codigoText.setText("Código do Produto:");
        codigoText.setBounds(50, 450, 150, 50);
        codigoText.setFont(new Font("Courier", Font.PLAIN, 13));

        nomeProdutoText = new JLabel();
        nomeProdutoText.setText("Nome do Produto:");
        nomeProdutoText.setBounds(500, 450, 150, 50);
        nomeProdutoText.setFont(new Font("Courier", Font.PLAIN, 13));

        valorText = new JLabel();
        valorText.setText("Valor:");
        valorText.setBounds(50, 500, 150, 50);
        valorText.setFont(new Font("Courier", Font.PLAIN, 13));

        empresaCNPJText = new JLabel();
        empresaCNPJText.setText("CNPJ do Fornecedor:");
        empresaCNPJText.setBounds(500, 500, 150, 50);
        empresaCNPJText.setFont(new Font("Courier", Font.PLAIN, 13));

        // Adiciona elementos na tela
        add(buttonInserir);
        add(buttonExcluir);

        add(tableScrollPane);

        add(codigoText);
        add(codigoInput);

        add(nomeProdutoText);
        add(nomeProdutoInput);

        add(valorText);
        add(valorInput);

        add(empresaCNPJText);
        add(empresaCNPJInput);

        atualizarTabela();

        // Torna a janela visível
        setVisible(true);
    }

    // Action Listeners
    private void buttonInserirActionPerformed(ActionEvent event){
        controller.inserirProduto();
    }

    private void buttonExcluirActionPerformed(ActionEvent event){
        controller.deletarProduto();
    }

    //
    public void exibirMensagem(String message){
        JOptionPane.showMessageDialog(null, message);
    }

    private void atualizarTabela(){
        controller.atualizarTabela();
    }

    // Getters & Setters
    public JTextField getCodigoInput() {
        return codigoInput;
    }

    public void setCodigoInput(JTextField codigoInput) {
        this.codigoInput = codigoInput;
    }

    public JTextField getNomeProdutoInput() {
        return nomeProdutoInput;
    }

    public void setNomeProdutoInput(JTextField nomeProdutoInput) {
        this.nomeProdutoInput = nomeProdutoInput;
    }

    public JTextField getValorInput() {
        return valorInput;
    }

    public void setValorInput(JTextField valorInput) {
        this.valorInput = valorInput;
    }

    public JTextField getEmpresaCNPJInput() {
        return empresaCNPJInput;
    }

    public void setEmpresaCNPJInput(JTextField empresaCNPJInput) {
        this.empresaCNPJInput = empresaCNPJInput;
    }

    public JTable getTableProdutos() {
        return tableProdutos;
    }

    public void setTableProdutos(JTable tableProdutos) {
        this.tableProdutos = tableProdutos;
    }
}
