/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelDominio;

/**
 *
 * @author lucas
 */
public class Grupo {
     private static final long serialVersionUID = 123L;
    
    private int codGrupo;
    private String nomegrupo;

    public Grupo(int codGrupo, String nomegrupo) {
        this.codGrupo = codGrupo;
        this.nomegrupo = nomegrupo;
    }

    public int getCodGrupo() {
        return codGrupo;
    }

    public String getNomegrupo() {
        return nomegrupo;
    }

    public void setCodGrupo(int codGrupo) {
        this.codGrupo = codGrupo;
    }

    public void setNomegrupo(String nomegrupo) {
        this.nomegrupo = nomegrupo;
    }

    @Override
    public String toString() {
        return "Grupo{" + "codGrupo=" + codGrupo + ", nomegrupo=" + nomegrupo + '}';
    }
    
}
