package chap18;

import java.util.ArrayList;

/**
 * MazeTraversal App
 */
public class App 
{
   private static final String[] directions = {"down","left","up","right"};

   public static void main( String[] args ){

      char[][] maze = {{'#','#','#','#','#','#','#','#','#','#','#','#'},
                      {'#','.','.','.','#','.','.','.','.','.','.','#'},
                      {'.','.','#','.','#','.','#','#','#','#','.','#'},
                      {'#','#','#','.','#','.','.','.','.','#','.','#'},
                      {'#','.','.','.','.','#','#','#','.','#','.','.'},
                      {'#','#','#','#','.','#','.','#','.','#','.','#'},
                      {'#','.','.','#','.','#','.','#','.','#','.','#'},
                      {'#','#','.','#','.','#','.','#','.','#','.','#'},
                      {'#','.','.','.','.','.','.','.','.','#','.','#'},
                      {'#','#','#','#','#','#','.','#','#','#','.','#'},
                      {'#','.','.','.','.','.','.','#','.','.','.','#'},
                      {'#','#','#','#','#','#','#','#','#','#','#','#'}};
      
      Integer[] initialPosition = {2,0};
      mazeTraversal(maze, initialPosition, new ArrayList<Integer[]>());
   }

   /**
    * mazeTraversal
    */
   public static ArrayList<Integer[]> mazeTraversal(char[][] maze, Integer[] currentPosition, ArrayList<Integer[]> path){
      for (int i = 0; i < directions.length; i++){
         Integer[] newPosition = tryMove(maze, currentPosition, directions[i]);
         if (newPosition[0] != null){
            return move(maze, currentPosition, newPosition, path);
         }
      }

      return backUp(maze, currentPosition, path);
   }

   /**
    * tryMove: returns a valid position if moving in the given direction is possible
    */
   public static Integer[] tryMove(char[][] maze, Integer[] currentPosition, String direction){
      Integer[] newPosition = computeNewPosition(currentPosition, direction);
      //if exiting from start or there is an 0, # or x, do not allow move
      if((isOutOfBounds(newPosition, maze.length) && findX(maze, currentPosition)[0] == null) || (!isOutOfBounds(newPosition, maze.length)
         && (maze[newPosition[0]][newPosition[1]] == '0' || maze[newPosition[0]][newPosition[1]] == '#' || maze[newPosition[0]][newPosition[1]] == 'x'))){
            return new Integer[2];
      }
      else
         return newPosition;
   }

   /**
    * move towards a given direction
    */
   private static ArrayList<Integer[]> move(char[][] maze, Integer[] prevPosition, Integer[] newPosition, ArrayList<Integer[]> path){
      ArrayList<Integer[]> updatedPath = new ArrayList<>(path);
      updatedPath.add(prevPosition);

      char[][] updatedMaze = new char[maze.length][maze.length];
      for(int i = 0; i < maze.length; i++)
         updatedMaze[i] = maze[i].clone();

      updatedMaze[prevPosition[0]][prevPosition[1]] = 'x';
      displayMaze(updatedMaze);

      if(isOutOfBounds(newPosition, maze.length)) //if newPosition is an exit
         return updatedPath;
      else
         return mazeTraversal(updatedMaze, newPosition, updatedPath);
   }

   /**
    * backUp if there is no move available
    */
   private static ArrayList<Integer[]> backUp(char[][] maze, Integer[] prevPosition, ArrayList<Integer[]> path){
      Integer[] prevPrevPos = findX(maze, prevPosition);

      //maze update
      char[][] updatedMaze = new char[maze.length][maze.length];

      for(int i = 0; i < maze.length; i++)
         updatedMaze[i] = maze[i].clone();

      updatedMaze[prevPrevPos[0]][prevPrevPos[1]] = '.';
      updatedMaze[prevPosition[0]][prevPosition[1]] = '0';

      //path update
      ArrayList<Integer[]> updatedPath = path;
      updatedPath.remove(path.size() - 1);

      return mazeTraversal(updatedMaze, prevPrevPos, updatedPath);
   }

   /**
    * computes the new position given a direction and the current position
    */
   public static Integer[] computeNewPosition(Integer[] currentPosition, String direction){
      Integer[] newPosition = new Integer[2];
      System.arraycopy(currentPosition, 0, newPosition, 0, currentPosition.length);
      
      switch(direction){
         case "down":
            newPosition[0] = newPosition[0] + 1;
            break;
         case "left":
            newPosition[1] = newPosition[1] - 1;
            break;
         case "up":
            newPosition[0] = newPosition[0] - 1;
            break;
         case "right":
            newPosition[1] = newPosition[1] + 1;
            break;
         default:
            return new Integer[2];
      }
      return newPosition;
   }
   
   /**
    * determines if position is out of bounds
    */
   public static boolean isOutOfBounds(Integer[] position, int mazeSize){
      return (position[0] < 0 || position[0] >= mazeSize || position[1] < 0 || position[1] >= mazeSize);
   }

   /**
    * determines the previous position from a given position
    */
   public static Integer[] findX(char[][] maze, Integer[] position){
      for (int i = 0; i < directions.length; i++){
        Integer[] newPosition = computeNewPosition(position, directions[i]);
        if (!isOutOfBounds(newPosition, maze.length) && maze[newPosition[0]][newPosition[1]] == 'x')
           return newPosition;
      }
      return new Integer[2];
   }
  
  /**
   * displays the maze
   */
   private static void displayMaze (char[][] maze){
      for (int i = 0; i < maze.length; i++){
         for (int j = 0; j < maze[i].length; j++){
           System.out.print(maze[i][j] + " ");
         }
         System.out.println();
      }
      
      System.out.println();
  }
}
