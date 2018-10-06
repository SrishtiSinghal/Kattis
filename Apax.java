import java.util.Scanner;

public class Apax{
  public static void main(String[] args){
    Scanner ob = new Scanner(System.in);
    String line = ob.nextLine();
    String[] arr = new String[line.length()];
    arr = line.split("");

    for(int i = 0 ; i<arr.length ; i++){
      for(int j = i+1 ; j<arr.length ; j++){
        if(arr[i].compareTo(arr[j]) == 0){
          arr[j] =  "";
        }
        else{
          break;
        }
      }
    }
    String fin  = "";
    for(int i = 0; i < arr.length; i++){
      if(arr[i].compareTo("")!=0){
        fin = fin + arr[i];
      }
    //  System.out.println(fin);
    }
    System.out.println(fin);
  }
}
