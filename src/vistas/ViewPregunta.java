/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controlador.Controlador;
import java.util.Arrays;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Foro;
import modelo.Pregunta;
import modelo.Respuesta;
import modelo.Usuario;
import modelo.Voto;

/**
 *
 * @author Alexander
 */
public class ViewPregunta extends javax.swing.JFrame {

    private JFrame previo;
    private Controlador controlador;
    private Pregunta pregunta;
    private Foro foro;
    private Usuario usuario;
    private Respuesta respuesta1;

    public ViewPregunta(JFrame p, Pregunta pre, Foro fo, Controlador c, Usuario usuari) {
        this.previo = p;
        this.pregunta = pre;
        this.foro = fo;
        this.controlador = c;
        this.usuario = usuari;
        initComponents();
        this.namePregunta.setText(pre.getTitulo());
        this.nameForo.setText(fo.getTitulo());
        this.cargarListRespuesta();
        
        List<String> datosUsuario = this.controlador.obtenerDatosUsuario(this.usuario);
        switch (datosUsuario.get(4)) {
            case "Estudiante":  
                     this.jButton4.setVisible(false);
                     break;
            case "Profesor":
                     this.jButton4.setVisible(false);
                     break;
            case "Registrador":
                     this.jButton4.setVisible(false);
                     break;
            default:
                     break;
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

        namePregunta = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listRespuestas = new javax.swing.JList<>();
        returnBtn = new javax.swing.JButton();
        nameForo = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        labelPositivo = new javax.swing.JLabel();
        labelNegativo = new javax.swing.JLabel();
        positiveVote = new javax.swing.JLabel();
        negativeVote = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listDetalles = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        buttonPositivos = new javax.swing.JButton();
        buttonNegativos = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        namePregunta.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        namePregunta.setText("NamePregunta");

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        listRespuestas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listRespuestasMouseClicked(evt);
            }
        });
        listRespuestas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listRespuestasValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listRespuestas);

        returnBtn.setText("Volver");
        returnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnBtnActionPerformed(evt);
            }
        });

        nameForo.setText("NameForo");

        jButton2.setText("Publicar Respuesta");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Buscar");

        labelPositivo.setForeground(new java.awt.Color(0, 153, 0));
        labelPositivo.setText("Votos Positivos:");

        labelNegativo.setForeground(new java.awt.Color(204, 0, 0));
        labelNegativo.setText("Votos Negativos:");

        jScrollPane3.setViewportView(listDetalles);

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        buttonPositivos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/me gusta.jpg"))); // NOI18N
        buttonPositivos.setBorder(null);
        buttonPositivos.setBorderPainted(false);
        buttonPositivos.setContentAreaFilled(false);
        buttonPositivos.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/me gusta2.jpg"))); // NOI18N
        buttonPositivos.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/me gusta2.jpg"))); // NOI18N
        buttonPositivos.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/me gusta2.jpg"))); // NOI18N
        buttonPositivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPositivosActionPerformed(evt);
            }
        });

        buttonNegativos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/no me gusta.jpg"))); // NOI18N
        buttonNegativos.setBorder(null);
        buttonNegativos.setBorderPainted(false);
        buttonNegativos.setContentAreaFilled(false);
        buttonNegativos.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/no me gusta2.jpg"))); // NOI18N
        buttonNegativos.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/me gusta2.jpg"))); // NOI18N
        buttonNegativos.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/no me gusta2.jpg"))); // NOI18N
        buttonNegativos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNegativosActionPerformed(evt);
            }
        });

        jButton4.setText("Eliminar Respuesta");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(returnBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(positiveVote)
                        .addGap(130, 130, 130)
                        .addComponent(negativeVote))
                    .addComponent(namePregunta)
                    .addComponent(nameForo)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1)
                                    .addComponent(jScrollPane3)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonPositivos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelPositivo))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNegativo)
                            .addComponent(buttonNegativos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(121, 121, 121))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(namePregunta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameForo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelPositivo)
                                    .addComponent(labelNegativo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(buttonPositivos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonNegativos))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(positiveVote)
                            .addComponent(negativeVote))
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(returnBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void returnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnBtnActionPerformed
        this.previo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_returnBtnActionPerformed

    private void listRespuestasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listRespuestasValueChanged
        this.respuesta1=this.listRespuestas.getSelectedValue();
        this.cargarListaDetalle();
    }//GEN-LAST:event_listRespuestasValueChanged

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        this.cargarListRespuesta();
    }//GEN-LAST:event_formWindowActivated

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        PublicarRespuesta principal = new PublicarRespuesta(this, this.pregunta, this.controlador, this.usuario);
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principal.setLocationRelativeTo(null);
        principal.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void buttonPositivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPositivosActionPerformed
        if (this.listRespuestas.getSelectedIndex() != -1) {
            this.controlador.crearVoto(true, this.listRespuestas.getSelectedValue(), this.usuario);
            this.cargarListaDetalle();
        }

    }//GEN-LAST:event_buttonPositivosActionPerformed

    private void buttonNegativosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNegativosActionPerformed
        if (this.listRespuestas.getSelectedIndex() != -1) {
            this.controlador.crearVoto(false, this.listRespuestas.getSelectedValue(), this.usuario);
            this.cargarListaDetalle();
        }
    }//GEN-LAST:event_buttonNegativosActionPerformed

    private void listRespuestasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listRespuestasMouseClicked

    }//GEN-LAST:event_listRespuestasMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (this.listRespuestas.getSelectedIndex() != -1) {
            this.controlador.eliminarRespuesta(this.respuesta1,this.pregunta);
            this.cargarListRespuesta();
        }else{
        JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna respuesta");
        }
    }//GEN-LAST:event_jButton4ActionPerformed
    private void cargarListaDetalle() {
        DefaultListModel modelo = new DefaultListModel();
        List respuestaInfo = this.controlador.obtenerInformacionRespuesta(this.listRespuestas.getSelectedValue());
        //se usa el triy catch porqu cuando se publica una nueva respuesta se activa el evento de valor cambiado en la lista respuesta y envia un objeto null y apareeen los errores de puntero.
        try {
            modelo.add(0, "Usuario: " + respuestaInfo.get(0));
            modelo.add(1, "Tipo de Usuario: " + respuestaInfo.get(1));
            modelo.add(2, "Fecha de publicacion: " + respuestaInfo.get(2));

            // modelo.add(2, "Respuesta: \n" + respuestaInfo.get(2));
            this.listDetalles.setModel(modelo);
            this.textArea.setText("Titulo: " + respuestaInfo.get(3) + '\n' + "Respuesta: \n" + respuestaInfo.get(4));

            this.textArea.setLineWrap(true);
            this.textArea.setEditable(false);
            this.labelPositivo.setText("Votos Positivos: " + (Integer) respuestaInfo.get(5));
            this.labelNegativo.setText("Votos Negativos: " + (Integer) respuestaInfo.get(6));
        } catch (Exception ex) {
        }
    }

    private void cargarListRespuesta() {
        DefaultListModel modelo = new DefaultListModel();
         Arrays.sort(this.controlador.obtenerRepuestasDePregunta(pregunta).toArray());
        for (Respuesta respuesta : this.controlador.obtenerRepuestasDePregunta(pregunta)) {
            modelo.addElement(respuesta);
        }
        this.listRespuestas.setModel(modelo);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonNegativos;
    private javax.swing.JButton buttonPositivos;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelNegativo;
    private javax.swing.JLabel labelPositivo;
    private javax.swing.JList<String> listDetalles;
    private javax.swing.JList<Respuesta> listRespuestas;
    private javax.swing.JLabel nameForo;
    private javax.swing.JLabel namePregunta;
    private javax.swing.JLabel negativeVote;
    private javax.swing.JLabel positiveVote;
    private javax.swing.JButton returnBtn;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}
