import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;

public class MazeGenerator {
  public static void main(String[] args) {
    char[][] maze = new char[12][12];
    int[][] entryAndExit = generate(maze);
    System.out.printf("Entry point: %d %d\n Exit: %d %d\n", entryAndExit[0][0], entryAndExit[0][1], entryAndExit[1][0], entryAndExit[1][1]);
    print(maze);
  }

  public static int[][] generate(char[][] maze){
    int[] entry = {5, 0};
    maze[4][0] = '#';
    maze[6][0] = '#';
    int[] exit = createPathToExit(maze, entry, entry);
    int[][] entryAndExit = new int[2][2];
    entryAndExit[0] = entry;
    entryAndExit[1] = exit;
    return entryAndExit;
    /*
      randomly define an entry point
        toss a coin to choose
          row = random row and col = first or last
          or row = first or last and col = random

      block left or right or up or down

      from the entry, randomly create a path to the exit
        successively move forward until an exit is found
          from each position
            randomly move to one of the available positions
            if it leads to a dead end
              backup up

      complete the wall
      randomly set the blanks to dot or wall
     */
  }

  private static int[] createPathToExit(char[][] maze, int[] entryPoint, int[] currentPosition){
    if(currentPosition[0] < 0 || currentPosition[0] >= maze.length || currentPosition[1] < 0 || currentPosition[1] >= maze[0].length
      || maze[currentPosition[0]][currentPosition[1]] != '\u0000')
      return null;

    maze[currentPosition[0]][currentPosition[1]] = '.';
    //print(maze);

    if((currentPosition[0] == 0 || currentPosition[0] == maze.length-1 || currentPosition[1] == 0 || currentPosition[1] == maze[0].length-1) &&
      (currentPosition[0] != entryPoint[0] || currentPosition[1] != entryPoint[1]))
      return currentPosition;

    Integer[] directionsArray = {0,1,2,3};
    List<Integer> directions = Arrays.asList(directionsArray);
    Collections.shuffle(directions);

    int[] result = null;
    int[] newPos = new int[2];
    for(int i = 0; i < directions.size() && result == null; i++){
      if(directions.get(i) == 0){
        newPos[0] = currentPosition[0] - 1;
        newPos[1] = currentPosition[1];
      }
      else if(directions.get(i) == 1){
        newPos[0] = currentPosition[0] + 1;
        newPos[1] = currentPosition[1];
      }
      else if(directions.get(i) == 2){
        newPos[0] = currentPosition[0];
        newPos[1] = currentPosition[1] - 1;
      }
      else{
        newPos[0] = currentPosition[0];
        newPos[1] = currentPosition[1] + 1;
      }
      result = createPathToExit(maze, entryPoint, newPos);
    }

    if(result != null)
      return result;
    else {
      maze[currentPosition[0]][currentPosition[1]] = '\u0000';
      return null;
    }
  }

  private static void print(char[][] maze){
    for(char[] row: maze){
      for(char cell: row){
        System.out.printf("%2s", cell);
      }
      System.out.println();
    }
    System.out.println();
  }
}
