import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {

        Game game = new Game();
        Scanner sc = new Scanner(System.in);

        while (game.hasGameEnded() == false) {
            game.nextPlayer(sc.nextInt());
            game.printBoard();
            game.isWin();
        }

    }
}
