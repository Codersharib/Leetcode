class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        return intersection(nums1,nums2);
    }
    public static int[] intersection(int[] arr1,int[] arr2){
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr1.length;i++) {
            if(map.containsKey(arr1[i])){
                map.put(arr1[i],map.get(arr1[i])+1);
            }
            else{
                map.put(arr1[i],1);
            }
        }
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<arr2.length;i++) {
            if(map.containsKey(arr2[i]) && map.get(arr2[i])>0){
                list.add(arr2[i]);
                map.put(arr2[i],map.get(arr2[i])-1);
            }
        }
        int[] ans=new int[list.size()];
        for(int i=0;i<ans.length;i++) {
            ans[i]=list.get(i);
        }
        return ans;
    }
}