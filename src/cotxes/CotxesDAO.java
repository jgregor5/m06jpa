package cotxes;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

/**
 *
 * @author julian
 */
public class CotxesDAO {
    
    public void createMarca(Marca marca) {
        
        throw new RuntimeException("no implementat!");
    }
    
    public Marca findMarca(String nom) {

        throw new RuntimeException("no implementat!");
    }
    
    public boolean deleteMarca(String nom) {
        
        throw new RuntimeException("no implementat!");
    }
    
    public List<Marca> findMarques() {
        
        throw new RuntimeException("no implementat!");
    }
    
    // COTXES
    
    public List<Cotxe> findCotxesMarca(String nom) {
        
        throw new RuntimeException("no implementat!");
    }
    
    public Cotxe findCotxe(String marcaStr, String modelStr) {
        
        throw new RuntimeException("no implementat!");
    }
    
    public Cotxe createCotxe(String marcaStr, String modelStr) {
        
        throw new RuntimeException("no implementat!");
    }
    
    public boolean deleteCotxe(String marcaStr, String modelStr) {
        
        throw new RuntimeException("no implementat!");
    }
    
    // VARIANTS
    
    public List<Variant> findVariantsCotxe(String marca, String model) {
        
        throw new RuntimeException("no implementat!");
    }
    
    public Variant createVariant(String marcaStr, String modelStr, String variantStr) {
        
        throw new RuntimeException("no implementat!");
    }
    
    // UTILS
    
    public static void exit() {
        
        throw new RuntimeException("no implementat!");
    }
}
