class Solution {
    public boolean judgeSquareSum(int c) {
        int start=0;
        int end=(int)Math.sqrt(c);
        while(start<=end){
            long a=(long)start*start;
            long b=(long)end*end;
            if(a+b==c){
                return true;
            }
            if(a+b>c){
                end--;
            }else{
                start++;
            }
        }
        return false;
    }
}