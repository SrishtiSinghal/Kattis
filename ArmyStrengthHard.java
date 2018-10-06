import java.util.*;
import java.io.*;

public class ArmyStrengthHard{

public static void main(String[] args) throws IOException{
  Reader read = new InputStreamReader(System.in);
  BufferedReader ob = new BufferedReader(read);
  String data = "'";
  data = ob.readLine();
  int num_cases = Integer.parseInt(data);
  for(int i = 0 ; i<num_cases; i++){
    data = ob.readLine();
    int n = Integer.parseInt(data);
    data = ob.readLine();
    int m = Integer.parseInt(data);

    int[] arr1 = new int[n];
    int[] arr2= new int[m];

    for(int j = 0 ; j<n ; j++){
      data = ob.readLine();
      arr1[j] = Integer.parseInt(data);
    }

    for(int j = 0; j<m ; j++){
      data = ob.readLine();
      arr2[j] = Integer.parseInt(data);
    }

    int high1 = arr1[0];
    int high2 = arr2[0];

    for(int j=1 ; j<n ; j++){
      if(arr1[j]>high1){
        high1 = arr1[j];
      }
    }

    for(int j=1; j<m; j++){
      if(arr2[j]>high2){
        high2 = arr2[j];
      }
    }
    if(high1 >= high2){
      System.out.println("Godzilla");
    }
    else if(high1<high2){
      System.out.println("MechaGodzilla");
    }
    else{
      System.out.println("uncertain");
    }
  }
}

}
