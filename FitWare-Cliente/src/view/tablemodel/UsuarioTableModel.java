package view.tablemodel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelDominio.Usuario;

/**
 *
 * Classe responsável por exibir os dados na jtable da consulta de
 * usuarios
 */
public class UsuarioTableModel extends AbstractTableModel {

    private ArrayList<Usuario> listaUsuarios; //aqui nessa lista vai estar todas os usuarios que vão estar no banco

    //Construtor:
    public UsuarioTableModel(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    //Implementar métodos na lampada de erro do UsuarioTableModel:
    // Retorna o número de linhas da tabela
    @Override
    public int getRowCount() {
        return listaUsuarios.size();
    }

    // Retorna o número de colunas da tabela
    @Override
    public int getColumnCount() {
        return 3;
    }

    // Retorna a informação que será exibida em cada célula
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //i ou rowIndex é o número da linha
        //i1 ou columnIndex é o número da coluna
        Usuario user = listaUsuarios.get(rowIndex); //Pegando o usuario conforme a linha
        switch (columnIndex) {
            case 0:
                return user.getCodUsuario();
            case 1:
                return user.getNome();
            case 2:
                return user.getEmail();
           default:
                return "";
        }
    }

    // Retorna o nome da coluna
    // column é o nome da coluna
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Código";
            case 1:
                return "Nome";
            case 2:
                return "Email";
            default:
                return "Sem nome";
        }
    }

    // Método que retorna o usuario que o usuário clicou
    public Usuario getUsuario(int linha) {
        return listaUsuarios.get(linha);
    }
}
