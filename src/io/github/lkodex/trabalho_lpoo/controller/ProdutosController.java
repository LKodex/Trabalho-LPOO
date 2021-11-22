package io.github.lkodex.trabalho_lpoo.controller;

import io.github.lkodex.trabalho_lpoo.controller.helper.ProdutosHelper;
import io.github.lkodex.trabalho_lpoo.model.Produto;
import io.github.lkodex.trabalho_lpoo.model.dao.ProdutoDAO;
import io.github.lkodex.trabalho_lpoo.view.ProdutosView;

public class ProdutosController {
    private final ProdutosView view;
    private final ProdutosHelper helper;

    public ProdutosController(ProdutosView view){
        this.view = view;
        this.helper = new ProdutosHelper(this.view);
    }

    public void inserirProduto(){
        if (helper.estaPreenchido()) {
            ProdutoDAO dao = new ProdutoDAO();
            Produto produto = helper.getProduto();
            if (produto == null) {
                view.exibirMensagem("ERRO! Não foi possível inserir novo produto, verifique se o CNPJ está correto.");
                return;
            }
            dao.createProduto(produto);
            helper.atualizarTabela(dao.getTable());
        } else {
            view.exibirMensagem("ERRO! Preencha todos os campos.");
        }
    }

    public void deletarProduto(){
        if (view.getCodigoInput().getText().isBlank()){
            view.exibirMensagem("ERRO! Preencha o campo de Código de Produto");
            return;
        }
        ProdutoDAO dao = new ProdutoDAO();
        Produto produto = dao.readProduto(Integer.parseInt(view.getCodigoInput().getText().replaceAll("[^0-9]", "")));
        if (produto == null){
            view.exibirMensagem("ERRO! Não foi possível encontrar o produto, verifique se o Código de Produto está correto.");
            return;
        }
        dao.deleteProduto(produto);
        helper.atualizarTabela(dao.getTable());
    }

    public void atualizarTabela(){
        ProdutoDAO dao = new ProdutoDAO();
        helper.atualizarTabela(dao.getTable());
    }
}
