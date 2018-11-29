/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forobitnet;

import controlador.*;
import dao.Persistencia;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Estudiante;
import modelo.Profesor;
import vistas.*;

/**
 *
 * @author Natan
 */
public class ForoBitNet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     EntityManagerFactory emf = Persistence.createEntityManagerFactory("ForoBitNetPU");
        // creo objeto de Persistencia (DAO)
        Persistencia persistencia = new Persistencia(emf);
        // creo controlador y asocio (inyecto) al controlador el objeto de Persistencia (DAO)
        ControladorAgus c = new ControladorAgus(persistencia);
        ControladorAlex ca = new ControladorAlex(persistencia);
        StartSesion principal = new StartSesion();
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principal.setLocationRelativeTo(null);     
        principal.setVisible(true);
    }
    
}
