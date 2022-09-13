package graph;
import java.util.*;

// https://leetcode.com/problems/course-schedule/

public class DetectCycleDFSDirected {
    public ArrayList<ArrayList<Integer>> generateMap(int nodeCount, int[][] preq){
        ArrayList<ArrayList<Integer>> map = new ArrayList<>(nodeCount);
        for(int i=0;i<nodeCount;i++){
            map.add(new ArrayList<Integer>());
        }
        for(int i=0;i<preq.length;i++){
            map.get(preq[i][0]).add(preq[i][1]);
        }
        return map;
    }

    public boolean hasCycle(int node,boolean[] visited,boolean[] dfsvisited, ArrayList<ArrayList<Integer>> adj){
        visited[node] = true;
        dfsvisited[node] = true;
        for(int child: adj.get(node)){
            if(!visited[child]){
                if(hasCycle(child,visited,dfsvisited,adj))
                    return true;
            } else if (dfsvisited[child]){
                return true;
            }
        }
        dfsvisited[node] = false;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = generateMap(numCourses, prerequisites);
        /*for(int i=0;i<adj.size();i++){
            System.out.println(Arrays.toString(adj.get(i).toArray()));
        }*/
        boolean[] visited = new boolean[numCourses];
        boolean[] dfsvisited = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(visited[i]==false){
                if(hasCycle(i,visited,dfsvisited,adj))
                    return false;
            }
        }
        return true;
    }
}
