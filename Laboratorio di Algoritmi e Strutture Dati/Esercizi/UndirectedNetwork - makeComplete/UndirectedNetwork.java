import java.util.*;
import java.util.HashMap;

public class UndirectedNetwork {
    private HashMap<Vertex, HashMap<Vertex, Integer>> adjacencyMap = new HashMap<>();

    // Creiamo una nuova entry della HashMap che non ne conterrà un'altra a sua volta.
    // Il fatto che non ne contenga un'altra e ciò che caraterriza il suo stato di Vertice.
    public void addVertex(Vertex vertex) {
        this.adjacencyMap.put(vertex, new HashMap<>());
    }

    // Per creare un Arco utilizzeremo un metodo ad-hoc, considerato che la classe in oggetto è Undirected.
    // Difatti, creiamo due vertici come nel metodo classico. Sfrutteremo poi il fatto che la HashMap consente
    // ha due Vertici, come nella dichiarazione fatta sopra, per connetterli a vicenda. 
    public void addEdge(Vertex vertex1, Vertex vertex2, int weight) {
        this.adjacencyMap.putIfAbsent(vertex1, new HashMap<>());
        this.adjacencyMap.putIfAbsent(vertex2, new HashMap<>());
        this.adjacencyMap.get(vertex1).put(vertex2, weight);
        this.adjacencyMap.get(vertex2).put(vertex1, weight);
    }

    public void makeComplete(Vertex vertex1, Vertex vertex2) {
        List<Vertex> vertices = new ArrayList<>();

        for (Vertex vertex: this.adjacencyMap.keySet()) {
            vertices.add(vertex);
        }

        for (int i = 0; i < vertices.size(); i++) {
            // Creiamo due porzioni di Lista: una scorsa, l'altra no. Invece di ripetere i confronti, quindi,
            // faremo in modo di scorrere solo ed esclusivamente la metà superiore della Lista.
            for (int j = i + 1; j < vertices.size(); j++) {
                // Prendiamo i due vertici su cui effettuare il confronto.
                Vertex v1 = vertices.get(i);
                Vertex v2 = vertices.get(j);

                // Controlliamo che i due Vertici non abbiano già un arco che li connette tra di loro. Nello
                // specifico, controlliamo se tra tutti i grafi esiste il Vertice v1. Se esiste, andiamo avanti
                // e controlliamo se esiste una connessione con il secondo vertice.
                // Entrati nel ramo positivo della Struttura Condizionale, aggiungiamo l'arco. In caso contrario
                // non si procede e si va avanti alla prossima iterazione.
                if (!(adjacencyMap.containsKey(v1) && adjacencyMap.get(v1).containsKey(v2))) addEdge(v1, v2, 0);
            }
        }
    }
}