package cotxes;

/*
CREATE TABLE `cotxes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `model` varchar(30) NOT NULL,
  `marca_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `model_idx` (`model`,`marca_id`),
  KEY `marca_fk_idx` (`marca_id`),
  CONSTRAINT `marca_fk` FOREIGN KEY (`marca_id`) REFERENCES `marques` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
);
*/

/**
 *
 * @author julian
 */
public class Cotxe {
    
    private int id;
    private String model;
    private Marca marca;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Cotxe{" + "id=" + id + ", model=" + model + ", marca=" + marca + '}';
    }

}
