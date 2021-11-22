package io.github.lkodex.trabalho_lpoo.controller.helper;

import io.github.lkodex.trabalho_lpoo.model.Cliente;
import io.github.lkodex.trabalho_lpoo.model.Endereco;
import io.github.lkodex.trabalho_lpoo.view.ClientesView;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ClientesHelper {
    private final ClientesView view;

    public ClientesHelper(ClientesView view){
        this.view = view;
    }

    public Cliente getCliente(){
        Cliente cliente;
        Endereco endereco;

        String nome = view.getNomeInput().getText();
        String cpf = view.getCpfInput().getText();
        String celular = view.getCelularInput().getText();

        String rua = view.getRuaInput().getText();
        int numero = Integer.parseInt(view.getNumeroInput().getText().strip().replaceAll("[^0-9]", ""));
        String bairro = view.getBairroInput().getText();
        String cidade = view.getCidadeInput().getText();
        String cep = view.getCepInput().getText();

        endereco = new Endereco(rua, numero, bairro, cidade, cep);
        cliente = new Cliente(nome, cpf, endereco, celular);

        if (cliente.validar(cpf)){
            return cliente;
        }
        return null;
    }

    public void atualizarTabela(List<Cliente> clientes){
        DefaultTableModel tableModel = (DefaultTableModel) view.getTableClientes().getModel();
        tableModel.setNumRows(0);
        for (Cliente cliente : clientes) {
            tableModel.addRow(new Object[]{
                    cliente.getCpf(),
                    cliente.getNome(),
                    cliente.getCelular(),
                    cliente.getEndereco().toString()
            });
        }
    }

    public boolean estaPreenchido(){
        String nome = view.getNomeInput().getText();
        String cpf = view.getCpfInput().getText();
        String celular = view.getCelularInput().getText();

        String rua = view.getRuaInput().getText();
        String numero = view.getNumeroInput().getText();
        String bairro = view.getBairroInput().getText();
        String cidade = view.getCidadeInput().getText();
        String cep = view.getCepInput().getText();

        return !(nome.isBlank() || cpf.isBlank() || celular.isBlank() || rua.isBlank()
        || numero.isBlank() || bairro.isBlank() || cidade.isBlank() || cep.isBlank());
    }
}
