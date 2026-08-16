class Solution {
    public String smallestNumber(String pattern) {
        return DI(pattern);
    }
    public static String DI(String s){
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[s.length()+1];
        int c=1;
        for (int i = 0; i < ans.length; i++) {
            if(i==s.length() || s.charAt(i)=='I'){
                ans[i]=c++;
                while(!st.isEmpty()){
                    ans[st.pop()]=c++;
                }
            }
            else{
                st.push(i);
            }
        }
        String res=Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining());
        return res;
    }
}