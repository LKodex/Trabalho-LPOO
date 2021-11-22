package io.github.lkodex.trabalho_lpoo.controller;

import io.github.lkodex.trabalho_lpoo.model.Compra;
import io.github.lkodex.trabalho_lpoo.view.ComprasView;
import io.github.lkodex.trabalho_lpoo.view.ListaComprasView;
import io.github.lkodex.trabalho_lpoo.controller.helper.ListaComprasHelper;

import io.github.lkodex.trabalho_lpoo.model.dao.CompraDAO;

public class ListaComprasController {
    private final ListaComprasView view;
    private final ListaComprasHelper helper;

    public ListaComprasController(ListaComprasView view){
        this.view = view;
        this.helper = new ListaComprasHelper(this.view);
    }

    public void inserirCompra(){
        if (helper.estaPreenchido()) {
            CompraDAO dao = new CompraDAO();
            Compra compra = helper.getCompra();
            if (compra == null) {
                view.exibirMensagem("ERRO! Não foi possível inserir nova compra, verifique se o Código de Compra está correto e sem pontuações.");
                return;
            }
            dao.createCompra(compra);
            helper.atualizarTabela(dao.getTable());
        } else {
            view.exibirMensagem("ERRO! Preencha todos os campos.");
        }
    }

    public void visualizarCompras(){
        if (view.getCodigoCompraInput().getText().isBlank()){
            view.exibirMensagem("ERRO! Preencha o campo de Código de Produto");
            return;
        }
        CompraDAO dao = new CompraDAO();
        Compra compra = dao.readCompra(Integer.parseInt(view.getCodigoCompraInput().getText().replaceAll("[^0-9]", "")));
        if (compra == null) {
            view.exibirMensagem("ERRO! Não foi possível inserir nova compra, verifique se o Código de Compra está correto e sem pontuações.");
            return;
        }
        new ComprasView(compra);
    }

    public void deletarCompra(){
        if (view.getCodigoCompraInput().getText().isBlank()){
            view.exibirMensagem("ERRO! Preencha o campo de Código de Produto");
            return;
        }
        CompraDAO dao = new CompraDAO();
        Compra compra = dao.readCompra(Integer.parseInt(view.getCodigoCompraInput().getText().replaceAll("[^0-9]", "")));
        if (compra == null){
            view.exibirMensagem("ERRO! Não foi possível encontrar a compra, verifique se o Código de Compra está correto.");
            return;
        }
        dao.deleteCompra(compra);
        helper.atualizarTabela(dao.getTable());
    }

    public void atualizarTabela(){
        CompraDAO dao = new CompraDAO();
        helper.atualizarTabela(dao.getTable());
    }
}
