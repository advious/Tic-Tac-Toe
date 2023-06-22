import java.util.*;

public class ticTacToe {

    static int n;                             // board size
    static char[][] board = new char[3][3];   // create a board of size 3x3
    static int curPlayer;                     // current player (1 or 2)
    static int numOfMoves;                    // keep the number of moves
    static int row, col;                      // current move
    static int finish;                        // status of the game
                                 //  {-1:in progress, 0:tie, 1:player 1 won, 2:player 2 won}
    static Scanner scan = new Scanner (System.in);  // scanner that will used in the entire code

    static void setupGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
        numOfMoves = 0;
        curPlayer = 1;
        finish = -1;
    }

    static void drawScreen() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    static void getMove() {
        System.out.println("Player " + curPlayer + ", please enter your move (row, col):");
        row = scan.nextInt() - 1;
        col = scan.nextInt() - 1;
        if (row != 0 && row != 1 && row != 2 || col != 0 && col != 1 && col != 2 || board[row][col] != '-') {
            while (row != 0 && row != 1 && row != 2 || col != 0 && col != 1 && col != 2 || board[row][col] != '-') {
                System.out.println("Invalid move!");
                System.out.println("Player " + curPlayer + ", please enter your move (row, col):");
                row = scan.nextInt() - 1;
                col = scan.nextInt() - 1;
            }
        }
    }

    static void makeMove() {
        if (curPlayer == 1) {
            board[row][col] = 'X';
        } else {
            board[row][col] = 'O';
        }
        curPlayer = 3 - curPlayer;
        numOfMoves++;
    }

    static int checkEndGame() {
        if (numOfMoves >= 5) {
            for (int i = 0; i < 3; i++) {
                if (board[i][0] == 'X' && board[i][1] == 'X' && board[i][2] == 'X' || board[0][i] == 'X' && board[1][i] == 'X' && board[2][i] == 'X' || board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X' || board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X') {
                    return 1;
                }
                if (board[i][0] == 'O' && board[i][1] == 'O' && board[i][2] == 'O' || board[0][i] == 'O' && board[1][i] == 'O' && board[2][i] == 'O' || board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O' || board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O') {
                    return 2;
                }
            }
        }
        if (numOfMoves == 9) {
            return 0;
        }
        return -1;
    }

    public static void main(String args[]) {

        setupGame();                        // STEP 1

        // main game loop
        while (true) {
            drawScreen();                   // STEP 2
            getMove();                      // STEP 3
            makeMove();                     // STEP 4
            finish = checkEndGame();        // STEP 5
            if (finish>-1) break;            // if game is finished, break the loop
        }

        // STEP 6: end game information
        drawScreen();
        if (checkEndGame() == 1) {
            System.out.println("Player 1 won the game!");
        } else if (checkEndGame() == 2) {
            System.out.println("Player 2 won the game!");
        } else if (checkEndGame() == 0) {
            System.out.println("Tie!");
        }
    }
}
