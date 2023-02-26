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

public class ExercicioDao {
    private Connection con;
    
    public ExercicioDao(){
    con = Conector.getConnection();
    }
    /**
     *
     * @param ex
     * @return
     */
    public int exercicioInserir(Exercicio exer)
    {
        PreparedStatement stmt = null;
        try {
            try {
               con.setAutoCommit(false);
                String sql = "insert into exercicio (nome, descricao, series, repeticoes, imagem) values (?,?,?,?,?)";
             stmt = con.prepareStatement(sql);
               stmt.setString(1, exer.getNomeExercicio());
               stmt.setString(2, exer.getDescricao());
               stmt.setString(3, exer.getSeries());
               stmt.setString(4, exer.getRepeticoes());
               stmt.setBytes(5, exer.getImagem());
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
    
    public int exercicioExcluir(Exercicio exer){
        //vai receber o script SQL de INSERT
        PreparedStatement stmt = null;
        try {
            try {
                //desliga o autocommit
                con.setAutoCommit(false);
                //o ? será substituido pelo valor
                String sql = "delete from exercicio where codExercicio = ?";
                stmt = con.prepareStatement(sql);
                //substituir os ? do script SQL:
                stmt.setInt(1, exer.getCodExercicio());
                
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
    
    public ArrayList<Exercicio> getLista(){
        PreparedStatement stmt = null;
        ArrayList<Exercicio> listaExercicios = new ArrayList<>();
        
        try {
            String sql = "select * from exercicio";
            stmt = con.prepareStatement(sql); 
            //Executando o script SQL:
            ResultSet res = stmt.executeQuery();
            
            //Se existe um resultado:
            while (res.next()){ 
                Exercicio exer = new Exercicio(res.getInt("codExercicio"), res.getString("nome"), res.getString("series"), res.getString("repeticoes"));
                // Ali em cima, dentro das "" é o nome do campo no banco de dados
                System.out.println(exer);
                listaExercicios.add(exer);
            }
            // Fechar as conexões e statements:
            res.close();
            stmt.close();
            con.close();
            return listaExercicios;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // Método que retorna todas os usuários cadastradas filtrando por nome
    public ArrayList<Exercicio> getExercicioListaNome(String nomeExercicio){
        PreparedStatement stmt = null;
        ArrayList<Exercicio> listaExercicios = new ArrayList<>();
        
        try {
            String sql = "select * from exercicio where nome like ?";
            //criar o statement e trocar os parametros
            stmt = con.prepareStatement(sql); 
            //trocando os parametros
            stmt.setString(1, "%"+nomeExercicio+"%");
            //Executando o script SQL:
            ResultSet res = stmt.executeQuery();
            
            //Se existe um resultado:
            while (res.next()){ 
                Exercicio exer = new Exercicio(res.getInt("codExercicio"), res.getString("nome"), res.getString("series"), res.getString("repeticoes"));
                // Ali em cima, dentro das "" é o nome do campo no banco de dados
                System.out.println(exer);
                listaExercicios.add(exer);
            }
            // Fechar as conexões e statements:
            res.close();
            stmt.close();
            con.close();
            return listaExercicios;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
