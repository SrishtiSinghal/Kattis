import java.io.*;
import java.util.*;

public class NoDuplicates{
  public static void main(String[] args){
    Scanner ob = new Scanner(System.in);
    String[] line = ob.nextLine().split(" ");
   // int count = 0;
     boolean duplicate =false;
    for(int i = 0 ; i<line.length ; i++){
      //boolean duplicate =false;
    //  int count =0;
      for(int j = i+1 ; j<line.length; j++){
        //int count = 0;
        if(j!=i && line[i].equals(line[j])){
         // count++;
          duplicate = true;
        }

      }

      //System.out.println(duplicate);
    }
    if(duplicate == true){
      System.out.println("no");
    }
    else{
      System.out.println("yes");
    }

  }
}
