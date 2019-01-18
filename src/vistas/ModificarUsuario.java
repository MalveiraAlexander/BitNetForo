/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controlador.Controlador;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Administrador;
import modelo.Estudiante;
import modelo.Materia;
import modelo.Profesor;
import modelo.Registrador;
import modelo.Usuario;

/**
 *
 * @author Admin
 */
public final class ModificarUsuario extends javax.swing.JFrame {

    private Controlador controlador;
    private Profesor profe;
    private Usuario usuario;
    private JFrame previo;

    public ModificarUsuario(JFrame p, Controlador c, Usuario u) {
        controlador = c;
        previo = p;
        profe = this.controlador.buscarProfesor(u.getId());
        usuario = u;
        initComponents();
        this.cargarDatos();
        if (profe == null) {
            this.labelMaterias.setVisible(false);
            this.labelMateriasActuales.setVisible(false);
            this.comboBoxMateriaActuales.setVisible(false);
            this.comboBoxMaterias.setVisible(false);
            this.buttonAgregar.setVisible(false);
            this.buttonQuitar.setVisible(false);
        }
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
        textNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textApellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        textDocumento = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textCorreo = new javax.swing.JTextField();
        labelMaterias = new javax.swing.JLabel();
        comboBoxMaterias = new javax.swing.JComboBox<>();
        labelMateriasActuales = new javax.swing.JLabel();
        comboBoxMateriaActuales = new javax.swing.JComboBox<>();
        buttonAgregar = new javax.swing.JButton();
        buttonQuitar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre:");

        jLabel2.setText("Apellido:");

        jLabel3.setText("Documento:");

        textDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textDocumentoKeyTyped(evt);
            }
        });

        jLabel4.setText("Correo:");

        labelMaterias.setText("Materias:");

        labelMateriasActuales.setText("Materias Actuales:");

        buttonAgregar.setText("Agregar");
        buttonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAgregarActionPerformed(evt);
            }
        });

        buttonQuitar.setText("Quitar");
        buttonQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonQuitarActionPerformed(evt);
            }
        });

        jButton3.setText("Guardar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Atras");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(buttonAgregar)
                        .addGap(100, 100, 100)
                        .addComponent(buttonQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(labelMateriasActuales)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(comboBoxMateriaActuales, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textDocumento))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelMaterias)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboBoxMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(121, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMaterias)
                    .addComponent(comboBoxMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMateriasActuales)
                    .addComponent(comboBoxMateriaActuales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonQuitar)
                    .addComponent(buttonAgregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAgregarActionPerformed
        if (this.comboBoxMaterias.getSelectedIndex() != -1) {
            Boolean existe = false;
            for (Materia mat : this.profe.getMaterias()) {
                if (this.comboBoxMaterias.getSelectedItem().equals(mat)) {
                    existe = true;
                }
            }
            if (!existe) {
                this.controlador.agregarMaterias((Materia) this.comboBoxMaterias.getSelectedItem(), profe);
                DefaultComboBoxModel modelo = new DefaultComboBoxModel();
                modelo = (DefaultComboBoxModel) this.comboBoxMateriaActuales.getModel();
                modelo.addElement(this.comboBoxMaterias.getSelectedItem());
                this.comboBoxMateriaActuales.setModel(modelo);
            }

        } else {
            JOptionPane.showMessageDialog(null, "No selecciono una materia de la lista de materias");
        }
    }//GEN-LAST:event_buttonAgregarActionPerformed

    private void buttonQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonQuitarActionPerformed
        if (this.comboBoxMateriaActuales.getSelectedIndex() != -1) {
            this.controlador.quitarMaterias((Materia) this.comboBoxMateriaActuales.getSelectedItem(), profe);
            DefaultComboBoxModel modelo = new DefaultComboBoxModel();
            modelo = (DefaultComboBoxModel) this.comboBoxMateriaActuales.getModel();
            modelo.removeElement(this.comboBoxMaterias.getSelectedItem());
            this.comboBoxMateriaActuales.setModel(modelo);

        } else {
            JOptionPane.showMessageDialog(null, "No selecciono una materia de la lista de materias");
        }
    }//GEN-LAST:event_buttonQuitarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        if (textCorreo.getText().contains("@") && textCorreo.getText().contains(".")) {
            if (this.controlador.modificarUsuario(usuario, this.textApellido.getText(), this.textNombre.getText(), this.textDocumento.getText(), this.textCorreo.getText())) {
                JOptionPane.showMessageDialog(null, "Se a guardado con exito");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Correo ingresado sin '@' y/o '.'! ", "Error en campo Correo", JOptionPane.ERROR_MESSAGE);
            textCorreo.setText("");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        JOptionPane.showMessageDialog(null, "Si ha realizado un cambio en las materias estos efectos no se deshacen");
        this.previo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void textDocumentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textDocumentoKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_textDocumentoKeyTyped

    /**
     * @param prof
     */
    public void cargarComboBoxMateria(Profesor prof) {

        DefaultComboBoxModel modelo = new DefaultComboBoxModel(prof.getMaterias().toArray());
        this.comboBoxMateriaActuales.setModel(modelo);
        DefaultComboBoxModel modelo2 = new DefaultComboBoxModel(this.controlador.listarMaterias().toArray());
        this.comboBoxMaterias.setModel(modelo2);
    }

    public void cargarDatos() {
        List<String> info = this.controlador.obtenerDatosUsuario(usuario);
        if (profe != null) {
            cargarComboBoxMateria(this.profe);
        }
        this.textApellido.setText(info.get(0));
        this.textNombre.setText(info.get(1));
        this.textDocumento.setText(info.get(2));
        this.textCorreo.setText(info.get(3));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAgregar;
    private javax.swing.JButton buttonQuitar;
    private javax.swing.JComboBox<Materia
    > comboBoxMateriaActuales;
    private javax.swing.JComboBox<Materia> comboBoxMaterias;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelMaterias;
    private javax.swing.JLabel labelMateriasActuales;
    private javax.swing.JTextField textApellido;
    private javax.swing.JTextField textCorreo;
    private javax.swing.JTextField textDocumento;
    private javax.swing.JTextField textNombre;
    // End of variables declaration//GEN-END:variables
}
