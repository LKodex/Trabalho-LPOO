package io.github.lkodex.trabalho_lpoo.view;

import io.github.lkodex.trabalho_lpoo.controller.ClientesController;
import io.github.lkodex.trabalho_lpoo.controller.FornecedoresController;

import javax.swing.*;
import java.awt.*;

public class FornecedoresView extends JFrame {
    private final FornecedoresController controller;

    public FornecedoresView(){
        initComponents();

        this.controller = new FornecedoresController(this);
    }

    private void initComponents(){
        // Default Configs //
        setLayout(new FlowLayout());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(450, 600);
        setTitle("Menu");
        // Centraliza a janela
        setLocationRelativeTo(null);
        // Remove bordas e botões de menu como o botão de fechar e minimizar
        setUndecorated(false);

        // Cria o conteúdo a ser adicionado à tela //


        // Adiciona o conteúdo à janela //


        // Torna a janela visível
        setVisible(true);
    }
}
