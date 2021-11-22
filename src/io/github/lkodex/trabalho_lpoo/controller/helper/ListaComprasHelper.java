package io.github.lkodex.trabalho_lpoo.controller.helper;

import io.github.lkodex.trabalho_lpoo.model.Cliente;
import io.github.lkodex.trabalho_lpoo.model.Compra;
import io.github.lkodex.trabalho_lpoo.model.Funcionario;

import io.github.lkodex.trabalho_lpoo.model.dao.ClienteDAO;
import io.github.lkodex.trabalho_lpoo.model.dao.FuncionarioDAO;

import io.github.lkodex.trabalho_lpoo.view.ListaComprasView;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ListaComprasHelper {
    private final ListaComprasView view;

    public ListaComprasHelper(ListaComprasView view){
        this.view = view;
    }

    public Compra getCompra(){
        Compra compra;
        Cliente cliente;
        Funcionario vendedor;

        int codigoCompra = Integer.parseInt(view.getCodigoCompraInput().getText().replaceAll("[^0-9]", ""));
        String cpfCliente = view.getClienteCpfInput().getText();
        String cpfFuncionario = view.getVendedorCpfInput().getText();

        ClienteDAO clienteDAO = new ClienteDAO();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        cliente = clienteDAO.readCliente(cpfCliente);
        vendedor = funcionarioDAO.readFuncionario(cpfFuncionario);
        compra = new Compra(codigoCompra, vendedor, cliente);

        return compra;
    }

    public void atualizarTabela(List<Compra> compras){
        DefaultTableModel tableModel = (DefaultTableModel) view.getTableComprasLista().getModel();
        tableModel.setNumRows(0);
        for (Compra compra : compras) {
            tableModel.addRow(new Object[]{
                    compra.getCodigoCompra(),
                    compra.getCliente().getNome(),
                    compra.getCliente().getCpfCensurado(),
                    compra.getFuncionario().getNome(),
            });
        }
    }

    public boolean estaPreenchido(){
        String codigoCompra = view.getCodigoCompraInput().getText();
        String clienteCpf = view.getClienteCpfInput().getText();
        String vendedorCpf = view.getVendedorCpfInput().getText();

        return !(codigoCompra.isBlank() || clienteCpf.isBlank() || vendedorCpf.isBlank());
    }

}
