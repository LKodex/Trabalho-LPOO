package io.github.lkodex.trabalho_lpoo.view;

import io.github.lkodex.trabalho_lpoo.controller.FuncionariosController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FuncionariosView extends JFrame {
    private final FuncionariosController controller;

    // Botões
    private JButton buttonInserir;
    private JButton buttonExcluir;

    private JTable tableFuncionarios;
    private JScrollPane tableScrollPane;

    // Campos para inserir, alterar ou excluir novos Clientes
    private JTextField nomeInput;
    private JTextField cpfInput; // Usado também para atualizar e excluir cadastro
    private JTextField celularInput;

    private JTextField funcaoInput;
    private JTextField salarioInput;

    private JTextField ruaInput;
    private JTextField numeroInput;
    private JTextField bairroInput;
    private JTextField cidadeInput;
    private JTextField cepInput; // Opcional

    // Labels para informar os campos de entrada
    private JLabel nomeText;
    private JLabel cpfText;
    private JLabel celularText;

    private JLabel funcaoText;
    private JLabel salarioText;

    private JLabel ruaText;
    private JLabel numeroText;
    private JLabel bairroText;
    private JLabel cidadeText;
    private JLabel cepText;

    public FuncionariosView(){
        this.controller = new FuncionariosController(this);
        initComponents();
    }

    private void initComponents(){
        // Default Configs //
        // Permite controle total de cada elemento
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1015, 700);
        setTitle("Sistema de Compras -> Funcionarios");
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
        tableFuncionarios = new JTable();
        tableFuncionarios.setBounds(25, 25, 950, 350);
        tableFuncionarios.setModel(new DefaultTableModel(new Object[][] {}, new String[] {"CPF", "NOME", "CELULAR", "FUNÇÃO", "SALÁRIO", "ENDERECO"}));
        tableFuncionarios.setEnabled(false);
        // Painel para a tabela
        tableScrollPane = new JScrollPane();
        tableScrollPane.setViewportView(tableFuncionarios);
        tableScrollPane.setBounds(25, 25, 950, 300);

        // Campos para inserir, alterar ou excluir novos Funcionarios
        // Campos de entradas
        // Dados pessoais
        nomeInput = new JTextField();
        nomeInput.setBounds(100, 360, 250, 30);
        nomeInput.setFont(new Font("Courier", Font.PLAIN, 13));

        cpfInput = new JTextField(); // Usado também para atualizar e excluir cadastro
        cpfInput.setBounds(450, 360, 175, 30);
        cpfInput.setFont(new Font("Courier", Font.PLAIN, 13));

        celularInput = new JTextField();
        celularInput.setBounds(725, 360, 175, 30);
        celularInput.setFont(new Font("Courier", Font.PLAIN, 13));

        // Endereco
        ruaInput = new JTextField();
        ruaInput.setBounds(100, 410, 250, 30);
        ruaInput.setFont(new Font("Courier", Font.PLAIN, 13));

        numeroInput = new JTextField();
        numeroInput.setBounds(450, 410, 175, 30);
        numeroInput.setFont(new Font("Courier", Font.PLAIN, 13));

        bairroInput = new JTextField();
        bairroInput.setBounds(725, 410, 175, 30);
        bairroInput.setFont(new Font("Courier", Font.PLAIN, 13));

        cidadeInput = new JTextField();
        cidadeInput.setBounds(100, 460, 250, 30);
        cidadeInput.setFont(new Font("Courier", Font.PLAIN, 13));

        cepInput = new JTextField(); // Opcional
        cepInput.setBounds(450, 460, 175, 30);
        cepInput.setFont(new Font("Courier", Font.PLAIN, 13));

        // Dados de funcionário
        funcaoInput = new JTextField();
        funcaoInput.setBounds(100, 510, 250, 30);
        funcaoInput.setFont(new Font("Courier", Font.PLAIN, 13));

        salarioInput = new JTextField();
        salarioInput.setBounds(450, 510, 175, 30);
        salarioInput.setFont(new Font("Courier", Font.PLAIN, 13));

        // Dados pessoais
        nomeText = new JLabel();
        nomeText.setText("Nome:");
        nomeText.setBounds(50, 350, 50, 50);
        nomeText.setFont(new Font("Courier", Font.PLAIN, 13));

        cpfText = new JLabel();
        cpfText.setText("CPF:");
        cpfText.setBounds(400, 350, 50, 50);
        cpfText.setFont(new Font("Courier", Font.PLAIN, 13));

        celularText =  new JLabel();
        celularText.setText("Celular:");
        celularText.setBounds(675, 350, 50, 50);
        celularText.setFont(new Font("Courier", Font.PLAIN, 13));

        // Dados de endereço
        ruaText = new JLabel();
        ruaText.setText("Rua:");
        ruaText.setBounds(50, 400, 50, 50);
        ruaText.setFont(new Font("Courier", Font.PLAIN, 13));

        numeroText = new JLabel();
        numeroText.setText("Número:");
        numeroText.setBounds(400, 400, 50, 50);
        numeroText.setFont(new Font("Courier", Font.PLAIN, 13));

        bairroText =  new JLabel();
        bairroText.setText("Bairro:");
        bairroText.setBounds(675, 400, 50, 50);
        bairroText.setFont(new Font("Courier", Font.PLAIN, 13));

        cidadeText = new JLabel();
        cidadeText.setText("Cidade:");
        cidadeText.setBounds(50, 450, 50, 50);
        cidadeText.setFont(new Font("Courier", Font.PLAIN, 13));

        cepText = new JLabel();
        cepText.setText("CEP:");
        cepText.setBounds(400, 450, 50, 50);
        cepText.setFont(new Font("Courier", Font.PLAIN, 13));

        // Dados de funcionário
        funcaoText = new JLabel();
        funcaoText.setText("Função:");
        funcaoText.setBounds(50, 500, 50, 50);
        funcaoText.setFont(new Font("Courier", Font.PLAIN, 13));

        salarioText = new JLabel();
        salarioText.setText("Salário:");
        salarioText.setBounds(400, 500, 50, 50);
        salarioText.setFont(new Font("Courier", Font.PLAIN, 13));

        // Adiciona o conteúdo à janela //
        add(buttonInserir);
        add(buttonExcluir);

        add(tableScrollPane);

        add(buttonInserir);

        add(nomeText);
        add(nomeInput);

        add(cpfText);
        add(cpfInput);

        add(celularText);
        add(celularInput);

        add(ruaText);
        add(ruaInput);

        add(numeroText);
        add(numeroInput);

        add(bairroText);
        add(bairroInput);

        add(cidadeText);
        add(cidadeInput);

        add(cepText);
        add(cepInput);

        add(funcaoText);
        add(funcaoInput);

        add(salarioText);
        add(salarioInput);

        atualizarTabela();

        // Torna a janela visível
        setVisible(true);
    }

    // Action Listeners
    private void buttonInserirActionPerformed(ActionEvent event){
        controller.inserirFuncionario();
    }

    private void buttonExcluirActionPerformed(ActionEvent event){
        controller.deletarFuncionario();
    }

    //
    public void exibirMensagem(String message){
        JOptionPane.showMessageDialog(null, message);
    }

    private void atualizarTabela(){
        controller.atualizarTabela();
    }

    // Getters & Setters
    public JTextField getNomeInput() {
        return nomeInput;
    }

    public void setNomeInput(JTextField nomeInput) {
        this.nomeInput = nomeInput;
    }

    public JTextField getCpfInput() {
        return cpfInput;
    }

    public void setCpfInput(JTextField cpfInput) {
        this.cpfInput = cpfInput;
    }

    public JTextField getCelularInput() {
        return celularInput;
    }

    public void setCelularInput(JTextField celularInput) {
        this.celularInput = celularInput;
    }

    public JTextField getFuncaoInput() {
        return funcaoInput;
    }

    public void setFuncaoInput(JTextField funcaoInput) {
        this.funcaoInput = funcaoInput;
    }

    public JTextField getSalarioInput() {
        return salarioInput;
    }

    public void setSalarioInput(JTextField salarioInput) {
        this.salarioInput = salarioInput;
    }

    public JTextField getRuaInput() {
        return ruaInput;
    }

    public void setRuaInput(JTextField ruaInput) {
        this.ruaInput = ruaInput;
    }

    public JTextField getNumeroInput() {
        return numeroInput;
    }

    public void setNumeroInput(JTextField numeroInput) {
        this.numeroInput = numeroInput;
    }

    public JTextField getBairroInput() {
        return bairroInput;
    }

    public void setBairroInput(JTextField bairroInput) {
        this.bairroInput = bairroInput;
    }

    public JTextField getCidadeInput() {
        return cidadeInput;
    }

    public void setCidadeInput(JTextField cidadeInput) {
        this.cidadeInput = cidadeInput;
    }

    public JTextField getCepInput() {
        return cepInput;
    }

    public void setCepInput(JTextField cepInput) {
        this.cepInput = cepInput;
    }

    public JTable getTableFuncionarios() {
        return tableFuncionarios;
    }

    public void setTableFuncionarios(JTable tableFuncionarios) {
        this.tableFuncionarios = tableFuncionarios;
    }
}
