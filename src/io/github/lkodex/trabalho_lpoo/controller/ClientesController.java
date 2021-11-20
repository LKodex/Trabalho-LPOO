package io.github.lkodex.trabalho_lpoo.controller;

import io.github.lkodex.trabalho_lpoo.controller.helper.ClientesHelper;
import io.github.lkodex.trabalho_lpoo.model.dao.ClienteDAO;
import io.github.lkodex.trabalho_lpoo.model.Cliente;
import io.github.lkodex.trabalho_lpoo.view.ClientesView;

public class ClientesController {
    private final ClientesView view;
    private final ClientesHelper helper;

    public ClientesController(ClientesView view){
        this.view = view;
        this.helper = new ClientesHelper(this.view);
    }

    public void inserirCliente(){
        if (helper.estaPreenchido()) {
            ClienteDAO dao = new ClienteDAO();
            Cliente cliente = helper.getCliente();
            if (cliente == null) {
                view.exibirMensagem("ERRO! Não foi possível inserir novo cliente, verifique se o CPF está correto e sem pontuações.");
                return;
            }
            dao.createCliente(cliente);
            helper.atualizarTabela(dao.getTable());
        } else {
            view.exibirMensagem("ERRO! Preencha todos os campos.");
        }
    }

    public void deletarCliente(){
        if (view.getCpfInput().getText().isBlank()){
            view.exibirMensagem("ERRO! Preencha o campo de CPF");
            return;
        }
        ClienteDAO dao = new ClienteDAO();
        Cliente cliente = dao.readCliente(view.getCpfInput().getText().replaceAll("[^0-9]", ""));
        if (cliente == null){
            view.exibirMensagem("ERRO! Não foi possível encontrar o cliente, verifique se o CPF está correto.");
            return;
        }
        dao.deleteCliente(cliente);
        helper.atualizarTabela(dao.getTable());
    }

    public void atualizarCliente(){
        if (helper.estaPreenchido()) {
            ClienteDAO dao = new ClienteDAO();
            Cliente clienteAntigo = dao.readCliente(view.getCpfInput().getText().replaceAll("[^0-9]", ""));
            Cliente clienteNovo = helper.getCliente();
            if (clienteAntigo == null) {
                view.exibirMensagem("ERRO! Não foi possível encontrar o cliente, verifique se o CPF está correto e sem pontuações.");
                return;
            }
            dao.updateCliente(clienteNovo);
            helper.atualizarTabela(dao.getTable());
        } else {
            view.exibirMensagem("ERRO! Preencha todos os campos.");
        }
    }
}
