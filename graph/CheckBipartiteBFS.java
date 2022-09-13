package graph;
import java.util.*;

// https://leetcode.com/problems/is-graph-bipartite/

public class CheckBipartiteBFS {
    public boolean isBipartite(int[][] graph) {

        int[] color = new int[graph.length];
        for(int i=0;i<color.length;i++){
            if(color[i] == 0){
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                color[i] = 1;
                while(!queue.isEmpty()){
                    int node = queue.poll();
                    int cc = color[node] == 1 ? 2 : 1;
                    for(int child: graph[node]){
                        if(color[child] == 0){
                            queue.add(child);
                            color[child] = cc;
                        } else if(color[child] == color[node]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;

    }
}
