class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> outer =new ArrayList<>();
        check(candidates,target,outer,new ArrayList<>(),0);
        return outer;
    }

    public void check(int[] arr, int target,List<List<Integer>> outer,List<Integer> inner,int ind){
        if(target==0){
            outer.add(new ArrayList<>(inner));
            return;
        }
        for(int i=ind;i<arr.length;i++){
            if(i!=ind && arr[i]==arr[i-1]) continue;
            if(arr[i] > target) break;
            inner.add(arr[i]);
            check(arr,target-arr[i],outer,inner,i+1);
            inner.remove(inner.size()-1);
        }
    }
}