import java.util.ArrayList;

/**
 * @author Vannel Zeufack 2/12/2019     
 */
public class EightQueen{
    
    final static int NUMBER_OF_ROWS = 8;
    final static int NUMBER_OF_COLUMNS = 8;
    private static Square [][] chessboard = new Square[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
    private static int [] countPossibilities = new int [8];
    
    /**
    * main method
    *
    * @param args
    */
    public static void main (String [] agrs){         
        int count;
        ArrayList <Square> [] listOf2Positions, listOf3Positions, listOf4Positions, listOf5Positions, listOf6Positions, listOf7Positions, listOf8Positions;
        Square [] pivot;
        
        //final long start = System.nanoTime();
         
        for (int i = 0; i < NUMBER_OF_ROWS; i++){
            for (int j = 0; j < NUMBER_OF_COLUMNS; j++){
                chessboard[i][j] = new Square(i,j, initEliminationNumber(i,j) + "");
            }
        } 
        
        //two queens
        count = 0;
        listOf2Positions = new ArrayList [64];
        for (int i = 0; i < NUMBER_OF_ROWS; i++){
            for (int j = 0; j < NUMBER_OF_COLUMNS; j++){
                pivot = new Square [1];
                pivot[0] = chessboard[i][j];
                listOf2Positions[count++] = getListOfPossiblePositions(pivot);
            }
        }
        //System.out.println("Number of possibilities = " + countPossibilities[0]);
        //printList (listOf2Positions);
        
        //3 queens      
        count = 0;
        listOf3Positions = new ArrayList [countPossibilities[0]];        
        for (int i = 0; i < listOf2Positions.length; i++){
            for (int j = 1; j < listOf2Positions[i].size(); j++){
                 pivot = new Square [2];
                 pivot[0] = listOf2Positions[i].get(0);
                 pivot[1] = listOf2Positions[i].get(j);
                 listOf3Positions[count++] = getListOfPossiblePositions(pivot);
            }
        }
        //System.out.println("Number of possibilities = " + countPossibilities[1]);
        //printList (listOf3Positions);
        
        //4 queens      
        count = 0;
        listOf4Positions = new ArrayList [countPossibilities[1]];        
        for (int i = 0; i < listOf3Positions.length; i++){
            for (int j = 2; j < listOf3Positions[i].size(); j++){
                 pivot = new Square [3];
                 pivot[0] = listOf3Positions[i].get(0);
                 pivot[1] = listOf3Positions[i].get(1);
                 pivot[2] = listOf3Positions[i].get(j);
                 listOf4Positions[count++] = getListOfPossiblePositions(pivot);
            }
        }
        //System.out.println("Number of possibilities = " + countPossibilities[2]);
        //printList (listOf4Positions);
        
        //5 queens      
        count = 0;
        listOf5Positions = new ArrayList [countPossibilities[2]];        
        for (int i = 0; i < listOf4Positions.length; i++){
            for (int j = 3; j < listOf4Positions[i].size(); j++){
                 pivot = new Square [4];
                 pivot[0] = listOf4Positions[i].get(0);
                 pivot[1] = listOf4Positions[i].get(1);
                 pivot[2] = listOf4Positions[i].get(2);
                 pivot[3] = listOf4Positions[i].get(j);
                 listOf5Positions[count++] = getListOfPossiblePositions(pivot);
            }
        }
        //System.out.println("Number of possibilities = " + countPossibilities[3]);
        //printList (listOf5Positions);
        
        //6 queens      
        count = 0;
        listOf6Positions = new ArrayList [countPossibilities[3]];        
        for (int i = 0; i < listOf5Positions.length; i++){
            for (int j = 4; j < listOf5Positions[i].size(); j++){
                 pivot = new Square [5];
                 pivot[0] = listOf5Positions[i].get(0);
                 pivot[1] = listOf5Positions[i].get(1);
                 pivot[2] = listOf5Positions[i].get(2);
                 pivot[3] = listOf5Positions[i].get(3);
                 pivot[4] = listOf5Positions[i].get(j);
                 listOf6Positions[count++] = getListOfPossiblePositions(pivot);
            }
        }        
        //printList (listOf6Positions);
        //System.out.println("Number of possibilities = " + countPossibilities[4]);
             
        //final long end = System.nanoTime();
        //System.out.println("Took: " + (end - start)/ 1000000000 + " seconds");
        
        //7 queens      
        count = 0;
        listOf7Positions = new ArrayList [countPossibilities[4]];       
        for (int i = 0; i < listOf6Positions.length; i++){
            for (int j = 5; listOf6Positions[i] != null && j < listOf6Positions[i].size(); j++){
                 pivot = new Square [6];
                 pivot[0] = listOf6Positions[i].get(0);
                 pivot[1] = listOf6Positions[i].get(1);
                 pivot[2] = listOf6Positions[i].get(2);
                 pivot[3] = listOf6Positions[i].get(3);
                 pivot[4] = listOf6Positions[i].get(4);
                 pivot[5] = listOf6Positions[i].get(j);
                 listOf7Positions[count++] = getListOfPossiblePositions(pivot);
            }
        }        
        //printList (listOf7Positions);
        //System.out.println("Number of possibilities = " + countPossibilities[5]);
        
        //8 queens      
        count = 0;
        listOf8Positions = new ArrayList [countPossibilities[5]];        
        for (int i = 0; i < listOf7Positions.length; i++){
            for (int j = 6; listOf7Positions[i] != null && j < listOf7Positions[i].size(); j++){
                 pivot = new Square [7];
                 pivot[0] = listOf7Positions[i].get(0);
                 pivot[1] = listOf7Positions[i].get(1);
                 pivot[2] = listOf7Positions[i].get(2);
                 pivot[3] = listOf7Positions[i].get(3);
                 pivot[4] = listOf7Positions[i].get(4);
                 pivot[5] = listOf7Positions[i].get(5);
                 pivot[6] = listOf7Positions[i].get(j);
                 listOf8Positions[count++] = getListOfPossiblePositions(pivot);
            }
        }        
        printList (listOf8Positions);
        System.out.println("Number of possibilities = " + countPossibilities[6]);
                                 
    }// end main method
    
    /**
      * Test method
      */
     private static void test(){
         //test getLeastElimSquare         
         /*for (int j = 0; j < NUMBER_OF_COLUMNS; j++){
             chessboard[0][j] = "x";
         }
         chessboard[1][0] = "+";
         chessboard[1][7] = "24"; 
         System.out.printf("%d %d\n", getLeastElimSquare()[0], getLeastElimSquare()[1]);*/
         /*int [] square = {4,4};
         markEliminatedSquares(square); 
         display();*/
         /*int [] p1 = {2,1};
         int [] p2 = {5,4};
         System.out.printf("%s\n", isAttacking(p1,p2)); 
         
         
        for (int i = 0; i < 64; i++){
            for (int j = 0; j < listOfPossiblePairsPositions[i].size(); j++){
                System.out.printf("%s ", listOfPossiblePairsPositions[i].get(j));
            } 
            System.out.println();
        }*/ 
     }

    
    /**
     * computes the number of squares eliminated by a queen if the chessboard is empty and 
     * the queen is at position (row, column)
     *
     * @param row        the queen's row
     * @param column     the queen's column
     * @return           the number of squares eliminated
     */
    public static int initEliminationNumber (int row, int column){
        int numberOfSquaresEliminated = 0;
        numberOfSquaresEliminated += countSquaresEliminatedHorizontally (row, column);
        numberOfSquaresEliminated += countSquaresEliminatedVertically (row, column);
        numberOfSquaresEliminated += countSquaresEliminatedDiagonally (row, column);
                
        return numberOfSquaresEliminated + 1;
    }
    
    /**
     * Computes the number of squares eliminated horizontally by a queen 
     * if the chessboard is empty and the queen is at position (row, column)
     *
     * @param row        the queen's row
     * @param column     the queen's column
     * @return           the number of squares eliminated
     */
    private static int countSquaresEliminatedHorizontally(int row, int column){
        int numberOfSquaresEliminated = 0;
        
        for (int j = column + 1; j < NUMBER_OF_COLUMNS; j++){
            numberOfSquaresEliminated++;
        }
        
        for (int j = column - 1; j >= 0; j--){
            numberOfSquaresEliminated++;
        }
        
        return numberOfSquaresEliminated;
    }   
     
    /**
     * Computes the number of squares eliminated vertically by a queen 
     * if the chessboard is empty and the queen is at position (row, column)
     *
     * @param row        the queen's row
     * @param column     the queen's column
     * @return           the number of squares eliminated
     */
    private static int countSquaresEliminatedVertically (int row, int column){
        int numberOfSquaresEliminated = 0;
    
        for (int i = row - 1; i >= 0; i--){
            numberOfSquaresEliminated++;
        }
        
        for (int i = row + 1; i < NUMBER_OF_ROWS; i++){
            numberOfSquaresEliminated++;
        }
        
        return numberOfSquaresEliminated;
    }    
    
    /**
     * Computes the number of squares eliminated diagonally by a queen 
     * if the chessboard is empty and the queen is at position (row, column)
     *
     * @param row        the queen's row
     * @param column     the queen's column
     * @return           the number of squares eliminated
     */
    public static int countSquaresEliminatedDiagonally (int row, int column){
        int numberOfSquaresEliminated = 0;
        numberOfSquaresEliminated += countSquaresEliminatedDiagonally1 (row,column);
        numberOfSquaresEliminated += countSquaresEliminatedDiagonally2 (row,column);
        return numberOfSquaresEliminated;
    }
    
    /**
     * Computes the number of squares eliminated on the first diagonal by a queen 
     * if the chessboard is empty and the queen is at position (row, column)
     *
     * @param row        the queen's row
     * @param column     the queen's column
     * @return           the number of squares eliminated
     */
    public static int countSquaresEliminatedDiagonally1 (int row, int column){
        int numberOfSquaresEliminated = 0;
        int i = row - 1;
        int j = column + 1;
        
        while (i >= 0 && j < NUMBER_OF_COLUMNS){
            numberOfSquaresEliminated++;
            i--;
            j++;
        }
        
        i = row + 1;
        j = column - 1;
        while (i < NUMBER_OF_ROWS && j >= 0){
            numberOfSquaresEliminated++;
            i++;
            j--;
        }

        return numberOfSquaresEliminated;
    }
    
    /**
     * Computes the number of squares eliminated on the second diagonal by a queen 
     * if the chessboard is empty and the queen is at position (row, column)
     *
     * @param row        the queen's row
     * @param column     the queen's column
     * @return           the number of squares eliminated
     */
    public static int countSquaresEliminatedDiagonally2 (int row, int column){
        int numberOfSquaresEliminated = 0;
        int i = row - 1;
        int j = column - 1;
        
        while (i >= 0 && j >= 0){
            numberOfSquaresEliminated++;
            i--;
            j--;
        }
        
        i = row + 1;
        j = column + 1;
        while (i < NUMBER_OF_ROWS && j < NUMBER_OF_COLUMNS){
            numberOfSquaresEliminated++;
            i++;
            j++;
        }

        return numberOfSquaresEliminated;
    }    
        
    /**
     * Determines the square at which a queen would eliminate
     * the least amount of squares compared to all other accessible squares 
     *
     * @return    the square with the least elimination number
     */
    private static int [] getLeastElimSquare(){
        int [] leastElimSquare = new int [2];
        int minElimationNumber = 50;
        int currentElimNumber;
        int i,j;
        
        for (i = 0; i < NUMBER_OF_ROWS; i++){
             for (j = 0; j < NUMBER_OF_COLUMNS; j++){
                 try{
                    currentElimNumber = Integer.parseInt(chessboard[i][j].getElimNumber());
                    if (!chessboard[i][j].equals("x") && !chessboard[i][j].equals("O") && currentElimNumber < minElimationNumber){
                         minElimationNumber = currentElimNumber;
                         leastElimSquare[0] = i;
                         leastElimSquare[1] = j;      
                    }
                 }
                 catch (NumberFormatException nfe){
                 
                 }             
             }
        } 
        
        if (minElimationNumber == 50)
            return null;
        else
            return leastElimSquare;
    }
    
    /**
     * displays the chessboard
     */
     public static void display(){
         for (int i = 0; i < NUMBER_OF_ROWS; i++){
             for (int j = 0; j < NUMBER_OF_COLUMNS; j++){
                 System.out.printf("%3s", chessboard[i][j].getElimNumber());
             }
             System.out.println();
         }
     }
          
     /**
      * Mark the squares eliminated by the queen
      *
      * @param the position of the queen
      */
     private static void markEliminatedSquares (int [] square){
         markEliminatedSquaresHV(square);
         markEliminatedSquaresD(square);
     }
     
     /**
      * Mark the squares eliminated horizontally and vertically by the queen
      *
      * @param the position of the queen
      */
     private static void markEliminatedSquaresHV (int [] square){
         int row = square[0];
         int col = square[1];
         
         for (int i = row + 1; i < NUMBER_OF_ROWS; i++){
             chessboard[i][col].setElimNumber("x");
         }
         
         for (int i = row - 1; i >= 0; i--){
             chessboard[i][col].setElimNumber("x");
         }
         
         for (int j = col + 1; j < NUMBER_OF_COLUMNS; j++){
             chessboard[row][j].setElimNumber("x");
         }
         
         for (int j = col - 1; j >= 0; j--){
             chessboard[row][j].setElimNumber("x");
         }
     }
     
     /**
      * Mark the squares eliminated diagonally by the queen
      *
      * @param the position of the queen
      */
     private static void markEliminatedSquaresD (int [] square){
        int row = square[0];
        int column = square[1];
        int i = row - 1;
        int j = column + 1;
        
        while (i >= 0 && j < NUMBER_OF_COLUMNS){
            chessboard[i][j].setElimNumber("x");
            i--;
            j++;
        }
        
        i = row + 1;
        j = column - 1;
        while (i < NUMBER_OF_ROWS && j >= 0){
            chessboard[i][j].setElimNumber("x");
            i++;
            j--;
        }
        
        i = row - 1;
        j = column - 1;        
        while (i >= 0 && j >= 0){
            chessboard[i][j].setElimNumber("x");
            i--;
            j--;
        }
        
        i = row + 1;
        j = column + 1;
        while (i < NUMBER_OF_ROWS && j < NUMBER_OF_COLUMNS){
            chessboard[i][j].setElimNumber("x");
            i++;
            j++;
        }
     }
     
     /**
      * checks if two queens respectively at position p1 and p2 attack each other
      * 
      * @param the first queen's position
      * @param the second queen's position
      * @return true if the queens attack each other, false otherwise
      */
      private static boolean isAttacking (Square p1, Square p2){
          int r1 = p1.getRow();
          int c1 = p1.getCol();
          int r2 = p2.getRow();
          int c2 = p2.getCol();
          
          if (r1 == r2 || c1 == c2 || Math.abs(r1-r2) == Math.abs(c1-c2))
              return true;
          
          return false;
      }
      
      /**
       * get the list of positions occupied by two non-attacking queens
       *
       * @param the reference square
       * @return the list of squares on which a queen won't attack another queen placed at the reference square
       */
      private static ArrayList <Square> getListOfPossiblePairsPositions(Square pivot){
          ArrayList <Square> listOfPossiblePairsPositions = new ArrayList <Square>();
          listOfPossiblePairsPositions.add(pivot);
          
          for (int i = 0; i < NUMBER_OF_ROWS; i++){
             for (int j = 0; j < NUMBER_OF_COLUMNS; j++){                 
                 if (!isAttacking(pivot, chessboard[i][j])){                   
                     listOfPossiblePairsPositions.add(chessboard[i][j]);
                     countPossibilities[0]++;
                 }
             }
          }
          return listOfPossiblePairsPositions;
      }      
      
      /**
       * get the list of positions occupied by three non-attacking queens
       *
       * @param the two reference squares
       * @return the list of squares on which a queen won't attack another the two others queens
       */
      private static ArrayList <Square> getListOfPossible3Positions (Square s1, Square s2){
           ArrayList <Square> listOfPossible3Positions = new ArrayList <Square>();
           listOfPossible3Positions.add(s1);
           listOfPossible3Positions.add(s2);
                      
           for (int i = 0; i < NUMBER_OF_ROWS; i++){
             for (int j = 0; j < NUMBER_OF_COLUMNS; j++){                 
                 if (!isAttacking(s1, chessboard[i][j]) && !isAttacking(s2, chessboard[i][j])){                   
                     listOfPossible3Positions.add(chessboard[i][j]);
                     countPossibilities[1]++;
                 }
             }
           }
           return listOfPossible3Positions;
      }
      
      /**
       * get the list of positions occupied by non-attacking queens
       *
       * @param reference squares
       * @return the list of squares on which a queen won't attack another queens on other positions
       */
      private static ArrayList <Square> getListOfPossiblePositions (Square [] refSquares){
           ArrayList <Square> listOfPossiblePositions = new ArrayList <Square>();
           boolean isNotAttacking = true;
           int countIndex = refSquares.length - 1;
           
           for (int i = 0; i < refSquares.length; i++){
               listOfPossiblePositions.add(refSquares[i]);
           }
                      
           for (int i = 0; i < NUMBER_OF_ROWS; i++){
             for (int j = 0; j < NUMBER_OF_COLUMNS; j++){
                 isNotAttacking = true;               
                 for (int k = 0; k < refSquares.length && isNotAttacking; k++){
                     if (isAttacking(refSquares[k], chessboard[i][j]))
                         isNotAttacking = false;
                 }
                 if (isNotAttacking){
                     listOfPossiblePositions.add(chessboard[i][j]);
                     countPossibilities[countIndex]++;
                 }
             }
           }
           
           if (listOfPossiblePositions.size() == refSquares.length){
               return null;
           }
           return listOfPossiblePositions;
      }  
      
      /**
       * prints the list of positions occupied by non attacking queens
       *
       * @param list of positions
       */
      private static void printList (ArrayList <Square> [] listOfPositions){
          for (int i = 0; i < listOfPositions.length; i++){
            if (listOfPositions[i] != null){
               for (int j = 0; j < listOfPositions[i].size(); j++){
                   System.out.printf("%s ",listOfPositions[i].get(j) );
               }
               System.out.println();
            }
        }
      }    
}