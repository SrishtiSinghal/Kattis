
import java.util.*;
import java.io.*;

public class CookieSelection{

  public static void main(String[] args){

    PriorityQueue<Integer> pQueue1 = new PriorityQueue<Integer>(Collections.reverseOrder());
    PriorityQueue<Integer> pQueue2 = new PriorityQueue<Integer>();
    Reader read = new InputStreamReader(System.in);
    BufferedReader ob = new BufferedReader(read);
    String data = "'";
    int median = 0;
    try{
      data = ob.readLine();
    }
    catch(Exception e){
    }
    median = Integer.parseInt(data);
    while(true){
      try{
        data = ob.readLine();
        int temp = Integer.parseInt(data);
        if(temp > median){
         pQueue2.add(temp);
        }
        else{
          pQueue1.add(temp);
        }
        if(pQueue1.size()<pQueue2.size()){
          pQueue1.add(median);
          median = pQueue2.poll();
        }
        else if(pQueue2.size()<pQueue1.size() - 1){
          pQueue2.add(median);
          median = pQueue1.poll();
        }
      }
      catch(Exception e){

          if(data == null){
            break;
          }


        System.out.println(median);

        if(pQueue1.size() == 0){
          median = -1;
        }

        else if(pQueue1.size() == pQueue2.size()){

          median = pQueue2.poll();

        }

        else if(pQueue1.size()>pQueue2.size()){
          median = pQueue1.poll();
        }
      }
    }


  }
}
