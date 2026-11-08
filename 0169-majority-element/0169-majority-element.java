class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int n=nums.length;
        for(int k:map.keySet()){
            int freq=map.get(k);
            if(freq>n/2){
                return k;
            }
        }
        return -1;
    }
}