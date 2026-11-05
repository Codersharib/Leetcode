class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        return differentWays(expression);
    }
    public static List<Integer> differentWays(String exp){
        Map<String,List<Integer>> memo=new HashMap<>();
        List<Integer> res=new ArrayList<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch=exp.charAt(i);
            if(ch=='+' || ch=='-' || ch=='*'){
                List<Integer> left=differentWays(exp.substring(0,i));
                List<Integer> right=differentWays(exp.substring(i+1));

                for (int l : left) {
                    for (int r : right) {
                        if(ch=='+')  res.add(l+r);
                        if(ch=='-')  res.add(l-r);
                        if(ch=='*')  res.add(l*r);
                    }
                }
            }
        }
        // base case
        if(res.isEmpty()) res.add(Integer.parseInt(exp));

        memo.put(exp,res);
        return res;
    }
}