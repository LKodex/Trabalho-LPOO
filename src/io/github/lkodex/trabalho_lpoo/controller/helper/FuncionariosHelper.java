package io.github.lkodex.trabalho_lpoo.controller.helper;

import io.github.lkodex.trabalho_lpoo.model.Endereco;
import io.github.lkodex.trabalho_lpoo.model.Funcionario;
import io.github.lkodex.trabalho_lpoo.view.FuncionariosView;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class FuncionariosHelper {
    private final FuncionariosView view;

    public FuncionariosHelper(FuncionariosView view){
        this.view = view;
    }

    public Funcionario getFuncionario(){
        Funcionario funcionario;
        Endereco endereco;

        String nome = view.getNomeInput().getText();
        String cpf = view.getCpfInput().getText();
        String celular = view.getCelularInput().getText();

        String rua = view.getRuaInput().getText();
        int numero = Integer.parseInt(view.getNumeroInput().getText().strip().replaceAll("[^0-9]", ""));
        String bairro = view.getBairroInput().getText();
        String cidade = view.getCidadeInput().getText();
        String cep = view.getCepInput().getText();

        String funcao = view.getFuncaoInput().getText();
        double salario = Double.parseDouble(view.getSalarioInput().getText().strip().replaceAll("[^0-9.,]", ""));

        endereco = new Endereco(rua, numero, bairro, cidade, cep);
        funcionario = new Funcionario(nome, cpf, endereco, celular, salario, funcao);

        if (funcionario.validar(cpf)){
            return funcionario;
        }
        return null;
    }

    public void atualizarTabela(List<Funcionario> funcionarios){
        DefaultTableModel tableModel = (DefaultTableModel) view.getTableFuncionarios().getModel();
        tableModel.setNumRows(0);
        for (Funcionario funcionario : funcionarios) {
            tableModel.addRow(new Object[]{
                    funcionario.getCpf(),
                    funcionario.getNome(),
                    funcionario.getCelular(),
                    funcionario.getFuncao(),
                    funcionario.getSalario(),
                    funcionario.getEndereco().toString()
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

        String funcao = view.getFuncaoInput().getText();
        String salario = view.getSalarioInput().getText();

        return !(nome.isBlank() || cpf.isBlank() || celular.isBlank() || rua.isBlank()
                || numero.isBlank() || bairro.isBlank() || cidade.isBlank() || cep.isBlank()
                || funcao.isBlank() || salario.isBlank());
    }
}
