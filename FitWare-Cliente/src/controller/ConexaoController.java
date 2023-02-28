package controller;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import modelDominio.Exercicio;
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
    
     //Método responsável por mandar o comando lá do UsuarioDao pro servidor:
    public ArrayList<Usuario> getUsuarioLista(){
        try {
            out.writeObject("UsuarioLista");
            return (ArrayList<Usuario>)in.readObject(); // Vai retornar a lista de usuarios
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
        public Boolean usuarioExcluir(Usuario user){
        String msg = "";
        try {
            out.writeObject("usuarioExcluir");
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
    
    public ArrayList<Usuario> getUsuarioListaNome(String pesquisa){
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
    
    public Boolean exercicioInserir(Exercicio exer){
        String msg = "";
        try {
            out.writeObject("ExercicioInserir");
            msg = (String) in.readObject(); //lendo ok
            out.writeObject(exer); //escrevendo o exercicio
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
    
    public Exercicio exercicioTabela(int codExercicio){
        String msg = "";
        Exercicio exercicio = null;
        try {
            out.writeObject("exercicoTabela");
            msg = (String) in.readObject(); //lendo ok
            out.writeObject(codExercicio); //escrevendo o exercicio
            exercicio = (Exercicio) in.readObject();
            if (exercicio != null){
                return exercicio;
            } else {
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public Boolean exercicioSalvarIntermediario(int codUsuario, int codExercicio){
        String msg = "";
        Exercicio exercicioaux;
        try {
            out.writeObject("exercicioSalvarIntermediario");
            msg = (String) in.readObject();
            out.writeObject(codUsuario);
            out.writeObject(codExercicio);
            msg = (String) in.readObject();  
            if (msg.equals("ok")) {
               return true;
            }else{
                return false;
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        
    }

    
     public ArrayList<Exercicio> getExercicioUsuario(int codUsuario){
        String msg = "";
         try {
            
            out.writeObject("exercicioUsuario");
            msg = (String) in.readObject();
            out.writeObject(codUsuario);
            return (ArrayList<Exercicio>)in.readObject(); // Vai retornar a lista de usuarios
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public Boolean exercicioExcluir(Exercicio exer){
        String msg = "";
        try {
            out.writeObject("ExercicioExcluir");
            msg = (String) in.readObject(); //lendo ok
            out.writeObject(exer); //escrevendo a bike
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
    
         //Método responsável por mandar o comando lá do ExercicioDao pro servidor:
    public ArrayList<Exercicio> getExercicioLista(){
        try {
            out.writeObject("ExercicioLista");
            return (ArrayList<Exercicio>)in.readObject(); // Vai retornar a lista de usuarios
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public ArrayList<Exercicio> getExercicioListaNome(String pesquisa){
        String msg;
        try {
            out.writeObject("ExercicioListaNome");
            msg = (String) in.readObject(); // recebi o ok
            out.writeObject(pesquisa); // envio a pesquisa pro servidor
            return (ArrayList<Exercicio>)in.readObject(); // recebo a lista
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
