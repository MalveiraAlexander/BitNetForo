/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controlador.Controlador;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(returnBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(namePregunta)
                                .addComponent(nameForo))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(82, 82, 82)
                                    .addComponent(positiveVote)
                                    .addGap(130, 130, 130)
                                    .addComponent(negativeVote))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(32, 32, 32)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(38, 38, 38)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelPositivo)
                                        .addComponent(buttonPositivos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(91, 91, 91)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addComponent(buttonNegativos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(labelNegativo)))
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(namePregunta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameForo))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelPositivo)
                            .addComponent(labelNegativo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buttonPositivos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonNegativos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addGap(32, 32, 32)
                .addComponent(returnBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(positiveVote)
                    .addComponent(negativeVote))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void returnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnBtnActionPerformed
        this.previo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_returnBtnActionPerformed

    private void listRespuestasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listRespuestasValueChanged
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
    private void cargarListaDetalle() {
        DefaultListModel modelo = new DefaultListModel();
        List respuestaInfo = this.controlador.obtenerInformacionRespuesta(this.listRespuestas.getSelectedValue());
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
    }

    private void cargarListRespuesta() {
        DefaultListModel modelo = new DefaultListModel();
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
