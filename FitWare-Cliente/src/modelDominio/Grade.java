/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelDominio;

import modelDominio.ExercicioEmGrade;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author aluno
 */
public class Grade implements Serializable{
    private static final long serialVersionUID = 123L;
    
    private int codGrade;
    private String nomeGrade;
    private byte[] imagem;
    List<ExercicioEmGrade> exercicios;
    
    //construtores

    public Grade(int codGrade, String nomeGrade, byte[] imagem, List<ExercicioEmGrade> exercicios) {
        this.codGrade = codGrade;
        this.nomeGrade = nomeGrade;
        this.imagem = imagem;
        this.exercicios = exercicios;
    }

    public Grade(String nomeGrade, byte[] imagem, List<ExercicioEmGrade> exercicios) {
        this.nomeGrade = nomeGrade;
        this.imagem = imagem;
        this.exercicios = exercicios;
    }
     
    //getter e setters

    public int getCodGrade() {
        return codGrade;
    }

    public void setCodGrade(int codGrade) {
        this.codGrade = codGrade;
    }

    public String getNomeGrade() {
        return nomeGrade;
    }

    public void setNomeGrade(String nomeGrade) {
        this.nomeGrade = nomeGrade;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public List<ExercicioEmGrade> getExercicios() {
        return exercicios;
    }

    public void setExercicios(List<ExercicioEmGrade> exercicios) {
        this.exercicios = exercicios;
    }

    @Override
    public String toString() {
        return "Grade{" + "codGrade=" + codGrade + ", nomeGrade=" + nomeGrade + ", imagem=" + imagem + ", exercicios=" + exercicios + '}';
    }
    
    
    
}
