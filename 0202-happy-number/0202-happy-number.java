class Solution {
    public boolean isHappy(int n) {
        while(n!=1 && n!=4){
            int sum=0;
            while(n>0){
                int d=n%10;
                sum=sum+(d*d);
                n=n/10;
            }
            n=sum;
        }
        return n==1;
    }

}

// class Solution {
//     public boolean isHappy(int n) {
//         int slow=n;
//         int fast=n;
//         do{
//             slow=square(slow);
//             fast=square(square(fast));
//         }while(slow!=fast);

//         return slow==1;
        
//     }

//     static int square(int num){
//         int sum=0;
//         while(num>0){
//             int d=num%10;
//             sum=sum+(d*d);
//             num=num/10;
//         }
//         return sum;
//     }

// }