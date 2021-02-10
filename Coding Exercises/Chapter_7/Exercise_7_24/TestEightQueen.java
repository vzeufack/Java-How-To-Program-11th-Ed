/**
 * Test EightQueen
 */
public class TestEightQueen{

    /**
     * main
     */
    public static void main (String [] args){
        
        int [][] testSquares = {{0,0}, {0,7}, {1,1}, {1,6}, {3,3}, {3,4}, {4,3}, {4,4}, {6,1}, {6,6}, {7,0}, {7,7}};
        
        /*test countSquaresEliminatedDiagonally1
        //Expected output: 0, 7, 2, 7, 6, 7, 7, 6, 7, 2, 7, 0
                           7	0	7	2	7	6	6	7	2	7	0	7 
        for (int i = 0; i < testSquares.length; i++){
            System.out.print(EightQueen.countSquaresEliminatedDiagonally1(testSquares[i][0], testSquares[i][1]) + ", ");
        }*/
        
        /*test countSquaresEliminatedDiagonally2
        //Expected output: 7	0	7	2	7	6	6	7	2	7	0	7                
        for (int i = 0; i < testSquares.length; i++){
            System.out.print(EightQueen.countSquaresEliminatedDiagonally2(testSquares[i][0], testSquares[i][1]) + ", ");
        }*/
        
        /*test countSquaresEliminatedDiagonally
        //Expected output: 7	7	9 9 13 13 13 13 9 9 7 7               
        for (int i = 0; i < testSquares.length; i++){
            System.out.print(EightQueen.countSquaresEliminatedDiagonally(testSquares[i][0], testSquares[i][1]) + ", ");
        }*/
        
        //test initEliminationNumber
        //Expected output: 22 22	24 24 28 28 28 28 24 24 22 22               
        /*for (int i = 0; i < testSquares.length; i++){
            System.out.print(EightQueen.initEliminationNumber(testSquares[i][0], testSquares[i][1]) + ", ");
        }*/
        
        //test getLeastElimSquare
        //System.out.printf("%d %d", getLeastElimSquare()[0], getLeastElimSquare()[1]);
        EightQueen.display();
    }
}