package io.github.lkodex.trabalho_lpoo.controller.helper;

import io.github.lkodex.trabalho_lpoo.model.Fornecedor;
import io.github.lkodex.trabalho_lpoo.model.Produto;
import io.github.lkodex.trabalho_lpoo.model.dao.FornecedorDAO;
import io.github.lkodex.trabalho_lpoo.view.ProdutosView;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ProdutosHelper {
    private final ProdutosView view;

    public ProdutosHelper(ProdutosView view){
        this.view = view;
    }

    // Cria um novo Produto a partir dos dados inseridos na view
    public Produto getProduto(){
        Produto produto;
        Fornecedor fornecedor;

        FornecedorDAO fornecedorDAO = new FornecedorDAO();

        int codigo = Integer.parseInt(view.getCodigoInput().getText().strip());
        String nomeProduto = view.getNomeProdutoInput().getText().strip();
        double valor = Double.parseDouble(view.getValorInput().getText().replaceAll(",", "."));

        String cnpj = view.getEmpresaCNPJInput().getText().strip();

        fornecedor = fornecedorDAO.readFornecedor(cnpj);
        produto = new Produto(codigo, nomeProduto, valor, fornecedor);

        if (fornecedor != null){
            return produto;
        }
        return null;
    }

    public void atualizarTabela(List<Produto> produtos){
        DefaultTableModel tableModel = (DefaultTableModel) view.getTableProdutos().getModel();
        tableModel.setNumRows(0);
        for (Produto produto : produtos) {
            tableModel.addRow(new Object[]{
                    produto.getCodigo(),
                    produto.getNomeProduto(),
                    String.format("%.2f", produto.getValor()),
                    produto.getEmpresa().toString()
            });
        }


    }

    public boolean estaPreenchido(){
        String codigo = view.getCodigoInput().getText();
        String nomeProduto = view.getNomeProdutoInput().getText();
        String valor = view.getValorInput().getText();
        String cnpjEndereco = view.getEmpresaCNPJInput().getText();

        return !(codigo.isBlank() || nomeProduto.isBlank() || valor.isBlank() || cnpjEndereco.isBlank());
    }
}
