/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import com.sun.jdi.connect.Connector;
import controller.TrataClienteController;
import factory.Conector;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class Principal {
    
    //criando o metodo main que vai executar o servidor
    public static void main(String[] args) {
        //fazendo a conexão com o banco
        Connection con;
        con = Conector.getConnection();

        //criar servidor socket        
        try {
            ServerSocket servidor = new ServerSocket(12345);
            System.out.println("Server incializado com sucesso! Aguardando conexões...");
            //chamando e executando classe "conectaservidor"
            ConectaServidor s1 = new ConectaServidor(servidor, con);
            s1.start();
            
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}

class ConectaServidor extends Thread
{
    private ServerSocket servidor;
    private int idUnico=0;
    private Connection con;

    public ConectaServidor(ServerSocket servidor, Connection con) {
        this.servidor = servidor;
        this.con = con;
    }

    @Override
    public void run()
    {
        try
        {
           while (true)
           {
               Socket cliente = servidor.accept();
               System.out.println("Um novo cliente conectou "+cliente);
               
               //criando objeto de entrada e saída
               ObjectInputStream in = new ObjectInputStream(cliente.getInputStream());
               ObjectOutputStream out = new ObjectOutputStream(cliente.getOutputStream());
               idUnico++;
               System.out.println("Inicializando uma Thread para o cliente "+idUnico);
               TrataClienteController trataCliente = new TrataClienteController(in, out, cliente, idUnico);
               trataCliente.start();
           }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
}