public class MazeTraversal {
    public static void main(String[] args) {
        char[][] maze = {{'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                         {'#', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '#'},
                         {'.', '.', '#', '.', '#', '.', '#', '#', '#', '#', '.', '#'},
                         {'#', '#', '#', '.', '#', '.', '.', '.', '.', '#', '.', '#'},
                         {'#', '.', '.', '.', '.', '#', '#', '#', '.', '#', '.', '.'},
                         {'#', '#', '#', '#', '.', '#', '.', '#', '.', '#', '.', '#'},
                         {'#', '.', '.', '#', '.', '#', '.', '#', '.', '#', '.', '#'},
                         {'#', '#', '.', '#', '.', '#', '.', '#', '.', '#', '.', '#'},
                         {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#'},
                         {'#', '#', '#', '#', '#', '#', '.', '#', '#', '#', '.', '#'},
                         {'#', '.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '#'},
                         {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}};

        int[] entry = {2, 0};
        int[] result = mazeTraversal(maze, entry, entry);
        System.out.printf("Exit = [%d %d]\n", result[0], result[1]);
    }

    private static int[] mazeTraversal(char[][] maze, int[] entryPoint, int[] currentPosition){
        if(currentPosition[0] < 0 || currentPosition[0] >= maze.length || currentPosition[1] < 0 || currentPosition[1] >= maze[0].length
           || maze[currentPosition[0]][currentPosition[1]] != '.')
            return null;

        maze[currentPosition[0]][currentPosition[1]] = 'X';
        print(maze);

        if((currentPosition[0] == 0 || currentPosition[0] == maze.length-1 || currentPosition[1] == 0 || currentPosition[1] == maze[0].length-1) &&
                (currentPosition[0] != entryPoint[0] || currentPosition[1] != entryPoint[1]))
            return currentPosition;

        int[] downPos = {currentPosition[0] - 1, currentPosition[1]};
        int[] downResult = mazeTraversal(maze, entryPoint, downPos);
        if(downResult != null)
            return downResult;

        int[] upPos = {currentPosition[0] + 1, currentPosition[1]};
        int[] upResult = mazeTraversal(maze, entryPoint, upPos);
        if(upResult != null)
            return upResult;

        int[] leftPos = {currentPosition[0], currentPosition[1] - 1};
        int[] leftResult = mazeTraversal(maze, entryPoint, leftPos);
        if(leftResult != null)
            return leftResult;

        int[] rightPos = {currentPosition[0], currentPosition[1] + 1};
        int[] rightResult = mazeTraversal(maze, entryPoint, rightPos);
        if(rightResult != null)
            return rightResult;

        maze[currentPosition[0]][currentPosition[1]] = 'O';
        return null;
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
