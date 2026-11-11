class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        ArrayList<Integer> list=new ArrayList<>();
        int top=0;
        int right=cols-1;
        int left=0;
        int bottom=rows-1;

        while(top<=bottom && left<=right){
            //first row
            for(int i=left;i<=right;i++){
                list.add(matrix[top][i]);
            }
            top++;
            //last col
            for(int i=top;i<=bottom;i++){
                list.add(matrix[i][right]);
            }
            right--;
            //last row
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }
            
            //first col
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    list.add(matrix[i][left]);
                }
                left++;
            }
            
        }
        return list;
    }
}