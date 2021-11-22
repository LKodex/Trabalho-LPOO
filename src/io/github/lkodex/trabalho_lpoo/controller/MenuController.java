package io.github.lkodex.trabalho_lpoo.controller;

import io.github.lkodex.trabalho_lpoo.view.*;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MenuController {
    private final MenuView view;
    private final WindowListener windowListener;

    public MenuController(MenuView view){
        this.view = view;
        windowListener = new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) { }

            @Override
            public void windowClosing(WindowEvent e) { }

            @Override
            public void windowClosed(WindowEvent e) {
                view.setEnabled(true);
                // Faz a janela principal parar de minimizar sózinha ao fechar a janela secundária
                view.setVisible(true);
            }

            @Override
            public void windowIconified(WindowEvent e) { }

            @Override
            public void windowDeiconified(WindowEvent e) { }

            @Override
            public void windowActivated(WindowEvent e) { }

            @Override
            public void windowDeactivated(WindowEvent e) { }
        };
    }

    // Controller methods
    public void clientesClicked(){
        view.setEnabled(false);
        JFrame clientesView = new ClientesView();
        clientesView.addWindowListener(windowListener);
    }

    public void comprasClicked(){
        view.setEnabled(false);
        JFrame comprasView = new ListaComprasView();
        comprasView.addWindowListener(windowListener);
    }

    public void fornecedoresClicked(){
        view.setEnabled(false);
        JFrame fornecedoresView = new FornecedoresView();
        fornecedoresView.addWindowListener(windowListener);
    }

    public void funcionariosClicked(){
        view.setEnabled(false);
        JFrame funcionariosView = new FuncionariosView();
        funcionariosView.addWindowListener(windowListener);
    }

    public void produtosClicked(){
        view.setEnabled(false);
        JFrame produtosView = new ProdutosView();
        produtosView.addWindowListener(windowListener);
    }
}
