package cotxes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 *
 * @author julian
 */
public class ProvaCotxes {
    
    public static void main(String[] args) {
        
        try {
            prova();            
            
        } catch (IOException | RuntimeException ex) {
            ex.printStackTrace();
            
        } finally {
            CotxesDAO.exit();
        }
    }
    
    public static void prova() throws IOException {
        
        CotxesDAO dao = new CotxesDAO();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean end = false;
        
        System.out.println("write a command (? for help)");
        while (!end) {
            System.out.print("> ");
            String line = br.readLine();
            if (line == null) {
                continue;
            }
            
            String[] parts = line.split(" ");            
            if (parts.length == 0) {
                continue;
            }
            
            switch (parts[0]) {
                case "?":
                    System.out.println(
                    "mlist|mnew TXT|mfind TXT|mdel TXT|exit");
                    break;
                
                case "mlist":
                    List<Marca> marques = dao.findMarques(); 
                    for (Marca marca: marques) {
                        System.out.println(marca);
                    }
                    break;
                    
                case "mnew":
                    String newName = getStrParameter(parts, 1);
                    Marca marca = new Marca();
                    marca.setMarca(newName);                    
                    dao.createMarca(marca);
                    System.out.println(marca);
                    break;
                    
                case "mdel":
                    String delName = getStrParameter(parts, 1);
                    boolean deleted = dao.deleteMarca(delName);
                    System.out.println("deleted=" + deleted);
                    break;
                    
                case "mfind":
                    String findName = getStrParameter(parts, 1);
                    Marca foundMarca = dao.findMarca(findName);
                    System.out.println(foundMarca);
                    break;
                    
                case "exit":
                    end = true;
                    break;
                default:
                    System.out.println("what? (? for help)");
                    break;
            }
        }
    }
    
    private static String getStrParameter(String[] parts, int pos) throws IOException {
        
        if (pos >= parts.length) {
            throw new IOException("missing part " + pos);
        }
        
        return parts[pos];
    }
    
    private static int getIntParameter(String[] parts, int pos) throws IOException {
        
        if (pos >= parts.length) {
            throw new IOException("missing part " + pos);
        }
        
        try {
            return Integer.parseInt(parts[pos]);
        } catch (NumberFormatException ex) {
            throw new IOException("wrong number " + parts[pos]);
        }
    }
}
