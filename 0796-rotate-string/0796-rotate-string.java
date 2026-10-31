class Solution {
    // public boolean rotateString(String s, String goal) {
    //     if(s.length()!=goal.length()) return false;
    //     char[] arr=s.toCharArray();
    //     int k=0;
    //     while(k<s.length()){
    //         char temp=arr[0];
    //         for(int i=1;i<arr.length;i++){
    //             arr[i-1]=arr[i];
    //         }
    //         arr[arr.length-1]=temp;
    //         if(new String(arr).equals(goal)) return true;
    //         k++;
    //     }
    //     return false;
    // }

    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()) return false;
        
        String k=s+s;
        return k.contains(goal);
    }

}