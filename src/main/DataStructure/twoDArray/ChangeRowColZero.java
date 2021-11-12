package main.DataStructure.twoDArray;

import java.util.Arrays;

public class ChangeRowColZero {
    public static void main(String[] args){
        int[][] mat =
                {
                        { 1, 1, 0, 1, 1 },
                        { 1, 1, 1, 1, 1 },
                        { 1, 1, 0, 1, 1 },
                        { 1, 1, 1, 1, 1 },
                        { 0, 1, 1, 1, 1 }
                };
        convert(mat);
        for (var r : mat) {
            System.out.println(Arrays.toString(r));
        }
    }

    // Function to convert the matrix
    public static void convert(int[][] mat)
    {
        // base case
        if (mat == null || mat.length == 0) {
            return;
        }

        // `M × N` matrix
        int M = mat.length;
        int N = mat[0].length;

        // traverse the matrix
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (mat[i][j] == 0)            // cell `(i, j)` has value 0
                {
                    // change each non-zero element in row `i` and column `j` to -1
                    coverRowAndCol(mat, M, N, i, j);
                }
            }
        }

        // traverse the matrix once again and replace cells having
        // value -1 with 0
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (mat[i][j] == -1) {
                    mat[i][j] = 0;
                }
            }
        }
    }



    public static void coverRowAndCol(int[][] mat, int R, int C, int r, int c) {
        for (int i =0; i<R; i++) {
            if (mat[r][i] != 0) {
                mat[r][i] = -1;
            }
        }

        for (int j =0; j<C; j++) {
            if (mat[j][c] != 0) {
                mat[j][c] = -1;
            }
        }
    }
}
