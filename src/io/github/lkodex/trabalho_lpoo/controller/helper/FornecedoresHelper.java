package io.github.lkodex.trabalho_lpoo.controller.helper;

import io.github.lkodex.trabalho_lpoo.model.Endereco;
import io.github.lkodex.trabalho_lpoo.model.Fornecedor;
import io.github.lkodex.trabalho_lpoo.view.FornecedoresView;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class FornecedoresHelper {
    private final FornecedoresView view;

    public FornecedoresHelper(FornecedoresView view){
        this.view = view;
    }

    public Fornecedor getFornecedor(){
        Fornecedor fornecedor;
        Endereco endereco;

        String nomeFantasia = view.getNomeFantasiaInput().getText();
        String razaoSocial = view.getRazaoSocialInput().getText();
        String cnpj = view.getCnpjInput().getText();
        String celular = view.getCelularInput().getText();

        String rua = view.getRuaInput().getText();
        int numero = Integer.parseInt(view.getNumeroInput().getText().strip().replaceAll("[^0-9]", ""));
        String bairro = view.getBairroInput().getText();
        String cidade = view.getCidadeInput().getText();
        String cep = view.getCepInput().getText();

        endereco = new Endereco(rua, numero, bairro, cidade, cep);
        fornecedor = new Fornecedor(razaoSocial, nomeFantasia, cnpj, endereco, celular);

        if (fornecedor.validar(cnpj)){
            return fornecedor;
        }
        return null;
    }

    public void atualizarTabela(List<Fornecedor> fornecedores){
        DefaultTableModel tableModel = (DefaultTableModel) view.getTableFornecedores().getModel();
        tableModel.setNumRows(0);
        for (Fornecedor fornecedor : fornecedores) {
            tableModel.addRow(new Object[]{
                    fornecedor.getNomeFantasia(),
                    fornecedor.getRazaoSocial(),
                    fornecedor.getCnpj(),
                    fornecedor.getCelular(),
                    fornecedor.getEndereco().toString()
            });
        }
    }

    public boolean estaPreenchido(){
        String nomeFantasia = view.getNomeFantasiaInput().getText();
        String razaoSocial = view.getRazaoSocialInput().getText();
        String cnpj = view.getCnpjInput().getText();
        String celular = view.getCelularInput().getText();

        String rua = view.getRuaInput().getText();
        String numero = view.getNumeroInput().getText();
        String bairro = view.getBairroInput().getText();
        String cidade = view.getCidadeInput().getText();
        String cep = view.getCepInput().getText();

        return !(nomeFantasia.isBlank() || razaoSocial.isBlank() || cnpj.isBlank() || celular.isBlank() || rua.isBlank()
                || numero.isBlank() || bairro.isBlank() || cidade.isBlank() || cep.isBlank());
    }
}
