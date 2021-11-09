package main.Compnay.Facebook;

import java.util.HashSet;

public class validateSudoku {

    public static void main(String[] args) {
        char[][] board = new char[][] {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };

        System.out.println((isValidConfig(board, 9) ?
                "YES" : "NO"));

        System.out.println(isValidSudoku(board));
    }

    // check there is any duplicates in row
    public static boolean notValidRow(char[][] a, int row) {
        HashSet<Character> set = new HashSet<>();

        for (int i =0; i<9; i++) {
            if(set.contains(a[row][i])) {
                return false;
            }

            if (a[row][i] != '.') {
                set.add(a[row][i]);
            }
        }
        return true;
    }

    // check there is any duplicates in the column
    public static boolean notValidCol(char[][] a, int col) {
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            if (set.contains(a[i][col])) {
                return false;
            }

            if(a[i][col] != '.') {
                set.add(a[i][col]);
            }
        }
        return true;
    }

    // Checks whether there is any duplicate
// in current 3x3 box or not.
    public static boolean notInBox(char arr[][],
                                   int startRow,
                                   int startCol)
    {
        HashSet<Character> st = new HashSet<>();

        for(int row = 0; row < 3; row++)
        {
            for(int col = 0; col < 3; col++)
            {
                char curr = arr[row + startRow][col + startCol];

                // If already encountered before, return
                // false
                if (st.contains(curr))
                    return false;

                // If it is not an empty cell,
                // insert value at current cell in set
                if (curr != '.')
                    st.add(curr);
            }
        }
        return true;
    }

    // Checks whether current row and current column and
// current 3x3 box is valid or not
    public static boolean isValid(char arr[][], int row,
                                  int col)
    {
        return notValidRow(arr, row) && notValidCol(arr, col) &&
                notInBox(arr, row - row % 3, col - col % 3);
    }

    public static boolean isValidConfig(char arr[][], int n)
    {
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {

                // If current row or current column or
                // current 3x3 box is not valid, return
                // false
                if (!isValid(arr, i, j))
                    return false;
            }
        }
        return true;
    }

    public static boolean isValidSudoku(char[][] board) {
        int N = 9;

        // Use hash set to record the status
        HashSet<Character>[] rows = new HashSet[N];
        HashSet<Character>[] cols = new HashSet[N];
        HashSet<Character>[] boxes = new HashSet[N];
        for (int r = 0; r < N; r++) {
            rows[r] = new HashSet<Character>();
            cols[r] = new HashSet<Character>();
            boxes[r] = new HashSet<Character>();
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                char val = board[r][c];

                // Check if the position is filled with number
                if (val == '.') {
                    continue;
                }

                // Check the row
                if (rows[r].contains(val)) {
                    return false;
                }
                rows[r].add(val);

                // Check the column
                if (cols[c].contains(val)) {
                    return false;
                }
                cols[c].add(val);

                // Check the box
                int idx = (r / 3) * 3 + c / 3;
                System.out.println("my index is " + idx);
                if (boxes[idx].contains(val)) {
                    return false;
                }
                boxes[idx].add(val);
            }
        }
        return true;
    }
}
