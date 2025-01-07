/**
 * Unweighted Network: grafo diretto non pesato (vertici non ordinati)
 * HOMEWORK
 * La variante che fa uso di TreeMap consente di mantenere i vertici ordinati
 * La variante che fa uso di TreeSet consente di manteneri gli archi odinati 
 * L'uso di TreeMap e TreeSet consente di mantenere l'ordinamento sia tra i
 * vertici che tra gli archi 
 * */

import java.util.*;


  public class UnweightedNetwork<Vertex> implements UnweightedGraph<Vertex> {    
	
	protected HashMap<Vertex, HashSet<Vertex>> adjacencyMap;  
  
    /**
     *  Initializes this UnweightedNetwork object to be empty.
     */
    public UnweightedNetwork()
    {        
        adjacencyMap = new HashMap<Vertex, HashSet<Vertex>>();    
    } // default constructor

       
    /**
     *  Initializes this UnweightedNetwork object to a shallow copy of a specified 
     *  UnweightedNetwork object.    
     *
     *  @param network - the UnweightedNetwork object that this UnweightedNetwork object is
     *                   initialized to a shallow copy of.
     * 
     *  @throws NullPointerException if network is null.
     *
     */
    public UnweightedNetwork (UnweightedNetwork<Vertex> network)
    {
        adjacencyMap = new HashMap<Vertex, HashSet<Vertex>>(network.adjacencyMap);
    } // copy constructor

    /**
     *  Determines if this UnweightedNetwork object is equal to a given object. 
     * 
     *  @param obj - the object this UnweightedNetwork object is compared to.
     *
     *  @return true - if this UnweightedNetwork object is equal to obj.
     *
     */
    public boolean equals (Object obj)
    {
        if ((obj == null) || !(obj instanceof UnweightedNetwork<?>))
            return false;
        UnweightedNetwork<?> other = (UnweightedNetwork<?>)obj;
        return adjacencyMap.equals (other.adjacencyMap);
    } // method equals
                
    /**
     *  Determines if this UnweightedNetwork object contains no vertices.
     *
     *  @return true - if this UnweightedNetwork object contains no vertices.
     *
     */
    public boolean isEmpty()
    {
        return adjacencyMap.isEmpty();
    } // method isEmpty

 
    /**
     *  Determines the number of vertices in this UnweightedNetwork object.
     *
     *  @return the number of vertices in this UnweightedNetwork object.
     *
     */
    public int size()
    {
        return adjacencyMap.size();
    } // method size


    /**
     *  Returns the number of edges in this UnweightedNetwork object.
     *  The worstTime(V, E) is O(V).
     *
     *  @return the number of edges in this UnweightedNetwork object.
     *
     */
    public int edgeSize()
    {
        int count = 0;
        // Computes the sum of the size of all Neighbor Sets (each vertex is associated with one edge)       
       
        for (HashSet<Vertex> neighborsSet: adjacencyMap.values()) count += neighborsSet.size();
        
        //for (Vertex v: adjacencyMap.keySet()) count += adjacencyMap.get(v).size();
        //for (Map.Entry<Vertex, HashSet<Vertex>> entry : adjacencyMap.entrySet())
        //    count += entry.getValue().size();
        
        return count;        
        
    } // method edgeSize


    /**
     *  Determines if this UnweightedNetwork object contains a specified Vertex object.
     *
     *  @param vertex - the Vertex object whose presence is sought.
     *
     *  @return true - if vertex is an element of this UnweightedNetwork object.
     * 
     *  @throws NullPointerException if vertex is null.
     */
    public boolean containsVertex (Vertex vertex)
    {
        return adjacencyMap.containsKey (vertex);
    } // method containsVertex


    /**
     *  Determines if this UnweightedNetwork object contains an edge specified by two vertices.
     *
     *  @param v1 - the beginning Vertex object of the edge sought.
     *  @param v2 - the ending Vertex object of the edge sought.
     *
     *  @return true - if this UnweightedNetwork object contains the edge <v1, v2>.
     *
     *  @throws NullPointerException if v1 and/or v2 is null.
     * 
     */
    public boolean containsEdge (Vertex v1, Vertex v2)
    {
        if (v1 == null || v2 == null)
            throw new NullPointerException();
        if (! (adjacencyMap.containsKey (v1) && adjacencyMap.containsKey (v2)))
            return false; 
        HashSet<Vertex> neighborsSet = adjacencyMap.get (v1);
        return neighborsSet.contains(v2);    
    } // method containsEdge
       

    /**
     *  Ensures that a specified Vertex object is an element of this UnweightedNetwork object.
     *
     *  @param vertex - the Vertex object whose presence is ensured.
     *
     *  @return true - if vertex was added to this UnweightedNetwork object by this call; returns
     *               false if vertex was already an element of this UnweightedNetwork object when
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
        adjacencyMap.put (vertex, new HashSet<Vertex>());
        return true;
    } // method addVertex



    /**
     *  Ensures that an edge is in this UnweightedNetwork object.
     *
     *  @param v1 - the beginning Vertex object of the edge whose presence is ensured.
     *                    
     *  @param v2 - the ending Vertex object of the edge whose presence is ensured.
     *
     *  @return true - if the given edge were added to this UnweightedNetwork object
     *                 by this call; return false, if the given edge were
     *                 already in this UnweightedNetwork object when this call was made.
     *
     *  @throws NullPointerException if v1 and/or v2 is null.
     * 
     */
    public boolean addEdge (Vertex v1, Vertex v2)
    {
        addVertex (v1);
        addVertex (v2);      
        if (containsEdge (v1, v2)) return false;
        HashSet<Vertex> neighborsSet = adjacencyMap.get (v1);       
        neighborsSet.add(v2);
        return true;
    } // method addEdge


    /**
     *  Ensures that a specified Vertex object is not an element of this UnweightedNetwork object.
     *
     *  @param vertex - the Vertex object whose absence is ensured.
     *
     *  @return true - if vertex was removed from this UnweightedNetwork object by this call;
     *                returns false if vertex was not an element of this UnweightedNetwork object
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
        for (Map.Entry<Vertex, HashSet<Vertex>> entry: adjacencyMap.entrySet()) 
        {
            HashSet<Vertex> neighborsSet = entry.getValue();
            neighborsSet.remove (vertex);            
        } 
        */
        for(HashSet<Vertex> neighborsSet: adjacencyMap.values()) neighborsSet.remove (vertex);
        
        adjacencyMap.remove (vertex);
        return true;
    } // removeVertex

    /**
     *  Ensures that an edge specified by two vertices is absent from this
     *  UnweightedNetwork object.
     *
     *  @param v1 -   the beginning Vertex object of the edge whose absence is ensured.
     *  @param v2 - the ending Vertex object of the edge whose absence is ensured.
     *
     *  @return true - if the edge <v1, v2> was removed from this UnweightedNetwork object
     *                          by this call; return false if the edge <v1, v2> was not in this
     *                          UnweightedNetwork object when this call was made.
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

       HashSet<Vertex> neighborsSet = adjacencyMap.get (v1);
       return neighborsSet.remove(v2);
    } // method removeEdge


    /**
     *  Returns a Set<Vertex> object of the neighbors of a specified Vertex object.
     *
     *  @param v - the Vertex object whose neighbors are returned.
     *
     *  @return a Set<Vertex> object of the vertices that are neighbors of v.
     * 
     *  @throws NullPointerException - if v is null.
     * 
     */
    public HashSet<Vertex> neighbors (Vertex v)
    {        
        return adjacencyMap.get (v);
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
            return itr.next();
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
     *
     *  @param v - the start Vertex object for the Iterator object returned.
     *
     *  @return a  breadth-first Iterator object over all vertices reachable from v.
     *
     *  @throws IllegalArgumentException - if v is not an element of this UnweightedNetwork object.
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
     *
     *  @param v - the start Vertex object for the Iterator object returned.
     *
     *  @return a depth-first Iterator object over all vertices reachable from v.
     *
     *  @throws IllegalArgumentException - if v is not an element of this UnweightedNetwork object.
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
            current = queue.remove();

            HashSet<Vertex> neighborsSet = adjacencyMap.get (current);            

            for (Vertex to: neighborsSet)
            {
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
            HashSet<Vertex> neighborsSet = adjacencyMap.get (current);

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
	   

/***** Exercise  *****/ 

    /**
     *  Determines if this UnweightedNetwork object is (strongly) connected.
     *
     *  @return true - if this UnweightedNetwork object is connected.
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
    
    


 
    
} // class UnweightedNetwork
