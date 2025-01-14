import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;


public class Allocations {
    private HashMap<String, HashSet<String>> adjacencyMap = new HashMap<>();

    public boolean assign(String mechanographic_code, String fiscal_code) {
        for (String key: this.adjacencyMap.keySet()) {
            if (this.adjacencyMap.get(key).contains(fiscal_code)) return false;
        }

        if (!(this.adjacencyMap.containsKey(mechanographic_code))) this.adjacencyMap.put(mechanographic_code, new HashSet<String>());
        
        this.adjacencyMap.get(mechanographic_code).add(fiscal_code);
        return true;
    }

    public String lookUp(String fiscal_code) {
        for (String key : this.adjacencyMap.keySet()) {
            if (this.adjacencyMap.get(key).contains(fiscal_code)) return key;
        }

        return null;
    }

    // Prima di revocare un'assegnazione, sfruttiamo la funzione lookUp per cercare la scuola
    // in cui il Codice Fiscale di nostro interesse è stato assegnato. Facciamo tutto in una riga
    // per comodità e (, a seconda dei punti di vista, semi-)leggibilitò.
    public String resign(String fiscal_code) {
        String mechanographic_code;

        if((mechanographic_code = lookUp(fiscal_code)) == null) return null;

        this.adjacencyMap.get(mechanographic_code).remove(fiscal_code);
        return mechanographic_code;
    }

    // Chiamiamo la funzione ponendo nella sua firma il tipo TreeSet, che si occupà di ordinare
    // gli elementi ad ogni aggiunta di uno di questi al suo interno.
    public TreeSet<String> assignmentsList() {
        TreeSet<String> assignments = new TreeSet<String>();

        for (String key: this.adjacencyMap.keySet()) {
            Iterator<String> iterator = this.adjacencyMap.get(key).iterator();

            while(iterator.hasNext()) {
                assignments.add(iterator.next());
            }
        }

        return assignments;
    }
}
