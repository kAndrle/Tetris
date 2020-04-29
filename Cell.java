import java.awt.*;

public class Cell {
    private boolean filled;
    private int x;
    private int y;
    private Color color;

    public Cell(int x, int y){
        this.x = x;
        this.y = y;
        filled = false;
        color = new Color(0,0,0);
    }

    public void draw(Graphics g){
        g.setColor(color);
        g.fillRect((25*x)+25,(25*y)+25,25,25);
        g.setColor(new Color(0,0,0));
        g.drawRect((25*x)+25,(25*y)+25,25,25);
    }

    public void setColor(Color c){
        color = c;
    }

    public Color getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void fill(){
        filled = true;
    }

    public void empty(){
        filled = false;
    }

    public boolean isFilled(){
        return filled;
    }
}
