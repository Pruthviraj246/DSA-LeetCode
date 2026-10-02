class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        boolean[] vis=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(vis[i]==false){
                count++;
                dfs(i,adj,vis);
            }
        }
        return count;    
        

    }
    static void dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] vis){
        vis[0]=true;
        for(int it:adj.get(node)){
            if(vis[it]==false){
                vis[it]=true;
                dfs(it,adj,vis);
            }
        }
    }
}