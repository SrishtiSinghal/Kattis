
import java.util.*;

public class Kitten{

  public static void main(String[] args){

    int[]parent = new int[101];
    Scanner ob = new Scanner(System.in);
    int position = ob.nextInt();
    ob.nextLine();
    int track = position;
    while(ob.hasNextLine()){
      String[] line = ob.nextLine().split(" ");
      track = Integer.parseInt(line[0]);
      if(track == -1){
        break;
      }
      for(int i = 1; i < line.length; i++){
         int digit = Integer.parseInt(line[i]);
         parent[digit] = track;
      }
    }
    while(parent[position]!=0){
      System.out.print(position + " ");
      position = parent[position];
    }
    System.out.println(position);
;  }
}
