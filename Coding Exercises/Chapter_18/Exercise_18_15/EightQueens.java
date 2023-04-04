import java.util.ArrayList;
import java.util.Optional;

public class EightQueens {
    public static void main(String[] args) {
        ArrayList<int[]> queensPositions = new ArrayList();
        boolean[][] board = new boolean[8][8];
        System.out.println(canPlaceAllQueens(board, queensPositions, 8));
        queensPositions.stream()
                .forEach(p -> System.out.printf("%d %d%n", p[0], p[1]));
    }
    private static boolean canPlaceAllQueens(boolean[][] board, ArrayList<int[]> queensPositions, int queensCount){
        if(queensCount == 0)
            return true;

        int nextCol = queensPositions.size() == 0 ? 0 : queensPositions.get(queensPositions.size() - 1)[1] + 1;

        for(int i = 0; i < 8; i++){
            if(isAvailable(queensPositions, i, nextCol)){
                board[i][nextCol] = true;
                int[] newPos = {i, nextCol};
                queensPositions.add(newPos);
                if(canPlaceAllQueens(board, queensPositions, queensCount-1))
                    return true;
                else{
                    board[i][nextCol] = false;
                    queensPositions.remove(newPos);
                }
            }
        }
        return false;
    }

    private static boolean isAvailable(ArrayList<int[]> queensPositions, int row, int col){
        Optional<int[]> pos = queensPositions.stream()
                .filter(p -> p[0] == row || p[1] == col || Math.abs(p[1]-col) == Math.abs(p[0]-row))
                .findAny();

        return !pos.isPresent();
    }
}
