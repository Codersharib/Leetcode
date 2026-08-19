class Solution {
    public int majorityElement(int[] nums) {
        return majority(nums);
    }

    public static int majority(int[] arr){
        int vote=0;
        int e=arr[0];
        for(int i=0;i<arr.length;i++){
            if(vote==0){
                e=arr[i];
            }
            if(arr[i]==e){
                vote++;
            }
            else{
                vote--;
            }
        }
        return e;
    }
}