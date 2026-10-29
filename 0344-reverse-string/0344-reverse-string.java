class Solution {
    public void reverseString(char[] s) {
        int f=0;
        int l=s.length-1;
        while(f<l){
            swap(s,f,l);
            f++;
            l--;
        }
    }
    public void swap(char[] s,int a,int b){
        char temp=s[a];
        s[a]=s[b];
        s[b]=temp;
    }
}