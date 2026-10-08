class Solution {
    public int rob(int[] nums) {
        // For Mem
        // ArrayList<Integer> list=new ArrayList<>(Collections.nCopies(nums.length,-1));
        // return mem(nums,nums.length-1,list);
        //For tab
        // ArrayList<Integer> list=new ArrayList<>(); 
        // return tab(nums,list);
        return tabSO(nums);
    }

    static int mem(int[] nums,int i,ArrayList<Integer> list){
        if(i==0) return nums[i];
        if(i<0) return 0;
        if(list.get(i)!=-1) return list.get(i);
        int pick=nums[i] + mem(nums,i-2,list);
        int notpick=mem(nums,i-1,list);
        list.set(i,Math.max(pick,notpick));
        return list.get(i);
    }

    static int tab(int[] nums,ArrayList<Integer> list){
        list.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            int take=nums[i];
            if(i>1) take+=list.get(i-2);
            int nontake=list.get(i-1);
            list.add(Math.max(take,nontake));
        }
        return list.get(nums.length-1);
    }

    static int tabSO(int[] nums){
        int prev=nums[0];
        int prev2=0;
        for(int i=0;i<nums.length;i++){
            int take=nums[i];
            if(i>1) take+=prev2;
            int nontake=prev;
            int curi=Math.max(take,nontake);
            prev2=prev;
            prev=curi;
        }
        return prev;
    }
}