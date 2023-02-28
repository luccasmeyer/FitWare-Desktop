package view.tablemodel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelDominio.Exercicio;

/**
 *
 * Classe responsável por exibir os dados na jtable da consulta de
 * usuarios
 */
public class GradeTableModel extends AbstractTableModel {

    private ArrayList<Exercicio> listaExercicios; //aqui nessa lista vai estar todas os exercicios que vão estar no banco

    //Construtor:
    public GradeTableModel(ArrayList<Exercicio> listaExercicios) {
        this.listaExercicios = listaExercicios;
    }

    //Implementar métodos na lampada de erro do UsuarioTableModel:
    // Retorna o número de linhas da tabela
    @Override
    public int getRowCount() {
        return listaExercicios.size();
    }

    // Retorna o número de colunas da tabela
    @Override
    public int getColumnCount() {
        return 2;
    }

    // Retorna a informação que será exibida em cada célula
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //i ou rowIndex é o número da linha
        //i1 ou columnIndex é o número da coluna
        Exercicio exer = listaExercicios.get(rowIndex); //Pegando o usuario conforme a linha
        switch (columnIndex) {
            case 0:
                return exer.getNomeExercicio();
            case 1:
                return exer.getTipoexercicio();
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
                return "Nome";
            case 1:
                return "Tipo";
            default:
                return "Sem nome";
        }
    }

    // Método que retorna o usuario que o usuário clicou
    public Exercicio getExercicio(int linha) {
        return listaExercicios.get(linha);
    }
}
