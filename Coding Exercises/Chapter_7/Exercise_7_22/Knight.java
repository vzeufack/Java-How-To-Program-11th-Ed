/*
   Knight.java by Vannel 12/18/2018
 */
 import java.security.SecureRandom;
 
 public class Knight{
     private Square position = new Square();
     
     public Knight(){
         SecureRandom randomNumberGenerator = new SecureRandom();
         int randomNumber = randomNumberGenerator.nextInt(4) + 1;
         switch (randomNumber){
             case 1:
                 position = new Square();
                 break;
             case 2:
                 position = new Square(0,7);
                 break;
             case 3:
                 position = new Square (7,0);
                 break;
             case 4:
                 position = new Square (7,7);
                 break;
              default:
                 position = new Square();
                 break;           
             }         
     }
     
     public Knight( Square initPosition ){
          setPosition(initPosition);
     }
     
     public Knight( int random ){
         SecureRandom randomGenerator = new SecureRandom();
         int row = randomGenerator.nextInt(8);
         int col = randomGenerator.nextInt(8);
         position = new Square(row,col);
     }
     
     public Square getPosition(){
         return position;
     }
     
     public void setPosition (Square newPosition){
         if (newPosition.isValid()){
             position.setRow(newPosition.getRow());
             position.setCol(newPosition.getCol());
             position.setAccessibility(newPosition.getAccessibility());
         }
     }
     
     public String toString(){
         return String.format("K r:%d c:%d n:%d a:%d", position.getRow(), position.getCol(), position.getNumber(), position.getAccessibility());
     }
 }