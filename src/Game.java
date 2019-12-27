public class Game {

    private boolean win;
    private int move;
    private String player;
    private String[][] board = {{" ", " ", " "},
            {" ", " ", " "},
            {" ", " ", " "}};

    public Game() {
        move = 0;
        win = false;
        player = "X";
        System.out.println("TicTacToe game. Player X starts. Chose position (1-9)");
    }

    public void printBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }

    public String nextMove() {
        move++;
        if (move % 2 == 1) {
            return "X";
        } else {
            return "O";
        }
    }

    public void nextPlayer(int position) {
        System.out.println("Next move... ");

        switch(position) {
            case 1: if (board[0][0] == " ") {
                board[0][0] = nextMove();
            } else {
                System.out.println("This field is taken");
                move--;
            }
                break;
            case 2: if (board[0][1] == " ") {
                board[0][1] = nextMove();
            } else {
                System.out.println("This field is taken");
                move--;
            }
                break;
            case 3: if (board[0][2] == " ") {
                board[0][2] = nextMove();
            } else {
                System.out.println("This field is taken");
                move--;
            }
                break;
            case 4: if (board[1][0] == " ") {
                board[1][0] = nextMove();
            } else {
                System.out.println("This field is taken");
                move--;
            }
                break;
            case 5: if (board[1][1] == " ") {
                board[1][1] = nextMove();
            } else {
                System.out.println("This field is taken");
                move--;
            }
                break;
            case 6: if (board[1][2] == " ") {
                board[1][2] = nextMove();
            } else {
                System.out.println("This field is taken");
                move--;
            }
                break;
            case 7: if (board[2][0] == " ") {
                board[2][0] = nextMove();
            } else {
                System.out.println("This field is taken");
                move--;
            }
                break;
            case 8: if (board[2][1] == " ") {
                board[2][1] = nextMove();
            } else {
                System.out.println("This field is taken");
                move--;
            }
                break;
            case 9: if (board[2][2] == " ") {
                board[2][2] = nextMove();
            } else {
                System.out.println("This field is taken");
                move--;
            }
                break;
        }
    }

    public void isWin() {
        String winX = "XXX";
        String winO = "OOO";

        String match1 = board[0][0] + board[0][1] + board[0][2];
        String match2 = board[1][0] + board[1][1] + board[1][2];
        String match3 = board[2][0] + board[2][1] + board[2][2];
        String match4 = board[0][0] + board[1][0] + board[2][0];
        String match5 = board[0][1] + board[1][1] + board[2][1];
        String match6 = board[0][2] + board[1][2] + board[2][2];
        String match7 = board[0][0] + board[1][1] + board[2][2];
        String match8 = board[0][2] + board[1][1] + board[2][0];

        if (winX.equals(match1) ||
                winX.equals(match2) ||
                winX.equals(match3) ||
                winX.equals(match4) ||
                winX.equals(match5) ||
                winX.equals(match6) ||
                winX.equals(match7) ||
                winX.equals(match8)
        ) {
            win = true;
            System.out.println("PLAYER \"X\" HAS WON!");
        } else if (winO.equals(match1) ||
                winO.equals(match2) ||
                winO.equals(match3) ||
                winO.equals(match4) ||
                winO.equals(match5) ||
                winO.equals(match6) ||
                winO.equals(match7) ||
                winO.equals(match8)
        ) {
            win = true;
            System.out.println("PLAYER \"O\" HAS WON!");
        }
    }


    public boolean hasGameEnded() {
        if (win == true || move == 9) {
            return true;
        } else {
            return false;
        }
    }




}
