class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> outer=new ArrayList<>();
        func(numRows,outer);
        return outer;
    }

    public void func(int numRows,List<List<Integer>> outer){
        if(numRows==0) return;
        if(outer.isEmpty()){
            List<Integer> inner=new ArrayList<>();
            inner.add(1);
            outer.add(inner);
            func(numRows-1, outer);
            return;
        }
        List<Integer> temp=outer.get(outer.size()-1);
        List<Integer> inner=new ArrayList<>();
        int p1=0;
        int p2=1;
        inner.add(1);
        while(p2<temp.size()){
            inner.add(temp.get(p1)+temp.get(p2));
            p1++;
            p2++;
        }
        inner.add(1);
        outer.add(inner);
        func(numRows-1,outer);
    }
}