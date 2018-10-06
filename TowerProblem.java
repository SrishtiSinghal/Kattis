import java.util.*;
import java.io.*;


public class TowerProblem{
  public static void main(String[] args){
    Scanner ob = new Scanner(System.in);
    int[] input = new int[8];
    for(int i = 0; i<8 ; i++){
      input[i] = ob.nextInt();
    }
    for(int i = 0 ; i<6; i++){
      for(int j = i+1; j<6; j++){
        for(int k = j+1; k<6; k++){
         // boolean[] b = new boolean[6];
          if(input[i]+input[j]+input[k] == input[6]){
            boolean[] b = new boolean[6];
            b[i] = b[j] = b[k] = true;
            int[] sorted = {input[i],input[j],input[k]};
            Arrays.sort(sorted);
            System.out.print(sorted[2]+" "+sorted[1]+" "+sorted[0]+" ");
            for(int t = 0, u =0; t<6 ; t++){
             //system.out.println(input[t]);
              if(!b[t]){
                sorted[u++] = input[t];
              }
            }
            Arrays.sort(sorted);
            System.out.print(sorted[2]+" "+sorted[1]+" "+sorted[0]+" ");
          }

        }
      }
    }
  }
}
