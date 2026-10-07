class Pair{
    int first,second;
    public Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}

class Tuple{
    int first,second,third;
    public Tuple(int first,int second,int third){
        this.first=first;
        this.second=second;
        this.third=third;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        int m=flights.length;
        for(int i=0;i<m;i++){
            int u=flights[i][0];
            int v=flights[i][1];
            int wt=flights[i][2];
            adj.get(u).add(new Pair(v,wt));
        }

        Queue<Tuple> q=new LinkedList<>();
        int[] dist=new int[n];

        for(int i=0;i<n;i++){
            dist[i]=Integer.MAX_VALUE;
        }

        q.add(new Tuple(0,src,0));
        dist[src]=0;

        while(!q.isEmpty()){
            Tuple it=q.peek();
            q.remove();

            int stops=it.first;
            int node=it.second;
            int cost=it.third;

            if(stops>k) continue;

            for(Pair iter:adj.get(node)){
                int adjNode=iter.first;
                int edW=iter.second;

                if(cost+edW<dist[adjNode] && stops<=k){
                    dist[adjNode]=cost+edW;
                    q.add(new Tuple(stops+1,adjNode,cost+edW));
                }
            }
        }

        if(dist[dst]==Integer.MAX_VALUE) return -1;

        return dist[dst];
    }
}