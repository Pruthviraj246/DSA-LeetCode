class Solution {
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }
        // return mem(n-1,m-1,grid,dp);
        //Tabulation
        return tab(grid,dp);
    }

    static int mem(int i,int j,int[][] grid,int[][] dp){
        if(i<0 || j<0) return (int)1e9;
        if(i==0 && j==0) return grid[0][0];
        if(dp[i][j]!=-1) return dp[i][j];

        int up=grid[i][j]+mem(i-1,j,grid,dp);
        int left=grid[i][j]+mem(i,j-1,grid,dp);
        dp[i][j]=Math.min(up,left);
        return dp[i][j];
    }

    static int tab(int[][] grid,int[][] dp){
        int n=grid.length;
        int m=grid[0].length;
        dp[0][0]=grid[0][0];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0) continue;
                int up=(int)1e9;
                int left=(int)1e9;
                if(i>0) up=dp[i-1][j];
                if(j>0) left=dp[i][j-1];
                dp[i][j]=grid[i][j]+Math.min(up,left);
            }
        }
        return dp[n-1][m-1];
    }
}