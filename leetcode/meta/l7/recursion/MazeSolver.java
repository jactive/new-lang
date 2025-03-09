package leetcode.meta.l7.recursion;

public class MazeSolver {
    // Directions: Right, Down, Left, Up
    private static final int[][] DIRECTIONS = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

    public static boolean solveMaze(int[][] maze, int x, int y, int[][] solution) {
        int N = maze.length;
        int M = maze[0].length;

        // Base case: If we reach the destination, mark it and return true
        if (x == N - 1 && y == M - 1) {
            solution[x][y] = 1;
            return true;
        }

        // Check if we can move to (x, y)
        if (isValidMove(maze, x, y)) {
            // Mark this cell as part of the solution path
            solution[x][y] = 1;

            // Try moving in all directions (Right, Down, Left, Up)
            for (int[] dir : DIRECTIONS) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (solveMaze(maze, newX, newY, solution)) {
                    return true; // Found a solution, stop searching
                }
            }

            // **Backtrack**: Unmark the cell, as this path did not lead to a solution
            solution[x][y] = 0;
        }

        return false;
    }

    private static boolean isValidMove(int[][] maze, int x, int y) {
        int N = maze.length;
        int M = maze[0].length;
        return (x >= 0 && x < N && y >= 0 && y < M && maze[x][y] == 0);
    }

    public static void main(String[] args) {
        int[][] maze = {
            {0, 1, 0, 0, 0},
            {0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0},
            {1, 1, 0, 1, 0},
            {0, 0, 0, 0, 0}
        };

        int[][] solution = new int[maze.length][maze[0].length];

        if (solveMaze(maze, 0, 0, solution)) {
            System.out.println("Path found:");
            printSolution(solution);
        } else {
            System.out.println("No path exists.");
        }
    }

    private static void printSolution(int[][] solution) {
        for (int[] row : solution) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
