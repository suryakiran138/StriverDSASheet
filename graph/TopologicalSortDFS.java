package graph;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/topological-sort/1

public class TopologicalSortDFS {
    static void dfs(int node,Stack<Integer> stack,boolean[] vis,ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        for(int child: adj.get(node)){
            if(!vis[child]){
                dfs(child,stack,vis,adj);
            }
        }
        stack.push(node);
    }

    //Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // add your code here
        boolean[] vis = new boolean[V];
        int[] result = new int[V];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<vis.length;i++){
            if(!vis[i]){
                dfs(i,stack,vis,adj);
            }
        }
        for(int i=0;i<V;i++){
            result[i] = stack.pop();
        }
        return result;
    }
}
