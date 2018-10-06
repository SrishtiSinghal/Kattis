import java.io.*;
import java.util.*;

public class Bishop{
  public static void main(String[] args){
    Scanner ob = new Scanner(System.in);
    while(ob.hasNext()){
      int size = ob.nextInt();
      if(size == 1){
        System.out.println(size);
      }
      else{
        System.out.println(2*size-2);
      }
    }
  }
}
