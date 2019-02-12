
import java.io.*;
import java.util.*;
 
class Graph
{
    private int V;   
 
    
    private LinkedList<Integer> adj[];
 
    
    Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
 
    
    void addEdge(int v, int w)
    {
        adj[v].add(w);  
        adj[w].add(v);
    }
 
    
    void DFSUtil(int v,boolean visited[],boolean control[],PrintStream writer)
    {
        
    	control[v] = true;
        visited[v] = true;
        //System.out.print(Assignment3.graphDic.get(v)+" ");
        writer.print(Main.graphDic.get(v)+" ");
       
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited,control,writer);
        }
    }
 
    
    boolean[] DFS(int v,boolean control[],PrintStream writer )
    {
       
        boolean visited[] = new boolean[V];
 
        
        DFSUtil(v, visited,control,writer);
        
        return control;
    }
}