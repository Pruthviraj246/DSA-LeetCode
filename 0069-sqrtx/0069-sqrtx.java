class Solution {
    public int mySqrt(int x) {
        int start=0;
        int end=x;
        int ans=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            long square=(long) mid*mid;
            if(square==x){
                return mid;
            }
            if(square>x){
                end=mid-1;
            }else{
                ans=mid;
                start=mid+1;
            }
        }
        return ans;
    }
}