import java.util.Random;
import java.util.Scanner;

public class Game {

    private boolean win;
    private int move;
    private int playerPos;
    private String playerChar;
    private String[] pos = {" ", " ", " ", " ", " ", " ", " ", " ", " "};

    Scanner sc = new Scanner(System.in);
    Random r = new Random();

    public Game() {
        move = 1;
        win = false;
        playerChar = "X";
        System.out.println("Welcome to the TicTacToe game. Chose position (1-9)");
    }

    public boolean hasGameEnded() {
        return win || move == 10;
    }

    public void nextMove() {

        if (move % 2 == 1) {
            System.out.println("Player X:");
            playerChar = "X";
            playerPos = sc.nextInt();
        } else {
            System.out.println("Computer:");
            playerChar = "O";
            playerPos = r.nextInt(9)+1;
        }

        if ( !pos[playerPos-1].equals(" ") ) {
            System.out.println("This filed is taken");
        } else {
            pos[playerPos-1] = playerChar;
            move++;
        }

        printBoard();
        checkForWin();
    }

    public void checkForWin() {
        String[] matches = {pos[0] + pos[1] + pos[2],
                pos[3] + pos[4] + pos[5],
                pos[6] + pos[7] + pos[8],
                pos[0] + pos[3] + pos[6],
                pos[1] + pos[4] + pos[7],
                pos[2] + pos[5] + pos[8],
                pos[0] + pos[4] + pos[8],
                pos[2] + pos[4] + pos[6]
        };
        for (String match : matches) {
            if ("XXX".equals(match)) {
                win = true;
                System.out.println("PLAYER X HAS WON!");
            } else if ("OOO".equals(match)) {
                win = true;
                System.out.println("PLAYER O HAS WON!");
            }
        }
        if (move == 10 && !win) {
            System.out.println("DRAW!");
        }
    }

    /**
     * Prints out the board after each move
     */
    public void printBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(pos[row*3 + col]);
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
    public void printBoardWithPositions() {
        int i = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                i++;
                System.out.print(i);
                if (col < 2) {
                    System.out.print("|");        // this adds column borders just to make board a bit prettier
                }
            }
            System.out.println();
        }
    }

}
