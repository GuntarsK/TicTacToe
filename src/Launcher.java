public class Launcher {
    public static void main(String[] args) {

        Game game = new Game();

        game.printBoardWithPositions();

        while (!game.hasGameEnded()) {
            game.nextMove();
            game.chosePosition(game.nextPlayer());
        }

    }
}
