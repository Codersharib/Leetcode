class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ll=new ArrayList<>();
        BinWatch(ll,turnedOn,0,0,0,0);
        return ll;
    }
    public static void BinWatch(List<String> ll,int turnedOn,int hour,int min,int qpsf,int idx){
        if(hour>11 || min>59) return ;
        if(qpsf==turnedOn){
            // System.out.println(hour+":"+min);
            if(hour<10 && min<10){
                ll.add(hour+":0"+min);
            }
            else if(hour<10){
                ll.add(hour+":"+min);
            }
            else if(min<10){
                ll.add(hour+":"+"0"+min);
            }
            else{
                ll.add(hour+":"+min);
            }
        }
        int[] hr={1,2,4,8};
        int[] minn={1,2,4,8,16,32};
        for (int i = idx; i < 10; i++) {
            if(i<4){
                BinWatch(ll, turnedOn, hour+ hr[i], min, qpsf+1,i+1);
            }
            else{
                BinWatch(ll, turnedOn, hour, min+ minn[i-4], qpsf+1,i+1);
            }
        }
    }
}