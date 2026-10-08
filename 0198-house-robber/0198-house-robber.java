class Solution {
    public int rob(int[] nums) {
        ArrayList<Integer> list=new ArrayList<>(Collections.nCopies(nums.length,-1));
        return mem(nums,nums.length-1,list);
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
}