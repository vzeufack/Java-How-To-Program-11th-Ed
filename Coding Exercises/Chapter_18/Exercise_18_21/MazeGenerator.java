import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;

public class MazeGenerator {
  private static SecureRandom random = new SecureRandom();
  public static void main(String[] args) {
    char[][] maze = new char[12][12];
    int[][] entryAndExit = generate(maze);
    System.out.printf("Entry point: %d %d\nExit: %d %d\n", entryAndExit[0][0], entryAndExit[0][1], entryAndExit[1][0], entryAndExit[1][1]);
    print(maze);
  }

  public static int[][] generate(char[][] maze){
    int[] entry = getEntryPoint(maze);
    int[] exit = createPathToExit(maze, entry, entry);
    setSurroundingWall(maze);
    fillBlanks(maze);

    System.out.printf("Entry: %d %d | Exit: %d %d\n", entry[0], entry[1], exit[0], exit[1]);
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

  private static int[] getEntryPoint(char[][] maze){
    int numOfRows = maze.length;
    int numOfCols = maze[0].length;

    boolean coin = random.nextBoolean();
    int row, col;
    if(coin){
      row = random.nextInt(numOfRows-2) + 1;
      col = random.nextBoolean()? 0 : numOfCols-1;
      maze[row+1][col] = '#';
      maze[row-1][col] = '#';
    }
    else{
      row = random.nextBoolean()? 0 : numOfRows-1;
      col = random.nextInt(numOfCols-2) + 1;
      maze[row][col+1] = '#';
      maze[row][col-1] = '#';
    }

    int[] result = {row, col};
    return result;
  }

  private static void setSurroundingWall(char[][] maze){
    int numOfRows = maze.length;
    int numOfCols = maze[0].length;

    for(int i = 0; i < numOfRows; i++){
      if(maze[i][0] == '\u0000')
        maze[i][0] = maze[i][0] = '#';

      if(maze[i][numOfCols-1] == '\u0000')
        maze[i][numOfCols-1] = maze[i][numOfCols-1] = '#';
    }

    for(int j = 0; j < numOfCols; j++){
      if(maze[0][j] == '\u0000')
        maze[0][j] = maze[0][j] = '#';

      if(maze[numOfRows-1][j] == '\u0000')
        maze[numOfRows-1][j] = maze[numOfRows-1][j] = '#';
    }
  }

  private static void fillBlanks(char[][] maze){
    for(int i = 1; i < maze.length-1; i++){
      for(int j = 1; j < maze[i].length-1; j++){
        if(maze[i][j] == '\u0000')
          maze[i][j] = random.nextBoolean()?'.':'#';
      }
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
