import java.util.LinkedList;

public class Snake {

    private SnakeNode head;
    private LinkedList<SnakeNode> list;
    private int length;
    private boolean win;


    public Snake(int headXpos, int headYpos) {
        this.head = new SnakeNode(headXpos, headYpos);
        this.list = new LinkedList<SnakeNode>();
        this.list.add(head);
        this.length = 1;
        this.win = false;
    }

    public void move(String direction) {

        int headXpos = head.getXpos();
        int headYpos = head.getYpos();

        switch (direction) {
            case "right" -> headXpos+=1;
            case "left"  -> headXpos -=1;
            case "up" -> headYpos -=1;
            case "down" -> headYpos+=1;
            default -> throw new DirectionException(direction + " isn't a valid direction");
        }

        if (length > 1 && headXpos == list.get(1).getXpos() && headYpos == list.get(1).getYpos())
            return;


        int[][] xyPos = new int[2][length];

        for (int i=1; i<length; i++) {
            xyPos[0][i] = list.get(i-1).getXpos();
            xyPos[1][i] = list.get(i-1).getYpos();
        }

        for (int i=1; i<length; i++) {
            list.get(i).setXpos(xyPos[0][i]);
            list.get(i).setYpos(xyPos[1][i]);
        }

        head.setXpos(headXpos);
        head.setYpos(headYpos);

    }

    public void eat(String direction) {

        SnakeNode newNode;
        int tailXpos = list.getLast().getXpos();
        int tailYpos = list.getLast().getYpos();

        switch (direction) {
            case "right" -> tailXpos-=1;
            case "left" ->  tailXpos+=1;
            case "up" -> tailYpos+=1;
            case "down" -> tailYpos-=1;
            default -> throw new DirectionException(direction + "isn't a valid direction");
        }

        newNode = new SnakeNode(tailXpos, tailYpos);
        list.add(newNode);
        length++;

    }


    public boolean isOver() {
        int boardSize = Board.BOARD_SIZE;
        return (isColliding() || isEdge()) || isWin(boardSize);

    }

    private boolean isWin(int boardSize) {

        win = length == (boardSize*(boardSize-4));
        return win;
    }

    private boolean isColliding() {
        for (int i=1; i<length; i++) {
            if (list.get(i).getXpos() == head.getXpos() && list.get(i).getYpos() == head.getYpos())
                return true;
        }
        return false;
    }

    private boolean isEdge() {
        int boardSize = Board.BOARD_SIZE;
        int headXpos = head.getXpos();
        int headYpos = head.getYpos();


        if (headXpos == 0 || headXpos == boardSize-1 || headYpos == 0 || headYpos == boardSize-1)
            return true;
        return false;

    }


    public SnakeNode getHead() {
        return head;
    }

    public void setHead(SnakeNode head) {
        this.head = head;
    }

    public LinkedList<SnakeNode> getList() {
        return list;
    }

    public int getLength() {
        return length;
    }
    public boolean getWin() {
        return win;
    }

}

