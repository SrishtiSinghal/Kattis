//Srishti Singhal

import java.io.*;
import java.util.*;

public class Diner{
  public static void main(String[] args){

    Scanner ob = new Scanner(System.in);
    while(ob.hasNextInt()){

      int count = ob.nextInt();
      TreeMap<String,ArrayList<String>> rbTree = new TreeMap<String,ArrayList<String>>();
      ArrayList<String> list = new ArrayList<String>();

      if(count == 0){
        break;
      }

      for(int i = 0; i<count ; i++){
        String name = ob.next();
        String[] lines = ob.nextLine().substring(1).split(" ");
        for(int j = 0;  j<lines.length; j++){
          if(!rbTree.containsKey(lines[j])){
            ArrayList<String> in = new ArrayList<>();
            in.add(name);
            rbTree.put(lines[j],in);
          }
          else{
            ArrayList<String> in = rbTree.get(lines[j]);
            in.add(name);
            rbTree.put(lines[j],in);
          }
        }
      }
      for (Map.Entry<String, ArrayList<String>> entry : rbTree.entrySet()) {
        String key = entry.getKey();
        ArrayList<String> value = entry.getValue();
        Collections.sort(value);
        System.out.print(key);
        String values = "";
        for(String val: value){
          values += " "+val;
        }
        System.out.println(values);
      }

      System.out.println();
    }
  }
}
