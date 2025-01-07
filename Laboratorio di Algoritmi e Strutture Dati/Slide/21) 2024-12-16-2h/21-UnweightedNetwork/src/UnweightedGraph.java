import java.util.*;

public interface UnweightedGraph<Vertex> extends Iterable<Vertex> {
	
//Vertex-related method specifications
	
	/**
	 *  Determines is this Graph contains vertex.
	 *  @return true – if this Graph contains vertex;
	 *                          otherwise, return false.
	 */
	public boolean containsVertex (Vertex vertex);

	/**
	 *  Ensures that this Graph contains a specified vertex.
	 *  @param vertex – the specified vertex.
	 *  @return true – if vertex has been inserted in this Graph
	 *          as a result of this call; return false if vertex  
	 *          was already in this Graph before this call.  
	 */
	public boolean addVertex (Vertex vertex);

	/**
	 *  Ensures that a specified vertex is not in this Graph.
	 *  @param vertex – the specified vertex.
	 *  @return true – if vertex has been removed from this Graph
	 *      as a result of this call; return false if vertex 
	 *      was not in this Graph when this call was made.
	 */
	public boolean removeVertex (Vertex vertex);
	
//Edge-related method specifications
	
	/**
	 *  @return the number of edges in this Graph.
	 */
	public int edgeSize();
	
	/**
	 * @return true – if this Graph contains the edge 
	 *                  <v1, v2>; otherwise, return false.
	 */
	public boolean containsEdge (Vertex v1, Vertex v2);
	
	/**
	 *  Ensures that the specified edge, <v1, v2>, with the
	 *  specified weight have been added to this Graph.
	 *  @return true – if the edge and weight have been added to
	 *      this Graph as a result of this call; return 
	 *      false if this Graph already contained this 
	 *      edge and weight before this call.
	 */
	public boolean addEdge (Vertex v1, Vertex v2);
	
	/**
	 *  Ensures that the edge <v1, v2> is not in this Graph.
	 *  @return true – if the edge <v1, v2> was removed from this
	 *         Graph as a result of this call; otherwise,
	 *         return false.
	 */
	public boolean removeEdge (Vertex v1, Vertex v2);


//Graph-as-a-whole method specifications

	
	/**
	 *  @return true – if this Graph has no vertices; 
	 *  otherwise, return false.   
	 */
	public boolean isEmpty( );

	/**
	 *  @return the number of vertices in this Graph.
	 */
	public int size();
	
	/**
	 *   Returns a Set<Vertex> of the neighbors 
	 *   of a specified Vertex object.
	 *  @param v – the Vertex object whose neighbors are returned.
	 *  @return a Set<Vertex> of the neighbors of v.
	 */
	public Set<Vertex> neighbors (Vertex v);
	
	/**
	 *  @return an Iterator over the vertices in this Graph.
	 */
	public Iterator<Vertex> iterator();
	
	/**
	 *  @return a breadth-first iterator over all vertices 
	 *                reachable from v. 
	 */
	public Iterator<Vertex> breadthFirstIterator (Vertex v);
	
	/**
	 *  @return a depth-first iterator over all vertices 
	 *                reachable from v. 
	 */
	public Iterator<Vertex> depthFirstIterator (Vertex v);
	

}
