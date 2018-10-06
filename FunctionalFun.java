//Srishti Singhal

import java.util.*;

public class FunctionalFun{
  public static void main(String[] args){
    Scanner ob = new Scanner(System.in);
    while(ob.hasNextLine()){
      TreeMap<String, String> map = new TreeMap<>();
      TreeMap<String, Integer> codomain_map = new TreeMap<>();

      String[] domain = ob.nextLine().split("\\s");
      String[] codomain = ob.nextLine().split("\\s");


      for(int j = 1; j<codomain.length; j++){
          codomain_map.put(codomain[j],0);

      }

      int num_mappings = ob.nextInt();
      ob.nextLine();
      int inject = 1;
      int surject = 1;
      int temp = 0;
      boolean var = false;
      //int var = 0;
      for(int i = 0; i<num_mappings; i++){
        String[] mappings = ob.nextLine().split("\\s");

        if(map.containsKey(mappings[0])){
          if(!map.get(mappings[0]).equals(mappings[2])){
            var = true;
            inject = 2;
          }
        }
        else{
          temp = codomain_map.get(mappings[2]);
          codomain_map.put(mappings[2],temp+1);
          map.put(mappings[0],mappings[2]);
        }
      }
      if(var == true){
        System.out.println("not a function");
      }
      int val = 0;
      if(inject!=2){
        for(int m = 1; m<codomain.length; m++){
        //  System.out.println(codomain_map);
          val = codomain_map.get(codomain[m]);
          if(val>1){
            inject = 0;
          }
          if(val == 0){
            surject = 0;
          }
        }


        if(inject == 1 && surject == 1){
          System.out.println("bijective");
        }
        else if(inject == 1 && surject == 0){
          System.out.println("injective");
        }
        else if(inject == 0 && surject ==1){
          System.out.println("surjective");
        }
        else if (inject == 0 && surject ==0){
          System.out.println("neither injective nor surjective");
        }
      }
   }
  }
}
