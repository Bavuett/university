/**
 
 * Network: Digrafo pesato sugli archi con valori numerici
 * 
 * */

import java.util.*;

/*
  public class Network<Vertex> implements Graph<Vertex, Double> {    
	
	protected HashMap<Vertex, HashMap<Vertex, Double>> adjacencyMap;  
	...
	}
 */

/*
public class Network<Vertex extends Comparable<? super Vertex>> implements Graph<Vertex, Double> {    
	
	protected TreeMap<Vertex, HashMap<Vertex, Double>> adjacencyMap;  
	...
	}
*/

/*
public class Network<Vertex extends Comparable<? super Vertex>> implements Graph<Vertex, Double> {    
	
	protected HashMap<Vertex, TreeMap<Vertex, Double>> adjacencyMap;  
	...
	}
*/

public class Network<Vertex extends Comparable<? super Vertex>> implements Graph<Vertex, Double>
{    
	protected TreeMap<Vertex, TreeMap<Vertex, Double>> adjacencyMap;   
   
    /**
     *  Initializes this Network object to be empty, with the ordering of
     *  vertices by an implementation of the Comparable interface.
     */
    public Network()
    {        
        adjacencyMap = new TreeMap<Vertex, TreeMap<Vertex, Double>>();        
    } // default constructor

       
    /**
     *  Initializes this Network object to a shallow copy of a specified Network
     *  object.    
     *
     *  @param network - the Network object that this Network object is
     *                   initialized to a shallow copy of.
     * 
     *  @throws NullPointerException if network is null.
     *
     */
    public Network (Network<Vertex> network)
    {
        adjacencyMap = new TreeMap<Vertex, TreeMap<Vertex, Double>>(network.adjacencyMap);
    } // copy constructor

    /**
     *  Determines if this Network object is equal to a given object. 
     * 
     *  @param obj - the object this Network object is compared to.
     *
     *  @return true - if this Network object is equal to obj.
     *
     */
    public boolean equals (Object obj)
    {
        if ((obj == null) || !(obj instanceof Network<?>))
            return false;
        Network<?> other = (Network<?>)obj;
        return adjacencyMap.equals (other.adjacencyMap);
    } // method equals
                
    /**
     *  Determines if this Network object contains no vertices.
     *
     *  @return true - if this Network object contains no vertices.
     *
     */
    public boolean isEmpty()
    {
        return adjacencyMap.isEmpty();
    } // method isEmpty

 
    /**
     *  Determines the number of vertices in this Network object.
     *
     *  @return the number of vertices in this Network object.
     *
     */
    public int size()
    {
        return adjacencyMap.size();
    } // method size


    /**
     *  Returns the number of edges in this Network object.
     *  The worstTime(V, E) is O(V).
     *
     *  @return the number of edges in this Network object.
     *
     */
    public int edgeSize()
    {
        int count = 0;
        // computes the sum of the size of all Neighbor Maps (each pair is associated with one edge)       
        
        for (TreeMap<Vertex, Double> neighborsMap: adjacencyMap.values()) 
        	count += neighborsMap.size();

        //for (Vertex v: adjacencyMap.keySet()) count += adjacencyMap.get(v).size();
        
        //for (Map.Entry<Vertex, TreeMap<Vertex, Double>> entry : adjacencyMap.entrySet())
        //    count += entry.getValue().size();
                
        return count;        
        
    } // method getEdgeCount


    /**
     *  Determines the weight of an edge in this Network object.
     *  The worstTime (V, E) is O(log V).
     *
     *  @param v1 - the beginning Vertex object of the edge whose weight is sought.
     *  @param v2 - the ending Vertex object of the edge whose weight is sought.
     *
     *  @return the weight of edge <v1, v2>, if <v1, v2> forms an edge; return null if
     *                <v1, v2> does not form an edge in this Network object.
     *
     *  @throws NullPointerException if v1 and/or v2 is null.
     */
    public Double getEdgeWeight (Vertex v1, Vertex v2)
    {
        if (v1 == null || v2 == null)
            throw new NullPointerException();
        if (! (adjacencyMap.containsKey (v1) && adjacencyMap.containsKey (v2)))
            return null; 
        // the value associated with vertex v1 in adjacencyMap is a treeMap (neighborsMap)
        TreeMap<Vertex, Double> neighborsMap = adjacencyMap.get (v1);
        // the value associated with vertex v2 in neighborsMap is the weight of edge <v1, v2> 
        return neighborsMap.get (v2);  // if there is no edge <v1, v2> weight will be null
    } // method getEdgeWeight


    /**
     *  Determines if this Network object contains a specified Vertex object.
     *  The worstTime(V, E) is O(log V).
     *
     *  @param vertex - the Vertex object whose presence is sought.
     *
     *  @return true - if vertex is an element of this Network object.
     * 
     *  @throws NullPointerException if vertex is null.
     */
    public boolean containsVertex (Vertex vertex)
    {
        return adjacencyMap.containsKey (vertex);
    } // method containsVertex


    /**
     *  Determines if this Network object contains an edge specified by two vertices.
     *  The worstTime (V, E) is O(log V).
     *
     *  @param v1 - the beginning Vertex object of the edge sought.
     *  @param v2 - the ending Vertex object of the edge sought.
     *
     *  @return true - if this Network object contains the edge <v1, v2>.
     *
     *  @throws NullPointerException if v1 and/or v2 is null.
     * 
     */
    public boolean containsEdge (Vertex v1, Vertex v2)
    {
        return getEdgeWeight (v1, v2) != null;
    } // method containsEdge


    /**
     *  Ensures that a specified Vertex object is an element of this Network object.
     *  The worstTime(V, E) is O(log V).
     *
     *  @param vertex - the Vertex object whose presence is ensured.
     *
     *  @return true - if vertex was added to this Network object by this call; returns
     *               false if vertex was already an element of this Network object when
     *               this call was made.
     * 
     *  @throws NullPointerException if vertex is null.
     * 
     */
    public boolean addVertex (Vertex vertex)
    {     
        if (vertex == null)
            throw new NullPointerException();
        if (adjacencyMap.containsKey (vertex))
            return false;
        adjacencyMap.put (vertex, new TreeMap<Vertex, Double>());
        return true;
    } // method addVertex



    /**
     *  Ensures that an edge is in this Network object.
     *  The worstTime(V, E) is O(log V).
     *
     *  @param v1 - the beginning Vertex object of the edge whose presence
     *                         is ensured.
     *  @param v2 - the ending Vertex object of the edge whose presence is
     *                        ensured.
     *  @param weight - the weight of the edge whose presence is ensured.
     *
     *  @return true - if the given edge (and weight) were added to this Network
     *                         object by this call; return false, if the given edge (and weight)
     *                         were already in this Network object when this call was made.
     *
     *  @throws NullPointerException if v1 and/or v2 is null.
     * 
     */
    public boolean addEdge (Vertex v1, Vertex v2, Double weight)
    {
        addVertex (v1);
        addVertex (v2);      
        if (containsEdge (v1, v2))
            return false;
        TreeMap<Vertex, Double> neighborsMap = adjacencyMap.get (v1);       
        neighborsMap.put (v2, weight);
        return true;
    } // method addEdge


    /**
     *  Ensures that a specified Vertex object is not an element of this Network object.
     *  The worstTime (V, E) is O (V log V).
     *
     *  @param vertex - the Vertex object whose absence is ensured.
     *
     *  @return true - if vertex was removed from this Network object by this call;
     *                returns false if vertex was not an element of this Network object
     *                when this call was made.
     * 
     *  @throws NullPointerException if vertex is null.
     * 
     */
    public boolean removeVertex (Vertex vertex)
    {
        if (!adjacencyMap.containsKey (vertex))
            return false;
        // remove all edges going to vertex
        /*
        for (Map.Entry<Vertex, TreeMap<Vertex, Double>> entry: adjacencyMap.entrySet()) 
        {
            TreeMap<Vertex, Double> neighborsMap = entry.getValue();
            neighborsMap.remove (vertex);            
        }
        */
        for(TreeMap<Vertex, Double> neighborsMap: adjacencyMap.values())
        	neighborsMap.remove (vertex);
        
        adjacencyMap.remove (vertex);
        return true;
    } // removeVertex

    /**
     *  Ensures that an edge specified by two vertices is absent from this Network
     *  object.
     *  The worstTime (V, E) is O (log V).
     *
     *  @param v1 -   the beginning Vertex object of the edge whose absence is
     *                          ensured.
     *  @param v2 - the ending Vertex object of the edge whose absence is
     *                        ensured.
     *
     *  @return true - if the edge <v1, v2> was removed from this Network object
     *                          by this call; return false if the edge <v1, v2> was not in this
     *                          Network object when this call was made.
     * 
     *  @throws NullPointerException if v1 and/or v2 is null.
     *
     */
    public boolean removeEdge (Vertex v1, Vertex v2)
    {
        if (v1 == null || v2 == null)
            throw new NullPointerException();
        if (!adjacencyMap.containsKey (v1) || !adjacencyMap.containsKey (v2))
            return false;

       TreeMap<Vertex, Double> neighborsMap = adjacencyMap.get (v1);
       if (!neighborsMap.containsKey (v2))  
           return false;
       neighborsMap.remove (v2);
       return true;
    } // method removeEdge


    /**
     *  Returns a LinkedList<Vertex> object of the neighbors of a specified Vertex object.
     *  The worstTime(V, E) is O(V).
     *
     *  @param v - the Vertex object whose neighbors are returned.
     *
     *  @return a LinkedList<Vertex> object of the vertices that are neighbors of v.
     * 
     *  @throws NullPointerException - if v is null.
     * 
     */
    public TreeSet<Vertex> neighbors (Vertex v)
    {        
        TreeMap<Vertex, Double> neighborsMap = adjacencyMap.get (v);
    	return new TreeSet<Vertex> (neighborsMap.keySet());   
    } // method neighbors

    /**
     *  Re-initializes this Network object to be empty.
     */
    public void clear()
    {
        adjacencyMap.clear();
    } // method clear


    /**
     *  Returns an Iterator object over the vertices in this Network object.
     *
     *  @return an Iterator object over the vertices in this Network object.
     *
     */
    public Iterator<Vertex> iterator()
    {
        return new NetworkIterator();
    } // method iterator



    protected class NetworkIterator implements Iterator<Vertex>
    {
        protected Iterator<Vertex> itr;
        protected Vertex current;

        /**
         * Initializes this NetworkIterator object to iterate over the
         * vertices in this Network object.
         *
         */
        public NetworkIterator()
        {
            itr = adjacencyMap.keySet().iterator();
        } // default constructor


        /**
         * Returns true if this NetworkIterator object has not yet finished
         * iterating over the vertices in this Network object.  Otherwise, 
         * returns false.
         *
         */
        public boolean hasNext()
        {
            return itr.hasNext();
        } // method hasNext


        /**
         * Returns the next vertex in this NetworkIterator object.
         *
         */    
        public Vertex next()
        {
            current = itr.next();
            return current;
        } // method next


        /**
         * Removes the most recently returned vertex from this
         * NetworkIterator object.
         *
         */
        public void remove()
        {         
         	throw new UnsupportedOperationException(); 
        } // method remove

    } // class NetworkIterator
    

    
    /**
     *  Returns a breadth-first Iterator object over all vertices reachable from
     *  a specified Vertex object.
     *  The worstTime(V, E) is O(V log V).
     *
     *  @param v - the start Vertex object for the Iterator object returned.
     *
     *  @return a  breadth-first Iterator object over all vertices reachable from v.
     *
     *  @throws IllegalArgumentException - if v is not an element of this Network
     *                 object.
     *
     *  @throws NullPointerException if v is null.
     * 
     */
    public Iterator<Vertex> breadthFirstIterator (Vertex v)
    {
        if (!adjacencyMap.containsKey (v))
            throw new IllegalArgumentException();
        return new BreadthFirstIterator(v);
    } // method breadthFirstIterator


    /**
     *  Returns a depth-first Iterator object over all vertices reachable from
     *  a specified Vertex object.
     *  The worstTime(V, E) is O(V log V).
     *
     *  @param v - the start Vertex object for the Iterator object returned.
     *
     *  @return a depth-first Iterator object over all vertices reachable from v.
     *
     *  @throws IllegalArgumentException - if v is not an element of this Network
     *                 object.
     *
     *  @throws NullPointerException if v is null.
     * 
     */
    public Iterator<Vertex> depthFirstIterator (Vertex v)
    {
        if (!adjacencyMap.containsKey (v))
            throw new IllegalArgumentException();
        return new DepthFirstIterator(v);
    } // method depthFirstIterator

      

    protected class BreadthFirstIterator implements Iterator<Vertex>
    {
        protected Queue<Vertex> queue;

        protected HashMap<Vertex, Boolean> reached;

        protected Vertex current;

        /**
         * Initializes this BreadthFirstIterator at start.
         *
         */
        public BreadthFirstIterator (Vertex start)
        {
            queue = new LinkedList<Vertex>();

            reached = new HashMap<Vertex, Boolean>();

            for (Vertex v: adjacencyMap.keySet())                            
                reached.put (v, false);

            queue.add (start);
            reached.put (start, true);
        } // one-parameter constructor


        /**
         * Returns true if this BreadthFirstIterator has not reached all of its 
         * reachable vertices.  Otherwise, returns false.
         *
         */
        public boolean hasNext()
        {
            return !(queue.isEmpty());
        } // method hasNext


        /**
         * Returns the next reachable vertex in this BreadthFirstIterator object.
         *
         */    
        public Vertex next()
        {            
            Vertex to;

            current = queue.remove();

            TreeMap<Vertex, Double> neighborsMap = adjacencyMap.get (current);            

            for (Map.Entry<Vertex, Double> entry: neighborsMap.entrySet())
            {
                to = entry.getKey();
                if (!reached.get (to))
                {
                   reached.put (to, true);
                   queue.add (to);
                } // if
            } // for
            return current;
        } // method next


        /**
         * Removes the most recently returned vertex.
         *
         */
        public void remove()
        {
        	  throw new UnsupportedOperationException();
        } // method remove

    } // class BreadthFirstIterator


    protected class DepthFirstIterator implements Iterator<Vertex>
    {
        Stack<Vertex> stack;

        HashMap<Vertex, Boolean> reached;

        Vertex current;


        /**
         * Initializes this DepthFirstIterator at start.
         *
         */
        public DepthFirstIterator (Vertex start)
        {
            stack = new Stack<Vertex>();

             reached = new HashMap<Vertex, Boolean>();

            for (Vertex v: adjacencyMap.keySet())                            
                reached.put (v, false);

            stack.add (start);
            reached.put (start, true);
        } // one-parameter constructor


        /**
         * Returns true if this DepththFirstIterator has not reached all of its 
         * reachable vertices.  Otherwise, returns false.
         *
         */
        public boolean hasNext()
        {
            return !(stack.isEmpty());
        } // method hasNext


        /**
         * Returns the next reachable vertex in this DepththFirstIterator object.
         *
         */    
        public Vertex next()
        {                      
            current = stack.pop();
             
            Set<Vertex> neighborsSet = (adjacencyMap.get (current)).keySet();
          
            for (Vertex to: neighborsSet)
            {
                if (!reached.get (to))
                {
                	reached.put (to, true);
                	stack.add (to);
                } else {
                	if (stack.remove(to)) stack.add (to);
                }
            } // for      
            return current;
        } // method next


        /**
         * Removes the most recently returned vertex.
         *
         */
        public void remove()
        {
            throw new UnsupportedOperationException();
        } // method remove

    } // class DepthFirstIterator
    
    
    /**
     *  Returns a Map-String representation of this Network object.
     *  The worstTime(V, E) is O(V * V).
     *
     *  @return a Map-String representation of this Network object.
     *
     */
    public String toString()
    {
        return adjacencyMap.toString();
    } // method toString   

    
    /******************* ESERCITAZIONE II PARZIALE *****************/
    
    /**
     *  Add to the NetworkVertex> class a new method that determines if this (directed
     *  Network object is (strongly) connected. The worstTime(V, E) is O(V * V * log V).
     *
     *  @return true - if this (directed) Network object is connected.
     *
     */
    public boolean isConnected()
    {
    	for (Vertex v : adjacencyMap.keySet())
        {
            // Count the vertices reachable from v.
            Iterator<Vertex> itr = new BreadthFirstIterator (v);
            int count = 0;
            while (itr.hasNext())
            {
                itr.next();
                count++;
            } // while
            if (count < adjacencyMap.size())
                return false;
        } // for
        return true;
    } // method isConnected
          
        
        
    
} // class Network
