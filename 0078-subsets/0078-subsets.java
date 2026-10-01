class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> outer =new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        sets(nums,0,outer,list);
        return outer;
        
    }

    static void sets(int[] nums,int i,List<List<Integer>> outer,List<Integer> list){
        if(i>=(nums.length)){
            outer.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        sets(nums,i+1,outer,list);
        list.remove(list.size()-1);
        sets(nums,i+1,outer,list);
    }
}