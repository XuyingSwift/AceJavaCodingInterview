package main.algorithms.BreadthFristSearch;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

    // data structure used to represent a graph
    int[][] adjMatrix;
    int rootNode = 0;
    int numNodes;
    boolean[] visited;


    // constructor of a graph
    BreadthFirstSearch(int[][] matrix) {
        this.numNodes = matrix.length;
        this.adjMatrix = new int[numNodes][numNodes];
        this.visited = new boolean[numNodes];

        for (int i = 0; i<numNodes; i++) {
            for (int j = 0; j<numNodes; j++) {
                adjMatrix[i][j] = matrix[i][j];
            }
        }
    }

    public void BSF() {
        // bfs uses queue data structure;
        Queue<Integer> queue = new LinkedList<Integer>();
        clearVisited();
        queue.add(0);

        // loop as long as there are active node
        while (!queue.isEmpty()) {
            int nextNode; // next node to visist
            nextNode = queue.remove();

            if (!visited[nextNode]) {
                visited[nextNode] = true;
                System.out.println("next node " + nextNode);

                for (int i = numNodes -1; i>= 0; i--) {
                    if (adjMatrix[nextNode][i] > 0 && !visited[i]) {
                        queue.add(i);
                    }
                }
            }
        }

    }

    public int getUnvisitedChildNode(int n) {
        for (int j = 0; j < numNodes; j++) {
            if (adjMatrix[n][j] > 0) {
                if (!visited[j]) {
                    return j;
                }
            }
        }
        return -1;
    }

    public void clearVisited() {
        for (int i =0; i<visited.length; i++) {
            visited[i] = false;
        }
    }
}
