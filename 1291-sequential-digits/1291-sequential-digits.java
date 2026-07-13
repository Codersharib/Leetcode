class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ll=new ArrayList<>();
        seq(low,high,ll);
        return ll;
    }
    public static void seq(int low,int high,List<Integer> ll){
        String num="123456789";
        for(int j=0;j<num.length();j++) {
            int si=0;
            for(int i=1+j;i<=num.length() && si <i ;i++) {
                String s=num.substring(si,i);
                if(Integer.parseInt(s)>=low && Integer.parseInt(s)<=high){
                    // System.out.println(Integer.parseInt(s));
                    ll.add(Integer.parseInt(s));
                }
                if(Integer.parseInt(s)>high) return;
                si++;
            }
        }
    }
}