import java.util.*;
import java.io.*;

public class Coloring{


  static int[][] adjMatrix;
  static int[] color;
  static int V;

    public static boolean graphColoringSolve(int adjMatrix[][], int V,
                              int color[], int v)
    {

        if (v == adjMatrix.length){
            return true;
        }

        boolean unsafe[] = new boolean[V+2];

        for(int i = 0; i< adjMatrix.length; i++){
          if(adjMatrix[v][i] ==1){
            unsafe[color[i]] = true;
          }
        }

        for (int c = 1; c <= V; c++)
        {

          if(unsafe[c] == false){

                color[v] = c;

                if (graphColoringSolve(adjMatrix, V,color, v + 1)){
                    return true;
                }

                color[v] = 0;

          }
        }

        return false;
    }


    public static boolean graphColoring(int adjMatrix[][], int V)
    {
        color = new int[V];

        for(int i = 1; i<=V; i++){

         // graphColoringSolve(adjMatrix,i,color,0);

          if(graphColoringSolve(adjMatrix,i,color,0)){
            System.out.println(i);
            break;
          }

        }
      /*  int start = 0;
        int end = V;
        int mid = 0;
        int result = search(start,end,mid);
        System.out.println(result); */
        return true;
    }
/*
    public static int search(int start, int end , int mid){

      while(start<end){
        mid = (start + end)/2;
        if(graphColoringSolve(adjMatrix,mid,color,0)){
          end = mid;
        }
        else{
          start = mid+1;
        }
      }
      return mid;
    } */

    public static void main(String[] args) throws Exception{

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      adjMatrix = new int[n][n];

      String[] temp;

      for(int i = 0 ; i<n ; i++){
        temp = br.readLine().split(" ");
        for(int j = 0 ; j<temp.length; j++){
          adjMatrix[i][Integer.parseInt(temp[j])] = 1;
          adjMatrix[Integer.parseInt(temp[j])][i] = 1;
        }
      }

      V = n;
      graphColoring(adjMatrix,V);
    }
}
