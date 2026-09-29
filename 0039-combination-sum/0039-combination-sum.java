class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        combination(0,candidates,target,ans,new ArrayList<>());

        return ans;
    }

    static void combination(int i,int[] arr,int target,List<List<Integer>> ans,List<Integer> ds){
        if(i==arr.length){
            if(target==0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(arr[i]<=target){
            ds.add(arr[i]);
            combination(i,arr,target-arr[i],ans,ds);
            ds.remove(ds.size()-1);
        }
        combination(i+1,arr,target,ans,ds);
    }
}