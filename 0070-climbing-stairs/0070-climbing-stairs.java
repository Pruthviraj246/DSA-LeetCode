class Solution {
    public int climbStairs(int n) {
        ArrayList<Integer> list=new ArrayList<>(Collections.nCopies(n+1,-1));
        // return mem(n,list);
        // return tab(n);
        return so(n);
    }

    static int mem(int n,ArrayList<Integer> list){ 
        if(n==0 || n==1){
            return 1;
        }
        if(list.get(n)!=-1) return list.get(n);
        list.set(n,mem(n-1,list)+mem(n-2,list));
        return list.get(n);
    }

    static int tab(int n){
        ArrayList<Integer> list=new ArrayList<>(Collections.nCopies(n+1,-1));
        list.set(0,1);
        list.set(1,1);
        for(int i=2;i<=n;i++){
            list.set(i,list.get(i-1)+list.get(i-2));
        }
        return list.get(n);
    }

    static int so(int n){
        int prev=1;
        int prev2=1;
        for(int i=2;i<=n;i++){
            int curi=prev+prev2;
            prev2=prev;
            prev=curi;
        }
        return prev;
    }
}