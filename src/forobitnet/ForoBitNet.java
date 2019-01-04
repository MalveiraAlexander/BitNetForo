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
        StartSesion principal = new StartSesion();
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principal.setLocationRelativeTo(null);     
        principal.setVisible(true);
        
    }
    
}
