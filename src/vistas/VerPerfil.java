/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import com.sun.glass.events.KeyEvent;
import modelo.UsuarioAcademico;
import controlador.Controlador;
import dao.Persistencia;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import modelo.Administrador;
import modelo.Estudiante;
import modelo.Materia;
import modelo.Profesor;
import modelo.Registrador;
import modelo.Usuario;
import servicios.Hash;

/**
 *
 * @author Admin
 */
public class VerPerfil extends javax.swing.JFrame {

    private Controlador controlador;
    private Profesor profe;
    private Estudiante estu;
    private JFrame previo;
    private Administrador admin;
    private Registrador reg;
    private Usuario usuario;

    /**
     * Creates new form VerPerfil
     *
     * @param usuario
     *
     * @param p
     * @param usua
     * @param per
     */
    public VerPerfil(JFrame p, Persistencia per, Usuario usua) {
        controlador = new Controlador(per);
        previo = p;
        usuario = usua;
        estu = controlador.buscarEstudiante(usuario.getId());
        profe = controlador.buscarProfesor(usuario.getId());
        admin = controlador.buscarAdministrador(usuario.getId());
        reg = controlador.buscarRegistrador(usuario.getId());

        initComponents();
        this.comboBoxMaterias.setVisible(false);
        this.jLabel7.setVisible(false);
        if (profe != null) {
            this.comboBoxMaterias.setVisible(true);
            this.jLabel7.setVisible(true);
        } else {
            if (admin != null) {
                this.jLabel4.setVisible(false);
                this.textReputacion.setVisible(false);
            } else {
                if (reg != null) {
                    this.jLabel4.setVisible(false);
                    this.textReputacion.setVisible(false);
                    this.jLabel5.setVisible(false);
                    this.textRespuestas.setVisible(false);
                    this.jLabel6.setVisible(false);
                    this.textPreguntas.setVisible(false);
                }
            }
        }
        this.cargarDatos();
        this.textReputacion.setEditable(false);
        this.textApellido.setEditable(false);
        this.textNombre.setEditable(false);
        this.textEmail.setEditable(false);
        this.textPreguntas.setEditable(false);
        this.textRespuestas.setEditable(false);
        this.texPass.setVisible(false);
        this.texPass.setEditable(false);
        this.jPasswordField1.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        comboBoxMaterias = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        textNombre = new javax.swing.JTextField();
        textApellido = new javax.swing.JTextField();
        textEmail = new javax.swing.JTextField();
        textReputacion = new javax.swing.JTextField();
        textPreguntas = new javax.swing.JTextField();
        textRespuestas = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        texPass = new javax.swing.JTextField();
        buttonModificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre:");

        jLabel2.setText("Apellido:");

        jLabel3.setText("Email:");

        jLabel4.setText("Reputacion:");

        jLabel5.setText("Respuestas realizadas:");

        jLabel6.setText("Pregutas realizadas:");

        jLabel7.setText("Materias asignadas:");

        comboBoxMaterias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("Atras");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        textNombre.setEditable(false);

        textEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textEmailActionPerformed(evt);
            }
        });

        jLabel8.setText("Password:");

        jPasswordField1.setText("adminBitNet");
        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyTyped(evt);
            }
        });

        texPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texPassActionPerformed(evt);
            }
        });

        buttonModificar.setText("Modificar Password");
        buttonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textPreguntas, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textRespuestas, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBoxMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textReputacion, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(texPass, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(384, 384, 384)
                        .addComponent(buttonModificar)))
                .addGap(84, 84, 84))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {comboBoxMaterias, jPasswordField1, textApellido, textEmail, textNombre, textPreguntas, textReputacion, textRespuestas});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel8))
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel6))
                    .addComponent(textPreguntas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5))
                    .addComponent(textRespuestas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4))
                    .addComponent(textReputacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel7))
                    .addComponent(comboBoxMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(buttonModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.previo.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void texPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texPassActionPerformed

    private void jPasswordField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyTyped
        if (evt.getKeyChar() != KeyEvent.VK_BACKSPACE) {
            this.texPass.setText(this.texPass.getText() + evt.getKeyChar());
        } else {
            evt.consume();
            if (this.texPass.getText().length() >= 1) {

                this.texPass.setText(this.texPass.getText().substring(0, this.texPass.getText().length() - 1));
            } else {
                if (this.texPass.getText().length() == 2) {
                    this.texPass.setText(this.texPass.getText().substring(0, 1));
                } else {
                    this.texPass.setText("");
                }

            }
        }
    }//GEN-LAST:event_jPasswordField1KeyTyped

    private void buttonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModificarActionPerformed
        if (this.buttonModificar.getText() == "Modificar Password") {
            this.texPass.setVisible(true);
            this.jPasswordField1.setEditable(true);
            this.buttonModificar.setText("Guardar");
            this.jPasswordField1.setText("");
        } else {
            this.texPass.setVisible(false);
            this.jPasswordField1.setEditable(false);
            char[] arrayC = jPasswordField1.getPassword();
            String pass = new String(arrayC);
            String pass2 = Hash.MD5(pass);
            this.controlador.cambiarPassUsuario(usuario, pass2);
            this.buttonModificar.setText("Modificar Password");
        }

    }//GEN-LAST:event_buttonModificarActionPerformed

    private void textEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textEmailActionPerformed

    /**
     * @param datos
     */
    public void cargarComboBoxMateria(List datos) {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel((Materia[]) datos.get(8));
        this.comboBoxMaterias.setModel(modelo);

    }

    /* [0]=materias [1]=reputacion [2]=apellido [3]=nombre [4]=correo 
    [5]=cantidad de preguntas [6]=cantidad de respuestas*/
    public void cargarDatos() {
        ArrayList<Object> datos = (ArrayList<Object>) this.controlador.obtenerDatosVerPerfil(estu, profe, admin, reg);
        if (profe != null) {
            cargarComboBoxMateria(datos);
        }
        this.textReputacion.setText(Integer.toString((int) datos.get(0)));
        this.textApellido.setText(datos.get(1).toString());
        this.textNombre.setText(datos.get(2).toString());
        this.textEmail.setText(datos.get(3).toString());
        this.textPreguntas.setText(Integer.toString((int) datos.get(4)));
        this.textRespuestas.setText(Integer.toString((int) datos.get(5)));
        this.jPasswordField1.setText(datos.get(7).toString());

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonModificar;
    private javax.swing.JComboBox<String> comboBoxMaterias;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField texPass;
    private javax.swing.JTextField textApellido;
    private javax.swing.JTextField textEmail;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textPreguntas;
    private javax.swing.JTextField textReputacion;
    private javax.swing.JTextField textRespuestas;
    // End of variables declaration//GEN-END:variables
}
