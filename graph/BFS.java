package graph;
import java.util.*;

//  https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1

public class BFS {

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[V];

        //for(int i=0;i<V;i++){
        //if(visited[i]==false) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        while(!queue.isEmpty()){
            int val = queue.poll();
            path.add(val);
            //System.out.println(val + "added visited: "+Arrays.toString(visited));
            for(Integer it: adj.get(val)){
                if(visited[it]==false){
                    queue.add(it);
                    visited[it] = true;
                }
            }
        }

        //}
        //}

        return path;
    }

}
