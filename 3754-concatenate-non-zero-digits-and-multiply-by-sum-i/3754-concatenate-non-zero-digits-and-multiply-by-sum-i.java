class Solution {
    public long sumAndMultiply(int n) {
        long value = 0;
        while (n > 0) {
            int digits = n % 10;
            if (digits != 0) {
                value = value * 10 + digits;
            }

            n = n / 10;
            //till here value=4321
        }
        
        long rev=0;
        while(value>0){
            long digits2=value%10;
            rev=rev*10+digits2;
            value=value/10;
            //rev=1234
        }


        long x = rev; // x=4321 //original number is stored in value

        long sum = 0;
        while (x > 0) {
            long digits3 = x % 10;
            sum = sum + digits3;
            x = x / 10;
        }
        return rev * sum;
    }
}