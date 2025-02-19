import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UnweightedUndirectedNetwork {
    private HashMap<Vertex, HashSet<Vertex>> adjacencyList = new HashMap<>();
    
    public UnweightedUndirectedNetwork(Set<Vertex> set) {
        for (Vertex vertex: set) {
            this.addVertex(vertex);
        }

        for (Vertex vertex1: set) {
            for (Vertex vertex2: set) {
                if (!vertex1.equals(vertex2)) this.addEdge(vertex1, vertex2);
            }
        }


    }

    public boolean addVertex(Vertex vertex) {
        if (this.adjacencyList.containsKey(vertex)) return false;

        this.adjacencyList.put(vertex, new HashSet<>());
        return true;
    }

    public boolean addEdge(Vertex v1, Vertex v2) throws NullPointerException {
        if (v1 == null || v2 == null) throw new NullPointerException("No valid Vertex given as argument");

        this.addVertex(v1);
        this.addVertex(v2);

        this.adjacencyList.get(v1).add(v2);
        this.adjacencyList.get(v2).add(v1);

        return true;
    }

    public boolean containsEdge(Vertex v1, Vertex v2) throws NullPointerException {
        if (v1 == null || v2 == null) throw new NullPointerException("No valid Vertex given as argument");

        if (!(this.adjacencyList.containsKey(v1) && this.adjacencyList.containsKey(v2))) return false;

        return this.adjacencyList.get(v1).contains(v2);
    }
}