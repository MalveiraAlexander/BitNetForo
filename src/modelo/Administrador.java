/**
 * This file was generated by the Jeddict
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Admin
 */
@Entity
public class Administrador extends UsuarioAcademico implements Serializable {

    public Administrador() {
        super();
    }

    public Administrador(String apellido, String nombre, String dni, String correo, String password) {
        super(apellido, nombre, dni, correo, password);
    }

    @Override
    public String toString() {
        return this.getApellido()+' '+ this.getNombre()+" (Administrador)";
    }

}
