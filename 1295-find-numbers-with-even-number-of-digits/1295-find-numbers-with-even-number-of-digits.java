class Solution {
    public int findNumbers(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(even(nums[i])){
                count++;
            }
        }
        return count;
    }

    static boolean even(int n){
        if(n==0){
            return false;
        }

        int count=0;
        while(n>0){
            count++;
            n/=10;
        }
        return count%2==0;
    }
}