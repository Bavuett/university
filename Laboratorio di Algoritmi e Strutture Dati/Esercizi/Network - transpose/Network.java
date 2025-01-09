import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Network<Vertex> {
    private HashMap<Vertex, HashSet<Vertex>> adjacencyMap = new HashMap<Vertex, HashSet<Vertex>>();

    // Creiamo un nuovo Vertice che non è connesso ad altri Vertici utilizzando degli archi.
    public boolean addVertex(Vertex vertex) throws NullPointerException {
        if (vertex == null) throw new NullPointerException("No valid Vertex as argument.");
        if (this.adjacencyMap.containsKey(vertex)) return false;

        this.adjacencyMap.put(vertex, new HashSet<Vertex>());
        return true;
    }

    public boolean addEdge(Vertex vertex1, Vertex vertex2) throws NullPointerException {
        if (vertex1 == null || vertex2 == null) throw new NullPointerException("No valid Vertex as argument.");

        if (containsEdge(vertex1, vertex2)) return false;

        this.addVertex(vertex1);
        this.addVertex(vertex2);

        this.adjacencyMap.get(vertex1).add(vertex2);
        return true;
    }

    public boolean containsEdge(Vertex vertex1, Vertex vertex2) throws NullPointerException {
        if (vertex1 == null || vertex2 == null) throw new NullPointerException("No valid Vertex as argument.");

        return this.adjacencyMap.containsKey(vertex1) && this.adjacencyMap.get(vertex1).contains(vertex2);
    }

    public Network<Vertex> transpose() {
        Network<Vertex> network = new Network<Vertex>();

        for (Vertex vertex: this.adjacencyMap.keySet()) {
            Iterator<Vertex> vertex_iterator = this.adjacencyMap.get(vertex).iterator();

            while (vertex_iterator.hasNext()) {
                network.addEdge(vertex_iterator.next(), vertex);
            }
        }

        return network;
    }
}