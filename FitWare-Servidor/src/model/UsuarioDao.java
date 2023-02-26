package model;

import factory.Conector;
import factory.Conector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelDominio.Administrador;
import modelDominio.Comum;
import modelDominio.Exercicio;
import modelDominio.Usuario;

public class UsuarioDao {
    private Connection con;
    
    public UsuarioDao() {
        con = Conector.getConnection();
        
    }
    
    public Usuario efetuarLogin(Usuario usr) {
        PreparedStatement stmt = null; // usado para rodar SQL
        Usuario usrselecionado = null;

        try {
            // passando a string SQL que faz o SELECT
            String sql = " select * from usuario "
                    + " where nome = ? and senha = ? ";
            stmt = con.prepareStatement(sql);
            //substituir os ? do script SQL
            stmt.setString(1, usr.getNome());
            stmt.setString(2, usr.getSenha());

            // Executando o select
            ResultSet res = stmt.executeQuery();

            // Percorrendo o resultado - res
            if (res.next()) {
                // int codUsuario, String nomeUsuario, String login, 
                // String senha, String email, boolean admin
                if (res.getInt("tipo") == 1) { // é administrador
                    usrselecionado
                            = new Administrador(res.getInt("codUsuario"),
                                    res.getString("nome"),
                                    res.getString("email"),
                                    res.getString("senha"),
                                    res.getString("cref"),
                                    res.getInt("tipo"));
                                    
                } else {
                    usrselecionado = new Comum(res.getInt("codUsuario"),
                            res.getString("nome"),
                            res.getString("email"),
                            res.getString("senha"),
                            res.getInt("foco"));
                }
                System.out.println("Criou Objeto: "+usrselecionado);
            }
            res.close();// fechando o resultado
            stmt.close();// fechando statment
            con.close(); // fechando conexão com o banco
            return usrselecionado;
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + "-" + e.getMessage());
            return null;
        }
    }
    
    //inserir usuário
    public int userInserir(Usuario user)
    {
        PreparedStatement stmt = null;
        try {
            try {
               con.setAutoCommit(false);
                String sql = "insert into usuario (nome, email, senha, foco, tipo) values (?,?,?,?, ?)";
             stmt = con.prepareStatement(sql);
               stmt.setString(1, user.getNome());
               stmt.setString(2, user.getEmail());
                stmt.setString(3, user.getSenha());
               stmt.setInt(4, user.getFoco());
            stmt.setInt(5, 0);
               stmt.execute();
            
                con.commit();
               return -1; //-1 indica que tudo deu certo
            } catch (SQLException e) {
               try {
                    con.rollback();
                    e.printStackTrace();
                    return e.getErrorCode();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    return ex.getErrorCode();
                }
            }
        } finally {
            try {
                stmt.close();
                con.setAutoCommit(true);
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return e.getErrorCode();
            }
        }
    }
    
    //lista de usuários
    public ArrayList<Usuario> getLista(){
        PreparedStatement stmt = null;
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        
        try {
            String sql = "select * from usuario";
            stmt = con.prepareStatement(sql); 
            //Executando o script SQL:
            ResultSet res = stmt.executeQuery();
            
            //Se existe um resultado:
            while (res.next()){ 
                Usuario user = new Usuario(res.getInt("codUsuario"), res.getString("nome"));
                // Ali em cima, dentro das "" é o nome do campo no banco de dados
                System.out.println(user);
                listaUsuarios.add(user);
            }
            // Fechar as conexões e statements:
            res.close();
            stmt.close();
            con.close();
            return listaUsuarios;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // Método que retorna todas os usuários cadastradas filtrando por nome
    public ArrayList<Usuario> getUsuarioListaNome(String nomeUsuario){
        PreparedStatement stmt = null;
        ArrayList<Usuario> listaUsuario = new ArrayList<>();
        
        try {
            String sql = "select * from usuario where nome like ?";
            //criar o statement e trocar os parametros
            stmt = con.prepareStatement(sql); 
            //trocando os parametros
            stmt.setString(1, "%"+nomeUsuario+"%");
            //Executando o script SQL:
            ResultSet res = stmt.executeQuery();
            
            //Se existe um resultado:
            while (res.next()){ 
                Usuario user = new Usuario(res.getInt("codUsuario"), res.getString("nome"));
                // Ali em cima, dentro das "" é o nome do campo no banco de dados
                System.out.println(user);
                listaUsuario.add(user);
            }
            // Fechar as conexões e statements:
            res.close();
            stmt.close();
            con.close();
            return listaUsuario;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public int usuarioExcluir(Usuario user){
        //vai receber o script SQL de INSERT
        PreparedStatement stmt = null;
        try {
            try {
                //desliga o autocommit
                con.setAutoCommit(false);
                //o ? será substituido pelo valor
                String sql = "delete from usuario where codUsuario = ?";
                stmt = con.prepareStatement(sql);
                //substituir os ? do script SQL:
                stmt.setInt(1, user.getCodUsuario());
                
                //executar o script SQL:
                stmt.execute();
                //efetivar a transação:
                con.commit();
                return -1;  // <- indica que tudo deu CERTO                
                
            } catch (SQLException e) {
                try {
                    con.rollback(); //cancelando
                    return e.getErrorCode();
                } catch (SQLException ex) {
                    return ex.getErrorCode();
                }
            }
        } finally { //isso será executado independente se der ERRO ou NÃO
            try {
                stmt.close();
                con.setAutoCommit(true);
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return e.getErrorCode();
            }
        }
        
    }
    
}


    