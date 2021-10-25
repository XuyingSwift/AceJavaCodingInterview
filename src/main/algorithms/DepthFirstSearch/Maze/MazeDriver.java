package main.algorithms.DepthFirstSearch.Maze;

import java.io.File;
import java.util.List;

public class MazeDriver {
    public static void main(String[] args) throws Exception {
        File maze1 = new File("src/main/resources/maze/maze1.txt");
        File maze2 = new File("src/main/resources/maze/maze2.txt");

        execute(maze1);
        execute(maze2);
    }

    private static void execute(File file) throws Exception {
        Maze maze = new Maze(file);
        dfs(maze);

    }

    private static void dfs(Maze maze) {
        DFSMazeSolver dfs = new DFSMazeSolver();
        List<Coordinate> path = dfs.solve(maze);
        maze.printPath(path);
        maze.reset();
    }
}
