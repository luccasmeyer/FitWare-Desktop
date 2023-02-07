package modelDominio;

import java.io.Serializable;

/**
 *
 * @author aluno
 */
public class Comum extends Usuario implements Serializable {
   private static final long serialVersionUID = 123L;

    public Comum(int codUsuario, String nome, String email, String senha, int foco) {
        super(codUsuario, nome, email, senha, foco);
    }

    public Comum(int codUsuario) {
        super(codUsuario);
    }

    public Comum(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    public Comum(int codUsuario, String nome) {
        super(codUsuario, nome);
    }
    
    @Override
    public String toString() {
        return super.toString()+"Comum{" + '}';
    }

   
   
}
