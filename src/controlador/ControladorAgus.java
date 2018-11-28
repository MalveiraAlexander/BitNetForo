package controlador;

import dao.Persistencia;
import java.util.ArrayList;
import java.util.List;
import modelo.Profesor;
import modelo.Estudiante;
import modelo.UsuarioAcademico;

//controla la vista: VerPerfil
public class ControladorAgus {

    Persistencia persistencia;

    public Persistencia getPersistencia() {
        return persistencia;
    }

    public ControladorAgus(Persistencia p) {
        this.persistencia = p;
    }
/*se crea una lista con materias, reputacion, apellido, nombre, correo, 
 cantidad de preguntas, cantidad de respuestas realizadas
    si es un alumno no se carga las materias*/
    public List obtenerDatosVerPerfil(Estudiante e, Profesor p) {
        List<Object> datos = new ArrayList<>();
        UsuarioAcademico ua;
        if (e == null) {
             ua= p;
            datos.add(p.getReputacion());
        } else {
            ua = e;
            datos.add(e.getReputacion());
        }
        datos.add(ua.getApellido());
        datos.add(ua.getNombre());
        datos.add(ua.getCorreo());
        datos.add(ua.getPreguntas().size());
        datos.add(ua.getRespuestas().size());
        if(e==null){
        datos.add(p.getMaterias());
        }
        return datos;
    }

}
