/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDominio;

import modelDominio.Exercicio;
import java.io.Serializable;
/**
 *
 * @author User
 */
public class ExercicioEmGrade implements Serializable {
    private static final long serialVersionUID = 123L;
    
    private int codExercicioEmGrade;
    private int codExercicio;
    private int codGrade;
    private int series;
    private int repeticoes;
    
    //construtores

    public ExercicioEmGrade(int codExercicioEmGrade, int codExercicio, int codGrade, int series, int repeticoes) {
        this.codExercicioEmGrade = codExercicioEmGrade;
        this.codExercicio = codExercicio;
        this.codGrade = codGrade;
        this.series = series;
        this.repeticoes = repeticoes;
    }

    public ExercicioEmGrade(int codExercicioEmGrade, int codExercicio, int codGrade) {
        this.codExercicioEmGrade = codExercicioEmGrade;
        this.codExercicio = codExercicio;
        this.codGrade = codGrade;
    }
    
    //getter e setters

    public int getCodExercicioEmGrade() {
        return codExercicioEmGrade;
    }

    public void setCodExercicioEmGrade(int codExercicioEmGrade) {
        this.codExercicioEmGrade = codExercicioEmGrade;
    }

    public int getCodExercicio() {
        return codExercicio;
    }

    public void setCodExercicio(int codExercicio) {
        this.codExercicio = codExercicio;
    }

    public int getCodGrade() {
        return codGrade;
    }

    public void setCodGrade(int codGrade) {
        this.codGrade = codGrade;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    @Override
    public String toString() {
        return "ExercicioEmGrade{" + "codExercicioEmGrade=" + codExercicioEmGrade + ", codExercicio=" + codExercicio + ", codGrade=" + codGrade + ", series=" + series + ", repeticoes=" + repeticoes + '}';
    }
    
    
    
}
