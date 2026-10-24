class Solution {
    public boolean checkPerfectNumber(int n) {
        int num=n;
        int sum=0;
        for(int i=1;i<n;i++){
            if(n%i==0){
                sum=sum+i;
            }
        }
        return sum==num;
    }
}