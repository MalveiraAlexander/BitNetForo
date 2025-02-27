/**
 * This file was generated by the Jeddict
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 * @author Admin
 */
@Entity
public class Pregunta implements Serializable, Comparable<Pregunta> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaPublicacion;

    @Basic
    private String descripcion;

    @Basic
    private String titulo;

    @OneToMany(targetEntity = Respuesta.class)
    private List<Respuesta> respuestas;
    @ManyToOne
    private Estudiante estudiante;
    @ManyToOne
    private Profesor profesor;
    @ManyToOne
    private Administrador administrador;

    public Pregunta() {
        respuestas = new ArrayList<>();
        this.fechaPublicacion = new Date();
    }

    public Pregunta(String titulo, String desc, Estudiante estudiante, Profesor profesor, Administrador administrador) {
        this.titulo = titulo;
        this.descripcion = desc;
        respuestas = new ArrayList<>();
        if (estudiante != null) {
            this.estudiante = estudiante;
            this.profesor = null;
            this.administrador = null;
        } else {
            if (profesor != null) {
                this.estudiante = null;
                this.profesor = profesor;
                this.administrador = null;
            } else {
                this.estudiante = null;
                this.profesor = null;
                this.administrador = administrador;
            }
        }
        this.fechaPublicacion = new Date();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaPublicacion() {
        return this.fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getPregunta() {
        return this.descripcion;
    }

    public void setPregunta(String pregunta) {
        this.descripcion = pregunta;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Respuesta> getRespuestas() {
        return this.respuestas;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    @Override
    public String toString() {
        return titulo;
    }

    public void agregarRespuesta(Respuesta respuesta) {
        this.respuestas.add(respuesta);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public UsuarioAcademico obtenerPublicador() {
        if (this.estudiante != null) {
            return this.estudiante;
        } else {
            if (this.profesor != null) {
                return this.profesor;
            } else {
                if (this.administrador != null) {
                    return this.administrador;
                }
            }
        }
        return null;
    }

    @Override
    public int compareTo(Pregunta o) {
        if (this.fechaPublicacion.getTime() < o.getFechaPublicacion().getTime()) {
            return -1;
        }
        if (this.fechaPublicacion.getTime() > o.getFechaPublicacion().getTime()) {
            return 1;
        }
        return 0;
    }
}
