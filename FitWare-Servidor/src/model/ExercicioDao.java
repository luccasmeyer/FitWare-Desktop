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
    public int salvarercicio(int codUsuario, Exercicio exer){
        PreparedStatement stmt = null;
        try {
            try {
               con.setAutoCommit(false);
                String sql = "insert into usuario_has_exercicio(usuario_codUsuario , exercicio_codExercicio) values (?,?)";
             stmt = con.prepareStatement(sql);
               stmt.setInt(1, codUsuario);
               stmt.setInt(2, exer.getCodExercicio());
          
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
    public int exercicioInserir(Exercicio exer)
    {
        PreparedStatement stmt = null;
        try {
            try {
               con.setAutoCommit(false);
                String sql = "insert into exercicio (nome, descricao, series, repeticoes, tipo) values (?,?,?,?,?)";
             stmt = con.prepareStatement(sql);
               stmt.setString(1, exer.getNomeExercicio());
               stmt.setString(2, exer.getDescricao());
               stmt.setString(3, exer.getSeries());
               stmt.setString(4, exer.getRepeticoes());
               stmt.setInt(5, exer.getTipoexercicio());
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
                //o ? ser?? substituido pelo valor
                String sql = "delete from exercicio where codExercicio = ?";
                stmt = con.prepareStatement(sql);
                //substituir os ? do script SQL:
                stmt.setInt(1, exer.getCodExercicio());
                
                //executar o script SQL:
                stmt.execute();
                //efetivar a transa????o:
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
        } finally { //isso ser?? executado independente se der ERRO ou N??O
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
                // Ali em cima, dentro das "" ?? o nome do campo no banco de dados
                System.out.println(exer);
                listaExercicios.add(exer);
            }
            // Fechar as conex??es e statements:
            res.close();
            stmt.close();
            con.close();
            return listaExercicios;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
        public ArrayList<Exercicio> getExercicioUsuario(int codUsuario){
        PreparedStatement stmt = null;
        ArrayList<Exercicio> listaExercicios = new ArrayList<>();
        
        try {
            String sql = "select * from usuario inner join exercicio inner join usuario_has_exercicio on usuario.codUsuario = usuario_has_exercicio.usuario_codUsuario and exercicio.codExercicio = usuario_has_exercicio.exercicio_codExercicio where usuario.codUsuario = ?;";
            //criar o statement e trocar os parametros
            stmt = con.prepareStatement(sql); 
            //trocando os parametros
            stmt.setInt(1, codUsuario);
            //Executando o script SQL:
            ResultSet res = stmt.executeQuery();
            
            //Se existe um resultado:
            while (res.next()){ 
                Exercicio exer = new Exercicio(res.getInt("exercicio.codExercicio"), res.getString("exercicio.nome"), res.getString("exercicio.series"), res.getString("exercicio.repeticoes"));
                // Ali em cima, dentro das "" ?? o nome do campo no banco de dados
                System.out.println(exer);
                listaExercicios.add(exer);
            }
            // Fechar as conex??es e statements:
            res.close();
            stmt.close();
            con.close();
            return listaExercicios;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // M??todo que retorna todas os usu??rios cadastradas filtrando por nome
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
                // Ali em cima, dentro das "" ?? o nome do campo no banco de dados
                System.out.println(exer);
                listaExercicios.add(exer);
            }
            // Fechar as conex??es e statements:
            res.close();
            stmt.close();
            con.close();
            return listaExercicios;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public Exercicio exercicioTabela(int codExercicio){
        PreparedStatement stmt = null;
        Exercicio exercicio = null;
        
        try {
            String sql = "select * from exercicio where codExercicio = ?";
            //criar o statement e trocar os parametros
            stmt = con.prepareStatement(sql); 
            //trocando os parametros
            stmt.setInt(1, codExercicio);
            //Executando o script SQL:
            ResultSet res = stmt.executeQuery();
            
            //Se existe um resultado:
            while (res.next()){ 
                Exercicio exer = new Exercicio(res.getInt("codExercicio"), res.getString("nome"), res.getString("descricao"), res.getString("series"), res.getString("repeticoes"), res.getInt("tipo"));
                // Ali em cima, dentro das "" ?? o nome do campo no banco de dados
                System.out.println(exer);
                exercicio = exer;
            }
            // Fechar as conex??es e statements:
            res.close();
            stmt.close();
            con.close();
            return exercicio;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public int exercicioSalvarIntermediario(int codUsuario, int codExercicio)
    {
        PreparedStatement stmt = null;
        try {
            try {
               con.setAutoCommit(false);
                String sql = "insert into usuario_has_exercicio values (?, ?);";
             stmt = con.prepareStatement(sql);
               stmt.setInt(1, codUsuario);
               stmt.setInt(2, codExercicio);
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

    public Object exercicioSalvarIntermediario(int exer) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
