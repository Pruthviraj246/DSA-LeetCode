class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> outer=new ArrayList<>();
        List<Integer> inner=new ArrayList<>();
        boolean[] used=new boolean[nums.length];
        func(nums,0,used,outer,inner);
        return outer;
    }
    static void func(int[] nums,int ind,boolean[] used,List<List<Integer>> outer,List<Integer> inner){
        if(ind>=nums.length){
            outer.add(new ArrayList<>(inner));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!used[i]){
                used[i]=true;
                inner.add(nums[i]);
                func(nums,ind+1,used,outer,inner);
                inner.remove(inner.size()-1);
                used[i]=false;
            }
        }
    }
}