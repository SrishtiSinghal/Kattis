import java.io.*;
import java.util.*;

public class DiceBetting{

  public static double arr[][];
  public static double function(int r,double d, int n , double s , double k){
    if(d >= k){
      return 1;
    }
    if((r<(k-d)) || ((r+d)>n)){
      return 0;
    }
    if (arr[(int)r][(int)d]!=0)
    {
        return arr[(int)r][(int)d];
    }
    else{
      double val = (d/s)*function(r-1,d,n,s,k) + ((s-d)/s)*function(r-1,d+1,n,s,k);
      arr[(int)r][(int)d] = val;
      return val;
    }
  }

  public static void main(String[] args){

    Scanner ob = new Scanner(System.in);
    int n = ob.nextInt();
    double s = ob.nextDouble();
    double k = ob.nextDouble();
    arr = new double[n+1][n];
    int r = n;
    double d = 0;
    double ans = function(r,d,n,s,k);
    System.out.println(ans);
  }
}
