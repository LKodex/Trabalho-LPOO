package io.github.lkodex.trabalho_lpoo.controller;

import io.github.lkodex.trabalho_lpoo.controller.helper.ComprasHelper;
import io.github.lkodex.trabalho_lpoo.model.Compra;
import io.github.lkodex.trabalho_lpoo.model.Produto;
import io.github.lkodex.trabalho_lpoo.model.dao.ClienteDAO;
import io.github.lkodex.trabalho_lpoo.model.dao.CompraDAO;
import io.github.lkodex.trabalho_lpoo.model.dao.ProdutoDAO;
import io.github.lkodex.trabalho_lpoo.view.ComprasView;

public class ComprasController {
    private final ComprasView view;
    private final ComprasHelper helper;
    private final int codigoCompra;

    public ComprasController(ComprasView view, int codigoCompra){
        this.view = view;
        this.codigoCompra = codigoCompra;
        this.helper = new ComprasHelper(this.view);
    }

    public void inserirProduto(){
        if (helper.estaPreenchido()) {
            ProdutoDAO produtoDAO = new ProdutoDAO();
            CompraDAO dao = new CompraDAO();

            int quantidade = 0;
            int codigoProduto = Integer.parseInt(view.getCodigoProdutoInput().getText().replaceAll("[^0-9]", ""));

            if (!view.getQuantidadeInput().getText().isBlank()) {
                quantidade = Integer.parseInt(view.getQuantidadeInput().getText().replaceAll("[^0-9]", ""));
            }

            Produto produto = produtoDAO.readProduto(codigoProduto);
            Compra compra = dao.readCompra(codigoCompra);

            if (produto == null || compra == null) {
                view.exibirMensagem("ERRO! Não foi possível inserir novo produto, verifique se o Código de Produto está correto.");
                return;
            }
            if (quantidade <= 1) {
                compra.adicionarProduto(produto);
            } else {
                for (int i = 0; i < quantidade; i++){
                    compra.adicionarProduto(produto);
                }
            }
            helper.atualizarTabela(compra);
        } else {
            view.exibirMensagem("ERRO! Preencha o campo Código de Produto.");
        }
    }

    public void removerProduto() {
        if (helper.estaPreenchido()) {
            CompraDAO dao = new CompraDAO();
            ProdutoDAO produtoDAO = new ProdutoDAO();

            int codigoProduto = Integer.parseInt(view.getCodigoProdutoInput().getText().replaceAll("[^0-9]", ""));
            int quantidade = 0;

            if (!view.getQuantidadeInput().getText().isBlank()) {
                quantidade = Integer.parseInt(view.getQuantidadeInput().getText().replaceAll("[^0-9]", ""));
            }
            // Verifica se o campo Código de Produto está em branco
            if (view.getCodigoProdutoInput().getText().isBlank()) {
                view.exibirMensagem("ERRO! Preencha o campo de Código de Produto");
                return;
            }

            Compra compra = dao.readCompra(codigoCompra);
            Produto produto = produtoDAO.readProduto(codigoProduto);

            if (produto == null || compra == null) {
                view.exibirMensagem("ERRO! Não foi possível encontrar o produto, verifique se o Código de Produto está correto.");
                return;
            }

            if (quantidade <= 1) {
                compra.removerProduto(produto);
            } else {
                for (int i = 0; i < quantidade; i++) {
                    compra.removerProduto(produto);
                }
            }
            helper.atualizarTabela(compra);
        } else {
            view.exibirMensagem("ERRO! Preencha o campo Código de Produto.");
        }
    }

    public void atualizarTabela(){
        CompraDAO dao = new CompraDAO();
        helper.atualizarTabela(dao.readCompra(codigoCompra));
    }
}
