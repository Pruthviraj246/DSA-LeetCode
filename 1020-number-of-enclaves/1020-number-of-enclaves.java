class Solution {
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] vis=new boolean[n][m];
        int[] delrow={-1,0,1,0};
        int[] delcol={0,1,0,-1};
        for(int j=0;j<m;j++){
            //first row
            if(grid[0][j]==1 && vis[0][j]==false){
                dfs(0,j,grid,vis,delrow,delcol);
            }
            //last row
            if(grid[n-1][j]==1 && vis[n-1][j]==false){
                dfs(n-1,j,grid,vis,delrow,delcol);
            }
        }
        for(int i=0;i<n;i++){
            //first col
            if(grid[i][0]==1 && vis[i][0]==false){
                dfs(i,0,grid,vis,delrow,delcol);
            }
            //last col
            if(grid[i][m-1]==1 && vis[i][m-1]==false){
                dfs(i,m-1,grid,vis,delrow,delcol);
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && vis[i][j]==false){
                    count++;
                }
            }
        }
        return count;
    }

    static void dfs(int r,int c,int[][] grid,boolean[][] vis,int[] delrow,int[] delcol){
        int n=grid.length;
        int m=grid[0].length;
        vis[r][c]=true;
        for(int i=0;i<4;i++){
            int nrow=r+delrow[i];
            int ncol=c+delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==false && grid[nrow][ncol]==1){
                dfs(nrow,ncol,grid,vis,delrow,delcol);
            }
        }
    }

}