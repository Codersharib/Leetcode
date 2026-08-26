class Solution {
    public String longestPalindrome(String s) {
        return LPS(s);
    }
    public static String LPS(String ques){
        // int odd=0;
        StringBuilder sb_o=new StringBuilder();
        StringBuilder sb=new StringBuilder();
        for(int axis=0;axis<ques.length();axis++) {
            for(int orbit=0;axis-orbit>=0 && axis+orbit<ques.length();orbit++) {
                if(ques.charAt(axis-orbit) != ques.charAt(axis+orbit)){
                    break;
                }
                if(axis-orbit == axis+orbit) sb.append(ques.charAt(axis+orbit));
                else{
                    sb.insert(0,ques.charAt(axis-orbit));
                    sb.append(ques.charAt(axis+orbit));

                }
                // odd++;
            }
            if(sb.length()>sb_o.length()){
                sb_o=new StringBuilder(sb.toString());
            }
            sb.setLength(0);
        }
        // int even=0;
        StringBuilder sb_e=new StringBuilder();
        StringBuilder sb1=new StringBuilder();
        for(double axis=0.5;axis<ques.length();axis++) {
            for(double orbit=0.5;axis-orbit>=0 && axis+orbit<ques.length();orbit++) {
                if(ques.charAt((int)(axis-orbit)) != ques.charAt((int)(axis+orbit))){
                    break;
                }
                if((int)(axis-orbit) == (int)(axis+orbit)) sb1.append(ques.charAt((int)(axis+orbit)));
                else{
                    sb1.insert(0,ques.charAt((int)(axis-orbit)));
                    sb1.append(ques.charAt((int)(axis+orbit)));
                }
                // even++;
            }
            if(sb1.length()>sb_e.length()){
                sb_e=new StringBuilder(sb1.toString());
            }
            sb1.setLength(0);

        }
        return sb_o.length()>sb_e.length()?sb_o.toString():sb_e.toString();
    }
}