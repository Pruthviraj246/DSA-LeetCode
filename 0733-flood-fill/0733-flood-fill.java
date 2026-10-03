class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int iniColor=image[sr][sc];
        int[][] ans=image;
        int[] delrow={-1,0,1,0};
        int[] delcol={0,1,0,-1};
        dfs(image,sr,sc,color,iniColor,ans,delrow,delcol);
        return ans;
    }

    static void dfs(int[][] image, int r, int c, int color,int iniColor,int[][] ans,int[] delrow,int[] delcol){
        int n=image.length;
        int m=image[0].length;
        ans[r][c]=color;
        for(int i=0;i<delrow.length;i++){
            int nrow=r+delrow[i];
            int ncol=c+delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && ans[nrow][ncol]!=color && image[nrow][ncol]==iniColor){
                dfs(image,nrow,ncol,color,iniColor,ans,delrow,delcol);
            }
        }
    }
}