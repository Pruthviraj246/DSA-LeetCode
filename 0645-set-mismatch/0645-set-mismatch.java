class Solution {
    public int[] findErrorNums(int[] arr) {
        sort(arr);
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=i+1){
                return new int[]{arr[i],i+1};
            }
        }
        return new int[]{-1,-1};
    }

    void sort(int[] arr){
        int i=0;
        while(i<arr.length){
            int correct=arr[i] -1 ;
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