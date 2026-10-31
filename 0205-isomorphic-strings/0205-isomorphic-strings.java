class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> forward=new HashMap<>();
        HashMap<Character,Character> backward=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            char ch2=t.charAt(i);

            if(forward.containsKey(ch) && (forward.get(ch)!=ch2)){
                return false;
            }else{
                forward.put(ch,ch2);
            }

            if(backward.containsKey(ch2) && (backward.get(ch2)!=ch)){
                return false;
            }else{
                backward.put(ch2,ch);
            }
        }
        return true;
    }
}