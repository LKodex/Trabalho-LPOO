package io.github.lkodex.trabalho_lpoo.view;

import io.github.lkodex.trabalho_lpoo.controller.ClientesController;
import io.github.lkodex.trabalho_lpoo.controller.FornecedoresController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FornecedoresView extends JFrame {
    private final FornecedoresController controller;

    // Botões
    private JButton buttonInserir;
    private JButton buttonExcluir;

    private JTable tableFornecedores;
    private JScrollPane tableScrollPane;

    // Campos para inserir, alterar ou excluir novos Clientes
    private JTextField nomeFantasiaInput;
    private JTextField razaoSocialInput; // Usado também para atualizar e excluir cadastro
    private JTextField cnpjInput;
    private JTextField celularInput;

    private JTextField ruaInput;
    private JTextField numeroInput;
    private JTextField bairroInput;
    private JTextField cidadeInput;
    private JTextField cepInput; // Opcional

    // Labels para informar os campos de entrada
    private JLabel nomeFantasiaText;
    private JLabel razaoSocialText;
    private JLabel cnpjText;
    private JLabel celularText;

    private JLabel ruaText;
    private JLabel numeroText;
    private JLabel bairroText;
    private JLabel cidadeText;
    private JLabel cepText;

    public FornecedoresView(){
        this.controller = new FornecedoresController(this);
        initComponents();
    }

    private void initComponents(){
        // Default Configs //
        // Permite controle total de cada elemento
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1015, 700);
        setTitle("Sistema de Compras -> Fornecedores");
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
        tableFornecedores = new JTable();
        tableFornecedores.setBounds(25, 25, 950, 350);
        tableFornecedores.setModel(new DefaultTableModel(new Object[][] {}, new String[] {"NOME FANTASIA", "RAZAO SOCIAL", "CNPJ", "CELULAR", "ENDERECO"}));
        tableFornecedores.setEnabled(false);
        // Painel para a tabela
        tableScrollPane = new JScrollPane();
        tableScrollPane.setViewportView(tableFornecedores);
        tableScrollPane.setBounds(25, 25, 950, 350);

        // Campos para inserir, alterar ou excluir novos Fornecedores
        // Campos de entradas
        nomeFantasiaInput = new JTextField();
        nomeFantasiaInput.setBounds(150, 410, 200, 30);
        nomeFantasiaInput.setFont(new Font("Courier", Font.PLAIN, 13));

        razaoSocialInput = new JTextField(); // Usado também para atualizar e excluir cadastro
        razaoSocialInput.setBounds(500, 410, 125, 30);
        razaoSocialInput.setFont(new Font("Courier", Font.PLAIN, 13));

        cnpjInput = new JTextField();
        cnpjInput.setBounds(725, 410, 175, 30);
        cnpjInput.setFont(new Font("Courier", Font.PLAIN, 13));

        celularInput = new JTextField();
        celularInput.setBounds(725, 460, 175, 30);
        celularInput.setFont(new Font("Courier", Font.PLAIN, 13));

        // Endereco
        ruaInput = new JTextField();
        ruaInput.setBounds(100, 460, 250, 30);
        ruaInput.setFont(new Font("Courier", Font.PLAIN, 13));

        numeroInput = new JTextField();
        numeroInput.setBounds(450, 460, 175, 30);
        numeroInput.setFont(new Font("Courier", Font.PLAIN, 13));

        bairroInput = new JTextField();
        bairroInput.setBounds(725, 510, 175, 30);
        bairroInput.setFont(new Font("Courier", Font.PLAIN, 13));

        cidadeInput = new JTextField();
        cidadeInput.setBounds(100, 510, 250, 30);
        cidadeInput.setFont(new Font("Courier", Font.PLAIN, 13));

        cepInput = new JTextField(); // Opcional
        cepInput.setBounds(450, 510, 175, 30);
        cepInput.setFont(new Font("Courier", Font.PLAIN, 13));

        // Campos de informações
        nomeFantasiaText = new JLabel();
        nomeFantasiaText.setText("Nome Fantasia:");
        nomeFantasiaText.setBounds(50, 400, 100, 50);
        nomeFantasiaText.setFont(new Font("Courier", Font.PLAIN, 13));

        razaoSocialText = new JLabel();
        razaoSocialText.setText("Razao Social:");
        razaoSocialText.setBounds(400, 400, 100, 50);
        razaoSocialText.setFont(new Font("Courier", Font.PLAIN, 13));

        cnpjText = new JLabel();
        cnpjText.setText("CNPJ:");
        cnpjText.setBounds(675, 400, 50, 50);
        cnpjText.setFont(new Font("Courier", Font.PLAIN, 13));

        celularText =  new JLabel();
        celularText.setText("Celular:");
        celularText.setBounds(675, 450, 50, 50);
        celularText.setFont(new Font("Courier", Font.PLAIN, 13));

        ruaText = new JLabel();
        ruaText.setText("Rua:");
        ruaText.setBounds(50, 450, 50, 50);
        ruaText.setFont(new Font("Courier", Font.PLAIN, 13));

        numeroText = new JLabel();
        numeroText.setText("Número:");
        numeroText.setBounds(400, 450, 50, 50);
        numeroText.setFont(new Font("Courier", Font.PLAIN, 13));

        bairroText =  new JLabel();
        bairroText.setText("Bairro:");
        bairroText.setBounds(675, 500, 50, 50);
        bairroText.setFont(new Font("Courier", Font.PLAIN, 13));

        cidadeText = new JLabel();
        cidadeText.setText("Cidade:");
        cidadeText.setBounds(50, 500, 50, 50);
        cidadeText.setFont(new Font("Courier", Font.PLAIN, 13));

        cepText = new JLabel();
        cepText.setText("CEP:");
        cepText.setBounds(400, 500, 50, 50);
        cepText.setFont(new Font("Courier", Font.PLAIN, 13));

        // Adiciona o conteúdo à janela //
        add(buttonInserir);
        add(buttonExcluir);

        add(tableScrollPane);

        add(nomeFantasiaText);
        add(nomeFantasiaInput);

        add(razaoSocialText);
        add(razaoSocialInput);

        add(cnpjText);
        add(cnpjInput);

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

        atualizarTabela();

        // Torna a janela visível
        setVisible(true);
    }

    // Action Listeners
    private void buttonInserirActionPerformed(ActionEvent event){
        controller.inserirFornecedor();
    }

    private void buttonExcluirActionPerformed(ActionEvent event){
        controller.deletarFornecedor();
    }

    public void exibirMensagem(String message){
        JOptionPane.showMessageDialog(null, message);
    }

    private void atualizarTabela(){
        controller.atualizarTabela();
    }

    // Getters & Setters
    public JTextField getNomeFantasiaInput() {
        return nomeFantasiaInput;
    }

    public void setNomeFantasiaInput(JTextField nomeFantasiaInput) {
        this.nomeFantasiaInput = nomeFantasiaInput;
    }

    public JTextField getRazaoSocialInput() {
        return razaoSocialInput;
    }

    public void setRazaoSocialInput(JTextField razaoSocialInput) {
        this.razaoSocialInput = razaoSocialInput;
    }

    public JTextField getCnpjInput() {
        return cnpjInput;
    }

    public void setCnpjInput(JTextField cnpjInput) {
        this.cnpjInput = cnpjInput;
    }

    public JTextField getCelularInput() {
        return celularInput;
    }

    public void setCelularInput(JTextField celularInput) {
        this.celularInput = celularInput;
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

    public JTable getTableFornecedores() {
        return tableFornecedores;
    }

    public void setTableFornecedores(JTable tableFornecedores) {
        this.tableFornecedores = tableFornecedores;
    }
}
