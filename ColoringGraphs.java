import java.util.*;
import java.io.*;
public class ColoringGraphs{
  /*
    4
    1 2
    0 2 3
    0 1
    1
  */

  static int[][] adjMatrix;
  static int[] color;
/*
  public static boolean Coloring(int v , int n){
    Set<Integer> neighbours = new HashSet<Integer>();

    if(v == n){
      return true;
    }
    for(int i = 0 ; i<n ; i++){
      if(adjMatrix[v][i] == 1 && k == color[i]){
        return false;
      }
    }
    Coloring(v+1,k,n);
    return true;
  }

  */
  public static boolean Coloring(int v , int k, int n, int[] color){

    Set<Integer> neighbours = new HashSet<Integer>();
    if(v == n){
      return true;
    }

    for(int i = 0 ; i<n ; i++){
      if(adjMatrix[v][i] == 1){
        neighbours = neighbours.add(color[i]);
        //return false;
      }
      else{
        color[v] = k;
        if(Coloring(v+1,k,n,color)){
          return true;
        }
        color[v] = 0;
      }
    }
    return false;
  }

  public static void main(String[] args) throws Exception{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    adjMatrix = new int[n][n];

    String[] temp;

    color = new int[n];

    for(int i = 0 ; i<n ; i++){
      color[i] = 0;
    }

    for(int i = 0 ; i<n ; i++){
      temp = br.readLine().split(" ");
      for(int j = 0 ; j<temp.length; j++){
        adjMatrix[i][Integer.parseInt(temp[j])] = 1;
        adjMatrix[Integer.parseInt(temp[j])][i] = 1;
      }
    }

    for(int i = 1 ; i<=n ; i++){
      Coloring(0,i,n,color);
      if(Coloring(0,i,n,color) == true){
        System.out.println(i);
        break;
      }
      else{
        System.out.println("impossible");
      }
    }

  }
}
