class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //Memoization
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        // for(int i=0;i<triangle.size();i++){
        //     list.add(new ArrayList<>(Collections.nCopies(triangle.get(i).size(),-1)));
        // }
        // return mem(0,0,triangle,list);
        //Tabulation
        for(int i=0;i<triangle.size();i++){
            list.add(new ArrayList<>(Collections.nCopies(triangle.get(i).size(),0)));
        }
        return tab(triangle,list);
    }

    static int mem(int i,int j,List<List<Integer>> triangle,ArrayList<ArrayList<Integer>> list){
        if(i==triangle.size()-1){
            return triangle.get(triangle.size()-1).get(j);
        }
        if(list.get(i).get(j) != -1) return list.get(i).get(j);
        int d=triangle.get(i).get(j)+mem(i+1,j,triangle,list);
        int dg=triangle.get(i).get(j)+mem(i+1,j+1,triangle,list);
        list.get(i).set(j,Math.min(d,dg));
        return list.get(i).get(j);
    }

    static int tab(List<List<Integer>> triangle,ArrayList<ArrayList<Integer>> list){
        int n=triangle.size();
        for(int i=0;i<n;i++){
            list.get(n-1).set(i,triangle.get(n-1).get(i));
        }

        for(int i=n-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                int d=triangle.get(i).get(j)+list.get(i+1).get(j);
                int dg=triangle.get(i).get(j)+list.get(i+1).get(j+1);
                list.get(i).set(j,Math.min(d,dg));
            }
        }
        return list.get(0).get(0);
    }
}