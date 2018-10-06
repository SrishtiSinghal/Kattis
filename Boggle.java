import java.util.*;
import java.io.*;

public class Boggle{

  static char[][] maze;

  public static boolean maze_solver(int x, int y , String word, int pos){

    int[]  x_arr = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] y_arr = {-1, 0, 1, -1, 1, -1, 0, 1};

    if(pos == word.length()){
      return true;
    }
    char temp =  maze[x][y];
    maze[x][y] = '/';

    boolean answer  = false;

    for(int i = 0; i<8; i++){
      int adj_x = x + x_arr[i];
      int adj_y = y + y_arr[i];

      if ((0 <= adj_x && adj_x <4) && (0 <= adj_y && adj_y < 4) && maze[adj_x][adj_y] == word.charAt(pos)) {
        if(answer == false){
          answer = answer || maze_solver(adj_x, adj_y, word, pos + 1);
        }
        else{
          break;
        }
      }

    }
    maze[x][y] = temp;
    return answer;
  }

  public static void main(String[] args) throws Exception{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num_words = Integer.parseInt(br.readLine());
    int[] scores = {0,0,0,1,1,2,3,5,11};
    String[] dic_words = new String[num_words];

    for(int i = 0 ; i<num_words; i++){
      dic_words[i] = br.readLine();
    }

    br.readLine();

    int num_boards = Integer.parseInt(br.readLine());

    while(num_boards!=0){

      maze = new char[4][4];
      Set<String> words_found = new HashSet<String>();

      for(int j = 0 ; j<4 ; j++){
        maze[j] = br.readLine().toCharArray();
      }

      for(String word : dic_words){
        for(int i = 0 ; i<4; i++){
          for(int j = 0; j<4 ; j++){
            if(words_found.contains(word)){
              i = 4;
              break;
            }
            if(maze[i][j] == word.charAt(0)){
              if(maze_solver(i,j,word,1)){
                words_found.add(word);
              }
            }
          }
        }
      }
      int count = words_found.size();
      int score  = 0;
      String longest_words = "";

      for(String word : words_found){
        if(word.length() > longest_words.length() || word.length() == longest_words.length() && word.compareTo(longest_words)<0){
          longest_words = word;
        }
        score = score + scores[word.length()];
      }

      --num_boards;

      if(num_boards>0){
        br.readLine();
      }

      System.out.println(score + " " + longest_words + " " + count);

    }

  }
}
