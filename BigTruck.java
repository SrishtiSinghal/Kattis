//Srishti Singhal

import java.util.*;
import java.io.*;

public class BigTruck{

  public static class GraphNode implements Comparable<GraphNode>{
    int currDistance;
    int num_items;
    int currLocation;

    GraphNode(int currDistance, int num_items, int currLocation){
      this.currDistance = currDistance;
      this.num_items = num_items;
      this.currLocation = currLocation;
    }

    public int compareTo(GraphNode object){
      if(this.currDistance < object.currDistance){
        return -1;
      }
      else if(this.currDistance == object.currDistance){
        if(this.num_items > object.num_items){
          return -1;
        }
        else{
          return 1;
        }
      }
      else{
        return 1;
      }
    }
  }

  public static void main(String[] args){

    Scanner ob = new Scanner(System.in);
    PriorityQueue<GraphNode> pQueue = new PriorityQueue<GraphNode>();
    int num_locations = ob.nextInt();

    int[][] arr = new int[num_locations][num_locations];
    ob.nextLine();

    int[] items = new int[num_locations];
    for(int i = 0; i<num_locations; i++){
        items[i] = ob.nextInt();
    }
    ob.nextLine();
    int num_roads = ob.nextInt();
    //System.out.println(num_roads);

    for(int j = 0 ; j<num_roads ; j++){
      ob.nextLine();
      int n1 = ob.nextInt()-1;
      int n2 = ob.nextInt()-1;
      int dis = ob.nextInt();

      arr[n1][n2] = dis;
      arr[n2][n1] = dis;

    }
    boolean[] visited = new boolean[num_locations]; //boolean array with only 0 or 1 values
    //visited[0] = true;

    pQueue.add(new GraphNode(0,items[0],0));

    GraphNode end = new GraphNode(-1,-1,num_locations-1);

    while(!pQueue.isEmpty()){
      GraphNode node1 = pQueue.poll();

      if(node1.currLocation == num_locations -1){
        end = node1;
        visited[node1.currLocation] = true;
        break;
      }
      if(visited[node1.currLocation]){
        continue;
      }
      //System.out.println(node1.currLocation + " " + node1.num_items);
      visited[node1.currLocation] =true;
      //int temp = 0;
      for(int i = 0; i<num_locations ; i++){
        if(visited[i] == false){
          if(arr[node1.currLocation][i]>0){
            //System.out.println(arr[no]);
            pQueue.add(new GraphNode(arr[node1.currLocation][i] + node1.currDistance, node1.num_items + items[i],i));
          }
        }
      }

    }
    if(visited[num_locations-1] == false){
      System.out.println("impossible");
    }
    else{
     System.out.println(end.currDistance + " " + end.num_items);
    }
  }
}
