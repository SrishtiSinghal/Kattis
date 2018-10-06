import java.io.*;
import java.util.*;

public class OddManOut{
   public static void main(String[] args){
    Scanner ob = new Scanner(System.in);
    int testCases = ob.nextInt();
    ob.nextLine();
    for(int i = 1; i<=testCases ; i++){
      int num = ob.nextInt();
      ob.nextLine();
      HashMap<String,Integer> hash = new HashMap<String,Integer>();
      String[] line = ob.nextLine().split(" ");
      for(int j = 0; j<num ; j++){
        hash.put(line[j],hash.containsKey(line[j])? 2:1);
      }
      for(int j = 0; j<num; j++){
        if(hash.get(line[j])==1){
          System.out.println("Case #"+i+": "+line[j]);
        }
      }
    }
  }
}
