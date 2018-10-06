import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HolyNQueens{

  static int N;
  static int[] X = new int[1000]; //solution
  static int count; // number of solutions
  static boolean[] a = new  boolean[1000];
  static boolean[] b = new boolean[1000];
  static boolean[] c = new boolean[1000];
  static boolean[][] board;

  static void gen(int col){
      for(int row  = 0 ; row<N; ++row){
        if(a[row] && b[row +col] && c[row-col + N]){
          if(!board[row][col]){
            X[col] = row;
            a[row] = b[row + col] = c[row-col +N] = false;

            if(col == N-1){
              count++;
            }
            else{
              gen(col+1);
            }
            a[row] = b[row + col] = c[row-col +N] = true;
          }
        }

      }

  }

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");

    for(int i = 0 ; i<1000; i++){
      a[i] = b[i] = c[i] = true;
    }


    while((N=Integer.parseInt(input[0]))!=0){
      board = new boolean[N][N];
      int holes = Integer.parseInt(input[1]);

      if(holes!=0){
        for(int j = 0 ; j<holes; j++){
          input = br.readLine().split(" ");
          int n1 = Integer.parseInt(input[0]);
          int n2 = Integer.parseInt(input[1]);
          board[n1][n2] = true;
        }
      }
      gen(0);
      input = br.readLine().split(" ");
      System.out.println(count);
      count = 0;
    }
    //System.out.println(count);
  }


}
