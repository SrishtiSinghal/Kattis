import java.io.*;
import java.util.*;
//import static java.lang.Math.pow;

public class PrinterStatues{
  public static void main(String[] args){
    Scanner ob = new Scanner(System.in);
    int items = ob.nextInt();
    int printers = 1;
    int itemsprinted = 0;
    int days = 0;

    while(itemsprinted < items){
      if(items-itemsprinted > printers){
        days += 1;
        printers += printers;
      }
      else{
        days += 1;
        itemsprinted += printers;
      }
    }
    System.out.println(days);
  }
}

// items = 5 itemsprinted = 0 printers = 1

//
