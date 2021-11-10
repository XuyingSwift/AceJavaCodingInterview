package main.algorithms.BreadthFristSearch;

import java.util.LinkedList;
import java.util.Queue;

public class FindTheShortedPathInAMaze {
    static class Node{
        public int x, y, dist;// mindist from the source to distance
        public Node(int x, int y, int dist) {
            this.x =x;
            this.y = y;
            this.dist = dist;
        }
    }

    // detail all four possible movements from a cell
    private static final int[] row = {-1, 0, 0, 1};
    private static final int[] col = {0, -1, 1, 0};

    public static boolean isValid(int[][] mat, boolean[][] visited, int row, int col) {
        return (row >=0 && row<mat.length
                && col>= 0
                && col<mat[0].length
                && mat[row][col] == 1
                && !visited[row][col]
        );
    }
    public static int findShortestPath(int[][] mat, int i, int j, int x, int y) {
        if (mat == null || mat.length == 0 || mat[i][j] ==0 || mat[x][y] == 0) {
            return -1;
        }

        int M = mat.length;
        int N = mat[0].length;

        // construct a matrix to keep track of visisted cells
        boolean[][] visited = new boolean[M][N];

        // Create a queue
        Queue<Node> queue = new LinkedList<>();
        // mark the source cell
        visited[i][j] = true;
        queue.add(new Node(i,j, 0));

        int min_dist = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            // dequeue
            Node node = queue.poll();
            //current node
            i = node.x;
            j = node.y;
            int distance = node.dist;
            if (i ==x && j ==y) {
                min_dist = distance;
                break;
            }

            //check four possible moves
            for (int k =0; k<4; k++) {
                // check if it is possible to go to postion
                if (isValid(mat, visited, i+ row[k], j+col[k])) {
                    // make next cell as visited
                    visited[i+row[k]][j+col[k]] = true;
                    queue.add(new Node(i+row[k], j+col[k], distance + 1));
                }
            }
        }
        if (min_dist != Integer.MAX_VALUE) {
            return min_dist;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[][] mat =
                {
                        { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
                        { 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
                        { 0, 0, 1, 0, 1, 1, 1, 0, 0, 1 },
                        { 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 },
                        { 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
                        { 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 },
                        { 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
                        { 0, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
                        { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
                        { 0, 0, 1, 0, 0, 1, 1, 0, 0, 1 },
                };

        int min_dist = findShortestPath(mat, 0, 0, 7, 5);

        if (min_dist != -1) {
            System.out.println("The shortest path from source to destination " +
                    "has length " + min_dist);
        } else {
            System.out.println("Destination cannot be reached from source");
        }
    }
}
