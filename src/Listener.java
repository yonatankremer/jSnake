import java.util.Scanner;

public class Listener extends Thread{

    private Game game;

    public Listener(Game game) {
        this.game = game;
    }

    @Override
    public void run() {

        do {

            Scanner in = new Scanner(System.in);
            char direction = in.next().charAt(0);

            switch (direction) {

                case 'w' -> game.setDirection("up");
                case 'a' -> game.setDirection("left");
                case 's' -> game.setDirection("down");
                case 'd' -> game.setDirection("right");
                default -> game.setDirection(game.getDirection());
            }
        }

        while (!game.isOver());

    }



}
