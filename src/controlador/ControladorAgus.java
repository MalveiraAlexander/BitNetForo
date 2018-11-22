
package controlador;

import dao.Persistencia;
import java.util.List;
import modelo.UsuarioAcademico;
import modelo.UsuarioAcademico_;
import modelo.Usuario_;



public class ControladorAgus {
        Persistencia persistencia;
        public Persistencia getPersistencia(){
        return persistencia;
        }
    public ControladorAgus(Persistencia p) {
        this.persistencia = p;
    }
    
    public List listarUsuarioAcademico() {
        return this.persistencia.buscarTodos(UsuarioAcademico.class);
    }

   
}
