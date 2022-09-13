package graph;

// https://leetcode.com/problems/number-of-islands/submissions/

public class NoOfIslands {
    public void dfs(int i,int j,boolean[][] visited,char[][] grid){
        visited[i][j] = true;
        // go up
        if(i-1>-1 && grid[i-1][j] == '1' && !visited[i-1][j]){
            dfs(i-1,j,visited,grid);
        }
        // go down
        if(i+1<grid.length && grid[i+1][j]=='1' && !visited[i+1][j]){
            dfs(i+1,j,visited,grid);
        }
        // go left
        if(j-1>-1 && grid[i][j-1]=='1' && !visited[i][j-1]){
            dfs(i,j-1,visited,grid);
        }
        // go right
        if(j+1<grid[0].length && grid[i][j+1]=='1' && !visited[i][j+1]){
            dfs(i,j+1,visited,grid);
        }
    }

    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int islands = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    islands++;
                    dfs(i,j,visited,grid);
                }
            }
        }
        return islands;
    }
}
