import java.util.Random;
import java.util.Scanner;

public class Game {

    private boolean win;
    private int move;
    private String player;
    private String pos;
    private String playerChar;
    private String[][] board = {{" ", " ", " "},
                                {" ", " ", " "},
                                {" ", " ", " "}};

    Scanner sc = new Scanner(System.in);
    Random r = new Random();


    public Game() {
        move = 0;
        win = false;
        playerChar = "X";
        System.out.println("Welcome to the TicTacToe game. Chose position (1-9)");
    }

    public boolean hasGameEnded() {
        return win || move == 9;
    }

    public void nextMove() {
        move++;
        if (move % 2 == 1) {
            System.out.println("Player X:");
            player = "user";
            playerChar = "X";
        } else {
            System.out.println("Computer:");
            player = "PC";
            playerChar = "O";
        }
    }

    public int nextPlayer() {
        if (player.equals("user")) {
            return sc.nextInt();
        } else {
            return r.nextInt(9)+1;
        }
    }

    public boolean isFieldTaken() {
        return !pos.equals(" ");
    }

    public void chosePosition(int position) {
        switch (position) {
            case 1:
                pos = board[0][0];
                if (isFieldTaken()) {
                    System.out.println("Field is taken. Try again.");
                    move--;
                } else {
                    board[0][0] = playerChar;
                }
                break;
            case 2:
                pos = board[0][1];
                if (isFieldTaken()) {
                    System.out.println("Field is taken. Try again.");
                    move--;
                } else {
                    board[0][1] = playerChar;
                }
                break;
            case 3:
                pos = board[0][2];
                if (isFieldTaken()) {
                    System.out.println("Field is taken. Try again.");
                    move--;
                } else {
                    board[0][2] = playerChar;
                }
                break;
            case 4:
                pos = board[1][0];
                if (isFieldTaken()) {
                    System.out.println("Field is taken. Try again.");
                    move--;
                } else {
                    board[1][0] = playerChar;
                }
                break;
            case 5:
                pos = board[1][1];
                if (isFieldTaken()) {
                    System.out.println("Field is taken. Try again.");
                    move--;
                } else {
                    board[1][1] = playerChar;
                }
                break;
            case 6:
                pos = board[1][2];
                if (isFieldTaken()) {
                    System.out.println("Field is taken. Try again.");
                    move--;
                } else {
                    board[1][2] = playerChar;
                }
                break;
            case 7:
                pos = board[2][0];
                if (isFieldTaken()) {
                    System.out.println("Field is taken. Try again.");
                    move--;
                } else {
                    board[2][0] = playerChar;
                }
                break;
            case 8:
                pos = board[2][1];
                if (isFieldTaken()) {
                    System.out.println("Field is taken. Try again.");
                    move--;
                } else {
                    board[2][1] = playerChar;
                }
                break;
            case 9:
                pos = board[2][2];
                if (isFieldTaken()) {
                    System.out.println("Field is taken. Try again.");
                    move--;
                } else {
                    board[2][2] = playerChar;
                }
                break;
            default:
                System.out.println("Input not recognized.");
                move--;
                break;
        }

        checkForWin();
        printBoard();
    }

    public void checkForWin() {
        String[] combo = {board[0][0] + board[0][1] + board[0][2],
                            board[1][0] + board[1][1] + board[1][2],
                            board[2][0] + board[2][1] + board[2][2],
                            board[0][0] + board[1][0] + board[2][0],
                            board[0][1] + board[1][1] + board[2][1],
                            board[0][2] + board[1][2] + board[2][2],
                            board[0][0] + board[1][1] + board[2][2],
                            board[0][2] + board[1][1] + board[2][0]
        };

        for (String match : combo) {
            if ("XXX".equals(match)) {
                win = true;
                System.out.println("PLAYER X HAS WON!");
            } else if ("OOO".equals(match)) {
                win = true;
                System.out.println("PLAYER O HAS WON!");
            }
        }

        if (move == 9) {
            System.out.println("DRAW!");
        }

    }

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

//    Prints out the board after each move
    public void printBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col]);
                if (col < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }

}
