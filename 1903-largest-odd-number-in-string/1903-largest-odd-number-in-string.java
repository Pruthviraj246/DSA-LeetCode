class Solution {
    public String largestOddNumber(String num) {
        while(!num.isEmpty()){
            if((int)(num.charAt(num.length()-1)) % 2 != 0){
                return num;
            }else{
                num=num.substring(0,num.length()-1);
            }
        }
        return num;
    }
}