class Solution {
    public int findGCD(int[] nums) {
        int max=max(nums);
        int min=min(nums);
        int gcd=gcd(max,min);
        return gcd;
    }

    static int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }

    static int max(int[] arr){
        int max=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>max){
            max=arr[i];
            }
        }
        return max;
    }

    static int min(int[] arr){
        int min=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]<min){
            min=arr[i];
            }
        }
        return min;
    }
}