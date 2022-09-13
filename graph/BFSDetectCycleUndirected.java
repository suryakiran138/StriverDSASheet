package graph;
import java.util.*;

// https://www.codingninjas.com/codestudio/problems/1062670?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website

public class BFSDetectCycleUndirected {
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

    static class Pair {
        int node;
        int parent;
        Pair(int node, int parent){
            this.node = node;
            this.parent = parent;
        }
    }

    public static String cycleDetection(int[][] edges, int n, int m) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> graph = createGraph(n,edges);
        /*for(ArrayList<Integer> node: graph){
            System.out.println(Arrays.toString(node.toArray()));
        }*/
        boolean[] visited = new boolean[n+1];

        for(int i=1;i<n+1;i++){
            if(!visited[i]){
                Queue<Pair> queue = new LinkedList<>();
                queue.add(new Pair(i,-1));
                while(!queue.isEmpty()){
                    Pair pair = queue.poll();
                    visited[pair.node] = true;
                    for(int child: graph.get(pair.node)){
                        if(!visited[child]){
                            visited[pair.node] = true;
                            queue.add(new Pair(child,pair.node));
                        } else if(child != pair.parent){
                            return "Yes";
                        }
                    }
                }
            }
        }
        return "No";
    }
}
