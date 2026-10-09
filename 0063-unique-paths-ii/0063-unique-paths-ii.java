class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        int row=obstacleGrid.length;
        int col=obstacleGrid[0].length;
        for(int i=0;i<row;i++){
            list.add(new ArrayList<>(Collections.nCopies(col,-1)));
        }
        // return mem(row-1,col-1,obstacleGrid,list);
        return tab(list,obstacleGrid);
    }

    static int mem(int row,int col,int[][] obstacleGrid,ArrayList<ArrayList<Integer>> list){
        if(row<0 || col<0) return 0;
        if(obstacleGrid[row][col]==1) return 0;
        if(row==0 && col==0) return 1;
        if(list.get(row).get(col)!=-1) return list.get(row).get(col);
        int left=mem(row,col-1,obstacleGrid,list);
        int up=mem(row-1,col,obstacleGrid,list);
        list.get(row).set(col,left+up);
        return list.get(row).get(col);
    }

    static int tab(ArrayList<ArrayList<Integer>> list,int[][] obstacleGrid){
        int row=obstacleGrid.length;
        int col=obstacleGrid[0].length;
        // i==row,j=col
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(obstacleGrid[i][j]==1){
                    list.get(i).set(j,0);
                }else if(i==0 && j==0){
                    list.get(i).set(j,1);
                }else{
                    int up=0;
                    int left=0;
                    if(i>0){
                        up=list.get(i-1).get(j);
                    }
                    if(j>0){
                        left=list.get(i).get(j-1);
                    }
                    list.get(i).set(j,left+up);
                } 
            }
        }
        return list.get(row-1).get(col-1);
    }
}