import java.util.Scanner;

public class ArmyStrength{

public static void main(String[] args){
  Scanner ob = new Scanner(System.in);
  int num_cases = ob.nextInt();
  for(int i = 0 ; i<num_cases ; i++){
    int n = ob.nextInt();
    int m = ob.nextInt();
    int[] arr1 = new int[n];
    int[] arr2= new int[m];

    for(int j = 0 ; j<n ; j++){
      arr1[j] = ob.nextInt();
    }

    for(int j = 0; j<m ; j++){
      arr2[j] = ob.nextInt();
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
