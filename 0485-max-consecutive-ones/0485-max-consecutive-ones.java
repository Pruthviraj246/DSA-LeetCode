class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int temp=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                count++;
            }
            if(count>temp){
                temp=count;
            }
            if(nums[i]==0){
                count=0;
            }
        }
        return temp;
    }
}