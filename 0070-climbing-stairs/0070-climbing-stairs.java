class Solution {
    public int climbStairs(int n) {
        ArrayList<Integer> list=new ArrayList<>(Collections.nCopies(n+1,-1));
        return mem(n,list);
    }
    static int mem(int n,ArrayList<Integer> list){
        if(n<=1) return 1;
        if(list.get(n)!=-1) return list.get(n);
        int left=mem(n-1,list);
        int right=mem(n-2,list);
        list.set(n,left+right);
        return list.get(n);
    }
}