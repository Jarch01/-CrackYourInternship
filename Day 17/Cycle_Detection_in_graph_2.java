class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[] = new boolean[V];
        for(int i=0; i<V; i++)
        {
            if(visited[i]==false)
            {
                boolean ans = findCycle(i,-1,adj,visited,new HashSet<Integer>());
                if(ans==true)
                return true;
            }
        }
        return false;
    }
    private boolean findCycle(int cv,int parent, ArrayList<ArrayList<Integer>> adj,boolean[] visited,HashSet<Integer> memo)
    {
        if(visited[cv])
        {
            if(memo.contains(cv))
            return true;
            return false;
        }
        memo.add(cv); //Adding current vertex to the  set
        visited[cv]=true; //Vertex is not visited so we set true
        
        for(int neigh : adj.get(cv))  //Accessing the neighbours of the vertex
        {
            
            if(neigh == parent) //When we get back to the parent as neighbour
            continue;
            
            boolean ans = findCycle(neigh,cv,adj,visited,memo);  //visting the neighnour for cycle
            if(ans==true)
            return true;
        }
        memo.remove(cv); //Back tracking
        return false; //After processing all neighbours no cycle is detected
    }
}
