class Solution {
    public int change(int amount, int[] coins) {
        ArrayList<ArrayList<Integer>> dp=new ArrayList<>();
        int n=coins.length;
        for(int i=0;i<n;i++){
            dp.add(new ArrayList<>(Collections.nCopies(amount+1,-1)));
        }
        // return mem(amount,n-1,coins,dp);
        // return tab(amount,coins);
        return tab2(amount,coins);
    }

    static int mem(int amount,int ind, int[] coins,ArrayList<ArrayList<Integer>> dp){
        if(ind==0){
            if((amount % coins[0])==0){
                return 1;
            }
            return 0;
        }
        if(dp.get(ind).get(amount)!=-1) return dp.get(ind).get(amount);
        int notTake=mem(amount,ind-1,coins,dp);
        int take=0;
        if(coins[ind]<=amount){
            take=mem(amount-coins[ind],ind,coins,dp);
        }
        dp.get(ind).set(amount,take+notTake);
        return dp.get(ind).get(amount);
    }

    static int tab(int amount, int[] coins){
        ArrayList<ArrayList<Integer>> dp=new ArrayList<>();
        int n=coins.length;
        for(int i=0;i<n;i++){
            dp.add(new ArrayList<>(Collections.nCopies(amount+1,-1)));
        }
        for(int t=0;t<=amount;t++){
            dp.get(0).set(t,t % coins[0] == 0 ? 1 : 0);
        }
        for(int i=1;i<n;i++){
            for(int t=0;t<=amount;t++){
                int notTake=dp.get(i-1).get(t);
                int take=0;
                if(coins[i]<=t){
                    take=dp.get(i).get(t-coins[i]);
                }
                dp.get(i).set(t,take+notTake);
            }
        }
        return dp.get(n-1).get(amount);
    }

    static int tab2(int amount, int[] coins){
        ArrayList<Integer> prev=new ArrayList<>(Collections.nCopies(amount+1,-1));
        ArrayList<Integer> cur=new ArrayList<>(Collections.nCopies(amount+1,-1));
        int n=coins.length;
        for(int t=0;t<=amount;t++){
            prev.set(t,t % coins[0] == 0 ? 1 : 0);
        }
        for(int i=1;i<n;i++){
            for(int t=0;t<=amount;t++){
                int notTake=prev.get(t);
                int take=0;
                if(coins[i]<=t){
                    take=cur.get(t-coins[i]);
                }
                cur.set(t,take+notTake);
            }
            prev=cur;
            cur=new ArrayList<>(Collections.nCopies(amount+1,0));
        }
        return prev.get(amount);
    }
}