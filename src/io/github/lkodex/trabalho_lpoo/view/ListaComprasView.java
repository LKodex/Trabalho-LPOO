package io.github.lkodex.trabalho_lpoo.view;

import io.github.lkodex.trabalho_lpoo.controller.ListaComprasController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaComprasView extends JFrame {
    private final ListaComprasController controller;

    private JButton buttonInserir;
    private JButton buttonVisualizar;
    private JButton buttonRemover;

    private JTable tableComprasLista;
    private JScrollPane tableScrollPane;

    // Campos para inserir, alterar ou excluir novas listas de Compras
    private JTextField codigoCompraInput;
    private JTextField clienteCpfInput;
    private JTextField vendedorCpfInput;

    // Labels para informar sobre os campos de entrada
    private JLabel codigoCompraText;
    private JLabel clienteCpfText;
    private JLabel vendedorCpfText;

    public ListaComprasView(){
        this.controller = new ListaComprasController(this);
        initComponents();
    }

    private void initComponents(){
        // Default Configs //
        // Permite controle total de cada elemento
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1015, 700);
        setTitle("Sistema de Compras -> Compras");
        setResizable(false);
        // Centraliza a janela
        setLocationRelativeTo(null);

        // Cria o conteúdo a ser adicionado à tela //
        // Botão Inserir
        buttonInserir = new JButton();
        buttonInserir.setText("Inserir/Atualizar");
        buttonInserir.setBounds(150, 575, 200, 50);
        buttonInserir.setFont(new Font("Courier", Font.PLAIN, 13));
        buttonInserir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                buttonInserirActionPerformed(event);
            }
        });

        // Botão Visualizar
        buttonVisualizar = new JButton();
        buttonVisualizar.setText("Visualizar");
        buttonVisualizar.setBounds(400, 575, 200, 50);
        buttonVisualizar.setFont(new Font("Courier", Font.PLAIN, 13));
        buttonVisualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                buttonVisualizarCompraActionPerformed(event);
            }
        });

        // Botão Excluir
        buttonRemover = new JButton();
        buttonRemover.setText("Excluir");
        buttonRemover.setBounds(650, 575, 200, 50);
        buttonRemover.setFont(new Font("Courier", Font.PLAIN, 13));
        buttonRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                buttonRemoverActionPerfomred(event);
            }
        });

        // Tabela
        tableComprasLista = new JTable();
        tableComprasLista.setBounds(25, 25, 950, 450);
        tableComprasLista.setModel(new DefaultTableModel(new Object[][] {}, new String[] {"CÓDIGO DE COMPRA", "CLIENTE", "CPF DO CLIENTE", "VENDEDOR"}));
        tableComprasLista.setEnabled(false);
        // Painel para a tabela
        tableScrollPane = new JScrollPane();
        tableScrollPane.setViewportView(tableComprasLista);
        tableScrollPane.setBounds(25, 25, 950, 450);

        // Campos para inserir, alterar ou excluir novos Clientes
        // Campos de entradas
        codigoCompraInput = new JTextField();
        codigoCompraInput.setBounds(175, 510, 75, 30);
        codigoCompraInput.setFont(new Font("Courier", Font.PLAIN, 13));

        clienteCpfInput = new JTextField(); // Usado também para atualizar e excluir cadastro
        clienteCpfInput.setBounds(400, 510, 200, 30);
        clienteCpfInput.setFont(new Font("Courier", Font.PLAIN, 13));

        vendedorCpfInput = new JTextField(); // Usado também para atualizar e excluir cadastro
        vendedorCpfInput.setBounds(750, 510, 200, 30);
        vendedorCpfInput.setFont(new Font("Courier", Font.PLAIN, 13));

        // Campos de informações sobre entrada
        codigoCompraText = new JLabel();
        codigoCompraText.setText("Código de Compra:");
        codigoCompraText.setBounds(50, 500, 150, 50);
        codigoCompraText.setFont(new Font("Courier", Font.PLAIN, 13));

        clienteCpfText = new JLabel();
        clienteCpfText.setText("CPF do Cliente:");
        clienteCpfText.setBounds(300, 500, 150, 50);
        clienteCpfText.setFont(new Font("Courier", Font.PLAIN, 13));

        vendedorCpfText = new JLabel();
        vendedorCpfText.setText("CPF do Vendedor:");
        vendedorCpfText.setBounds(625, 500, 150, 50);
        vendedorCpfText.setFont(new Font("Courier", Font.PLAIN, 13));

        // Adiciona o conteúdo à janela //
        add(buttonInserir);
        add(buttonVisualizar);
        add(buttonRemover);

        add(tableScrollPane);

        add(codigoCompraText);
        add(codigoCompraInput);

        add(clienteCpfText);
        add(clienteCpfInput);

        add(vendedorCpfText);
        add(vendedorCpfInput);

        atualizarTabela();

        // Torna a janela visível
        setVisible(true);
    }

    // Action Listeners
    private void buttonInserirActionPerformed(ActionEvent event){
        controller.inserirCompra();
    }

    private void buttonVisualizarCompraActionPerformed(ActionEvent event){
        controller.visualizarCompras();
    }

    private void buttonRemoverActionPerfomred(ActionEvent event){
        controller.deletarCompra();
    }

    // Mehtods
    public void exibirMensagem(String message){
        JOptionPane.showMessageDialog(null, message);
    }

    private void atualizarTabela(){
        controller.atualizarTabela();
    }

    // Getters & Setters
    public JTextField getCodigoCompraInput() {
        return codigoCompraInput;
    }

    public void setCodigoCompraInput(JTextField codigoCompraInput) {
        this.codigoCompraInput = codigoCompraInput;
    }

    public JTextField getClienteCpfInput() {
        return clienteCpfInput;
    }

    public void setClienteCpfInput(JTextField clienteCpfInput) {
        this.clienteCpfInput = clienteCpfInput;
    }

    public JTextField getVendedorCpfInput() {
        return vendedorCpfInput;
    }

    public void setVendedorCpfInput(JTextField vendedorCpfInput) {
        this.vendedorCpfInput = vendedorCpfInput;
    }

    public JTable getTableComprasLista() {
        return tableComprasLista;
    }

    public void setTableComprasLista(JTable tableComprasLista) {
        this.tableComprasLista = tableComprasLista;
    }
}
