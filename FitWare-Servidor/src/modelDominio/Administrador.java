package modelDominio;

import java.io.Serializable;

/**
 *
 * @author aluno
 */
public class Administrador extends Usuario implements Serializable {
    private static final long serialVersionUID = 123L;
    
    //construtores

    public Administrador(int codUsuario, String nome, String email, String senha, String cref, int tipo) {
        super(codUsuario, nome, email, senha, cref);
    }

    public Administrador(int codUsuario) {
        super(codUsuario);
    }

    public Administrador(String nome, String email, String senha) {
        super(nome, email, senha);
    }
    
    @Override
    public String toString(){
        return super.toString()+"Administrador{" + '}';
    }
}
