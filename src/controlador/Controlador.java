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
import modelo.Respuesta;
import modelo.Usuario;
import modelo.UsuarioAcademico;

//controla la vista: VerPerfil
public class Controlador {

    Persistencia persistencia;

    public Controlador(Persistencia p) {
        this.persistencia = p;
    }

    public Persistencia getPersistencia() {
        return persistencia;
    }

    public List<Pregunta> listarPregunta() {
        return this.persistencia.buscarTodos(Pregunta.class);
    }

    public List<Foro> listarForos() {
        return this.persistencia.buscarTodos(Foro.class);
    }

    public List<Profesor> listarProfesor() {
        return this.persistencia.buscarTodos(Profesor.class);
    }

    public List<Estudiante> listarEstudiante() {
        return this.persistencia.buscarTodos(Estudiante.class);
    }

    public List<Registrador> listarRegistrador() {
        return this.persistencia.buscarTodos(Registrador.class);
    }

    public List<Administrador> listarAdministrador() {
        return this.persistencia.buscarTodos(Administrador.class);
    }

    public Foro buscarForo(String nombre) {
        return this.persistencia.buscar(Foro.class, nombre);
    }

    public Estudiante buscarEstudiante(Long id) {
        return this.persistencia.buscar(Estudiante.class, id);
    }

    public Profesor buscarProfesor(Long id) {
        return this.persistencia.buscar(Profesor.class, id);
    }

    public Administrador buscarAdministrador(Long id) {
        return this.persistencia.buscar(Administrador.class, id);
    }

    public Registrador buscarRegistrador(Long id) {
        return this.persistencia.buscar(Registrador.class, id);
    }

    public List<Pregunta> obtenerPreguntasDelForo(Foro foro) {
        return foro.getPreguntas();
    }

    public List<Respuesta> obtenerRepuestasDePregunta(Pregunta p) {
        return p.getRespuestas();
    }

    public List obtenerListRespuestaOrdenada(Pregunta pre) {
        return pre.getRespuestas();
    }

    public void crearPregunta(String titulo, String descripcion, Foro foro) {
        this.persistencia.iniciarTransaccion();

        try {

            Pregunta pregunta = new Pregunta(titulo, descripcion);
            // si es un departamento valido
            this.persistencia.insertar(pregunta);
            foro.agregarPregunta(pregunta);
            this.persistencia.modificar(foro);
            this.persistencia.confirmarTransaccion();
        } catch (Exception ex) {
            this.persistencia.descartarTransaccion();
            System.out.println("Error al insertar");
        }
    }

    public Boolean crearRespuesta(String respu, Pregunta pregunta, Usuario usuario) {
        this.persistencia.iniciarTransaccion();

        try {
            Administrador administrador = null;
            Estudiante estudiante = null;
            Profesor profesor = null;
            Respuesta respuesta = null;
            //insertamos la respuesta en la BD y asociamos a su usuario qu publico.
            if ((administrador = this.buscarAdministrador(usuario.getId())) != null) {
                respuesta = new Respuesta(respu, estudiante, profesor, administrador);
                this.persistencia.insertar(respuesta);
                administrador.agregarRespuesta(respuesta);
                this.persistencia.modificar(administrador);
            } else {
                if ((estudiante = this.buscarEstudiante(usuario.getId())) != null) {
                    respuesta = new Respuesta(respu, estudiante, profesor, administrador);
                    this.persistencia.insertar(respuesta);
                    estudiante.agregarRespuesta(respuesta);
                    this.persistencia.modificar(estudiante);
                } else {
                    if ((profesor = this.buscarProfesor(usuario.getId())) != null) {
                        respuesta = new Respuesta(respu, estudiante, profesor, administrador);
                        this.persistencia.insertar(respuesta);
                        profesor.agregarRespuesta(respuesta);
                        this.persistencia.modificar(profesor);
                    }
                }
            }
            //asociamos la respuesta a la pregunta
            pregunta.agregarRespuesta(respuesta);
            this.persistencia.modificar(pregunta);
            this.persistencia.confirmarTransaccion();
            return true;
        } catch (Exception ex) {
            this.persistencia.descartarTransaccion();
            System.out.println("Error al insertar");
            return false;
        }
    }

    public Boolean crearForo(String nombre) {
        this.persistencia.iniciarTransaccion();
        List foros = this.persistencia.buscarTodos(Foro.class);
        int si = 0;
        Foro foro;
        for (Foro foro1 : (List<Foro>) foros) {
            if (foro1.getTitulo().toUpperCase().equals(nombre.toUpperCase())) {
                si = 1;
                break;
            }
        }
        if (si == 0) {
            foro = new Foro(nombre);
            this.persistencia.insertar(foro);
            this.persistencia.confirmarTransaccion();
            return true;
        } else {
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

//vista  ViewPreunta pasarle el nombre, tipo de usuario,hora, respuesta,votos postivos, votos negativos
    public List obtenerInformacionRespuesta(Respuesta respuesta) {
        List datos = new ArrayList<>();

        datos.add(respuesta.obtenerPublicador().getApellido() + ' ' + respuesta.obtenerPublicador().getNombre());
        if (this.buscarAdministrador(respuesta.obtenerPublicador().getId()) != null) {
            datos.add("Administrador");
        } else {
            if (this.buscarEstudiante(respuesta.obtenerPublicador().getId()) != null) {
                datos.add("Estudiante");
            } else {
                if (this.buscarProfesor(respuesta.obtenerPublicador().getId()) != null) {
                    datos.add("Profesor");
                }
            }
        }
        datos.add(respuesta.getFechaPublicacion());
        datos.add(respuesta.getRespuesta());
        datos.add(respuesta.getVotosPositivos());
        datos.add(respuesta.getVotosNegativos());

        return datos;

    }

    //se usa en la vista MainFrame
    //la lista esta en esta orden Apellido, nombre, documento, correo , ttipo de usuario (ejemplo "Administrador") 
    public List<String> obtenerDatosUsuario(Usuario usuario) {
        List<String> datos = new ArrayList<>();
        datos.add(usuario.getApellido());
        datos.add(usuario.getNombre());
        datos.add(usuario.getDocumento());
        datos.add(usuario.getCorreo());
        if (this.buscarAdministrador(usuario.getId()) != null) {
            datos.add("Administrador");
        } else {
            if (this.buscarEstudiante(usuario.getId()) != null) {
                datos.add("Estudiante");
            } else {
                if (this.buscarProfesor(usuario.getId()) != null) {
                    datos.add("Profesor");
                } else {
                    if (this.buscarRegistrador(usuario.getId()) != null) {
                        datos.add("Registrador");
                    }
                }
            }
        }
        return datos;
    }

}
