import java.util.LinkedList;


public class Game extends Thread {

    private int moveCounter;
    private String direction;
    final private LinkedList<String> moves;
    private final Board board;
    private final Snake snake;
    public Game() {
        this.board = new Board();
        this.snake = new Snake(5,5);
        this.moveCounter = 0;
        this.moves = new LinkedList<>();
        this.direction = "right";
    }

    @TODO_ASYNC
    private String keyboardInput() {return null;}

    @Override
    public void run() {

            Food food = new Food();
        do {
            board.printBoard(snake, food);
            System.out.println("snake length: "+snake.getLength());
            moves.add(direction);
            snake.move(direction);
            moveCounter++;
            if (snake.getHead().getXpos() == food.getXpos() && snake.getHead().getYpos() == food.getYpos()) {
                snake.eat(moves.get(moveCounter-snake.getLength()));
                food = new Food();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }

        while (!snake.isOver());

        if (snake.getWin())
            System.out.println("You Won");

        System.out.println("Game Over!");

    }


    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public boolean isOver(){return snake.isOver();}

}
