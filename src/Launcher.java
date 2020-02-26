import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String playAgain = "";

        do {
            Game game = new Game();
            game.printBoardWithPositions();
            while (!game.hasGameEnded()) {
                game.nextMove();
            }
            System.out.println("Play again? Enter Y to continue or any other key to quit: ");
            playAgain = sc.nextLine();
        } while (playAgain.equalsIgnoreCase("y"));

        System.out.println("Thank you for playing!");

    }
}
