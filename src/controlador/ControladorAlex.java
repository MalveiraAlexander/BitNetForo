/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.Persistencia;
import java.util.List;
import modelo.Pregunta;

/**
 *
 * @author malve
 */
public class ControladorAlex {
    Persistencia persistencia;
    public ControladorAlex(Persistencia p) {
        this.persistencia = p;
    }
    public List listarPregunta(){
    return this.persistencia.buscarTodos(Pregunta.class);
    }

}
