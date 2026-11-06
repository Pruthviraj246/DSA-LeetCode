class Solution {
    // public int[] intersect(int[] nums1, int[] nums2) {
    //     Arrays.sort(nums1);
    //     Arrays.sort(nums2);
    //     ArrayList<Integer> list=new ArrayList<>();
    //     int i=0;
    //     int j=0;
    //     while(i<nums1.length && j<nums2.length){
    //         if(nums1[i]==nums2[j]){
    //             list.add(nums1[i]);
    //             i++;
    //             j++;
    //         }else if(nums1[i]>nums2[j]){
    //             j++;
    //         }else{
    //             i++;
    //         }
    //     }
    //     int[] ans=new int[list.size()];
    //     int index=0;
    //     for(int k:list){
    //         ans[index]=k;
    //         index++;
    //     }
    //     return ans;
    // }

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
        }
        int n=Math.min(nums1.length,nums2.length);
        int[] ans=new int[n];
        int k=0;
        
        for(int j:nums2){
            if(map.getOrDefault(j,0)>0){
                ans[k]=j;
                k++;
                map.put(j,map.get(j)-1);
            }
        }
        return Arrays.copyOf(ans,k);
    }
}