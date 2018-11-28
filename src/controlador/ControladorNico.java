/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.Persistencia;
import java.util.List;
import modelo.Foro;

/**
 *
 * @author Admin
 */
//Controla la vista: Crear Foro
public class ControladorNico {
        Persistencia persistencia;
    public ControladorNico(Persistencia p){
        persistencia=p;
    
    }
    public List listarForo(){
    return this.persistencia.buscarTodos(Foro.class);
    }
    public void crearForo(String nombre){
        this.persistencia.iniciarTransaccion();
        
        Foro foro= new Foro(nombre);
        this.persistencia.insertar(foro);
        this.persistencia.confirmarTransaccion();
    }
}
