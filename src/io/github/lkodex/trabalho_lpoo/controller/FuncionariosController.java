package io.github.lkodex.trabalho_lpoo.controller;

import io.github.lkodex.trabalho_lpoo.controller.helper.FuncionariosHelper;
import io.github.lkodex.trabalho_lpoo.model.Funcionario;
import io.github.lkodex.trabalho_lpoo.model.dao.ClienteDAO;
import io.github.lkodex.trabalho_lpoo.model.dao.FuncionarioDAO;
import io.github.lkodex.trabalho_lpoo.view.FuncionariosView;

public class FuncionariosController {
    private final FuncionariosView view;
    private final FuncionariosHelper helper;

    public FuncionariosController(FuncionariosView view){
        this.view = view;
        this.helper = new FuncionariosHelper(this.view);
    }

    public void inserirFuncionario(){
        if (helper.estaPreenchido()) {
            FuncionarioDAO dao = new FuncionarioDAO();
            Funcionario funcionario = helper.getFuncionario();
            if (funcionario == null) {
                view.exibirMensagem("ERRO! Não foi possível inserir novo funcionário, verifique se o CPF está correto e sem pontuações.");
                return;
            }
            dao.createFuncionario(funcionario);
            helper.atualizarTabela(dao.getTable());
        } else {
            view.exibirMensagem("ERRO! Preencha todos os campos.");
        }
    }

    public void deletarFuncionario(){
        if (view.getCpfInput().getText().isBlank()){
            view.exibirMensagem("ERRO! Preencha o campo de CPF");
            return;
        }
        FuncionarioDAO dao = new FuncionarioDAO();
        Funcionario funcionario = dao.readFuncionario(view.getCpfInput().getText().replaceAll("[^0-9]", ""));
        if (funcionario == null){
            view.exibirMensagem("ERRO! Não foi possível encontrar o funcionário, verifique se o CPF está correto.");
            return;
        }
        dao.deleteFuncionario(funcionario);
        helper.atualizarTabela(dao.getTable());
    }

    public void atualizarTabela(){
        FuncionarioDAO dao = new FuncionarioDAO();
        helper.atualizarTabela(dao.getTable());
    }
}
