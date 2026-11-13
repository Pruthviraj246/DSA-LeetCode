class Solution {
    public int climbStairs(int n) {
        ArrayList<Integer> list=new ArrayList<>(Collections.nCopies(n+1,-1));
        return mem(n,list);
    }

    static int mem(int n,ArrayList<Integer> list){ 
        if(n==0 || n==1){
            return 1;
        }
        if(list.get(n)!=-1) return list.get(n);
        list.set(n,mem(n-1,list)+mem(n-2,list));
        return list.get(n);
    }
}