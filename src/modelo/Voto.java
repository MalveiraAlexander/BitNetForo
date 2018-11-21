/**
 * This file was generated by the Jeddict
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Admin
 */
@Entity
@Table(name = "votos")
public class Voto implements Serializable {

    @Id
     @SequenceGenerator(name = "sec_votos", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_votos")
   
    private Long id;

    
    private Boolean voto;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean isVoto() {
        return this.voto;
    }

    public void setVoto(Boolean voto) {
        this.voto = voto;
    }

}