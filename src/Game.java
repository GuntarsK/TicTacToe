import java.util.Random;
import java.util.Scanner;

class Game {
    private boolean win;
    private int move;
    private String[] board = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
    private Scanner sc = new Scanner(System.in);
    private Random r = new Random();

    Game() {
        move = 0;
        win = false;
        System.out.println("Welcome to the TicTacToe game. Chose board position: 1 - 9");
    }

    boolean hasGameEnded() {
        return win || move == 9;
    }

    void nextMove() {
        int playerPos;
        String playerChar;

        if (move % 2 == 0) {
            System.out.println("Player X:");
            playerChar = "X";
            while(!sc.hasNext("[1-9]")){
                System.out.println("Input not recognized. Chose a number between 1 and 9.");
                sc.nextLine();
            }
            playerPos = sc.nextInt();
        } else {
            System.out.println("Computer's move:");
            playerChar = "O";
            playerPos = r.nextInt(9) + 1;
        }

        if ( board[playerPos - 1].equals(" ") ) {
            board[playerPos - 1] = playerChar;
            move++;
        } else {
            System.out.println("This filed is taken");
        }

        printBoard();
        checkForWin();
    }

    private void checkForWin() {
        String[] matches = {board[0] + board[1] + board[2],
                            board[3] + board[4] + board[5],
                            board[6] + board[7] + board[8],
                            board[0] + board[3] + board[6],
                            board[1] + board[4] + board[7],
                            board[2] + board[5] + board[8],
                            board[0] + board[4] + board[8],
                            board[2] + board[4] + board[6]
        };
        for (String match : matches) {
            if ("XXX".equals(match)) {
                win = true;
                System.out.println("CONGRATS! YOU WON!");
            } else if ("OOO".equals(match)) {
                win = true;
                System.out.println("COMPUTER HAS WON!");
            }
        }
        if (move == 9 && !win) {
            System.out.println("DRAW!");
        }
    }

    /**
     * Prints out the board after each move
     */
    private void printBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row*3 + col]);
                if (col < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }

    /**
     * Prints out the board to show positions at the beginning of the game
     */
    void printBoardWithPositions() {
        int i = 1;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(i++);
                if (col < 2) {
                    System.out.print("|");        // this adds column borders just to make board a bit prettier
                }
            }
            System.out.println();
        }
    }

}
