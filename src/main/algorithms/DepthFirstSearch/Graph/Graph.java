package main.algorithms.DepthFirstSearch.Graph;

import java.net.Inet4Address;
import java.util.Stack;

public class Graph {
    private int numOfNode;
    private int[][] matrix;
    private boolean[] visited;

    // constructor
    public Graph(int[][] mat) {
        this.numOfNode = mat.length;
        // init matrix and visited
        this.matrix = new int[numOfNode][numOfNode];
        this.visited = new boolean[numOfNode];

        for (int i = 0; i< numOfNode; i++) {
            for (int j = 0; j < numOfNode; j++) {
                matrix[i][j] = mat[i][j];
            }
        }
    }

    public void DFS() {
        // create a stack that save nodes to "tovisit" node
        Stack<Integer> stack = new Stack<>();
        clearVisited(); // set all visted to false
        stack.push(0);// start with 0;
        // loop through there is no active node
        while (!stack.isEmpty()) {
            int nextNode;
            nextNode = stack.pop();

            if (!visited[nextNode]) {
                visited[nextNode] = true;
                System.out.println("Next node is " + nextNode);

                for (int i= numOfNode -1; i >=0 ; i-- ) {
                    System.out.println("matrix value " + matrix[nextNode][i]);
                    System.out.println("node name " + i);
                    if (matrix[nextNode][i] > 0 && ! visited[i]) {
                        stack.push(i);
                    }
                }
            }
        }


    }


    void clearVisited()
    {
        int i;

        for (i = 0; i < visited.length; i++)
            visited[i] = false;
    }

    void printNode(int n)
    {
        System.out.println(n);
    }
}

