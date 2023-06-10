public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Listener listener = new Listener(game);

        listener.start();
        game.start();

    }
}