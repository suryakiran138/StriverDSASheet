package graph;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1

public class DFS {
    public void dfsHelper(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> path){

        visited[node] = true;
        path.add(node);
        for(int i: adj.get(node)){
            if(visited[i] == false)
                dfsHelper(i,adj,visited,path);
        }

    }


    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];
        ArrayList<Integer> path = new ArrayList<>();
        dfsHelper(0,adj,visited,path);
        return path;
    }
}
