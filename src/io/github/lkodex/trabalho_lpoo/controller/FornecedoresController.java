package io.github.lkodex.trabalho_lpoo.controller;

import io.github.lkodex.trabalho_lpoo.controller.helper.FornecedoresHelper;
import io.github.lkodex.trabalho_lpoo.model.Fornecedor;
import io.github.lkodex.trabalho_lpoo.model.dao.ClienteDAO;
import io.github.lkodex.trabalho_lpoo.model.dao.FornecedorDAO;
import io.github.lkodex.trabalho_lpoo.view.FornecedoresView;

public class FornecedoresController {
    private final FornecedoresView view;
    private final FornecedoresHelper helper;

    public FornecedoresController(FornecedoresView view){
        this.view = view;
        this.helper = new FornecedoresHelper(this.view);
    }

    public void inserirFornecedor(){
        if (helper.estaPreenchido()) {
            FornecedorDAO dao = new FornecedorDAO();
            Fornecedor fornecedor = helper.getFornecedor();
            if (fornecedor == null) {
                view.exibirMensagem("ERRO! Não foi possível inserir novo fornecedor, verifique se o CNPJ está correto.");
                return;
            }
            dao.createFornecedor(fornecedor);
            helper.atualizarTabela(dao.getTable());
        } else {
            view.exibirMensagem("ERRO! Preencha todos os campos.");
        }
    }

    public void deletarFornecedor(){
        if (view.getCnpjInput().getText().isBlank()){
            view.exibirMensagem("ERRO! Preencha o campo de CNPJ");
            return;
        }
        FornecedorDAO dao = new FornecedorDAO();
        Fornecedor fornecedor = dao.readFornecedor(view.getCnpjInput().getText().replaceAll("[^0-9]", ""));
        if (fornecedor == null){
            view.exibirMensagem("ERRO! Não foi possível encontrar o cliente, verifique se o CNPJ está correto.");
            return;
        }
        dao.deleteFornecedor(fornecedor);
        helper.atualizarTabela(dao.getTable());
    }

    public void atualizarTabela(){
        FornecedorDAO dao = new FornecedorDAO();
        helper.atualizarTabela(dao.getTable());
    }
}
