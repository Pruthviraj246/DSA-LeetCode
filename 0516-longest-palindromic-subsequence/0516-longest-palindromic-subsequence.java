class Solution {
    public int longestPalindromeSubseq(String s) {
        String s1=s;
        String s2=rev(s);
        return tab2(s1,s2);
    }

    static int tab2(String text1, String text2){
        int n=text1.length();
        int m=text2.length();
        ArrayList<Integer> prev=new ArrayList<>(Collections.nCopies(m+1,-1));
        ArrayList<Integer> cur=new ArrayList<>(Collections.nCopies(m+1,-1));
        for(int j=0;j<=m;j++){
            prev.set(j,0);
        }
        for(int i=1;i<=n;i++){
            cur=new ArrayList<>(Collections.nCopies(m+1,0));
            for(int j=1;j<=m;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    cur.set(j,1+prev.get(j-1));
                }else{
                    cur.set(j,Math.max(prev.get(j),cur.get(j-1)));
                }
            }
            prev=cur;
        }
        return prev.get(m);
    }

    static String rev(String s){
        String ans="";
        for(int i=s.length()-1;i>=0;i--){
            ans+=s.charAt(i);
        }
        return ans;
    }
}