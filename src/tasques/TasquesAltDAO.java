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
public class TasquesAltDAO {
        
    public void crearTasca(Tasca tasca) {        

        new JPATransaction<Object>() {
            @Override
            Object result(EntityManager manager) {
                manager.persist(tasca);
                return null;
            }
            
        }.result();
    }
    
    public int ultimId() {
        
        return new JPATransaction<Integer>() {
            @Override
            Integer result(EntityManager manager) {                
                TypedQuery<Integer> query = manager.createQuery("Select MAX(t.id) from Tasca t", Integer.class);
                Integer result = query.getSingleResult();                
                return result == null? 0 : result;
            }
            
        }.result();
    }
    
    public Tasca trobarTasca(int id) {
        
        return new JPATransaction<Tasca>() {
            @Override
            Tasca result(EntityManager manager) {
                return manager.find(Tasca.class, id);
            }
            
        }.result();
    }
    
    public List<Tasca> trobarPerDescripcio(String descripcio) {
        
        return new JPATransaction<List<Tasca>>() {
            @Override
            List<Tasca> result(EntityManager manager) {
                TypedQuery<Tasca> query = manager.createQuery("SELECT t FROM Tasca t WHERE t.descripcio LIKE :text", Tasca.class);
                query.setParameter("text", "%" + descripcio + "%");                
                return query.getResultList();
            }
            
        }.result();
    }
    
    public List<Tasca> trobarTotesLesTasques() {
        
        return new JPATransaction<List<Tasca>>() {
            @Override
            List<Tasca> result(EntityManager manager) {
                return manager.createQuery("SELECT t FROM Tasca t", Tasca.class).getResultList();
            }
            
        }.result();
    }
    
    // UTILS
    
    private static EntityManagerFactory emf;
    
    private EntityManagerFactory getEMF() {
        if (TasquesAltDAO.emf == null) {
            TasquesAltDAO.emf = Persistence.createEntityManagerFactory("tasques_ms");
        }
        return TasquesAltDAO.emf;
    }
    
    public static void exit() {
        if (TasquesAltDAO.emf != null) {
            TasquesAltDAO.emf.close();
        }
    }
    
    private abstract class JPATransaction<T> {
        
        abstract T result(EntityManager manager);
        
        public T result() {
            
            EntityManager manager = getEMF().createEntityManager();
            EntityTransaction transaction = null;

            try {
                transaction = manager.getTransaction();
                transaction.begin();
                
                T value = result(manager);

                transaction.commit();
                return value;

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
}
