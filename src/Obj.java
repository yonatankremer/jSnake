import java.util.Random;

abstract class Obj {

    protected int xpos;
    protected int ypos;

    protected Obj(int xpos, int ypos) {
        this.xpos = xpos;
        this.ypos = ypos;
    }

    protected Obj() {
        Random rnd = new Random();
        this.xpos = rnd.nextInt(Board.BOARD_SIZE-3)+1;
        this.ypos = rnd.nextInt(Board.BOARD_SIZE-3)+1;
    }

    public int getXpos() {
        return xpos;
    }

    public void setXpos(int xpos) {
        this.xpos = xpos;
    }

    public int getYpos() {
        return ypos;
    }

    public void setYpos(int ypos) {
        this.ypos = ypos;
    }
}
