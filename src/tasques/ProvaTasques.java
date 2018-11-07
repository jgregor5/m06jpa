package tasques;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author julian
 */
public class ProvaTasques {
    
    public static void main(String[] args) {
        
        try {
            //crearITrobar();
            trobarTots();
            //trobarDescripcio("estudiar");
            
        } finally {
            TasquesDAO.exit();
        }
    }
    
    private static void crearITrobar() {
        
        TasquesDAO tdao = new TasquesDAO();
        
        int id = crear("una prova");
        Tasca tasca = tdao.trobarTasca(id);
        System.out.println(tasca);
    }
    
    private static void trobarTots() {
        
        TasquesDAO tdao = new TasquesDAO();
        
        List<Tasca> tasques = tdao.trobarTotesLesTasques();
        for (Tasca tasca: tasques) {
            System.out.println(tasca);
        }
    }
    
    private static void trobarDescripcio(String descripcio) {
        
        TasquesDAO tdao = new TasquesDAO();
        
        List<Tasca> tasques = tdao.trobarPerDescripcio(descripcio);
        for (Tasca tasca: tasques) {
            System.out.println(tasca);
        }
    }
    
    private static int crear(String descripcio) {
        
        TasquesDAO tdao = new TasquesDAO();
        
        Date dataInici = new GregorianCalendar(2018, Calendar.SEPTEMBER, 17).getTime();
        Date dataFinal = new GregorianCalendar(2019, Calendar.MAY, 31).getTime();        
        
        int id = tdao.ultimId() + 1;        
        tdao.crearTasca(new Tasca(id, descripcio, dataInici, dataFinal, false));
        return id;
    }
}
