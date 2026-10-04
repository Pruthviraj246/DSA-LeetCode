class Pair{
    int first;
    int second;
    int count;
    public Pair(int first,int second,int count){
        this.first=first;
        this.second=second;
        this.count=count;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        boolean[][] vis=new boolean[n][m];
        int[][] dist=new int[n][m];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=true;
                }
            }
        }
        int[] delrow={-1,0,1,0};
        int[] delcol={0,1,0,-1};
        while(!q.isEmpty()){
            int r=q.peek().first;
            int c=q.peek().second;
            int cnt=q.peek().count;
            q.remove();
            dist[r][c]=cnt;
            for(int i=0;i<4;i++){
                int nrow=r+delrow[i];
                int ncol=c+delcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol <m && vis[nrow][ncol]==false){
                    vis[nrow][ncol]=true;
                    q.add(new Pair(nrow,ncol,cnt+1));
                }
            }
        }
        return dist;
    }
}