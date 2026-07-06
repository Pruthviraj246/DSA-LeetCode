class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] seen=new boolean[26];
        for(int i=0;i<sentence.length();i++){
            char ch = sentence.charAt(i);
            seen[ch-'a']=true;
        }
        for(int j=0;j<26;j++){
            if(!seen[j]){
                return false;
            }
        }
        return true;
    }
}