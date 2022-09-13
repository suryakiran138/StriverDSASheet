package graph;
import java.util.*;

public class DFSDetectCycleUnDirected {
    public static ArrayList<ArrayList<Integer>> createGraph(int n,int[][] edges){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n+1;i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }

    public static boolean hasCycle(int node,int parent,boolean[] visited,ArrayList<ArrayList<Integer>> graph){
        visited[node] = true;
        for(int child: graph.get(node)){
            if(visited[child] == false){
                if(hasCycle(child,node,visited,graph))
                    return true;
            } else if(child!=parent){
                return true;
            }
        }
        return false;
    }

    public static String cycleDetection(int[][] edges, int n, int m) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> graph = createGraph(n,edges);
        /*for(ArrayList<Integer> node: graph){
            System.out.println(Arrays.toString(node.toArray()));
        }*/
        boolean[] visited = new boolean[n+1];
        for(int i=1;i<n+1;i++){
            if(visited[i]==false){
                if(hasCycle(i,-1,visited,graph))
                    return "Yes";
            }
        }
        return "No";
    }
}
