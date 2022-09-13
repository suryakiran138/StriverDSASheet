package graph;
import java.util.*;

// https://leetcode.com/problems/is-graph-bipartite/

public class CheckBipartiteDFS {
    public boolean dfsCheck(int node,int c,int[] color,int[][] graph){
        color[node] = c;
        int cc = c == 1 ? 2 : 1;
        for(int child: graph[node]){
            if(color[child] == 0){
                if(!dfsCheck(child, cc, color, graph)){
                    return false;
                }
            } else if(color[child] == c){
                return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for(int i=0;i<color.length;i++){
            if(color[i] == 0){
                if(!dfsCheck(i,1,color,graph)){
                    return false;
                }
            }
        }
        return true;

    }
}
