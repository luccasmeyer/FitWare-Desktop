/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import model.ExercicioDao;
import model.UsuarioDao;
import modelDominio.Exercicio;
import modelDominio.Usuario;

/**
 *
 * @author aluno
 */
public class TrataClienteController extends Thread{
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private Socket s;
    private int idUnico;
    

    public TrataClienteController(ObjectInputStream in, ObjectOutputStream out, Socket s, int idUnico)
    {
        this.in = in;
        this.out = out;
        this.s = s;
        this.idUnico = idUnico;
        
    }
    
     @Override
    public void run(){
        String comando;
         System.out.println("Esperando comandos do cliente");
         try {
            comando = (String) in.readObject();
            while(!comando.equalsIgnoreCase("fim"))
            {
            //tratando comandos do cliente
            System.out.println("Cliente "+idUnico+" enviou comando: "+comando);
            if (comando.equalsIgnoreCase("EfetuarLogin"))
            {
                out.writeObject("ok");
                Usuario user = (Usuario) in.readObject();
                //consultar pra ver se o usuario existe
                UsuarioDao usdao = new UsuarioDao();
                Usuario userlogado = usdao.efetuarLogin(user);
                out.writeObject(userlogado);
            }
            else if (comando.equalsIgnoreCase("UserInserir")) {
                    out.writeObject("ok");
                    //esperando o objeto bike vir do cliente
                    Usuario user = (Usuario) in.readObject();
                    //criando um Dao para armazenar no Banco
                    UsuarioDao userdao = new UsuarioDao();
                    if (userdao.userInserir(user) == -1){
                        out.writeObject("ok");
                    } else {
                        out.writeObject("nok");
                    }
            }
            else if (comando.equalsIgnoreCase("usuarioExcluir")) {
                    out.writeObject("ok");
                    //esperando o objeto exercicio vir do cliente
                    Usuario usuario = (Usuario) in.readObject();
                    //criando um Dao para armazenar no Banco
                    UsuarioDao userdao = new UsuarioDao();
                    if (userdao.usuarioExcluir(usuario) == -1){
                        out.writeObject("ok");
                    } else {
                        out.writeObject("nok");
                    }
                }
            
            else if (comando.equalsIgnoreCase("UsuarioLista"))
            {
                    UsuarioDao userdao = new UsuarioDao();
                    out.writeObject(userdao.getLista());
            }
            else if (comando.equalsIgnoreCase("UsuarioListaNome")) {
                    out.writeObject("ok");
                    String nome = (String) in.readObject();
                    UsuarioDao userdao = new UsuarioDao();
                    out.writeObject(userdao.getUsuarioListaNome(nome));
            }
            else if (comando.equalsIgnoreCase("exercicioInserir")) {
                    out.writeObject("ok");
                    //esperando o objeto bike vir do cliente
                    Exercicio exer = (Exercicio) in.readObject();
                    //criando um Dao para armazenar no Banco
                    ExercicioDao exerdao = new ExercicioDao();
                    if (exerdao.exercicioInserir(exer) == -1){
                        out.writeObject("ok");
                    } else {
                        out.writeObject("nok");
                    }
            }
            else if (comando.equalsIgnoreCase("ExercicioExcluir")) {
                    out.writeObject("ok");
                    //esperando o objeto exercicio vir do cliente
                    Exercicio exercicio = (Exercicio) in.readObject();
                    //criando um Dao para armazenar no Banco
                    ExercicioDao exerdao = new ExercicioDao();
                    if (exerdao.exercicioExcluir(exercicio) == -1){
                        out.writeObject("ok");
                    } else {
                        out.writeObject("nok");
                    }
                }
            else if (comando.equalsIgnoreCase("ExercicioLista"))
            {
                    ExercicioDao exerdao = new ExercicioDao();
                    out.writeObject(exerdao.getLista());
            }
            else if (comando.equalsIgnoreCase("ExercicioListaNome")) {
                    out.writeObject("ok");
                    String nome = (String) in.readObject();
                    ExercicioDao exerdao = new ExercicioDao();
                    out.writeObject(exerdao.getExercicioListaNome(nome));
            }
            comando = (String) in.readObject();
            }
         } catch (Exception e) {
             e.printStackTrace();
         }
    }
}