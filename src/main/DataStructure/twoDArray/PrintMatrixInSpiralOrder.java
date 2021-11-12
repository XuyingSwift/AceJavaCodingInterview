package main.DataStructure.twoDArray;

import java.util.Arrays;

public class PrintMatrixInSpiralOrder {
    public static void main(String[] args) {
        int[][] mat =
                {
                        { 1, 2, 3, 4, 5},
                        {16, 17, 18, 19, 6},
                        {15, 24, 25, 20, 7},
                        {14, 23, 22, 21, 8},
                        {13, 12, 11, 10, 9}
                };
        print(mat);
        System.out.println();
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25 };
        int[][] matrix = build(a, 5, 5);
        for (var r : matrix) {
            System.out.println(Arrays.toString(r));
        }
        System.out.println("shifted matrix");
        int[][] shift = shift(mat);
        for (var r : shift) {
            System.out.println(Arrays.toString(r));
        }
    }

    public static void print(int[][] matrix) {
        // check the base case
        if (matrix == null || matrix.length == 0) {
            return;
        }
        // direction variables
        int rowTop = 0, rowBottom = matrix.length-1;
        int colLeft = 0, colRight = matrix.length-1;

        while (true) {
            // checked row numbers from top to bottom
            if (rowTop > rowBottom) {
                break;
            }

            // loop through and print the top
            for (int i = colLeft; i<=colRight; i++) {
                System.out.print(matrix[rowTop][i] + " ");
            }
            // first row is done, so update row numbers
            rowTop ++;

            // check the left and right col
            if (colLeft > colRight) {
                break;
            }

            // loop through right most col
            for (int i = rowTop; i<=rowBottom; i++) {
                System.out.print(matrix[i][colRight] + " ");
            }

            // move the right to left by one
            colRight--;

            // check top and bottom
            if (rowTop > rowBottom) {
                break;
            }

            for (int i = colRight; i>= colLeft; i--) {
                System.out.print(matrix[rowBottom][i] + " ");
            }

            // move the row up by one
            rowBottom--;

            // check left and right
            if (colLeft > colRight) {
                break;
            }

            for (int i = rowBottom; i>= rowTop; i--) {
                System.out.print(matrix[i][colLeft] + " ");
            }
            // move the col in a bit
            colLeft++;
        }
    }

    public static int[][] build(int[] arr, int R, int C) {

        //check the base cases
        if (arr.length == 0 || arr == null) {
            return new int[0][0];
        }

        // create the board
        // create the 4 directions
        int[][] spiral = new int[R][C];
        int rowTop = 0, rowBottom = R -1;
        int colLeft = 0, colRight = C -1;

        // index for the single array
        int index = 0;

        while (true) {
            if (rowTop > rowBottom) {
                break;
            }
            for (int i = colLeft; i<=colRight; i++) {
                spiral[rowTop][i] = arr[index++];

            }
            rowTop ++;

            if (colLeft > colRight) {
                break;
            }
            for (int i = rowTop ; i<=rowBottom; i++ ) {
                spiral[i][colRight] = arr[index++];

            }
            colRight--;

            if (colLeft > colRight) {
                break;
            }
            for(int i = colRight; i>=colLeft; i--) {
                spiral[rowBottom][i] = arr[index++];

            }
            rowBottom --;

            if (rowTop > rowBottom) {
                break;
            }
            for(int i = rowBottom; i >= rowTop; i--) {
                spiral[i][colLeft] = arr[index++];

            }
            colLeft ++;
        }
        return spiral;
    }

    public static int[][] shift(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0][0];
        }
        int topRow =0, topBottom = matrix.length -1;
        int leftCol = 0, rightCol = matrix[0].length -1;
        int prev = matrix[0][0];

        while (true) {
            if (topRow > topBottom) {
                break;
            }
            for (int i = leftCol; i<= rightCol; i++) {
               int temp = matrix[topRow][i];
               matrix[topRow][i] = prev;
               prev = temp;
            }
            topRow ++;

            if (leftCol > rightCol) {
                break;
            }

            for (int i = topRow; i <= topBottom; i++) {
                int temp = matrix[i][rightCol];
                matrix[i][rightCol] = prev;
                prev = temp;
            }
            rightCol --;

            if (topRow > topBottom) {
                break;
            }

            for (int i = rightCol; i >= leftCol; i--) {
                int temp = matrix[topBottom][i];
                matrix[topBottom][i] = prev;
                prev = temp;
            }

            topBottom --;

            if (leftCol>rightCol) {
                break;
            }

            for(int i = topBottom; i>= topRow; i--) {
                int temp = matrix[i][leftCol];
                matrix[i][leftCol] = prev;
                prev = temp;
            }

            leftCol ++;

        }

        // replace the first element with the prev
        matrix[0][0] = prev;
        return matrix;
    }

}
