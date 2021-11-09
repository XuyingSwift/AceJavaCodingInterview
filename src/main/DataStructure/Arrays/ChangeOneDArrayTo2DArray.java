package main.DataStructure.Arrays;

public class ChangeOneDArrayTo2DArray {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6};
        int row = 2;
        int col = 3;

        int[][] b = changeOneToTwo(a, row, col);
        for (int i =0; i<row; i++) {
            for (int j=0; j<col; j++) {
                System.out.print(b[i][j]);
            }
        }
    }

    public static int[][] changeOneToTwo(int[] a, int row, int col) {
        if (row*col < a.length || row*col > a.length) {
            return new int[0][0];
        }
        int[][] arr = new int[row][col];
        int index =0;
        for(int i=0; i<row; i++) {
            for (int j =0; j<col; j++) {
                arr[i][j] = a[index++];
            }
        }
        return arr;
    }
}
