package graph;
import java.util.*;

// https://leetcode.com/problems/course-schedule/

public class DetectCycleBFSDirected {
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

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> map = generateMap(numCourses,prerequisites);
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        //find in degree of each node
        for(ArrayList<Integer> edges: map){
            for(int edge: edges){
                indegree[edge]++;
            }
        }
        //put all nodes with indegree of 0 in queue
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)
                queue.add(i);
        }
        //System.out.println("queue: "+Arrays.toString(queue.toArray()));
        int index = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            index++;
            for(int child: map.get(node)){
                indegree[child]--;
                if(indegree[child]==0){
                    queue.add(child);
                }
            }
        }
        //System.out.println("index: "+index);
        if(index==numCourses)
            return true;
        return false;
    }
}
