package chap18;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
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
    
    Integer[][] exitPathAs2DArray = {{2,0},{2,1},{1,1},{1,2},{1,3},{2,3},
                                     {3,3},{4,3},{4,4},{5,4},{6,4},{7,4},
                                     {8,4},{8,5},{8,6},{8,7},{8,8},{7,8},
                                     {6,8},{5,8},{4,8},{3,8},{3,7},{3,6},
                                     {3,5},{2,5},{1,5},{1,6},{1,7},{1,8},
                                     {1,9},{1,10},{2,10},{3,10},{4,10},{4,11}};

    /**
     * Test 1 for mazeTraversal
     */
    @Test
    public void testMazeTraversal1(){
        Integer[] initialPosition = {2,0};
        List<Integer[]> expected = Arrays.asList(exitPathAs2DArray);
        List<Integer[]> actual = App.mazeTraversal(maze, initialPosition, new ArrayList<Integer[]>());
        
        for (int i = 0; i < expected.size(); i++){
            assertArrayEquals(expected.get(i), actual.get(i));
        }
    }

    /**
     * Test isOutOfBounds
     */
    @Test
    public void testIsOutOfBounds(){
        int mazeSize = 12;
        Integer[] p1 = {4,5};
        Integer[] p2 = {-1, 9};
        Integer[] p3 = {12, 5};
        Integer[] p4 = {3,-1};
        Integer[] p5 = {3, 12};

        
        assertFalse(App.isOutOfBounds(p1, mazeSize));
        assertTrue(App.isOutOfBounds(p2, mazeSize));
        assertTrue(App.isOutOfBounds(p3, mazeSize));
        assertTrue(App.isOutOfBounds(p4, mazeSize));
        assertTrue(App.isOutOfBounds(p5, mazeSize));
    }

    /**
     * Test computeNewPosition
     */
    @Test
    public void testComputeNewPosition(){
        Integer[] originalPosition = {0,0};
        Integer[] downPosition = {1,0};
        Integer[] upPosition = {-1,0};
        Integer[] leftPosition = {0,-1};
        Integer[] rightPosition = {0, 1};

        assertArrayEquals(App.computeNewPosition(originalPosition, "down"), downPosition);
        assertArrayEquals(App.computeNewPosition(originalPosition, "up"), upPosition);
        assertArrayEquals(App.computeNewPosition(originalPosition, "left"), leftPosition);
        assertArrayEquals(App.computeNewPosition(originalPosition, "right"), rightPosition);
    }

    /**
     * Test findX 
     */
    @Test
    public void testFindX(){
        char[][] maze = {{'#','#','#','#','#','#','#','#','#','#','#','#'},
                         {'#','.','.','.','#','.','.','.','.','.','.','#'},
                         {'x','.','#','.','#','.','#','#','#','#','.','#'},
                         {'#','#','#','.','#','.','.','.','.','#','.','#'},
                         {'#','.','.','.','.','#','#','#','.','#','.','.'},
                         {'#','#','#','#','.','#','.','#','.','#','.','#'},
                         {'#','.','.','#','.','#','.','#','.','#','.','#'},
                         {'#','#','.','#','.','#','.','#','.','#','.','#'},
                         {'#','.','.','.','.','.','.','.','.','#','.','#'},
                         {'#','#','#','#','#','#','.','#','#','#','.','#'},
                         {'#','.','.','.','.','.','.','#','.','.','.','#'},
                         {'#','#','#','#','#','#','#','#','#','#','#','#'}};
        
        Integer[] iPos1 = {2,1};
        Integer[] iPos2 = {2,0};
        Integer[] xPos1 = {2,0};
        Integer[] xPos2 = new Integer[2];

        assertArrayEquals(xPos1, App.findX(maze, iPos1));
        assertArrayEquals(xPos2, App.findX(maze, iPos2));
    }
    /**
     * Tests tryMove
     */
    @Test
    public void testTryMove(){
       Integer[] iPos = {2,0};
       Integer[] rightMove = {2,1};
       Integer[] leftMove = new Integer[2];
       Integer[] downMove = new Integer[2];
       Integer[] upMove = new Integer[2];

       assertArrayEquals(rightMove, App.tryMove(maze, iPos, "right"));
       assertArrayEquals(leftMove, App.tryMove(maze, iPos, "left"));
       assertArrayEquals(downMove, App.tryMove(maze, iPos, "down"));
       assertArrayEquals(upMove, App.tryMove(maze, iPos, "up"));       
    }
}
