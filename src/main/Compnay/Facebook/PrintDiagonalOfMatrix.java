package main.Compnay.Facebook;

public class PrintDiagonalOfMatrix {

    public static void main(String[] args) {
        int n = 4;
        int a[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 } };
        printDiagonal(a, n);
        printSecondaryDiagonal(a, n);
        System.out.println();
        printFirst(a, n);
        System.out.println();
        printSecond(a, n);
    }

    public static void printDiagonal(int[][] matrix, int n) {
        System.out.println("print the diagonal elements ");
        for (int i = 0; i<n; i++) {
            for (int j =0; j<n; j++) {
                if (i ==j) {
                    System.out.println(matrix[i][j]);
                }
            }
        }
    }

    public static void printSecondaryDiagonal(int[][] matrix, int n) {
        System.out.println("Secondary");
        for (int i=0; i<n;i++) {
            for (int j =0; j<n; j++) {
                if(i+j == n-1) {
                    System.out.print(matrix[i][j]);
                }
            }
        }
    }

    public static void printFirst(int[][] a, int n) {
        for (int i =0; i<n; i++) {
            System.out.print(a[i][i]);
        }
    }

    public static void printSecond(int[][] a, int n) {
        int k = n -1;
        for (int i =0; i<n; i++) {
            System.out.print(a[i][k--]);
        }
    }
}
