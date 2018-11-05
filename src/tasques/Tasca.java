package tasques;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 CREATE TABLE `tasques` (
  `id` INT NOT NULL,
  `descripcio` VARCHAR(300) NOT NULL,
  `data_inici` DATETIME NULL,
  `data_final` DATETIME NOT NULL,
  `finalitzada` TINYINT NULL DEFAULT 0,
  PRIMARY KEY (`id`));
 *
 * @author julian
 */
@Entity
@Table(name = "tasques")
public class Tasca implements Serializable {
    
    @Id
    @Column(name = "id", unique = true)
    private int id;
    @Column(name = "descripcio", nullable = false)
    private String descripcio;
    @Column(name = "data_inici", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInici;
    @Column(name = "data_final", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFinal;
    @Column(name = "finalitzada", nullable = true)
    private boolean finalitzada;
    
    public Tasca() {        
    }
    
    public Tasca(int id, String descripcio, Date dataInici, Date dataFinal, 
            boolean finalitzada) {
        
        this.id = id;
        this.descripcio = descripcio;
        this.dataInici = dataInici;
        this.dataFinal = dataFinal;
        this.finalitzada = finalitzada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public Date getDataInici() {
        return dataInici;
    }

    public void setDataInici(Date dataInici) {
        this.dataInici = dataInici;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public boolean isFinalitzada() {
        return finalitzada;
    }

    public void setFinalitzada(boolean finalitzada) {
        this.finalitzada = finalitzada;
    }

    @Override
    public String toString() {
        return "Tasca{" + "id=" + id + ", descripcio=" + descripcio + 
                ", dataInici=" + dataInici + ", dataFinal=" + dataFinal + 
                ", finalitzada=" + finalitzada + '}';
    }
}
