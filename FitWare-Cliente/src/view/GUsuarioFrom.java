/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelDominio.Comum;
import modelDominio.Exercicio;
import modelDominio.Usuario;
import view.tablemodel.GradeTableModel;
import view.tablemodel.UsuarioTableModel;
import view.util.ComboBoxExercicio;

/**
 *
 * @author aluno
 */
public class GUsuarioFrom extends javax.swing.JDialog {
    
    
    private Usuario usuario;
    private javax.swing.JTable jTableUsuario;
    private UsuarioTableModel userModel;
    private javax.swing.JComboBox<String> cmbCampo;
    private javax.swing.JTextField jtxtPesquisa;
    private  ArrayList<Exercicio> listaExercicioTabela = new ArrayList<>();

    private void atualizaTabela(){
       listaExercicioTabela = FitWareCliente.ccont.getExercicioUsuario(usuario.getCodUsuario());
       DefaultTableModel model = new DefaultTableModel();
       jTable1.setModel(new GradeTableModel(listaExercicioTabela));
       
    }
     
    
     
     private void preencheComboBoxExercicio() {
        // preenchendo o comboBox dos Marcas
        ArrayList<Exercicio> listaex = new ArrayList<Exercicio>();
        ArrayList<String> listanomes = new ArrayList<>();
        Exercicio exercicio= null;
        listaex = FitWareCliente.ccont.getExercicioLista();
//        for(int x=0; x<listaex.size(); x++){
//            exercicio = listaex.get(x);
//            String aux = "";
//            aux = exercicio.getNomeExercicio();
//            listanomes.add(aux);
//        }
        // ComboBoxExercicio.preencheComboBoxExercicio(-1, jcExercicios, listaex, false);
        jcExercicios.setModel(new DefaultComboBoxModel(listaex.toArray()));
    }
    
    /**
     * Creates new form MenuPrincipalFrom
     */
    private void atualizacampo(){
      jTextFieldNome.setText(FitWareCliente.ccont.usuario.getNome());
      jTextFieldSenha.setText(FitWareCliente.ccont.usuario.getSenha()); 
      jTextFieldEmail.setText(FitWareCliente.ccont.usuario.getEmail());
    }
    
    
    public GUsuarioFrom(Usuario usuario) {
        this.usuario = usuario;
        initComponents();
        preencheComboBoxExercicio();
        atualizaTabela();
        atualizacampo();
        jLabel1.setText(FitWareCliente.ccont.usuario.getNome());
        
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        acExercicio = new javax.swing.JLabel();
        acHome = new javax.swing.JLabel();
        acUsuarios = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldSenha = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButtonAutenticar = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxFoco = new javax.swing.JComboBox<>();
        btnSair1 = new javax.swing.JButton();
        jcExercicios = new javax.swing.JComboBox<>();
        jcGrupos = new javax.swing.JComboBox<>();
        jbAddTabela = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(76, 86, 219));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("[usuario]");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Gerenciamento de Usuários");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/fitware 100.png"))); // NOI18N

        acExercicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/acExercicio.png"))); // NOI18N
        acExercicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                acExercicioMouseClicked(evt);
            }
        });

        acHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/acHome.png"))); // NOI18N
        acHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                acHomeMouseClicked(evt);
            }
        });

        acUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/acUsuarios.png"))); // NOI18N
        acUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                acUsuariosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel3)))
                .addGap(120, 120, 120)
                .addComponent(acExercicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(acHome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(acUsuarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(acHome)
                    .addComponent(acUsuarios)
                    .addComponent(acExercicio)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(6, 6, 6)))
                .addGap(16, 16, 16))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Novo Usuário");

        jLabel5.setText("Nome:");

        jLabel6.setText("E-mail:");

        jLabel7.setText("Senha");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Grade"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton4.setBackground(new java.awt.Color(76, 86, 219));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("+");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/nAut.png"))); // NOI18N
        jLabel8.setText("Não Autenticado");

        jButtonAutenticar.setBackground(new java.awt.Color(76, 86, 219));
        jButtonAutenticar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAutenticar.setText("Autenticar");

        jButton5.setBackground(new java.awt.Color(76, 86, 219));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Salvar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel9.setText("Foco");

        jComboBoxFoco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Emagrecimento", "Hipertrofia" }));
        jComboBoxFoco.setSelectedIndex(-1);

        btnSair1.setBackground(new java.awt.Color(76, 86, 219));
        btnSair1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/Volta.png"))); // NOI18N
        btnSair1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSair1ActionPerformed(evt);
            }
        });

        jcExercicios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar" }));
        jcExercicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcExerciciosActionPerformed(evt);
            }
        });

        jcGrupos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Grade A", "Grade B", "Grade C", "Grade D" }));
        jcGrupos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcGruposActionPerformed(evt);
            }
        });

        jbAddTabela.setText("Salvar");
        jbAddTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddTabelaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5)
                                    .addComponent(jTextFieldNome)
                                    .addComponent(jLabel6)
                                    .addComponent(jTextFieldEmail)
                                    .addComponent(jLabel7)
                                    .addComponent(jTextFieldSenha)
                                    .addComponent(jLabel9)
                                    .addComponent(jComboBoxFoco, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(87, 87, 87)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jcExercicios, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jcGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jbAddTabela)))
                            .addComponent(btnSair1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonAutenticar)))))
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jcExercicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jbAddTabela)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addGap(12, 12, 12)
                        .addComponent(jTextFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxFoco, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 44, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4)
                                .addGap(37, 37, 37)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButtonAutenticar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(btnSair1)))
                        .addGap(19, 19, 19))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        GGradeFrom formgrade = new GGradeFrom();
        formgrade.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int foco = jComboBoxFoco.getSelectedIndex();
        
        if (jTextFieldNome.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencha o campo Nome",
                    this.getTitle(), JOptionPane.ERROR_MESSAGE);
            jTextFieldNome.requestFocus();
        } else if (jTextFieldEmail.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencha o campo E-mail",
                    this.getTitle(), JOptionPane.ERROR_MESSAGE);
            jTextFieldEmail.requestFocus();
        } else if (jTextFieldSenha.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencha o campo Senha",
                    this.getTitle(), JOptionPane.ERROR_MESSAGE);
            jTextFieldSenha.requestFocus();
        } else if (foco <= -1) {
            JOptionPane.showMessageDialog(this, "Selecione o Foco",
                    this.getTitle(), JOptionPane.ERROR_MESSAGE);
            jTextFieldSenha.requestFocus();
        }else { //Aqui é confirmado que todos os campos foram preenchidos corretamente e um objeto de Bike é criado
            Comum user;
                user = new Comum(jTextFieldNome.getText(), jTextFieldEmail.getText(), jTextFieldSenha.getText(), foco);
            Boolean ok = FitWareCliente.ccont.userInserir(user); //Método Inserir é chamado
            System.out.println("Usuário cadastrado: "+user);
            
        }
    }//GEN-LAST:event_jButton5ActionPerformed
    
    
    
    private void btnSair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSair1ActionPerformed
        ListaUsuarios formuser = new ListaUsuarios();
        formuser.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnSair1ActionPerformed

    private void acExercicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acExercicioMouseClicked
        ListaExercicioFrom exercicios = new ListaExercicioFrom();
        exercicios.setVisible(true);
        dispose();
    }//GEN-LAST:event_acExercicioMouseClicked

    private void acHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acHomeMouseClicked
        MenuPrincipalFrom MenuPrincipalfrom = new MenuPrincipalFrom();
        MenuPrincipalfrom.setVisible(true);
        dispose();
    }//GEN-LAST:event_acHomeMouseClicked

    private void acUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acUsuariosMouseClicked
        ListaUsuarios usuarios = new ListaUsuarios();
        usuarios.setVisible(true);
        dispose();
    }//GEN-LAST:event_acUsuariosMouseClicked

    private void jcExerciciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcExerciciosActionPerformed
         
    }//GEN-LAST:event_jcExerciciosActionPerformed

    private void jcGruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcGruposActionPerformed
           
    }//GEN-LAST:event_jcGruposActionPerformed

    private void jbAddTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddTabelaActionPerformed
      
      Exercicio exercicio = (Exercicio) jcExercicios.getSelectedItem();
      int codUsuario = usuario.getCodUsuario();
      int codExercicio = exercicio.getCodExercicio();
      Boolean aux = null;
      aux = FitWareCliente.ccont.exercicioSalvarIntermediario(codUsuario, codExercicio);
        if (aux == true) {
            atualizaTabela();
        }
      
      
    }//GEN-LAST:event_jbAddTabelaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUsuarioFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUsuarioFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUsuarioFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUsuarioFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel acExercicio;
    private javax.swing.JLabel acHome;
    private javax.swing.JLabel acUsuarios;
    private javax.swing.JButton btnSair1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonAutenticar;
    private javax.swing.JComboBox<String> jComboBoxFoco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldSenha;
    private javax.swing.JButton jbAddTabela;
    private javax.swing.JComboBox<String> jcExercicios;
    private javax.swing.JComboBox<String> jcGrupos;
    // End of variables declaration//GEN-END:variables
}
