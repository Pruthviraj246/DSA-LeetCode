class Solution {
    // public List<List<Integer>> subsets(int[] nums) {
    //     List<List<Integer>> outer=new ArrayList<>();
    //     int n=nums.length;
    //     int subsets=1<<n;
    //     for(int i=0;i<subsets;i++){
    //         List<Integer> inner=new ArrayList<>();
    //         for(int j=0;j<n;j++){
    //             if((i & (1<<j))!=0){
    //                 inner.add(nums[j]);
    //             }
    //         }
    //         outer.add(inner);
    //     }
    //     return outer;
    // }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> outer=new ArrayList<>();
        ArrayList<Integer> list=new ArrayList<>();
        sets(nums,0,list,outer);
        return outer;
    }

    static void sets(int[] nums,int i,ArrayList<Integer> list,List<List<Integer>> outer){
        if(i>=nums.length){
            outer.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        sets(nums,i+1,list,outer);
        list.remove(list.size()-1);
        sets(nums,i+1,list,outer);
        
    } 
        
}