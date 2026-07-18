// class Solution {
//     public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
//         String str1="";
//         String str2="";
//         for(int i=0;i<word1.length;i++){
//             str1=str1+word1[i];
//         }
//         for(int j=0;j<word2.length;j++){
//             str2=str2+word2[j];
//         }
        
//         return str1.equals(str2);
//     }
// }

class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String str1=String.join("",word1);
        String str2=String.join("",word2);
        return str1.equals(str2);
    }
}