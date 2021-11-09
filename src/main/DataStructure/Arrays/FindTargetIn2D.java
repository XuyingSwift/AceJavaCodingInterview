package main.DataStructure.Arrays;

import java.util.ArrayList;
import java.util.List;

public class FindTargetIn2D {

    public static void main(String[] args) {
        int[][] a = {
                {1,2,3},
                {4,5,6},
                {7,8,9}};
        int target = 4;

        System.out.println(findTarget(a, target));
        System.out.println(searchMatrix(a, target));
    }

    public static boolean findTarget(int[][] a, int target) {

        for (int i =0; i<a.length; i++) {
            for (int j =0; j<a[i].length; j++) {
                if (target == a[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix == null) return false;
        int row = 0, col = matrix[0].length - 1;

        while(row < matrix.length && col >= 0){
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] < target){
                row++;
            }else{
                col--;
            }
        }
        return false;
    }
}
