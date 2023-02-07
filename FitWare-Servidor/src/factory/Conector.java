/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author aluno
 */
public class Conector {
    // declarar variável que vai armazenar a conexão
    private static Connection con;

    // metodo que faz a conexão
    public static Connection getConnection()
    {
        try
        {
            String url = "jdbc:mysql://localhost:3306/"; //caminho do banco
            String banco = "fitware";
            String usuario = "root";
            String senha = "";

            con = DriverManager.getConnection(url + banco, usuario, senha);
            System.out.println("Conectado com sucesso no banco: "+banco);
            return con;
        }
        catch (Exception e)
        {
            e.printStackTrace(); //imprime o erro
            return null;
        }

    }

}
