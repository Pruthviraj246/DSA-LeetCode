class Solution {
    public int uniquePaths(int m, int n) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        for(int i=0;i<m;i++){
            list.add(new ArrayList<>(Collections.nCopies(n,-1)));
        }
        return mem(m-1,n-1,list);
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
}