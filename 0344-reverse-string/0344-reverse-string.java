class Solution {
    // public void reverseString(char[] s) {
    //     int f=0;
    //     int l=s.length-1;
    //     while(f<l){
    //         swap(s,f,l);
    //         f++;
    //         l--;
    //     }
    // }
    // public void swap(char[] s,int a,int b){
    //     char temp=s[a];
    //     s[a]=s[b];
    //     s[b]=temp;
    // }

    public void reverseString(char[] s) {
        reverse(s,0,s.length-1);
    }

    public void reverse(char[] s,int f,int l){
        if(f>l){
            return;
        }
        swap(s,f,l);
        reverse(s,f+1,l-1);
    }

    public void swap(char[] s,int f,int l){
        char temp=s[f];
        s[f]=s[l];
        s[l]=temp;
    }
}