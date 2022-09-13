package graph;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/topological-sort/1

public class TopologicalSortBFS {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // add your code here
        // find in degree of the vertices
        int[] indegree = new int[V];
        Queue<Integer> queue = new LinkedList<>();
        for(ArrayList<Integer> edges: adj){
            for(int edge: edges){
                indegree[edge]++;
            }
        }
        // copying in queue whose indegree is 0
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        int[] result = new int[V];
        int count = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int child: adj.get(node)){
                indegree[child]--;
                if(indegree[child]==0){
                    queue.add(child);
                }
            }
            result[count++] = node;
        }
        return result;
    }
}
