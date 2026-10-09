class Solution {
    public int uniquePaths(int m, int n) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        //Mem
        for(int i=0;i<m;i++){
            list.add(new ArrayList<>(Collections.nCopies(n,0)));
        }
        // return mem(m-1,n-1,list);
        //Tab
        return tab(m-1,n-1,list);
    }

    static int mem(int row,int col,ArrayList<ArrayList<Integer>> list){
        if(row==0 && col==0){
            return 1;
        }
        if(row<0 || col<0) return 0;
        if(list.get(row).get(col)!=-1) return list.get(row).get(col);
        int down=mem(row-1,col,list);
        int right=mem(row,col-1,list);
        list.get(row).set(col,down+right);
        return list.get(row).get(col);
    }

     static int tab(int m,int n,ArrayList<ArrayList<Integer>> list){
        list.get(0).set(0,1);
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 && j==0){
                    continue;
                }else{
                    int down=0;
                    int right=0;
                    if(i>0){
                        down=list.get(i-1).get(j);
                    } 
                    if(j>0){
                        right=list.get(i).get(j-1);
                    } 
                    list.get(i).set(j,down+right);
                } 
            }
        }
        return list.get(m).get(n);
    }
}