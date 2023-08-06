public class N_queens {

    public static boolean isSafe(char board[][], int row, int col) {
        //vertical up
        for (int i = row - 1; i >= 0; i--) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }
        //diag left up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }
        //diag right up
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
    public static void nqueens(char board[][], int row) {
        //base
        if(row == board.length) {
            printBoard(board);
            return;
        }
        //recursion
        for (int i = 0; i < board.length; i++) {
            if(isSafe(board, row, i)) {
                board[row][i] = 'Q';
                nqueens(board, row + 1);
                board[row][i] = 'x';
            } 
        }
    }

    //count all possible solutions
    public static void nqueens_c(char board[][], int row) {
        //base
        if(row == board.length) {
            // printBoard(board );
            count++;
            return;
        }
        //recursion
        for (int i = 0; i < board.length; i++) {
            if(isSafe(board, row, i)) {
                board[row][i] = 'Q';
                nqueens_c(board, row + 1);
                board[row][i] = 'x';
            } 
        }
    }

    //print one solution
    public static boolean nqueens_one(char board[][], int row) {
        //base
        if(row == board.length) {
            return true;
        }
        //recursion
        for (int i = 0; i < board.length; i++) {
            if(isSafe(board, row, i)) {
                board[row][i] = 'Q';
                if(nqueens_one(board, row + 1)) {
                    return true;
                }
            } 
        }
        return false;
    }
    //print board
    public static void printBoard(char board[][]) {
        System.out.println("______________\n");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    //main fn
    static int count = 0;
    public static void main(String args[]) {
        int n = 5;
        char board[][] = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = 'x';
            }
        }
        // nqueens(board, 0);
        // nqueens_c(board, 0);
        // System.out.println("count: " + count);
        if(nqueens_one(board, 0)) {
            System.out.println();
            System.out.println("sol is poss |");
            System.out.println("            v");
            printBoard(board);
        }
        else {
            System.out.println("no");
        }
    }
}
