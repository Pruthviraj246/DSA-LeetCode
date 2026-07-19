class Solution {
    public List<Integer> findDisappearedNumbers(int[] arr) {
        sort(arr);
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=i+1){
                ans.add(i+1);
            }
        }
        return ans;
    }

    void sort(int[] arr){
        int i=0;
        while(i<arr.length){
            int correct=arr[i]-1;
            if(arr[i]!=arr[correct]){
                swap(arr,i,correct);
            }else{
                i++;
            }

        }
        
    }

    void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}