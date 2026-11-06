class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length==0) return;
        int i=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=0){
                swap(nums,i,j);
                i++;
            }
        }
    }

    public void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}