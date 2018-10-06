import java.io.*;
import java.util.*;
import java.lang.Math;

public class Kastenlauf{


  public static void main(String[] args){
    Scanner ob = new Scanner(System.in);
    int testCases = ob.nextInt();

    for (int i = 0; i<testCases ;i++ ){
      int n = ob.nextInt();
      ob.nextLine();
      int[] x = new int[n+2];
      int[] y = new int[n+2];
      int[] parent = new int[n+2];

      for(int j = 0 ; j<n+2; j++){
        String[] line = ob.nextLine().split(" ");
        x[j] = Integer.parseInt(line[0]);
        y[j] = Integer.parseInt(line[1]);
        parent[j] = j;
      }

      for(int k = 0; k<n+2; k++){
        for(int l = k+1 ; l<n+2 ; l++){
          if((Math.abs(x[k]-x[l]) + Math.abs(y[k]-y[l])) <= 1000){
            for(int r = 0 ; r< n+2; r++){
              int pid = parent[k];
              int qid = parent[l];
              if(pid == qid){
                break;
              }
              else if(parent[r] == qid){
                parent[r] = pid;
              }
            }
          }
        }
      }
      if(parent[0] == parent[n+1]){
        System.out.println("happy");
      }
      else{
        System.out.println("sad");
      }
    }
  }

}

