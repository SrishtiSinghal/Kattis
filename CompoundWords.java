import java.io.*;
import java.util.*;

public class CompoundWords{
  public static void main(String[] args){
    ArrayList<String> words = new ArrayList<String>();
    TreeSet<String> combinations = new TreeSet<String>();
    Scanner ob = new Scanner(System.in);
    while(ob.hasNext())
    {
      words.add(ob.next());
    }
    //String[] combinations = new String[1000];
    for(int i = 0 ; i<words.size(); i++){
      for(int j = 0; j<words.size(); j++){
        if(i!=j){
          combinations.add(words.get(i) + words.get(j));
        }
      }
    }
    for(String s: combinations){
      System.out.println(s);
    }
  }
}
