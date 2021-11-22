package io.github.lkodex.trabalho_lpoo.controller.helper;

import io.github.lkodex.trabalho_lpoo.model.*;
import io.github.lkodex.trabalho_lpoo.model.dao.CompraDAO;
import io.github.lkodex.trabalho_lpoo.model.dao.ProdutoDAO;
import io.github.lkodex.trabalho_lpoo.view.ComprasView;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ComprasHelper {
    private final ComprasView view;

    public ComprasHelper(ComprasView view){
        this.view = view;
    }

    public Compra getCompra(){
        Compra compra;

        CompraDAO compraDAO = new CompraDAO();

        compra = compraDAO.readCompra(Integer.parseInt(view.getCodigoProdutoInput().getText().replaceAll("[^0-9]", "")));

        return compra;
    }

    public void atualizarTabela(Compra compra){
        DefaultTableModel tableModel = (DefaultTableModel) view.getTableProdutosLista().getModel();
        double valorTotal = 0.0;
        tableModel.setNumRows(0);
        List<Produto> produtos = compra.getProdutos();
        for (Produto produto : produtos) {
            valorTotal += produto.getValor();
            tableModel.addRow(new Object[]{
                    produto.getCodigo(),
                    produto.getNomeProduto(),
                    String.format("%.2f", produto.getValor()),
                    produto.getEmpresa()
            });
        }
        view.getTotalValorText().setText(String.format("%.2f", valorTotal));
        // Isso aqui é gambiarra, não deveria ser atualizado toda vez atualizasse a tabela
        view.getClienteNomeText().setText(compra.getCliente().getNome());
        view.getVendedorNomeText().setText(compra.getFuncionario().getNome());
    }

    public boolean estaPreenchido(){
        String codigoProduto = view.getCodigoProdutoInput().getText();

        return !(codigoProduto.isBlank());
    }
}
