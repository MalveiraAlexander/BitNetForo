package controlador;

import dao.Persistencia;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import modelo.Administrador;
import modelo.Profesor;
import modelo.Estudiante;
import modelo.Foro;
import modelo.Materia;
import modelo.Pregunta;
import modelo.Registrador;
import modelo.Respuesta;
import modelo.Usuario;
import modelo.UsuarioAcademico;
import modelo.Voto;

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
    
    public List<Usuario> listarUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        for (Usuario usuario : this.persistencia.buscarTodos(Administrador.class)) {
            lista.add(usuario);
        }
        for (Usuario usuario : this.persistencia.buscarTodos(Estudiante.class)) {
            lista.add(usuario);
        }
        for (Usuario usuario : this.persistencia.buscarTodos(Profesor.class)) {
            lista.add(usuario);
        }
        for (Usuario usuario : this.persistencia.buscarTodos(Registrador.class)) {
            lista.add(usuario);
        }
        return lista;
        
    }
    
    public List<Usuario> listarUsuariosPersonalizado(String filtro, String nombre) {
        List<Usuario> lista = new ArrayList<>();
        if (filtro.toUpperCase().equals("ADMINISTRADOR")) {
            if (nombre.trim().equals("")) {
                for (Usuario us : this.listarAdministrador()) {
                    lista.add(us);
                }
                return lista;
            } else {
                for (Usuario us : this.listarAdministrador()) {
                    if (us.getNombre().toUpperCase().equals(nombre.toUpperCase())) {
                        lista.add(us);
                    }
                    
                }
                return lista;
                
            }
            
        } else {
            if (filtro.toUpperCase().equals("REGISTRADOR")) {
                if (nombre.trim().equals("")) {
                    for (Usuario us : this.listarRegistrador()) {
                        lista.add(us);
                    }
                    return lista;
                } else {
                    for (Usuario us : this.listarRegistrador()) {
                        if (us.getNombre().toUpperCase().equals(nombre.toUpperCase())) {
                            lista.add(us);
                        }
                        
                    }
                    return lista;
                    
                }
            } else {
                if (filtro.toUpperCase().equals("PROFESOR")) {
                    if (nombre.trim().equals("")) {
                        for (Usuario us : this.listarProfesor()) {
                            lista.add(us);
                        }
                        return lista;
                    } else {
                        for (Usuario us : this.listarProfesor()) {
                            if (us.getNombre().toUpperCase().equals(nombre.toUpperCase())) {
                                lista.add(us);
                            }
                            
                        }
                        return lista;
                        
                    }
                } else {
                    if (filtro.toUpperCase().equals("ESTUDIANTE")) {
                        if (nombre.trim().equals("")) {
                            for (Usuario us : this.listarEstudiante()) {
                                lista.add(us);
                            }
                            return lista;
                        } else {
                            for (Usuario us : this.listarEstudiante()) {
                                if (us.getNombre().toUpperCase().equals(nombre.toUpperCase())) {
                                    lista.add(us);
                                }
                                
                            }
                            return lista;
                            
                        }
                    } else {
                        if (filtro.toUpperCase().equals("CORREO")) {
                            for (Usuario us : this.listarUsuarios()) {
                                if (us.getCorreo().toUpperCase().equals(nombre.toUpperCase())) {
                                    lista.add(us);
                                    break;
                                }
                            }
                            return lista;
                        } else {
                            if (filtro.toUpperCase().equals("DOCUMENTO")) {
                                for (Usuario us : this.listarUsuarios()) {
                                    if (us.getDocumento().toUpperCase().equals(nombre.toUpperCase())) {
                                        lista.add(us);
                                        break;
                                    }
                                }
                                return lista;
                            } else {
                                if (filtro.toUpperCase().equals("TODOS")) {
                                    
                                    return this.listarUsuarios();
                                }
                                
                            }
                            
                        }
                    }
                }
            }
        }
        return null;
    }
    
    public List<Materia> listarMaterias() {
        return this.persistencia.buscarTodos(Materia.class);
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
    
    public void crearPregunta(String titulo, String descripcion, Foro foro, Usuario usuario) {
        this.persistencia.iniciarTransaccion();
        
        try {
            Administrador administrador = null;
            Estudiante estudiante = null;
            Profesor profesor = null;
            Pregunta pregunta = null;
            //insertamos la pregunta en la BD y asociamos a su usuario que publico.
            if ((administrador = this.buscarAdministrador(usuario.getId())) != null) {
                pregunta = new Pregunta(titulo, descripcion, estudiante, profesor, administrador);
                this.persistencia.insertar(pregunta);
                administrador.agregarPregunta(pregunta);
                this.persistencia.modificar(administrador);
            } else {
                if ((estudiante = this.buscarEstudiante(usuario.getId())) != null) {
                    pregunta = new Pregunta(titulo, descripcion, estudiante, profesor, administrador);
                    this.persistencia.insertar(pregunta);
                    estudiante.agregarPregunta(pregunta);
                    this.persistencia.modificar(estudiante);
                } else {
                    if ((profesor = this.buscarProfesor(usuario.getId())) != null) {
                        pregunta = new Pregunta(titulo, descripcion, estudiante, profesor, administrador);
                        this.persistencia.insertar(pregunta);
                        profesor.agregarPregunta(pregunta);
                        this.persistencia.modificar(profesor);
                    }
                }
            }
            
            foro.agregarPregunta(pregunta);
            this.persistencia.modificar(foro);
            this.persistencia.confirmarTransaccion();
        } catch (Exception ex) {
            this.persistencia.descartarTransaccion();
            System.out.println("Error al insertar");
        }
    }
    
    public Boolean eliminarPregunta(Pregunta pregunta, Foro foro) {
        this.persistencia.iniciarTransaccion();
        if (pregunta.getRespuestas().isEmpty()) {
            foro.getPreguntas().remove(pregunta);
            Administrador administrador = pregunta.getAdministrador();
            Profesor profesor = pregunta.getProfesor();
            Estudiante estudiante = pregunta.getEstudiante();
            if (administrador != null) {
                administrador.getPreguntas().remove(pregunta);
                this.persistencia.modificar(administrador);
            } else {
                if (profesor != null) {
                    profesor.getPreguntas().remove(pregunta);
                    this.persistencia.modificar(profesor);
                } else {
                    if (estudiante != null) {
                        estudiante.getPreguntas().remove(pregunta);
                        this.persistencia.modificar(estudiante);
                    }
                }
            }
            this.persistencia.modificar(foro);
            this.persistencia.eliminar(pregunta);
            
            this.persistencia.confirmarTransaccion();
            return true;
        } else {
            this.persistencia.descartarTransaccion();
            JOptionPane.showMessageDialog(null, "La pregunta no se puede elimar porque esta asociada a " + pregunta.getRespuestas().size() + " respuestas");
            return false;
        }
    }
    
    public Boolean crearRespuesta(String respu, String titulo, Pregunta pregunta, Usuario usuario) {
        this.persistencia.iniciarTransaccion();
        
        try {
            Administrador administrador = null;
            Estudiante estudiante = null;
            Profesor profesor = null;
            Respuesta respuesta = null;
            //insertamos la respuesta en la BD y asociamos a su usuario que publico.
            if ((administrador = this.buscarAdministrador(usuario.getId())) != null) {
                respuesta = new Respuesta(respu, titulo, estudiante, profesor, administrador);
                this.persistencia.insertar(respuesta);
                administrador.agregarRespuesta(respuesta);
                this.persistencia.modificar(administrador);
            } else {
                if ((estudiante = this.buscarEstudiante(usuario.getId())) != null) {
                    respuesta = new Respuesta(respu, titulo, estudiante, profesor, administrador);
                    this.persistencia.insertar(respuesta);
                    estudiante.agregarRespuesta(respuesta);
                    this.persistencia.modificar(estudiante);
                } else {
                    if ((profesor = this.buscarProfesor(usuario.getId())) != null) {
                        respuesta = new Respuesta(respu, titulo, estudiante, profesor, administrador);
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
    
    public Boolean eliminarRespuesta(Respuesta respuesta, Pregunta pregunta) {
        if (respuesta.getVotos().isEmpty()) {
            try {
                this.persistencia.iniciarTransaccion();
                Administrador administrador = respuesta.getAdministrador();
                Profesor profesor = respuesta.getProfesor();
                Estudiante estudiante = respuesta.getEstudiante();
                if (administrador != null) {
                    administrador.getPreguntas().remove(respuesta);
                    this.persistencia.modificar(administrador);
                } else {
                    if (profesor != null) {
                        profesor.getPreguntas().remove(respuesta);
                        this.persistencia.modificar(profesor);
                    } else {
                        if (estudiante != null) {
                            estudiante.getPreguntas().remove(respuesta);
                            this.persistencia.modificar(estudiante);
                        }
                    }
                }
                pregunta.getRespuestas().remove(respuesta);
                this.persistencia.modificar(pregunta);
                this.persistencia.eliminar(respuesta);
                this.persistencia.confirmarTransaccion();
                return true;
                
            } catch (Exception ex) {
                this.persistencia.descartarTransaccion();
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se puede eliminar porque esta asociado a " + respuesta.getVotos().size() + " votos");
            return false;
        }
        
    }
    
    public Boolean crearMateria(String materia, String enlace) {
        Materia materia1 = new Materia(materia, enlace);
        try {
            this.persistencia.iniciarTransaccion();
            this.persistencia.insertar(materia1);
            this.persistencia.confirmarTransaccion();
            return true;
        } catch (Exception ex) {
            this.persistencia.descartarTransaccion();
            return false;
        }
    }
    
    public Boolean modificarMateria(Materia materia, String nombre, String enlace) {
        materia.setMateria(nombre);
        materia.setEnlace(enlace);
        try {
            this.persistencia.iniciarTransaccion();
            this.persistencia.modificar(materia);
            this.persistencia.confirmarTransaccion();
            return true;
        } catch (Exception ex) {
            this.persistencia.descartarTransaccion();
            return false;
        }
    }
    
    public Boolean eliminarMateria(Materia materia) {
        
        if (materia.getProfesores() == null) {
            this.persistencia.iniciarTransaccion();
            this.persistencia.eliminar(materia);
            this.persistencia.confirmarTransaccion();
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "No se puede eliminar porque esta asociado a " + materia.getProfesores().size() + " profesores");
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
    
    public Boolean eliminarForo(Foro foro) {
        
        if (foro.getPreguntas().isEmpty()) {
            this.persistencia.iniciarTransaccion();
            this.persistencia.eliminar(foro);
            this.persistencia.confirmarTransaccion();
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "No se puede eliminar el foro que tiene " + foro.getPreguntas().size() + " preguntas");
            return false;
        }
        
    }

    /*se crea una lista con materias, reputacion, apellido, nombre, correo, 
 cantidad de preguntas, cantidad de respuestas realizadas, documento
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
        datos.add(ua.getDocumento());
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
//la lista de datos tiene Apellido y nombre, tipo de usuario, titulo, descripcion, fecha de publicacion, cantidad de respuestas, fecha de la ultima respuesta

    public List obtenerInformacionPregunta(Pregunta pregunta) {
        List datos = new ArrayList<>();
        try {
            datos.add(pregunta.obtenerPublicador().getApellido() + ' ' + pregunta.obtenerPublicador().getNombre());
            if (this.buscarAdministrador(pregunta.obtenerPublicador().getId()) != null) {
                datos.add("Administrador");
            } else {
                if (this.buscarEstudiante(pregunta.obtenerPublicador().getId()) != null) {
                    datos.add("Estudiante");
                } else {
                    if (this.buscarProfesor(pregunta.obtenerPublicador().getId()) != null) {
                        datos.add("Profesor");
                    }
                }
            }
            datos.add(pregunta.getTitulo());
            datos.add(pregunta.getDescripcion());
            datos.add(pregunta.getFechaPublicacion());
            List<Respuesta> listaRespuesta = pregunta.getRespuestas();
            datos.add(listaRespuesta.size());
            if (!listaRespuesta.isEmpty()) {
                datos.add(listaRespuesta.get(listaRespuesta.size() - 1).getFechaPublicacion());
            } else {
                datos.add("Vacio");
            }

            //si quiero agregar que muestre la respuesta mas votada dejo lo siguiente
            /*Respuesta viejo = null;
        if (!pregunta.getRespuestas().isEmpty()) {
            viejo = pregunta.getRespuestas().get(0);
            Integer reputacion = viejo.getVotosPositivos() - viejo.getVotosNegativos();
            //en viejo se almacena la respuesta con mejor reputacion
            for (Respuesta respuesta : pregunta.getRespuestas()) {
                if ((respuesta.getVotosPositivos() - respuesta.getVotosNegativos()) > reputacion) {
                    reputacion = respuesta.getVotosPositivos() - respuesta.getVotosNegativos();
                    viejo = respuesta;
                }

            }
        }
        datos.add(viejo);*/
        } catch (Exception ex) {
        }
        return datos;
    }
//vista  ViewPreunta pasarle el nombre, tipo de usuario,hora, titulo,respuesta,votos postivos, votos negativos

    public List obtenerInformacionRespuesta(Respuesta respuesta) {
        List datos = new ArrayList<>();
        try {
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
            datos.add(respuesta.getTitulo());
            datos.add(respuesta.getRespuesta());
            datos.add(respuesta.getVotosPositivos());
            datos.add(respuesta.getVotosNegativos());
            return datos;
        } catch (Exception ex) {
            // es un errore que siempre salta porque funciona con el eento value change en la vista view pregunta aveces pasa un puntero null por lo tatno captura el error
        }
        
        return null;
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
    
    public void crearVoto(Boolean voto, Respuesta respuesta, Usuario usuario) {
        this.persistencia.iniciarTransaccion();
        try {
            Administrador administrador = null;
            Estudiante estudiante = null;
            Profesor profesor = null;
            Boolean existe = false;
            //recorremos todos los votos de la respuesta
            for (Voto viejo : respuesta.getVotos()) {
                //verificamos si el usuario es un administrador o no
                if ((administrador = viejo.getAdministrador()) != null) {
                    //verificamos si el usuario que hizo el voto ahora es el mismo del voto viejo 
                    if (Objects.equals(usuario.getId(), administrador.getId())) {
                        existe = true;
                        //si el voto viejo es igual al nuevo voto
                        if (viejo.isVoto().equals(voto)) {
                            //si los dos votos son iguales no tengo que hacer nada ya que voto anteriormente
                            break;
                        } else {
                            //si no son iguales debo modificar al nuevo voto
                            viejo.setVoto(voto);
                            // al no sser igual debo calcular los votos negativo y positivo nuevamente
                            if (voto) {
                                //si es positivo ahora quiere decir que antes era negativo por eso hacemos lo siguiente
                                respuesta.setVotosPositivos(respuesta.getVotosPositivos() + 1);
                                respuesta.setVotosNegativos(respuesta.getVotosNegativos() - 1);
                                //recalcular los votos del usuario que esta votando ahora
                                administrador.setVotosPositivos(administrador.getVotosPositivos() + 1);
                                administrador.setVotosNegativos(administrador.getVotosNegativos() - 1);
                                //ahora calcular la reputacion del que hizo la respuesta (el administrador no tiene reputacion)
                                Estudiante estu = null;
                                Profesor profe = null;
                                if ((estu = respuesta.getEstudiante()) != null) {
                                    estu.setReputacion(estu.getReputacion() + 1);
                                    this.persistencia.modificar(estu);
                                } else {
                                    if ((profe = respuesta.getProfesor()) != null) {
                                        profe.setReputacion(estu.getReputacion() + 1);
                                        this.persistencia.modificar(profe);
                                    }
                                    
                                }
                                
                            } else {
                                respuesta.setVotosPositivos(respuesta.getVotosPositivos() - 1);
                                respuesta.setVotosNegativos(respuesta.getVotosNegativos() + 1);
                                administrador.setVotosPositivos(administrador.getVotosPositivos() - 1);
                                administrador.setVotosNegativos(administrador.getVotosNegativos() + 1);
                                Estudiante estu = null;
                                Profesor profe = null;
                                if ((estu = respuesta.getEstudiante()) != null) {
                                    estu.setReputacion(estu.getReputacion() - 1);
                                    this.persistencia.modificar(estu);
                                } else {
                                    if ((profe = respuesta.getProfesor()) != null) {
                                        profe.setReputacion(estu.getReputacion() - 1);
                                        this.persistencia.modificar(profe);
                                    }
                                }
                            }
                            this.persistencia.modificar(respuesta);
                            this.persistencia.modificar(administrador);
                            this.persistencia.modificar(viejo);
                        }
                        break;
                    }
                } else {
                    if ((estudiante = viejo.getEstudiante()) != null) {
                        //verificamos si el usuario que hizo el voto ahora es el mismo del voto viejo 
                        if (Objects.equals(usuario.getId(), estudiante.getId())) {
                            existe = true;
                            //si el voto viejo es igual al nuevo voto
                            if (viejo.isVoto().equals(voto)) {
                                //si los dos votos son iguales no tengo que hacer nada ya que voto anteriormente
                                break;
                            } else {
                                //si no son iguales debo modificar al nuevo voto
                                viejo.setVoto(voto);
                                // al no sser igual debo calcular los votos negativo y positivo nuevamente
                                if (voto) {
                                    //si es positivo ahora quiere decir que antes era negativo por eso hacemos lo siguiente
                                    respuesta.setVotosPositivos(respuesta.getVotosPositivos() + 1);
                                    respuesta.setVotosNegativos(respuesta.getVotosNegativos() - 1);
                                    //recalcular los votos del usuario que esta votando ahora
                                    estudiante.setVotosPositivos(estudiante.getVotosPositivos() + 1);
                                    estudiante.setVotosNegativos(estudiante.getVotosNegativos() - 1);
                                    //ahora calcular la reputacion del que hizo la respuesta (el administrador no tiene reputacion)
                                    Estudiante estu = null;
                                    Profesor profe = null;
                                    if ((estu = respuesta.getEstudiante()) != null) {
                                        estu.setReputacion(estu.getReputacion() + 1);
                                        this.persistencia.modificar(estu);
                                    } else {
                                        if ((profe = respuesta.getProfesor()) != null) {
                                            profe.setReputacion(estu.getReputacion() + 1);
                                            this.persistencia.modificar(profe);
                                        }
                                    }
                                    
                                } else {
                                    respuesta.setVotosPositivos(respuesta.getVotosPositivos() - 1);
                                    respuesta.setVotosNegativos(respuesta.getVotosNegativos() + 1);
                                    estudiante.setVotosPositivos(estudiante.getVotosPositivos() - 1);
                                    estudiante.setVotosNegativos(estudiante.getVotosNegativos() + 1);
                                    Estudiante estu = null;
                                    Profesor profe = null;
                                    if ((estu = respuesta.getEstudiante()) != null) {
                                        estu.setReputacion(estu.getReputacion() - 1);
                                        this.persistencia.modificar(estu);
                                    } else {
                                        if ((profe = respuesta.getProfesor()) != null) {
                                            profe.setReputacion(estu.getReputacion() - 1);
                                            this.persistencia.modificar(profe);
                                        }
                                    }
                                }
                                this.persistencia.modificar(respuesta);
                                this.persistencia.modificar(estudiante);
                                this.persistencia.modificar(viejo);
                            }
                            break;
                        }
                    } else {
                        if ((profesor = viejo.getProfesor()) != null) {
                            //verificamos si el usuario que hizo el voto ahora es el mismo del voto viejo 
                            if (Objects.equals(usuario.getId(), profesor.getId())) {
                                existe = true;
                                //si el voto viejo es igual al nuevo voto
                                if (viejo.isVoto().equals(voto)) {
                                    //si los dos votos son iguales no tengo que hacer nada ya que voto anteriormente
                                    break;
                                } else {
                                    //si no son iguales debo modificar al nuevo voto
                                    viejo.setVoto(voto);
                                    // al no sser igual debo calcular los votos negativo y positivo nuevamente
                                    if (voto) {
                                        //si es positivo ahora quiere decir que antes era negativo por eso hacemos lo siguiente
                                        respuesta.setVotosPositivos(respuesta.getVotosPositivos() + 1);
                                        respuesta.setVotosNegativos(respuesta.getVotosNegativos() - 1);
                                        //recalcular los votos del usuario que esta votando ahora
                                        profesor.setVotosPositivos(profesor.getVotosPositivos() + 1);
                                        profesor.setVotosNegativos(profesor.getVotosNegativos() - 1);
                                        //ahora calcular la reputacion del que hizo la respuesta (el administrador no tiene reputacion)
                                        Estudiante estu = null;
                                        Profesor profe = null;
                                        if ((estu = respuesta.getEstudiante()) != null) {
                                            estu.setReputacion(estu.getReputacion() + 1);
                                            this.persistencia.modificar(estu);
                                        } else {
                                            if ((profe = respuesta.getProfesor()) != null) {
                                                profe.setReputacion(estu.getReputacion() + 1);
                                                this.persistencia.modificar(profe);
                                            }
                                        }
                                        
                                    } else {
                                        respuesta.setVotosPositivos(respuesta.getVotosPositivos() - 1);
                                        respuesta.setVotosNegativos(respuesta.getVotosNegativos() + 1);
                                        profesor.setVotosPositivos(profesor.getVotosPositivos() - 1);
                                        profesor.setVotosNegativos(profesor.getVotosNegativos() + 1);
                                        Estudiante estu = null;
                                        Profesor profe = null;
                                        if ((estu = respuesta.getEstudiante()) != null) {
                                            estu.setReputacion(estu.getReputacion() - 1);
                                            this.persistencia.modificar(estu);
                                        } else {
                                            if ((profe = respuesta.getProfesor()) != null) {
                                                profe.setReputacion(estu.getReputacion() - 1);
                                                this.persistencia.modificar(profe);
                                            }
                                        }
                                    }
                                    this.persistencia.modificar(respuesta);
                                    this.persistencia.modificar(profesor);
                                    this.persistencia.modificar(viejo);
                                }
                                break;
                            }
                        }
                    }
                }
            }
            
            if (!existe) {
                if ((administrador = this.buscarAdministrador(usuario.getId())) != null) {
                    Voto voto1 = new Voto(voto, null, null, administrador);
                    this.persistencia.insertar(voto1);
                    administrador.agregarVoto(voto1);
                    if (voto) {
                        administrador.setVotosPositivos(administrador.getVotosPositivos() + 1);
                        respuesta.agregarVoto(voto1);
                        respuesta.setVotosPositivos(respuesta.getVotosPositivos() + 1);
                        //estudiante que realizo la respuesta
                        Estudiante estu = null;
                        Profesor profe = null;
                        if ((estu = respuesta.getEstudiante()) != null) {
                            estu.setReputacion(estu.getReputacion() + 1);
                            this.persistencia.modificar(estu);
                        } else {
                            if ((profe = respuesta.getProfesor()) != null) {
                                profe.setReputacion(profe.getReputacion() + 1);
                                this.persistencia.modificar(profe);
                            }
                        }
                    } else {
                        administrador.setVotosNegativos(administrador.getVotosNegativos() + 1);
                        respuesta.setVotosNegativos(respuesta.getVotosNegativos() + 1);
                        Estudiante estu = null;
                        Profesor profe = null;
                        if ((estu = respuesta.getEstudiante()) != null) {
                            estu.setReputacion(estu.getReputacion() - 1);
                            this.persistencia.modificar(estu);
                        } else {
                            if ((profe = respuesta.getProfesor()) != null) {
                                profe.setReputacion(profe.getReputacion() - 1);
                                this.persistencia.modificar(profe);
                            }
                        }
                    }
                    this.persistencia.modificar(respuesta);
                    this.persistencia.modificar(administrador);
                } else {
                    if ((estudiante = this.buscarEstudiante(usuario.getId())) != null) {
                        Voto voto1 = new Voto(voto, estudiante, null, null);
                        this.persistencia.insertar(voto1);
                        estudiante.agregarVoto(voto1);
                        if (voto) {
                            estudiante.setVotosPositivos(estudiante.getVotosPositivos() + 1);
                            respuesta.agregarVoto(voto1);
                            respuesta.setVotosPositivos(respuesta.getVotosPositivos() + 1);
                            //estudiante que realizo la respuesta
                            Estudiante estu = null;
                            Profesor profe = null;
                            if ((estu = respuesta.getEstudiante()) != null) {
                                estu.setReputacion(estu.getReputacion() + 1);
                                this.persistencia.modificar(estu);
                            } else {
                                if ((profe = respuesta.getProfesor()) != null) {
                                    profe.setReputacion(profe.getReputacion() + 1);
                                    this.persistencia.modificar(profe);
                                }
                            }
                        } else {
                            estudiante.setVotosNegativos(estudiante.getVotosNegativos() + 1);
                            respuesta.setVotosNegativos(respuesta.getVotosNegativos() + 1);
                            Estudiante estu = null;
                            Profesor profe = null;
                            if ((estu = respuesta.getEstudiante()) != null) {
                                estu.setReputacion(estu.getReputacion() - 1);
                                this.persistencia.modificar(estu);
                            } else {
                                if ((profe = respuesta.getProfesor()) != null) {
                                    profe.setReputacion(profe.getReputacion() - 1);
                                    this.persistencia.modificar(profe);
                                }
                            }
                        }
                        this.persistencia.modificar(respuesta);
                        this.persistencia.modificar(estudiante);
                    } else {
                        if ((profesor = this.buscarProfesor(usuario.getId())) != null) {
                            Voto voto1 = new Voto(voto, null, null, administrador);
                            this.persistencia.insertar(voto1);
                            profesor.agregarVoto(voto1);
                            if (voto) {
                                profesor.setVotosPositivos(profesor.getVotosPositivos() + 1);
                                respuesta.agregarVoto(voto1);
                                respuesta.setVotosPositivos(respuesta.getVotosPositivos() + 1);
                                //estudiante que realizo la respuesta
                                Estudiante estu = null;
                                Profesor profe = null;
                                if ((estu = respuesta.getEstudiante()) != null) {
                                    estu.setReputacion(estu.getReputacion() + 1);
                                    this.persistencia.modificar(estu);
                                } else {
                                    if ((profe = respuesta.getProfesor()) != null) {
                                        profe.setReputacion(profe.getReputacion() + 1);
                                        this.persistencia.modificar(profe);
                                    }
                                }
                            } else {
                                profesor.setVotosNegativos(profesor.getVotosNegativos() + 1);
                                respuesta.setVotosNegativos(respuesta.getVotosNegativos() + 1);
                                Estudiante estu = null;
                                Profesor profe = null;
                                if ((estu = respuesta.getEstudiante()) != null) {
                                    estu.setReputacion(estu.getReputacion() - 1);
                                    this.persistencia.modificar(estu);
                                } else {
                                    if ((profe = respuesta.getProfesor()) != null) {
                                        profe.setReputacion(profe.getReputacion() - 1);
                                        this.persistencia.modificar(profe);
                                    }
                                }
                            }
                            this.persistencia.modificar(respuesta);
                            this.persistencia.modificar(profesor);
                        }
                    }
                }
                
            }
            this.persistencia.confirmarTransaccion();
        } catch (Exception ex) {
            this.persistencia.descartarTransaccion();
            System.err.println("Transaccion descartada");
        }
        
    }
//verifica si el usuario que esta usando el sistema ya voto

    public Boolean verificarSiVoto(Usuario usuario, Respuesta respuesta) {
        Administrador administrador = this.buscarAdministrador(usuario.getId());
        Estudiante estudiante = this.buscarEstudiante(usuario.getId());
        Profesor profesor = this.buscarProfesor(usuario.getId());
        if (administrador != null) {
            for (Voto voto : respuesta.getVotos()) {
                if (voto.getAdministrador() == administrador) {
                    return true;
                }
                
            }
        } else {
            if (estudiante != null) {
                for (Voto voto : respuesta.getVotos()) {
                    if (voto.getEstudiante() == estudiante) {
                        return true;
                    }
                    
                }
            } else {
                if (profesor != null) {
                    for (Voto voto : respuesta.getVotos()) {
                        if (voto.getProfesor() == profesor) {
                            return true;
                        }
                        
                    }
                }
            }
        }
        return false;
    }
    //ver perfil solo del estudiante y el profesor

    public Estudiante verPerfilEstudiante(Usuario usuario) {
        Estudiante estudiante = this.buscarEstudiante(usuario.getId());
        if (estudiante != null) {
            return estudiante;
        }
        return null;
    }
    
    public Profesor verPerfilProfesor(Usuario usuario) {
        Profesor profesor = this.buscarProfesor(usuario.getId());
        if (profesor != null) {
            return profesor;
        }
        return null;
    }
    
    public void agregarMaterias(Materia materia, Profesor profesor) {
        try {
            this.persistencia.iniciarTransaccion();
            profesor.agregarMateria(materia);
            this.persistencia.modificar(profesor);
            this.persistencia.modificar(materia);
            this.persistencia.confirmarTransaccion();
        } catch (Exception ex) {
            this.persistencia.descartarTransaccion();
        }
    }
    
    public void quitarMaterias(Materia materia, Profesor profesor) {
        try {
            this.persistencia.iniciarTransaccion();
            profesor.quitarMateria(materia);
            this.persistencia.modificar(profesor);
            this.persistencia.modificar(materia);
            this.persistencia.confirmarTransaccion();
        } catch (Exception ex) {
            this.persistencia.descartarTransaccion();
        }
    }
    
    public Boolean modificarUsuario(Usuario usuario, String apellido, String nombre, String documento, String correo) {
        Profesor profesor = this.buscarProfesor(usuario.getId());
        Estudiante estudiante = this.buscarEstudiante(usuario.getId());
        Administrador administrador = this.buscarAdministrador(usuario.getId());
        Registrador registrador = this.buscarRegistrador(usuario.getId());
        usuario.setApellido(apellido);
        usuario.setNombre(nombre);
        usuario.setDocumento(documento);
        usuario.setCorreo(correo);
        try {
            this.persistencia.iniciarTransaccion();
            if (profesor != null) {
                
                this.persistencia.modificar(profesor);
            } else {
                if (estudiante != null) {
                    this.persistencia.modificar(estudiante);
                } else {
                    if (administrador != null) {
                        this.persistencia.modificar(administrador);
                    } else {
                        if (registrador != null) {
                            this.persistencia.modificar(registrador);
                        }
                    }
                }
            }
            this.persistencia.confirmarTransaccion();
            return true;
        } catch (Exception ex) {
            this.persistencia.descartarTransaccion();
            return false;
        }
    }
    
    public void eliminarUsuario(Usuario usuario) {
        
        Administrador administrador = this.buscarAdministrador(usuario.getId());
        Profesor profesor = this.buscarProfesor(usuario.getId());
        Estudiante estudiante = this.buscarEstudiante(usuario.getId());
        Registrador registrador = this.buscarRegistrador(usuario.getId());
        this.persistencia.iniciarTransaccion();
        if (administrador != null) {
            if (administrador.getPreguntas().isEmpty() && administrador.getRespuestas().isEmpty() && administrador.getVotos().isEmpty()) {
                this.persistencia.eliminar(administrador);
            } else {
                JOptionPane.showMessageDialog(null, "No se puede eliminar el administrador porque tiene asociado preguntas, respuestas o votos");
            }
        } else {
            if (profesor != null) {
                if (profesor.getPreguntas().isEmpty() && profesor.getRespuestas().isEmpty() && profesor.getVotos().isEmpty()) {
                    this.persistencia.eliminar(profesor);
                } else {
                    JOptionPane.showMessageDialog(null, "No se puede eliminar el profesor porque tiene asociado preguntas, respuestas o votos");
                }
            } else {
                if (estudiante != null) {
                    if (estudiante.getPreguntas().isEmpty() && estudiante.getRespuestas().isEmpty() && estudiante.getVotos().isEmpty()) {
                        this.persistencia.eliminar(estudiante);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se puede eliminar el estudiante porque tiene asociado preguntas, respuestas o votos");
                    }
                } else {
                    if (registrador != null) {
                        this.persistencia.eliminar(registrador);
                    }
                }
            }
        }
        this.persistencia.confirmarTransaccion();
    }
    
    public DefaultListModel obtenerModeloListaMateria() {
        DefaultListModel modelo = new DefaultListModel();
        for (Materia materia : this.listarMaterias()) {
            modelo.addElement(materia);
        }
        return modelo;
        
    }
}
