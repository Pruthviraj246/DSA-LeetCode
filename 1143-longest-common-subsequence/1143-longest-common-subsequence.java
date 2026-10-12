
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        ArrayList<ArrayList<Integer>> dp=new ArrayList<>();
        for(int i=0;i<n+1;i++){
            dp.add(new ArrayList<>(Collections.nCopies(m+1,-1)));
        }
        // return mem(text1,text2,n,m,dp);
        // return tab(text1,text2);
        return tab2(text1,text2);
    }

    static int mem(String text1, String text2,int ind1,int ind2,ArrayList<ArrayList<Integer>> dp){
        if(ind1==0 || ind2==0){
            return 0;
        }
        if(dp.get(ind1).get(ind2)!=-1) return dp.get(ind1).get(ind2);
        if(text1.charAt(ind1-1)==text2.charAt(ind2-1)){
            dp.get(ind1).set(ind2,1+mem(text1,text2,ind1-1,ind2-1,dp));
            return dp.get(ind1).get(ind2);
        }
        dp.get(ind1).set(ind2,Math.max(mem(text1,text2,ind1-1,ind2,dp),mem(text1,text2,ind1,ind2-1,dp)));
        return dp.get(ind1).get(ind2);
    }

    static int tab(String text1, String text2){
        int n=text1.length();
        int m=text2.length();
        ArrayList<ArrayList<Integer>> dp=new ArrayList<>();
        for(int i=0;i<n+1;i++){
            dp.add(new ArrayList<>(Collections.nCopies(m+1,-1)));
        }
        for(int i=0;i<=n;i++){
            dp.get(i).set(0,0);
        }
        for(int j=0;j<=m;j++){
            dp.get(0).set(j,0);
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp.get(i).set(j,1+dp.get(i-1).get(j-1));
                }else{
                    dp.get(i).set(j,Math.max(dp.get(i-1).get(j),dp.get(i).get(j-1)));
                }
            }
        }
        return dp.get(n).get(m);
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

}
