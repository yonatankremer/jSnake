public class Board {

    char[][] board;
    final static int BOARD_SIZE = 16;
    final char emptyChar = '-';
    public Board() {
        board = new char[BOARD_SIZE][BOARD_SIZE];
        init();
    }

    void init() {
        for (int i=0; i<BOARD_SIZE; i++) {
            board[0][i] = '_';
            board[BOARD_SIZE-1][i] = '_';

            board[i][0] = '|';
            board[i][BOARD_SIZE-1] = '|';
        }

        for (int i=1; i<BOARD_SIZE-1; i++)
            for (int j=1; j<BOARD_SIZE-1; j++)
                board[i][j] = emptyChar;
    }

    public void printBoard(Snake s, Food f) {
        init();
        addFood(f);
        addSnake(s);

        for (int i=0; i<BOARD_SIZE; i++) {
            for (int j=0; j<BOARD_SIZE; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    private void addSnake(Snake s) {

        for (SnakeNode node : s.getList()) {
            int xpos = node.getXpos();
            int ypos = node.getYpos();

            board[ypos][xpos] = SnakeNode.objChar;

        }

    }

    private void addFood(Food f) {

        int xpos = f.getXpos();
        int ypos = f.getYpos();

        board[ypos][xpos] = Food.objChar;

    }


    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public char getEmptyChar() {
        return emptyChar;
    }
}
