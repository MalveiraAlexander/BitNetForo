/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.Persistencia;
import java.util.List;
import modelo.Administrador;
import modelo.Estudiante;
import modelo.Foro;
import modelo.Pregunta;
import modelo.Profesor;
import modelo.Registrador;

/**
 *
 * @author Admin
 */
public class ControladorPadre {

    Persistencia persistencia;

    public Persistencia getPersistencia() {
        return persistencia;
    }

    public List listarPregunta() {
        return this.persistencia.buscarTodos(Pregunta.class);
    }

    public List listarForos() {
        return this.persistencia.buscarTodos(Foro.class);
    }

    public List listarProfesor() {
        return this.persistencia.buscarTodos(Profesor.class);
    }

    public List listarEstudiante() {
        return this.persistencia.buscarTodos(Estudiante.class);
    }

    public List listarRegistrador() {
        return this.persistencia.buscarTodos(Registrador.class);
    }

    public List listarAdministrador() {
        return this.persistencia.buscarTodos(Administrador.class);
    }
}
