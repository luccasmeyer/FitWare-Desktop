package controller;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import modelDominio.Usuario;

/**
 *
 * @author aluno
 */
public class ConexaoController {
    private ObjectInputStream in;
    private ObjectOutputStream out;
    
    //proximo atributo armazena o usuario que está conectado
    public Usuario usuario;

    public ConexaoController(ObjectInputStream in, ObjectOutputStream out) {
        this.in = in;
        this.out = out;
    }
    
    public Usuario efetuarLogin(Usuario user)
    {
        String mensagem;
        //implementar comunicação com o servidor
        try {
            out.writeObject("EfetuarLogin");
            mensagem = (String) in.readObject();//aqui vou ler o "OK"
            out.writeObject(user);//enviando o usuario que tentou fazer login
            Usuario usrlogin = (Usuario) in.readObject();//recebe todos os dados do usuario que fez o login
            return usrlogin;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public Boolean userInserir(Usuario user){
        String msg = "";
        try {
            out.writeObject("UserInserir");
            msg = (String) in.readObject(); //lendo ok
            out.writeObject(user); //escrevendo a bike
            msg = (String) in.readObject(); //lendo ok
            if (msg.equals("ok")){
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
     //Método responsável por mandar o comando lá do MarcaDao pro servidor:
    public ArrayList<Usuario> getUsuarioLista(){
        try {
            out.writeObject("UsuarioLista");
            return (ArrayList<Usuario>)in.readObject(); // Vai retornar a lista de usuarios
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public ArrayList<Usuario> getListaNome(String pesquisa){
        String msg;
        try {
            out.writeObject("UsuarioListaNome");
            msg = (String) in.readObject(); // recebi o ok
            out.writeObject(pesquisa); // envio a pesquisa pro servidor
            return (ArrayList<Usuario>)in.readObject(); // recebo a lista
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
