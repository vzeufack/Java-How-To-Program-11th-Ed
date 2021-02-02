//implements a tic tac toe game
public class TicTacToe2{
   //private enum CellValue{X, O, EMPTY};
   private CellValue[][] board = new CellValue[3][3];
      
   //constructor
   public TicTacToe2(){
      for (int i = 0; i < board.length; i++){
         for (int j = 0; j < board[i].length; j++){
             board[i][j] = CellValue.EMPTY;
         }
      }
   }
   
   //returns the board
   private CellValue[][] getBoard(){
      return board;
   }
   
   //sets the value of a board's cell
   private void setBoard(int row, int col, CellValue value){
      this.board[row][col] = value;
   }
   
   //starts the game
   public void start(){
      //Game title
      System.out.printf("***** Tic Tac Toe Version 1.0 *****\n\n");
      System.out.printf("How to play: to mark a cell, enter the cell value. Cell values range from 1 to 9 as shown below\n");
      displayReferenceBoard();
      System.out.println();         
      
      int gameMode;      
      
      //play until player wants to stop
      do{
         //choose game mode (vs human or vs computer)         
         System.out.printf("%s\n%s\n%s\n%s\n%s", "Menu:", "1- Play against Human", "2- Play against Computer", "3- Stop", "Enter 1, 2 or 3 > ");
         do{
            gameMode = read.nextInt();
            if (gameMode != 1 && gameMode != 2 && gameMode != 3){
               System.out.print("Please, enter 1, 2 or 3 > ");
            }
         }while (gameMode != 1 && gameMode != 2 && gameMode != 3);
         
         play (gameMode);         
      }while(gameMode != 3);
      
      //display Good Bye Message
      System.out.println("\n***** Thank you for playing! *****");  
   }
   
   //plays a game depending on the game mode
   private void play (int gameMode){
       //set player 1 and player 2
       Player player1, player2;
       if (gameMode == 1){
           player1 = new Player(1, false);
           player2 = new Player(2, false);
       }
       else{
           System.out.print("Do you want to start (y/n)>");
           answer = read.next().charAt(0);
           if (answer == 'y'){
               player1 = new Player(1, false);
               player2 = new Player(2, true);
           }
           else{
               player1 = new Player(1, true);
               player2 = new Player(2, false);   
           }        
       }
      
       //play 
       while(!(thereIsWin() || thereIsDraw())){
           player1.move(board);
           displayBoard();
           if (!(thereIsWin() || thereIsDraw()))
               player2.move(board);
               displayBoard();
       }
   }
   
   private void displayReferenceBoard(){
   
   }
}