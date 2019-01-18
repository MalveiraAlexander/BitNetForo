/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controlador.Controlador;
import dao.Persistencia;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;
import modelo.Administrador;
import servicios.Hash;
import java.lang.Long;
import modelo.Estudiante;
import modelo.Profesor;
import modelo.Registrador;
import modelo.Usuario;
import servicios.Hash;

/**
 *
 * @author Alexander
 */
public class StartSesion extends javax.swing.JFrame {

    public StartSesion() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        textUsuario.setText("admin@admin.com");

        jLabel1.setText("Correo:");

        jLabel2.setText("Contraseña:");

        jButton1.setText("Entrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Iniciar Sesión");

        jPasswordField1.setText("adminBitNet");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                            .addComponent(textUsuario)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addContainerGap(82, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(179, 179, 179))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("empty-statement")
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ForoBitNetPU");

        Persistencia persistencia = new Persistencia(emf);
        Controlador controlador = new Controlador(persistencia);
        // 0= Estudiante. 1= Profesor,2=Administrador , 3= Registrador
        //usuario[0]= id del usuario----- usuario[1]= tipo de usuario explicado arriba
        if (!controlador.existeAdministrador()) {
            controlador.crearUsuario("Admin".toUpperCase(), "BitNet".toUpperCase(), "admin@admin.com", "000000", "Administrador".toUpperCase(), Hash.MD5("adminBitNet"));
        }

        char[] arrayC = jPasswordField1.getPassword();
        String pass = new String(arrayC);
        String pass2 = Hash.MD5(pass);
        
        for (Administrador administrador : controlador.listarAdministrador()) {
            if (administrador.getCorreo().equals(this.textUsuario.getText())&&administrador.getPassword().equals(pass2)) {
                MainFrame principal = new MainFrame(persistencia, (Usuario) administrador
                );
                principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                principal.setLocationRelativeTo(null);
                principal.setVisible(true);
                this.dispose();

            }else{
                this.jLabel4.setText("Contraseña incorrecta y/o usuario inexistente");
            }
        }
        for (Estudiante estudiante : controlador.listarEstudiante()) {
            if (estudiante.getCorreo().equals(this.textUsuario.getText())&&estudiante.getPassword().equals(pass2)) {
                MainFrame principal = new MainFrame(persistencia, (Usuario) estudiante
                );
                principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                principal.setLocationRelativeTo(null);
                principal.setVisible(true);
                this.dispose();
            }else{
                this.jLabel4.setText("Contraseña incorrecta y/o usuario inexistente");
            }
        }
        for (Profesor profesor : controlador.listarProfesor()) {
            if (profesor.getCorreo().equals(this.textUsuario.getText())&&profesor.getPassword().equals(pass2)) {
                MainFrame principal = new MainFrame(persistencia, (Usuario) profesor);
                principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                principal.setLocationRelativeTo(null);
                principal.setVisible(true);
                this.dispose();
            }else{
                this.jLabel4.setText("Contraseña incorrecta y/o usuario inexistente");
            }
        }
        for (Registrador registrador : controlador.listarRegistrador()) {
            if (registrador.getCorreo().equals(this.textUsuario.getText())&&registrador.getPassword().equals(pass2)) {
                MainFrame principal = new MainFrame(persistencia, (Usuario) registrador);
                principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                principal.setLocationRelativeTo(null);
                principal.setVisible(true);
                this.dispose();
            }else{
                this.jLabel4.setText("Contraseña incorrecta y/o usuario inexistente");
            }
            
        }
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField textUsuario;
    // End of variables declaration//GEN-END:variables
}
