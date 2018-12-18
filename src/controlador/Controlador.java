package controlador;

import dao.Persistencia;
import java.util.ArrayList;
import java.util.List;
import modelo.Administrador;
import modelo.Profesor;
import modelo.Estudiante;
import modelo.Foro;
import modelo.Pregunta;
import modelo.Registrador;
import modelo.UsuarioAcademico;


//controla la vista: VerPerfil
public class Controlador  {

    Persistencia persistencia;
    public Controlador(Persistencia p) {
        this.persistencia = p;
    }
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
    /*se crea una lista con materias, reputacion, apellido, nombre, correo, 
 cantidad de preguntas, cantidad de respuestas realizadas
    si es un alumno no se carga las materias*/
    public List obtenerDatosVerPerfil(Estudiante e, Profesor p) {
        List<Object> datos = new ArrayList<>();
        UsuarioAcademico ua;
        if (e == null) {
            ua = p;
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
        if (e == null) {
            datos.add(p.getMaterias());
        }
        return datos;
    }
//visa crear usuario crea al usuario dependiendo el tipo de usuario que sea (administrador,registrador, estudiante, profesor)
    public Boolean crearUsuario(String nombre, String apellido, String correo, String documento, String usuario) {
        this.persistencia.iniciarTransaccion();
        if (usuario.equals("Administrador")) {
            Administrador admin = new Administrador(apellido, nombre, documento, correo);
            this.persistencia.insertar(admin);
        } else {
            if (usuario.equals("Registrador")) {
                Registrador re = new Registrador(apellido, nombre, documento, correo);
                this.persistencia.insertar(re);
            } else {
                if (usuario.equals("Profesor")) {
                    Profesor re = new Profesor(apellido, nombre, documento, correo);
                    this.persistencia.insertar(re);
                } else {
                    if (usuario.equals("Estudiante")) {
                        Estudiante re = new Estudiante(apellido, nombre, documento, correo);
                        this.persistencia.insertar(re);
                    } else {
                        this.persistencia.descartarTransaccion();
                        return false;
                    }
                }

            }
        }
        this.persistencia.confirmarTransaccion();
        return true;

    }

   
}
