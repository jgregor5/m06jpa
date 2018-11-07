package tasques;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author julian
 */
public class TasquesDAO {
    
    public void crearTasca(Tasca tasca) {        

        EntityManager manager = getEMF().createEntityManager();
        EntityTransaction transaction = null;
    
        try {
            transaction = manager.getTransaction();
            transaction.begin();
            
            manager.persist(tasca);

            transaction.commit();
            
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            
            throw ex;
            
        } finally {
            manager.close();
        }
    }
    
    public int ultimId() {
        
        EntityManager manager = getEMF().createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();

            TypedQuery<Integer> query = manager.createQuery("Select MAX(t.id) from Tasca t", Integer.class);
            Integer result = query.getSingleResult();

            transaction.commit();
            return result == null? 0 : result;
            
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            
            throw ex;
            
        } finally {
            manager.close();
        }
    }
    
    public Tasca trobarTasca(int id) {
        
        EntityManager manager = getEMF().createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();

            Tasca tasca = manager.find(Tasca.class, id);

            transaction.commit();
            return tasca;
            
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            
            throw ex;
            
        } finally {
            manager.close();
        }
    }
    
    public List<Tasca> trobarPerDescripcio(String descripcio) {
        
        EntityManager manager = getEMF().createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();
            
            TypedQuery<Tasca> query = manager.createQuery("SELECT t FROM Tasca t WHERE t.descripcio LIKE :text", Tasca.class);
            query.setParameter("text", "%" + descripcio + "%");

            List<Tasca> tasques = query.getResultList();

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
    
    // UTILS
    
    private static EntityManagerFactory emf;
    
    private EntityManagerFactory getEMF() {
        if (TasquesDAO.emf == null) {
            TasquesDAO.emf = Persistence.createEntityManagerFactory("tasques_ms");
        }
        return TasquesDAO.emf;
    }
    
    public static void exit() {
        if (TasquesDAO.emf != null) {
            TasquesDAO.emf.close();
        }
    }

}
