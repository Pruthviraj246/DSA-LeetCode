// class Solution {
//     public int[][] flipAndInvertImage(int[][] image) {
//         for(int row=0;row<image.length;row++){
//             int start=0;
//             int end=image[row].length-1;
//             while(start<end){
//                 swap(image,row,start,end);
//                 start++;
//                 end--;
//             }
//             for(int col=0;col<image[row].length;col++){
//                 if(image[row][col]==0){
//                     image[row][col]=1;
//                 }else{
//                     image[row][col]=0;
//                 }
//             }
//         }
//         return image;
//     }

//     void swap(int[][] image,int row,int start,int end){
//         int temp=image[row][start];
//         image[row][start]=image[row][end];
//         image[row][end]=temp;
//     }
// }

class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int[] row : image) {
            // reverse this array
            for (int i = 0; i < (image[0].length + 1) / 2; i++) {
                // swap
                int temp = row[i] ^ 1;
                row[i] = row[image[0].length - i - 1] ^ 1;
                row[image[0].length - i - 1] = temp;
            }
        }
        return image;
    }
}