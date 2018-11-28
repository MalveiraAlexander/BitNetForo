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

    public ControladorNico(Persistencia p) {
        persistencia = p;

    }

    public List listarForo() {
        return this.persistencia.buscarTodos(Foro.class);
    }
//devuleve verdadero si se crea el foro
    public Boolean crearForo(String nombre) {
        this.persistencia.iniciarTransaccion();
        List foros = this.persistencia.buscarTodos(Foro.class);
        int si = 0;
        Foro foro;
        for (Foro foro1 : (List<Foro>) foros) {
            if (foro1.getTitulo().toUpperCase().equals(nombre.toUpperCase()) ) {
                si = 1;
                break;
            }
        }
        if (si == 0) {
            foro = new Foro(nombre);
            this.persistencia.insertar(foro);
            this.persistencia.confirmarTransaccion();
            return true;
        }else{
            this.persistencia.descartarTransaccion();
            return false;
        }

    }
}
