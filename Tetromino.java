import java.awt.*;
// todo [wall kicks, floor kicks, left/right collision checks to use in DrawingPanel's key events]

public class Tetromino {
    enum Rotation {
        Base,One,Two,Three //quarter turns
    }

    protected Rotation rotation;
    protected int x;
    protected int y;
    //protected int[] xBits = new int[4];
    //protected int[] yBits = new int[4];
    protected int xMax;
    protected int xMin;
    protected int yMax; // this value is used differently from xMax, xMin, as it denotes how far away from the reference y the bottom of the tetromino is.
    protected Color color;

    public Tetromino(int x, int y, Color color){
        this.x = x;
        this.y = y;
        this.color = color;
        rotation = Rotation.Base;
    }

    public boolean isFloating(Cell[][] grid){
        return y+yMax<21;
    }

    public boolean isBlockedRight(Cell[][] grid){
        return !(x<xMax);
    }

    public boolean isBlockedLeft(Cell[][] grid){
        return !(x>xMin);
    }

    public void lock(Cell[][] grid){

    }

    public int getxMax() {
        return xMax;
    }

    public int getxMin() {
        return xMin;
    }

    public int getyMax() {
        return yMax;
    }

    public Color getColor() {
        return color;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveDown(Graphics g,Cell[][] grid){

        draw(g, grid, new Color(0, 0, 0));
        y++;
        draw(g, grid, color);

    }

    public void moveRight(Graphics g,Cell[][] grid){
        if(!isBlockedRight(grid)) {
            draw(g, grid, new Color(0, 0, 0));
            x++;
            draw(g, grid, color);
        }
    }

    public void moveLeft(Graphics g,Cell[][] grid){
        if(!isBlockedLeft(grid)) {
            draw(g, grid, new Color(0, 0, 0));
            x -= 1;
            draw(g, grid, color);
        }
    }

    public void teleportDown(){
        // Gonna figure this out later

    }

    public void draw(Graphics g,Cell[][] grid,Color c){

    }

    public void rotateCW(Graphics g,Cell[][] grid){
        draw(g,grid,new Color(0,0,0));
        Rotation voidCase = rotation;
        int originalX = x;
        int originalY = y;
        Rotation temp = Rotation.Base;
        switch(rotation){
            case Base:
                temp = Rotation.One;
                break;
            case One:
                temp = Rotation.Two;
                break;
            case Two:
                temp = Rotation.Three;
                break;
            case Three:
                temp = Rotation.Base;
                break;
        }
        rotation = temp;
        draw(g,grid,color);
    }

    public void rotateCCW(Graphics g,Cell[][] grid){
        draw(g,grid,new Color(0,0,0));
        Rotation voidCase = rotation;
        int originalX = x;
        int originalY = y;
        Rotation temp = Rotation.Base;
        switch(rotation){
            case Base:
                temp = Rotation.Three;
                break;
            case One:
                temp = Rotation.Base;
                break;
            case Two:
                temp = Rotation.One;
                break;
            case Three:
                temp = Rotation.Two;
                break;
        }
        rotation = temp;
        draw(g,grid,color);
    }



}
