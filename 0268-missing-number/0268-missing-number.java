class Solution {
    public int missingNumber(int[] arr) {
        sort(arr);
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=i){
                return i;
            }
        }
        return arr.length;
    }


    void sort(int[] arr){
        int i=0;
        while(i<arr.length){
            int correct=arr[i];
            if(arr[i]<arr.length && arr[i]!=arr[correct]){
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