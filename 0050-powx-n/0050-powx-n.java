class Solution {
    public double myPow(double x, int n) {
       double ans=1.0;
       long pow=n;
       if(pow<0){
        pow=-1*pow;
       }
       double ans2=func(x,pow,ans);
       if(n<0){
            ans2=(double)(1.0)/(double)(ans2);
       }
       return ans2;

    }

    public double func(double x,long pow,double ans){
        if(pow==0){
            return ans;
        }

        if(pow%2==0){
            return func(x*x,pow/2,ans);
        }else{
            return func(x,pow-1,ans*x);
        }
    }
}