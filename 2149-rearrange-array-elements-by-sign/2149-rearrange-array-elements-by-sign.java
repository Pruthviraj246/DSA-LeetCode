class Solution {
    public int[] rearrangeArray(int[] nums) {
        //Brute-Force
        int n=nums.length;
        int[] positive=new int[n/2];
        int[] negative=new int[n/2];
        int p=0;
        int l=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                positive[p]=nums[i];
                p++;
            }else{
                negative[l]=nums[i];
                l++;
            }
        }
        int[] ans=new int[n];
        for(int i=0;i<positive.length;i++){
            ans[2*i]=positive[i];
            ans[2*i+1]=negative[i];
        }
        return ans;
    }
}