/**
 * TicTacToe Front End
 */
public class TicTacToeTest{
   public static void main (String [] args){
      TicTacToe game = new TicTacToe();
      game.start();
      
      /*CellValue[][] board = new CellValue[3][3];
      board[0][0] = CellValue.X;
      board[0][1] = CellValue.O;
      board[0][2] = CellValue.O;
      board[1][0] = CellValue.O;
      board[1][1] = CellValue.X;
      board[1][2] = CellValue.X;
      board[2][0] = CellValue.EMPTY;
      board[2][1] = CellValue.X;
      board[2][2] = CellValue.O;
      
      int [] move = {0,0};
      System.out.println(game.thereIsDraw(board, move, 2, 1));*/
      //Game header
      /*System.out.printf("***** Tic Tac Toe Version 1.0 *****\n\n");
        
      //Tutorial
      displayTutorial();
      System.out.println();         
      
      int opponent;      
      
      do{
          displayMenu();           
          //opponent selection
          do{
              opponent = read.nextInt();
              if (opponent != 1 && opponent != 2 && opponent != 3){
                  System.out.print("Please, enter 1, 2 or 3 > ");
               }
          }while (opponent != 1 && opponent != 2 && opponent != 3);
            
          if (opponent == 1 || opponent == 2)
             play(opponent);    
                    
      }while(opponent != 3);
      
      //display Good Bye Message
      System.out.println("\n***** Thank you for playing! *****");*/
   }
   
   /**
    * Allows to play against the specified opponent 
    *
    * @param opponent    the opponent choice
    *                    1 = Human and 2 = AI    
    */
    /*public void play (int opponent){          
       //set player 1 and player 2       
       if (opponent == 1){
           System.out.println("\n---------- Playing Against Human ---------");
           player1.setType("human");
           player2.setType("human");
       }
       else{
           System.out.println("\n---------- Playing Against AI ---------");
           System.out.print("Do you want to start (y/n)>");
           char answer = read.next().charAt(0);
           //boolean isHuman = answer == 'y'? true : false;
           if (answer == 'y'){
              player1.setType("human");
              player2.setType("ai");
           }
           else{
              player1.setType("ai");
              player2.setType("human");
           }        
       }
       
       int lastMove = 0;
       int currentPlayer = 1;
      
       //play 
       while(!(thereIsWin(lastMove, currentPlayer) || thereIsDraw(lastMove, currentPlayer))){           
           do{
               lastMove = player1.move(board);
           }while(!isValid(lastMove));
           
           updateBoard(lastMove, 1);
           displayBoard();
           currentPlayer = 2;
           
           if (!(thereIsWin(lastMove, currentPlayer) || thereIsDraw(lastMove, currentPlayer))){               
               do{
                   lastMove = player2.move(board);
               }while(!isValid(lastMove));
               updateBoard(lastMove, 2);
               displayBoard();
           }
           
           currentPlayer = 1;
       }
   }*/
}