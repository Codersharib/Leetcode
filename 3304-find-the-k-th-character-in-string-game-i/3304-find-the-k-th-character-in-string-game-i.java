class Solution {
    public char kthCharacter(int k) {
        return kthchar(k);
    }
    public static char kthchar(int k){
        String str="a";
        while(str.length()<k){
            String str2="";
            for(int i=0;i<str.length();i++) {
                char ch=str.charAt(i);
                if(ch=='z') ch='a';
                else ch++;
                str2=str2+ch;
            }
            str=str+str2;
        }
        return str.charAt(k-1);
    }
}