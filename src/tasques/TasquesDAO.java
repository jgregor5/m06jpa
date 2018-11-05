package tasques;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author julian
 */
public class TasquesDAO {
    
    private static EntityManagerFactory emf;
    
    private EntityManagerFactory getEMF() {
        if (TasquesDAO.emf == null) {
            TasquesDAO.emf = Persistence.createEntityManagerFactory("tasques");
        }
        return TasquesDAO.emf;
    }
    
    public static void exit() {
        if (TasquesDAO.emf != null) {
            TasquesDAO.emf.close();
        }
    }
    
    public void crearTasca(Tasca tasca) {        

        // implementa-ho!
    }
    
    public int ultimId() {
        
        // implementa-ho!
        return 0;
    }
    
    public Tasca trobarTasca(int id) {
        
        // implementa-ho!
        return null;
    }
    
    public List<Tasca> trobarPerDescripcio(String descripcio) {
        
        // implementa-ho!
        return null;
    }
    
    public List<Tasca> trobarTotesLesTasques() {
        
        EntityManager manager = getEMF().createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();

            List<Tasca> tasques = manager.createQuery("SELECT t FROM Tasca t", Tasca.class).getResultList();

            transaction.commit();
            return tasques;
            
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            
            throw ex;
            
        } finally {
            manager.close();
        }
    }
    
}
