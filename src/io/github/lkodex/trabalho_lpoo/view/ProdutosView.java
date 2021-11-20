package io.github.lkodex.trabalho_lpoo.view;

import io.github.lkodex.trabalho_lpoo.controller.ClientesController;
import io.github.lkodex.trabalho_lpoo.controller.ProdutosController;

import javax.swing.*;
import java.awt.*;

public class ProdutosView extends JFrame {
    private final ProdutosController controller;

    public ProdutosView(){
        initComponents();

        this.controller = new ProdutosController(this);
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
