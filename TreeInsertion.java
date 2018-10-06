import java.math.BigInteger;
import java.util.Scanner;
import java.math.*;

public class TreeInsertion{

  public static Node root;

  private class Node{
    int data;
    Node left;
    Node right;
    public Node(int data){
      this.data = data;
      left = null;
      right = null;
    }
  }

  public TreeInsertion(){
    this.root  = null;
  }

  public void insert(int id){
    Node newNode = new Node(id);
   // System.out.println("Creating new node:");
    if(root==null){
      root = newNode;
      return;
    }
    Node current = root;
    Node parent = null;
    while(true){
      parent = current;
      if(id<current.data){
        current = current.left;
        if(current==null){
          parent.left = newNode;
          return;
        }
      }else{
        current = current.right;
        if(current==null){
          parent.right = newNode;
          return;
        }
      }
    }
  }

  public static BigInteger countInsertionOrdering(Node t){

    if(t == null){
      return BigInteger.ONE;
    }
    int m = numElementsIn(t.left);
    //System.out.println("at " + t.data);
    int n = numElementsIn(t.right);

    return (countInsertionOrdering(t.left).multiply(binomial_coefficient(m + n, n))).multiply(countInsertionOrdering(t.right));

  }

  public static int numElementsIn(Node n){
    //System.out.println("second print statement");
    int count = 0;
    if(n == null){
    //  System.out.println(count);
      return count;

    }
    else{

      count = 1 + numElementsIn(n.left) + numElementsIn(n.right);
      //System.out.println(count);
      return count;
    }

  }

  public static BigInteger binomial_coefficient(int n , int k){
    if(k >= n/2)
      k = n - k;
    return SeqMultiply(n -k , n).divide(SeqMultiply(0, k));
  }

  public static BigInteger SeqMultiply(int min, int max){
    BigInteger initially = BigInteger.ONE;
    for(int i = min; ++i <= max;){
      initially = initially.multiply(BigInteger.valueOf(i));
    }
    return initially;
  }

  public static TreeInsertion tree = new TreeInsertion();

  public static void main(String[] args){

    Scanner ob = new Scanner(System.in);
    while(ob.hasNextInt()){
      //TreeInsertion tree = new TreeInsertion();
      int count = ob.nextInt();
      ob.nextLine();
      if(count == 0){
        break;
      }
      int[] arr = new int[count];
      for(int i = 0; i<count ; i++){
        arr[i] = ob.nextInt();
        tree.insert(arr[i]);
      }
      //System.out.println(binomial_coefficient(0, 0).toString());
      System.out.println(countInsertionOrdering(tree.root));
      tree.root = null;
    }
    //System.out.println(binomial_coefficient(30,15).toString());
  }

}




