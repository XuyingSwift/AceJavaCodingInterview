package main.newYear2023.April16th;

import java.util.HashSet;

public class isValidsudoku {
    public static void main(String[] args)
    {
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
        boolean result = isValidSudoku1(board);
        System.out.println(result);
    }

    public static boolean isValidSudoku(char[][] board)
    {
        /*
        * Initialize a list containing 9 hash sets, where the hash set at index r will be used to store previously seen numbers in row r
        * Initialize list of 9 hash sets to track the columns
        * */
        int N = 9;
        HashSet<Character>[] rows = new HashSet[N];
        HashSet<Character>[] cols = new HashSet[N];
        HashSet<Character>[] boxes = new HashSet[9];
        /*
        *  Iterate over each position (r,c) in the sudoku, At each iteration, if there is a number at the current position:
        *   check if the number exits in the hash set for the current row, column, or box. If it does, return false. Because
        *   this is the second occurrence of the number in the current row, column, box
        *   Other, update the set resposible for tracking previously seen numbers in the current row, column, and box.
        *   the index of the current box is ((r /3) * 3 + (c/3) where / represent the floor division
            If no duplicates were found after every position on the sudoku board has been visited, the sudoku is valid so return true
        * */
        for (int r = 0; r < N; r++)
        {
            rows[r] = new HashSet<Character>();
            cols[r] = new HashSet<Character>();
            boxes[r] = new HashSet<Character>();
        }

        for (int r = 0; r < N; r++)
        {
            for (int c = 0; r < N; c++)
            {
                char value = board[r][c];
                // check if the position is filled with number
                if (value == '.')
                {
                    continue;
                }
                // check the row
                if (rows[r].contains(value))
                {
                    return false;
                }
                rows[r].add(value);
                // check column
                if (cols[c].contains(value))
                {
                    return false;
                }
                cols[c].add(value);

                // check the box
                int idx = (r/3) *3 + c/3;
                if (boxes[idx].contains(value))
                {
                    return false;
                }
                boxes[idx].add(value);
            }
        }
        return true;
    }

    public static boolean isValidSudoku1(char[][] board) {
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
                if (boxes[idx].contains(val)) {
                    return false;
                }
                boxes[idx].add(val);
            }
        }
        return true;
    }
}
