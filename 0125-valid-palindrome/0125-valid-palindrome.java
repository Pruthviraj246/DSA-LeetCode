// class Solution {
//     public boolean isPalindrome(String s) {
//         s=s.toLowerCase();
//         s=s.replaceAll("[^a-zA-Z0-9]", "");
//         int start=0;
//         int end=s.length()-1;
//         while(start<end){
//             if(s.charAt(start)!=s.charAt(end)){
//                 return false;
//             }
//             start++;
//             end--;
//         }
//         return true;

//     }
// }

class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        s=s.replaceAll("[^a-zA-Z0-9]", "");
        return check(s,0,s.length()-1);
    }

    static boolean check(String s,int f,int l){
        if(f>l){
            return true;
        }

        return (s.charAt(f)==s.charAt(l)) && check(s,f+1,l-1);
    }

}